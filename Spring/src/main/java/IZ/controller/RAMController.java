package IZ.controller;

import IZ.model.RAM;
import IZ.service.RAMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/RAM")
public class RAMController {

    @Autowired
    private RAMService ramService;
    
    @GetMapping(value = "{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RAM getRAM(@PathVariable("title") String title){
        return ramService.getRAM(title);
    }
}
