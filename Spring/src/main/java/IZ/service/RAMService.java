package IZ.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IZ.model.Motherboard;
import IZ.model.RAM;
import IZ.sparql.SparqlStaticFields;

@Service
public class RAMService {
	@Autowired
	private MotherboardService motherboardService;
	
	public RAM getOne(String title) {
		String selectString = SparqlStaticFields.Prefix +
				"SELECT ?title ?ram_type ?ram_speed ?ram_memory ?rgb \n" +
			    "\tWHERE {\n" +
                "?ram rdf:type iz:RAM .\n" +
                "?ram iz:title \"" + title + "\".\n" +
                "?ram rdf:type iz:RAM .\n" +
                "OPTIONAL {?ram iz:title  ?title .}\n" +
                "OPTIONAL {?ram iz:ram_type  ?ram_type .}\n" +
                "OPTIONAL {?ram iz:ram_speed ?ram_speed .}\n" +
                "OPTIONAL {?ram iz:ram_memory ?ram_memory .}\n" +
                "OPTIONAL {?ram iz:rgb ?rgb .}\n" +
                "}";
		RAM ram = new RAM();
		Query query = QueryFactory.create(selectString);
		QueryExecution q = QueryExecutionFactory.sparqlService(SparqlStaticFields.SELECT_URL, query);
		ResultSet results = q.execSelect();
		if (results.hasNext()) {
			QuerySolution solution = results.nextSolution();
			ram.setTitle((solution.getLiteral("title") != null) ? solution.getLiteral("title").getString() : null);
			ram.setType((solution.getLiteral("ram_type") != null) ? solution.getLiteral("ram_type").getString(): null);
			ram.setSpeed((solution.getLiteral("ram_speed") != null) ? solution.getLiteral("ram_speed").getInt() : null);
			ram.setMemory((solution.getLiteral("ram_memory") != null) ? solution.getLiteral("ram_memory").getInt(): null);
			ram.setRgb((solution.getLiteral("rgb") != null) ? solution.getLiteral("rgb").getBoolean(): null);
		}
		return ram;
	}
	
	public List<RAM> getAll() {
		String selectString = SparqlStaticFields.Prefix +
				"SELECT ?title ?ram_type ?ram_speed ?ram_memory ?rgb \n" +
			    "\tWHERE {\n" +
                "?ram rdf:type iz:RAM .\n" +
                "OPTIONAL {?ram iz:title  ?title .}\n" +
                "OPTIONAL {?ram iz:ram_type  ?ram_type .}\n" +
                "OPTIONAL {?ram iz:ram_speed ?ram_speed .}\n" +
                "OPTIONAL {?ram iz:ram_memory ?ram_memory .}\n" +
                "OPTIONAL {?ram iz:rgb ?rgb .}\n" +
                "}";
		List<RAM> ramList = new ArrayList<RAM>();
		Query query = QueryFactory.create(selectString);
		QueryExecution q = QueryExecutionFactory.sparqlService(SparqlStaticFields.SELECT_URL, query);
		ResultSet results = q.execSelect();
		while (results.hasNext()) {
			QuerySolution solution = results.nextSolution();
			RAM ram = new RAM();
			ram.setTitle((solution.getLiteral("title") != null) ? solution.getLiteral("title").getString() : null);
			ram.setType((solution.getLiteral("ram_type") != null) ? solution.getLiteral("ram_type").getString(): null);
			ram.setSpeed((solution.getLiteral("ram_speed") != null) ? solution.getLiteral("ram_speed").getInt() : null);
			ram.setMemory((solution.getLiteral("ram_memory") != null) ? solution.getLiteral("ram_memory").getInt(): null);
			ram.setRgb((solution.getLiteral("rgb") != null) ? solution.getLiteral("rgb").getBoolean(): null);
			if(ram.getMemory() != null) {
				ramList.add(ram);
			}
		}
		return ramList;
	}
	
	public List<RAM> getCompatibleRAM(String title) {
		Motherboard motherboard = motherboardService.getOne(title);
		String selectString = SparqlStaticFields.Prefix +
				"SELECT ?title ?ram_type ?ram_speed ?ram_memory ?rgb \n" +
			    "\tWHERE {\n" +
			    "?ram rdf:type iz:RAM .\n" +
                "?ram iz:ram_type \"" + motherboard.getMemoryType() + "\".\n" +
                "?ram rdf:type iz:RAM .\n" +
                "OPTIONAL {?ram iz:title  ?title .}\n" +
                "OPTIONAL {?ram iz:ram_type  ?ram_type .}\n" +
                "OPTIONAL {?ram iz:ram_speed ?ram_speed .}\n" +
                "OPTIONAL {?ram iz:ram_memory ?ram_memory .}\n" +
                "OPTIONAL {?ram iz:rgb ?rgb .}\n" +
                "}";
		List<RAM> ramList = new ArrayList<RAM>();
		Query query = QueryFactory.create(selectString);
		QueryExecution q = QueryExecutionFactory.sparqlService(SparqlStaticFields.SELECT_URL, query);
		ResultSet results = q.execSelect();
		while (results.hasNext()) {
			QuerySolution solution = results.nextSolution();
			RAM ram = new RAM();
			ram.setTitle((solution.getLiteral("title") != null) ? solution.getLiteral("title").getString() : null);
			ram.setType((solution.getLiteral("ram_type") != null) ? solution.getLiteral("ram_type").getString(): null);
			ram.setSpeed((solution.getLiteral("ram_speed") != null) ? solution.getLiteral("ram_speed").getInt() : null);
			ram.setMemory((solution.getLiteral("ram_memory") != null) ? solution.getLiteral("ram_memory").getInt(): null);
			ram.setRgb((solution.getLiteral("rgb") != null) ? solution.getLiteral("rgb").getBoolean(): null);
			if(ram.getMemory() != null) {
				ramList.add(ram);
			}
		}
		return ramList;
	}
}
