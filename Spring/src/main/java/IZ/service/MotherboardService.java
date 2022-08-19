package IZ.service;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.springframework.stereotype.Service;

import IZ.model.Motherboard;
import IZ.sparql.SparqlStaticFields;

@Service
public class MotherboardService {
	public Motherboard getMotherboard(String title){
        String selectString = SparqlStaticFields.Prefix +
                "SELECT ?Motherboard_memory_type ?socket ?Motherboard_m2_slots ?Motherboard_pcie_slots ?Motherboard_sata_port ?Motherboard_memory_slots ?rgb ?Motherboard_memory_max ?Motherboard_memory_max_frequency ?title ?Motherboard_form ?Motherboard_usb_ports ?Motherboard_chipset \n" +
                "\tWHERE {\n" + 
                "?mobo rdf:type iz:Motherboard ." +
                "?mobo iz:title \"" + title + "\".\n" +
                "?mobo rdf:type iz:Motherboard .\n" +
                "OPTIONAL {?mobo iz:socket  ?socket .}\n" +
                "OPTIONAL {?mobo iz:title  ?title .}\n" +
        		"OPTIONAL {?mobo iz:Motherboard_memory_type ?Motherboard_memory_type .}\n" +
        		"OPTIONAL {?mobo iz:Motherboard_m2_slots ?Motherboard_m2_slots .}\n" +
                "OPTIONAL {?mobo iz:Motherboard_pcie_slots ?Motherboard_pcie_slots .}\n" +
                "OPTIONAL {?mobo iz:Motherboard_sata_port ?Motherboard_sata_port .}\n" +
                "OPTIONAL {?mobo iz:Motherboard_memory_slots ?Motherboard_memory_slots .}\n" +
                "OPTIONAL {?mobo iz:Motherboard_memory_max ?Motherboard_memory_max .}\n" +
        	    "OPTIONAL {?mobo iz:Motherboard_memory_max_frequency ?Motherboard_memory_max_frequency .}\n" +
                "OPTIONAL {?mobo iz:Motherboard_form ?Motherboard_form .}\n" +
                "OPTIONAL {?mobo iz:Motherboard_usb_ports ?Motherboard_usb_ports .}\n" +
                "OPTIONAL {?mobo iz:Motherboard_chipset ?Motherboard_chipset .}\n" +
        	    "OPTIONAL {?mobo iz:rgb ?rgb .}\n" +
                "}";
        Motherboard motherboard = new Motherboard();
        Query query = QueryFactory.create(selectString);
        QueryExecution q = QueryExecutionFactory.sparqlService(SparqlStaticFields.SELECT_URL, query);
        ResultSet results = q.execSelect();
        if (results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            motherboard.setTitle((solution.getLiteral("title") != null) ? solution.getLiteral("title").getString() : null);
            motherboard.setSocket((solution.getLiteral("socket") != null) ? solution.getLiteral("socket").getString() : null);
            motherboard.setMemoryType((solution.getLiteral("Motherboard_memory_type") != null) ? solution.getLiteral("Motherboard_memory_type").getString() : null);
            motherboard.setM2Slots((solution.getLiteral("Motherboard_m2_slots") != null) ? solution.getLiteral("Motherboard_m2_slots").getInt() : null);
            motherboard.setPcieSlots((solution.getLiteral("Motherboard_pcie_slots") != null) ? solution.getLiteral("Motherboard_pcie_slots").getInt() : null);
            motherboard.setSataPorts((solution.getLiteral("Motherboard_sata_port") != null) ? solution.getLiteral("Motherboard_sata_port").getInt() : null);
            motherboard.setMemorySlots((solution.getLiteral("Motherboard_memory_slots") != null) ? solution.getLiteral("Motherboard_memory_slots").getInt() : null);
            motherboard.setMemoryMax((solution.getLiteral("Motherboard_memory_max") != null) ? solution.getLiteral("Motherboard_memory_max").getInt() : null);
            motherboard.setMemoryMaxFrequency((solution.getLiteral("Motherboard_memory_max_frequency") != null) ? solution.getLiteral("Motherboard_memory_max_frequency").getInt() : null);
            motherboard.setForm((solution.getLiteral("Motherboard_form") != null) ? solution.getLiteral("Motherboard_pcie_slots").getString() : null);
            motherboard.setUsbPorts((solution.getLiteral("Motherboard_usb_ports") != null) ? solution.getLiteral("Motherboard_usb_ports").getInt() : null);
            motherboard.setChipset((solution.getLiteral("Motherboard_chipset") != null) ? solution.getLiteral("Motherboard_chipset").getString() : null);
            motherboard.setRgb((solution.getLiteral("rgb") != null) ? solution.getLiteral("rgb").getBoolean() : null);
        }
        return motherboard;
    }
}
