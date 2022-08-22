package IZ.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.springframework.stereotype.Service;

import IZ.model.HDD;
import IZ.sparql.SparqlStaticFields;

@Service
public class HDDService {
	  public HDD getOne(String title){
	        String selectString = SparqlStaticFields.Prefix +
	                "SELECT ?storage_capacity ?storage_type ?title ?storage_rpm ?storage_sata_speed \n" +
	                "\tWHERE {\n" +
	                "?hdd rdf:type iz:HDD .\n" +
	                "?hdd iz:title \"" + title + "\".\n" +
	                "?hdd rdf:type iz:HDD .\n" +
	                "OPTIONAL {?hdd iz:title  ?title .}\n" +
	                "OPTIONAL {?hdd iz:storage_capacity  ?storage_capacity .}\n" +
	                "OPTIONAL {?hdd iz:storage_type ?storage_type .}\n" +
	                "OPTIONAL {?hdd iz:storage_rpm ?storage_rpm .}\n" +
	                "OPTIONAL {?hdd iz:storage_sata_speed ?storage_sata_speed .}\n" +
	                "}";
	        HDD hdd = new HDD();
	        Query query = QueryFactory.create(selectString);
	        QueryExecution q = QueryExecutionFactory.sparqlService(SparqlStaticFields.SELECT_URL, query);
	        ResultSet results = q.execSelect();
	        if (results.hasNext()) {
	            QuerySolution solution = results.nextSolution();
	            hdd.setTitle((solution.getLiteral("title") != null) ? solution.getLiteral("title").getString() : null);
	            hdd.setCapacity((solution.getLiteral("storage_capacity") != null) ? solution.getLiteral("storage_capacity").getInt() : null);
	            hdd.setRpm((solution.getLiteral("storage_rpm") != null) ? solution.getLiteral("storage_rpm").getInt() : null);
	            hdd.setSataSpeed((solution.getLiteral("storage_sata_speed") != null) ? solution.getLiteral("storage_sata_speed").getInt() : null);
	            hdd.setType((solution.getLiteral("storage_type") != null) ? solution.getLiteral("storage_type").getString() : null);
	        }
	        return hdd;
	    }
	  
	  public List<HDD> getAll(){
	        String selectString = SparqlStaticFields.Prefix +
	                "SELECT ?storage_capacity ?storage_type ?title ?storage_rpm ?storage_sata_speed \n" +
	                "\tWHERE {\n" +
	                "?hdd rdf:type iz:HDD .\n" +
	                "OPTIONAL {?hdd iz:title  ?title .}\n" +
	                "OPTIONAL {?hdd iz:storage_capacity  ?storage_capacity .}\n" +
	                "OPTIONAL {?hdd iz:storage_type ?storage_type .}\n" +
	                "OPTIONAL {?hdd iz:storage_rpm ?storage_rpm .}\n" +
	                "OPTIONAL {?hdd iz:storage_sata_speed ?storage_sata_speed .}\n" +
	                "}";
	        List<HDD> hdds = new ArrayList<HDD>();
	        Query query = QueryFactory.create(selectString);
	        QueryExecution q = QueryExecutionFactory.sparqlService(SparqlStaticFields.SELECT_URL, query);
	        ResultSet results = q.execSelect();
	        while (results.hasNext()) {
	            QuerySolution solution = results.nextSolution();
	            HDD hdd = new HDD();
	            hdd.setTitle((solution.getLiteral("title") != null) ? solution.getLiteral("title").getString() : null);
	            hdd.setCapacity((solution.getLiteral("storage_capacity") != null) ? solution.getLiteral("storage_capacity").getInt() : null);
	            hdd.setRpm((solution.getLiteral("storage_rpm") != null) ? solution.getLiteral("storage_rpm").getInt() : null);
	            hdd.setSataSpeed((solution.getLiteral("storage_sata_speed") != null) ? solution.getLiteral("storage_sata_speed").getInt() : null);
	            hdd.setType((solution.getLiteral("storage_type") != null) ? solution.getLiteral("storage_type").getString() : null);
	            hdds.add(hdd);
	        }
	        return hdds;
	    }
}
