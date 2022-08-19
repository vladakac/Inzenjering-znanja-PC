package IZ.controller;

import IZ.model.GPU;
import IZ.service.GPUService;
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
    public GPU getGPU(@PathVariable("title") String title){
        return gpuService.getGPU(title);
    }

}
