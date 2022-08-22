package IZ.service;

import IZ.model.GPU;
import IZ.model.PSU;
import IZ.sparql.SparqlStaticFields;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.query.*;


@Service
public class GPUService {
	@Autowired
	private PSUService psuService;

    public GPU getOne(String title){
        String selectString = SparqlStaticFields.Prefix +
                "SELECT ?title ?gpu_chipset ?gpu_memory ?gpu_clock ?gpu_memory_clock ?gpu_recw ?gpu_power_usage ?gpu_connector ?gpu_hashrate ?gpu_vga_ports ?gpu_memory_type ?gpu_dp_ports ?gpu_boost_clock ?gpu_dvi_ports ?gpu_hdmi_ports \n" +
                "\tWHERE {\n" +
                "?gpu rdf:type iz:GPU .\n" +
                "?gpu iz:title \"" + title + "\".\n" +
                "?gpu rdf:type iz:GPU .\n" +
                "OPTIONAL {?gpu iz:title  ?title .}\n" +
                "OPTIONAL {?gpu iz:gpu_chipset  ?gpu_chipset .}\n" +
                "OPTIONAL {?gpu iz:gpu_memory ?gpu_memory .}\n" +
                "OPTIONAL {?gpu iz:gpu_memory_type ?gpu_memory_type .}\n" +
                "OPTIONAL {?gpu iz:gpu_memory_clock ?gpu_memory_clock .}\n" +
                "OPTIONAL {?gpu iz:gpu_clock ?gpu_clock .}\n" +
                "OPTIONAL {?gpu iz:gpu_recw ?gpu_recw .}\n" +
                "OPTIONAL {?gpu iz:gpu_boost_clock ?gpu_boost_clock .}\n" +
                "OPTIONAL {?gpu iz:gpu_power_usage ?gpu_power_usage .}\n" +
                "OPTIONAL {?gpu iz:gpu_connector ?gpu_connector .}\n" +
                "OPTIONAL {?gpu iz:gpu_dp_ports ?gpu_dp_ports .}\n" +
                "OPTIONAL {?gpu iz:gpu_hdmi_ports ?gpu_hdmi_ports .}\n" +
                "OPTIONAL {?gpu iz:gpu_dvi_ports ?gpu_dvi_ports .}\n" +
                "OPTIONAL {?gpu iz:gpu_vga_ports ?gpu_vga_ports .}\n" +
                "OPTIONAL {?gpu iz:gpu_hashrate ?gpu_hashrate .}\n" +
                "}";
        GPU gpu = new GPU();
        Query query = QueryFactory.create(selectString);
        QueryExecution q = QueryExecutionFactory.sparqlService(SparqlStaticFields.SELECT_URL, query);
        ResultSet results = q.execSelect();
        if (results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            gpu.setTitle((solution.getLiteral("title") != null) ? solution.getLiteral("title").getString() : null);
            gpu.setChipset((solution.getLiteral("gpu_chipset") != null) ? solution.getLiteral("gpu_chipset").getString() : null);
            gpu.setMemory((solution.getLiteral("gpu_memory") != null) ? solution.getLiteral("gpu_memory").getInt() : -1);
            gpu.setMemoryType((solution.getLiteral("gpu_memory_type") != null) ? solution.getLiteral("gpu_memory_type").getString() : null);
            gpu.setMemoryClock((solution.getLiteral("gpu_memory_clock") != null) ? solution.getLiteral("gpu_memory_clock").getInt() : -1);
            gpu.setClock((solution.getLiteral("gpu_clock") != null) ? solution.getLiteral("gpu_clock").getInt() : -1);
            gpu.setBoostClock((solution.getLiteral("gpu_boost_clock") != null) ? solution.getLiteral("gpu_boost_clock").getInt() : -1);
            gpu.setPowerUsage((solution.getLiteral("gpu_power_usage") != null) ? solution.getLiteral("gpu_power_usage").getInt() : null);
            gpu.setConnector((solution.getLiteral("gpu_connector") != null) ? solution.getLiteral("gpu_connector").getString() : null);
            gpu.setDpPorts((solution.getLiteral("gpu_dp_ports") != null) ? solution.getLiteral("gpu_dp_ports").getInt() : -1);
            gpu.setHdmiPorts((solution.getLiteral("gpu_hdmi_ports") != null) ? solution.getLiteral("gpu_hdmi_ports").getInt() : -1);
            gpu.setDviPorts((solution.getLiteral("gpu_dvi_ports") != null) ? solution.getLiteral("gpu_dvi_ports").getInt() : -1);
            gpu.setVgaPorts((solution.getLiteral("gpu_vga_ports") != null) ? solution.getLiteral("gpu_vga_ports").getInt() : -1);
            gpu.setHashRate((solution.getLiteral("gpu_hashrate") != null) ? solution.getLiteral("gpu_hashrate").getFloat() : -1);
            gpu.setRecWattage((solution.getLiteral("gpu_recw") != null) ? solution.getLiteral("gpu_recw").getInt() : -1);
        }
        return gpu;
    }
    
    public List<GPU> getAll(){
        String selectString = SparqlStaticFields.Prefix +
                "SELECT ?title ?gpu_chipset ?gpu_memory ?gpu_clock ?gpu_recw ?gpu_memory_clock ?gpu_power_usage ?gpu_connector ?gpu_hashrate ?gpu_vga_ports ?gpu_memory_type ?gpu_dp_ports ?gpu_boost_clock ?gpu_dvi_ports ?gpu_hdmi_ports \n" +
                "\tWHERE {\n" +
                "?gpu rdf:type iz:GPU .\n" +
                "OPTIONAL {?gpu iz:title  ?title .}\n" +
                "OPTIONAL {?gpu iz:gpu_chipset  ?gpu_chipset .}\n" +
                "OPTIONAL {?gpu iz:gpu_memory ?gpu_memory .}\n" +
                "OPTIONAL {?gpu iz:gpu_memory_type ?gpu_memory_type .}\n" +
                "OPTIONAL {?gpu iz:gpu_memory_clock ?gpu_memory_clock .}\n" +
                "OPTIONAL {?gpu iz:gpu_clock ?gpu_clock .}\n" +
                "OPTIONAL {?gpu iz:gpu_recw ?gpu_recw .}\n" +
                "OPTIONAL {?gpu iz:gpu_boost_clock ?gpu_boost_clock .}\n" +
                "OPTIONAL {?gpu iz:gpu_power_usage ?gpu_power_usage .}\n" +
                "OPTIONAL {?gpu iz:gpu_connector ?gpu_connector .}\n" +
                "OPTIONAL {?gpu iz:gpu_dp_ports ?gpu_dp_ports .}\n" +
                "OPTIONAL {?gpu iz:gpu_hdmi_ports ?gpu_hdmi_ports .}\n" +
                "OPTIONAL {?gpu iz:gpu_dvi_ports ?gpu_dvi_ports .}\n" +
                "OPTIONAL {?gpu iz:gpu_vga_ports ?gpu_vga_ports .}\n" +
                "OPTIONAL {?gpu iz:gpu_hashrate ?gpu_hashrate .}\n" +
                "}";
        List<GPU> gpus = new ArrayList<GPU>();
        Query query = QueryFactory.create(selectString);
        QueryExecution q = QueryExecutionFactory.sparqlService(SparqlStaticFields.SELECT_URL, query);
        ResultSet results = q.execSelect();
        while (results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            GPU gpu = new GPU();
            gpu.setTitle((solution.getLiteral("title") != null) ? solution.getLiteral("title").getString() : null);
            gpu.setChipset((solution.getLiteral("gpu_chipset") != null) ? solution.getLiteral("gpu_chipset").getString() : null);
            gpu.setMemory((solution.getLiteral("gpu_memory") != null) ? solution.getLiteral("gpu_memory").getInt() : -1);
            gpu.setMemoryType((solution.getLiteral("gpu_memory_type") != null) ? solution.getLiteral("gpu_memory_type").getString() : null);
            gpu.setMemoryClock((solution.getLiteral("gpu_memory_clock") != null) ? solution.getLiteral("gpu_memory_clock").getInt() : -1);
            gpu.setClock((solution.getLiteral("gpu_clock") != null) ? solution.getLiteral("gpu_clock").getInt() : -1);
            gpu.setBoostClock((solution.getLiteral("gpu_boost_clock") != null) ? solution.getLiteral("gpu_boost_clock").getInt() : -1);
            gpu.setPowerUsage((solution.getLiteral("gpu_power_usage") != null) ? solution.getLiteral("gpu_power_usage").getInt() : null);
            gpu.setConnector((solution.getLiteral("gpu_connector") != null) ? solution.getLiteral("gpu_connector").getString() : null);
            gpu.setDpPorts((solution.getLiteral("gpu_dp_ports") != null) ? solution.getLiteral("gpu_dp_ports").getInt() : -1);
            gpu.setHdmiPorts((solution.getLiteral("gpu_hdmi_ports") != null) ? solution.getLiteral("gpu_hdmi_ports").getInt() : -1);
            gpu.setRecWattage((solution.getLiteral("gpu_recw") != null) ? solution.getLiteral("gpu_recw").getInt() : -1);
            gpu.setDviPorts((solution.getLiteral("gpu_dvi_ports") != null) ? solution.getLiteral("gpu_dvi_ports").getInt() : -1);
            gpu.setVgaPorts((solution.getLiteral("gpu_vga_ports") != null) ? solution.getLiteral("gpu_vga_ports").getInt() : -1);
            gpu.setHashRate((solution.getLiteral("gpu_hashrate") != null) ? solution.getLiteral("gpu_hashrate").getFloat() : -1);
            gpus.add(gpu);
        }
        return gpus;
    }
    
    public List<GPU> getCompatibleGPU(String title){
    	PSU psu = psuService.getOne(title);
    	List<GPU> all = getAll();
    	List<GPU> gpuList = new ArrayList<GPU>();
    	for(GPU gpu: all) {
    		if((psu.getWattage() * 0.95) > gpu.getRecWattage()) {
    			gpuList.add(gpu);
    		}
    	}
    	return gpuList;
    }

}
