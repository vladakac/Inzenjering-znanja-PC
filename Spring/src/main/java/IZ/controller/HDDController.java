package IZ.controller;

import IZ.model.HDD;
import IZ.service.HDDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/HDD")
public class HDDController {

    @Autowired
    private HDDService hddService;
    
    @GetMapping(value = "{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HDD getHDD(@PathVariable("title") String title){
        return hddService.getHDD(title);
    }
}
