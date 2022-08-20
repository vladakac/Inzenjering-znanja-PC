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

import IZ.model.CPU;
import IZ.sparql.SparqlStaticFields;

@Service
public class CPUService {
	public CPU getOne(String title) {
		String selectString = SparqlStaticFields.Prefix +
				"SELECT ?socket ?title ?cpu_core_clock ?cpu_core_count ?cpu_core_clock_boost ?cpu_series ?cpu_power_usage ?cpu_integrated_graphics \n" +
			    "\tWHERE {\n" +
                "?cpu rdf:type iz:CPU .\n" +
                "?cpu iz:title \"" + title + "\".\n" +
                "?cpu rdf:type iz:CPU .\n" +
                "OPTIONAL {?cpu iz:title  ?title .}\n" +
                "OPTIONAL {?cpu iz:socket  ?socket .}\n" +
                "OPTIONAL {?cpu iz:cpu_core_clock ?cpu_core_clock .}\n" +
                "OPTIONAL {?cpu iz:cpu_core_count ?cpu_core_count .}\n" +
                "OPTIONAL {?cpu iz:cpu_core_clock_boost ?cpu_core_clock_boost .}\n" +
                "OPTIONAL {?cpu iz:cpu_series ?cpu_series .}\n" +
                "OPTIONAL {?cpu iz:cpu_power_usage ?cpu_power_usage .}\n" +
                "OPTIONAL {?cpu iz:cpu_integrated_graphics ?cpu_integrated_graphics .}\n" +
                "}";
		CPU cpu = new CPU();
		Query query = QueryFactory.create(selectString);
		QueryExecution q = QueryExecutionFactory.sparqlService(SparqlStaticFields.SELECT_URL, query);
		ResultSet results = q.execSelect();
		if (results.hasNext()) {
			QuerySolution solution = results.nextSolution();
			cpu.setTitle((solution.getLiteral("title") != null) ? solution.getLiteral("title").getString() : null);
			cpu.setSocket((solution.getLiteral("socket") != null) ? solution.getLiteral("socket").getString(): null);
			cpu.setSeries((solution.getLiteral("cpu_series") != null) ? solution.getLiteral("cpu_series").getString() : null);
			cpu.setCoreCount((solution.getLiteral("cpu_core_count") != null) ? solution.getLiteral("cpu_core_count").getInt(): null);
			cpu.setCoreClock((solution.getLiteral("cpu_core_clock") != null) ? solution.getLiteral("cpu_core_clock").getInt(): null);
			cpu.setIntegratedGraphics((solution.getLiteral("cpu_integrated_graphics") != null) ? solution.getLiteral("cpu_integrated_graphics").getBoolean() : null);
			cpu.setCoreClockBoost((solution.getLiteral("cpu_core_clock_boost") != null) ? solution.getLiteral("cpu_core_clock_boost").getInt(): null);
			cpu.setPowerUsage((solution.getLiteral("cpu_power_usage") != null) ? solution.getLiteral("cpu_power_usage").getInt(): null);
		}
		return cpu;
	}
	
	
	public List<CPU> getAll() {
		String selectString = SparqlStaticFields.Prefix +
				"SELECT ?socket ?title ?cpu_core_clock ?cpu_core_count ?cpu_core_clock_boost ?cpu_series ?cpu_power_usage ?cpu_integrated_graphics \n" +
			    "\tWHERE {\n" +
                "?cpu rdf:type iz:CPU .\n" +
                "OPTIONAL {?cpu iz:title  ?title .}\n" +
                "OPTIONAL {?cpu iz:socket  ?socket .}\n" +
                "OPTIONAL {?cpu iz:cpu_core_clock ?cpu_core_clock .}\n" +
                "OPTIONAL {?cpu iz:cpu_core_count ?cpu_core_count .}\n" +
                "OPTIONAL {?cpu iz:cpu_core_clock_boost ?cpu_core_clock_boost .}\n" +
                "OPTIONAL {?cpu iz:cpu_series ?cpu_series .}\n" +
                "OPTIONAL {?cpu iz:cpu_power_usage ?cpu_power_usage .}\n" +
                "OPTIONAL {?cpu iz:cpu_integrated_graphics ?cpu_integrated_graphics .}\n" +
                "}";
		List<CPU> cpus = new ArrayList<CPU>();
		Query query = QueryFactory.create(selectString);
		QueryExecution q = QueryExecutionFactory.sparqlService(SparqlStaticFields.SELECT_URL, query);
		ResultSet results = q.execSelect();
		while (results.hasNext()) {
			QuerySolution solution = results.nextSolution();
			CPU cpu = new CPU();
			cpu.setTitle((solution.getLiteral("title") != null) ? solution.getLiteral("title").getString() : null);
			cpu.setSocket((solution.getLiteral("socket") != null) ? solution.getLiteral("socket").getString(): null);
			cpu.setSeries((solution.getLiteral("cpu_series") != null) ? solution.getLiteral("cpu_series").getString() : null);
			cpu.setCoreCount((solution.getLiteral("cpu_core_count") != null) ? solution.getLiteral("cpu_core_count").getInt(): null);
			cpu.setCoreClock((solution.getLiteral("cpu_core_clock") != null) ? solution.getLiteral("cpu_core_clock").getInt(): null);
			cpu.setIntegratedGraphics((solution.getLiteral("cpu_integrated_graphics") != null) ? solution.getLiteral("cpu_integrated_graphics").getBoolean() : null);
			cpu.setCoreClockBoost((solution.getLiteral("cpu_core_clock_boost") != null) ? solution.getLiteral("cpu_core_clock_boost").getInt(): null);
			cpu.setPowerUsage((solution.getLiteral("cpu_power_usage") != null) ? solution.getLiteral("cpu_power_usage").getInt(): null);
			cpus.add(cpu);
		}
		return cpus;
	}
}
