package IZ.controller;

import IZ.model.SSD;
import IZ.service.SSDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/SSD")
public class SSDController {

    @Autowired
    private SSDService ssdService;
    
    @GetMapping(value = "{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SSD getSSD(@PathVariable("title") String title){
        return ssdService.getSSD(title);
    }
}
