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

import IZ.model.GPU;
import IZ.model.PSU;
import IZ.sparql.SparqlStaticFields;

@Service
public class PSUService {
	@Autowired
	private GPUService gpuService;
	
	public PSU getOne(String title) {
		String selectString = SparqlStaticFields.Prefix +
				"SELECT ?title ?psu_wattage ?psu_type ?psu_modular ?psu_fanless \n" +
			    "\tWHERE {\n" +
                "?psu rdf:type iz:PSU .\n" +
                "?psu iz:title \"" + title + "\".\n" +
                "?psu rdf:type iz:PSU .\n" +
                "OPTIONAL {?psu iz:title  ?title .}\n" +
                "OPTIONAL {?psu iz:psu_wattage  ?psu_wattage .}\n" +
                "OPTIONAL {?psu iz:psu_type ?psu_type .}\n" +
                "OPTIONAL {?psu iz:psu_modular ?psu_modular .}\n" +
                "OPTIONAL {?psu iz:psu_fanless ?psu_fanless .}\n" +
                "}";
		PSU psu = new PSU();
		Query query = QueryFactory.create(selectString);
		QueryExecution q = QueryExecutionFactory.sparqlService(SparqlStaticFields.SELECT_URL, query);
		ResultSet results = q.execSelect();
		if (results.hasNext()) {
			QuerySolution solution = results.nextSolution();
			psu.setTitle((solution.getLiteral("title") != null) ? solution.getLiteral("title").getString() : null);
			psu.setType((solution.getLiteral("psu_type") != null) ? solution.getLiteral("psu_type").getString(): null);
			psu.setWattage((solution.getLiteral("psu_wattage") != null) ? solution.getLiteral("psu_wattage").getInt() : null);
			psu.setModular((solution.getLiteral("psu_modular") != null) ? solution.getLiteral("psu_modular").getBoolean(): false);
			psu.setFanless((solution.getLiteral("psu_fanless") != null) ? solution.getLiteral("psu_fanless").getBoolean(): false);
		}
		return psu;
	}
	
	public List<PSU> getAll() {
		String selectString = SparqlStaticFields.Prefix +
				"SELECT ?title ?psu_wattage ?psu_type ?psu_modular ?psu_fanless \n" +
			    "\tWHERE {\n" +
                "?psu rdf:type iz:PSU .\n" +
                "OPTIONAL {?psu iz:title  ?title .}\n" +
                "OPTIONAL {?psu iz:psu_wattage  ?psu_wattage .}\n" +
                "OPTIONAL {?psu iz:psu_type ?psu_type .}\n" +
                "OPTIONAL {?psu iz:psu_modular ?psu_modular .}\n" +
                "OPTIONAL {?psu iz:psu_fanless ?psu_fanless .}\n" +
                "}";
		List<PSU> psuList = new ArrayList<PSU>();
		Query query = QueryFactory.create(selectString);
		QueryExecution q = QueryExecutionFactory.sparqlService(SparqlStaticFields.SELECT_URL, query);
		ResultSet results = q.execSelect();
		while (results.hasNext()) {
			QuerySolution solution = results.nextSolution();
			PSU psu = new PSU();
			psu.setTitle((solution.getLiteral("title") != null) ? solution.getLiteral("title").getString() : null);
			psu.setType((solution.getLiteral("psu_type") != null) ? solution.getLiteral("psu_type").getString(): null);
			psu.setWattage((solution.getLiteral("psu_wattage") != null) ? solution.getLiteral("psu_wattage").getInt() : null);
			psu.setModular((solution.getLiteral("psu_modular") != null) ? solution.getLiteral("psu_modular").getBoolean(): false);
			psu.setFanless((solution.getLiteral("psu_fanless") != null) ? solution.getLiteral("psu_fanless").getBoolean(): false);
			if(psu.getWattage() != null) {
			psuList.add(psu);
			}
		}
		return psuList;
	}
	
	   public List<PSU> getCompatiblePSU(String title){
	    	GPU gpu = gpuService.getOne(title);
	    	List<PSU> all = getAll();
	    	List<PSU> psuList = new ArrayList<PSU>();
	    	for(PSU psu: all) {
	    		if((psu.getWattage() * 0.95) > gpu.getRecWattage()) {
	    			psuList.add(psu);
	    		}
	    	}
	    	return psuList;
	    }
}
