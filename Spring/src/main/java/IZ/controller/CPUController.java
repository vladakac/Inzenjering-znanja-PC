package IZ.controller;

import IZ.model.CPU;
import IZ.service.CPUService;
import IZ.service.CBR.SparqlConnector;
import ucm.gaia.jcolibri.cbrcore.CBRCase;

import java.util.Collection;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/CPU")
public class CPUController {

    @Autowired
    private CPUService cpuService;
    @Autowired
    private SparqlConnector sp;
    
    @GetMapping(value = "{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CPU getOne(@PathVariable("title") String title){
        return cpuService.getOne(title);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CPU> getAll(){
        return cpuService.getAll();
    }
    
    @GetMapping(value="/asd/asd",produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CBRCase> getAasdasdll(){
        return sp.retrieveAllCases();
    }
}
