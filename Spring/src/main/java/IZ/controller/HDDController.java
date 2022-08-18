package IZ.controller;

import IZ.service.HDDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/HDD")
public class HDDController {

    @Autowired
    private HDDService hddService;
}
