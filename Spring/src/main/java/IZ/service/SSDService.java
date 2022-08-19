package IZ.service;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.springframework.stereotype.Service;

import IZ.model.SSD;
import IZ.sparql.SparqlStaticFields;

@Service
public class SSDService {
	  public SSD getSSD(String title){
	        String selectString = SparqlStaticFields.Prefix +
	                "SELECT ?storage_capacity ?storage_type ?title ?storage_rpm ?storage_sata_speed \n" +
	                "\tWHERE {\n" +
	                "?ssd rdf:type iz:SSD .\n" +
	                "?ssd iz:title \"" + title + "\".\n" +
	                "?ssd rdf:type iz:SSD .\n" +
	                "OPTIONAL {?ssd iz:title  ?title .}\n" +
	                "OPTIONAL {?ssd iz:storage_capacity  ?storage_capacity .}\n" +
	                "OPTIONAL {?ssd iz:storage_type ?storage_type .}\n" +
	                "OPTIONAL {?ssd iz:storage_rpm ?storage_rpm .}\n" +
	                "OPTIONAL {?ssd iz:storage_sata_speed ?storage_sata_speed .}\n" +
	                "}";
	        SSD ssd = new SSD();
	        Query query = QueryFactory.create(selectString);
	        QueryExecution q = QueryExecutionFactory.sparqlService(SparqlStaticFields.SELECT_URL, query);
	        ResultSet results = q.execSelect();
	        if (results.hasNext()) {
	            QuerySolution solution = results.nextSolution();
	            ssd.setTitle((solution.getLiteral("title") != null) ? solution.getLiteral("title").getString() : null);
	            ssd.setCapacity((solution.getLiteral("storage_capacity") != null) ? solution.getLiteral("storage_capacity").getInt() : null);
	            ssd.setRpm((solution.getLiteral("storage_rpm") != null) ? solution.getLiteral("storage_rpm").getInt() : null);
	            ssd.setSataSpeed((solution.getLiteral("storage_sata_speed") != null) ? solution.getLiteral("storage_sata_speed").getInt() : null);
	            ssd.setType((solution.getLiteral("storage_type") != null) ? solution.getLiteral("storage_type").getString() : null);
	        }
	        return ssd;
	    }
}
