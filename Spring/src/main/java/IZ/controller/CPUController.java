package IZ.controller;

import IZ.model.CPU;
import IZ.service.CPUService;
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
    
    @GetMapping(value = "{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CPU getCPU(@PathVariable("title") String title){
        return cpuService.getCPU(title);
    }
}
