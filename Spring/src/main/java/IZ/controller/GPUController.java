package IZ.controller;

import IZ.model.GPU;
import IZ.service.GPUService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/GPU")
public class GPUController {

    @Autowired
    private GPUService gpuService;
    
    @GetMapping(value = "{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GPU getOne(@PathVariable("title") String title){
        return gpuService.getOne(title);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GPU> getAll(){
        return gpuService.getAll();
    }

}
