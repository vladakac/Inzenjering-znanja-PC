package IZ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;

import IZ.dto.PCInputDTO;
import IZ.model.CPU;
import IZ.model.GPU;
import IZ.model.HDD;
import IZ.model.Motherboard;
import IZ.model.PersonalComputer;
import IZ.model.RAM;
import IZ.model.SSD;
import IZ.service.CPUService;
import IZ.service.GPUService;
import IZ.service.HDDService;
import IZ.service.MotherboardService;
import IZ.service.RAMService;
import IZ.service.SSDService;
import IZ.service.CBR.CBRService;

@CrossOrigin
@RestController
@RequestMapping("/api/cbr")
public class CBRController {
	@Autowired
	private CBRService cbrService;
	@Autowired
	private CPUService cpuService;
	@Autowired
	private GPUService gpuService;
	@Autowired
	private HDDService hddService;
	@Autowired
	private MotherboardService motherboardService;
	@Autowired
	private RAMService ramService;
	@Autowired
	private SSDService ssdService;
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonalComputer> FindSimilar(@RequestBody PCInputDTO dto){
		CPU cpu = cpuService.getOne(dto.getCpuTitle());
		GPU gpu = gpuService.getOne(dto.getGpuTitle());
		Motherboard mobo = motherboardService.getOne(dto.getMoboTitle());
		HDD hdd = hddService.getOne(dto.getHddTitle());
		RAM ram = ramService.getOne(dto.getRamTitle());
		SSD ssd = ssdService.getOne(dto.getSsdTitle());
		
		PersonalComputer pc = new PersonalComputer();
		pc.setCpu(cpu);
		pc.setGpu(gpu);
		pc.setHdd(hdd);
		pc.setMotherboard(mobo);
		pc.setRam(ram);
		pc.setSsd(ssd);
		
		List<PersonalComputer> result = cbrService.start(pc);
		
		return result;
	}
}
