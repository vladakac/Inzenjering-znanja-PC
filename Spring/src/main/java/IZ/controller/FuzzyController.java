package IZ.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import IZ.dto.FuzzyOutputDTO;
import IZ.sparql.SparqlStaticFields;
import IZ.dto.FuzzyDTO;
import IZ.dto.FuzzyInputDTO;

import org.springframework.http.MediaType;

@CrossOrigin
@RestController
@RequestMapping("/api/fuzzy")
public class FuzzyController {
	@PutMapping(value = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
	public FuzzyOutputDTO FuzyCheck(@RequestBody FuzzyDTO dto) {
		FuzzyOutputDTO result = FuzzyEvaluate(dto);
		return result;
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public FuzzyOutputDTO Fuzzy(@RequestBody FuzzyInputDTO dto){
        String sparqlQuery = SparqlStaticFields.Prefix + 
        		"SELECT  ?cpu_core_count ?gpu_memory ?ram_memory ?storage_capacity ?storage_sata_speed \n" +
        		"\tWHERE {\n" +
        		"?cpu rdf:type iz:CPU .\n" +
        		"?cpu iz:title \"" + dto.getCpuTitle() + "\".\n" +
                "?cpu rdf:type iz:CPU .\n" +
                "?cpu iz:cpu_core_count ?cpu_core_count .\n" +
                "?gpu rdf:type iz:GPU .\n" +
        		"?gpu iz:title \"" + dto.getGpuTitle() + "\".\n" +
                "?gpu rdf:type iz:GPU .\n" +
                "?gpu iz:gpu_memory ?gpu_memory .\n" +
                "?ram rdf:type iz:RAM .\n" +
        		"?ram iz:title \"" + dto.getRamTitle() + "\".\n" +
                "?ram rdf:type iz:RAM .\n" +
                "?ram iz:ram_memory ?ram_memory .\n" +
                "?hdd rdf:type iz:HDD .\n" +
        		"?hdd iz:title \"" + dto.getDiskTitle() + "\".\n" +
                "?hdd rdf:type iz:HDD .\n" +
                "OPTIONAL {?hdd iz:storage_capacity  ?storage_capacity .}\n" +
                "OPTIONAL {?hdd iz:storage_sata_speed ?storage_sata_speed .}\n" +
                "}";
        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qexec = QueryExecutionFactory.sparqlService(SparqlStaticFields.SELECT_URL, query);
        ResultSet results = qexec.execSelect();
        FuzzyDTO rawDto = new FuzzyDTO();
        if(results.hasNext()){
            QuerySolution solution = results.nextSolution();
            rawDto.setCpuCores((solution.getLiteral("cpu_core_count") != null) ? solution.getLiteral("cpu_core_count").getInt(): null);
            rawDto.setRamSize((solution.getLiteral("ram_memory") != null) ? solution.getLiteral("ram_memory").getInt(): null);
            rawDto.setVramSize((solution.getLiteral("gpu_memory") != null) ? solution.getLiteral("gpu_memory").getInt() : null);
            rawDto.setDiskSize((solution.getLiteral("storage_capacity") != null) ? solution.getLiteral("storage_capacity").getInt() : 0);
            rawDto.setDiskSpeed((solution.getLiteral("storage_sata_speed") != null) ? solution.getLiteral("storage_sata_speed").getInt() : 0);
        }
        FuzzyOutputDTO resultDto = FuzzyEvaluate(rawDto);
        return resultDto;
    }

	private FuzzyOutputDTO FuzzyEvaluate(FuzzyDTO dto) {
		FIS fis = FIS.load("data/pc_purpose.fcl", true);

		if (fis == null) {
			System.err.println("Can't load file");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "fcl file not found");
		}

		FunctionBlock block = fis.getFunctionBlock("pc_purpose");

		fis.setVariable("cpu_cores", dto.getCpuCores());
		fis.setVariable("ram_size", dto.getRamSize());
		fis.setVariable("vram_size", dto.getVramSize());
		fis.setVariable("disk_speed", dto.getDiskSpeed());
		fis.setVariable("disk_size", dto.getDiskSize());

		fis.evaluate();

		FuzzyOutputDTO result = new FuzzyOutputDTO();
		result.setHomeUsage((float) block.getVariable("home_usage").getValue()*10);
		result.setProfessionalUsage((float) block.getVariable("professional_usage").getValue()*10);
		result.setServerHosting((float) block.getVariable("server_hosting").getValue()*10);
		result.setGaming((float) block.getVariable("gaming").getValue()*10);
		result.setMining((float) block.getVariable("mining").getValue()*10);
		return result;
	}
}
