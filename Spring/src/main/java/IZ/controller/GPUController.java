package IZ.controller;

import IZ.service.GPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/GPU")
public class GPUController {

    @Autowired
    private GPUService gpuService;
}
