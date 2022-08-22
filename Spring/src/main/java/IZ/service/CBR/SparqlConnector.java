package IZ.service.CBR;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;

@Service
public class SparqlConnector implements Connector {
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

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCases(Collection<CBRCase> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initFromXMLfile(URL arg0) throws InitializingException {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<CBRCase> retrieveAllCases() {
		int ct = 0;
		List<CBRCase> cbrs = new ArrayList<CBRCase>();
		List<CPU> cpuList = new ArrayList<CPU>();
		List<GPU> gpuList = new ArrayList<GPU>();
		List<HDD> hddList = new ArrayList<HDD>();
		List<Motherboard> moboList = new ArrayList<Motherboard>();
		List<RAM> ramList = new ArrayList<RAM>();
		List<SSD> ssdList = new ArrayList<SSD>();

		cpuList = cpuService.getAll();
		gpuList = gpuService.getAll();
		hddList = hddService.getAll();
		moboList = motherboardService.getAll();
		ramList = ramService.getAll();
		ssdList = ssdService.getAll();
		
		if(cpuList.size() > 0) {
		for (CPU cpu : cpuList) {
			PersonalComputer pc = new PersonalComputer();
			pc.setCpu(cpu);
			if (ct >= gpuList.size()) {
				pc.setGpu(gpuList.get(0));
				;
			} else {
				pc.setGpu(gpuList.get(ct));
				;
			}
			if (ct >= hddList.size()) {
				pc.setHdd(hddList.get(0));
				;
			} else {
				pc.setHdd(hddList.get(ct));
				;
			}
			if (ct >= moboList.size()) {
				pc.setMotherboard(moboList.get(0));
			} else {
				pc.setMotherboard(moboList.get(ct));
			}
			if (ct >= ramList.size()) {
				pc.setRam(ramList.get(0));
			} else {
				pc.setRam(ramList.get(ct));
			}
			if (ct >= ssdList.size()) {
				pc.setSsd(ssdList.get(0));
			} else {
				pc.setSsd(ssdList.get(ct));
			}
			CBRCase cbrCase = new CBRCase();
			cbrCase.setDescription(pc);
			cbrs.add(cbrCase);
			ct++;
			}
		}
		else {
		CPU cpu1 = new CPU();
		cpu1.setCoreClock(3800);
		cpu1.setCoreClockBoost(4000);
		cpu1.setCoreCount(4);
		cpu1.setIntegratedGraphics(false);
		cpu1.setPowerUsage(65);
		cpu1.setTitle("Ryzen34100");
		cpu1.setSeries("3");
		cpu1.setSocket("AM4");
		
		GPU gpu1 = new GPU();
		gpu1.setTitle("GTX1050TI");
		gpu1.setChipset("Nvidia");
		gpu1.setBoostClock(1392);
		gpu1.setClock(1290);
		gpu1.setConnector("PCI Express 3.0");
		gpu1.setDpPorts(1);
		gpu1.setDviPorts(1);
		gpu1.setHashRate((float) 6.4);
		gpu1.setMemory(4096);
		gpu1.setMemoryClock(7008);
		gpu1.setMemoryType("GDDR5");
		gpu1.setHdmiPorts(1);
		gpu1.setPowerUsage(75);
		gpu1.setVgaPorts(0);
		
		Motherboard motherboard1 = new Motherboard();
		motherboard1.setTitle("GigabyteB550MDS3H");
		motherboard1.setChipset("AMD B550");
		motherboard1.setForm("Micro ATX");
		motherboard1.setM2Slots(2);
		motherboard1.setMemoryMax(128);
		motherboard1.setMemoryMaxFrequency(4600);
		motherboard1.setMemorySlots(4);
		motherboard1.setMemoryType("DDR4");
		motherboard1.setPcieSlots(2);
		motherboard1.setSataPorts(4);
		motherboard1.setUsbPorts(2);
		motherboard1.setRgb(false);
		motherboard1.setSocket("АМ4");
		
		HDD hdd1 = new HDD();
		hdd1.setTitle("Seagate10TB7200rmp");
		hdd1.setCapacity(10240);
		hdd1.setRpm(7200);
		hdd1.setSataSpeed(500);
		hdd1.setType("SATA");
		
		SSD ssd1 = new SSD();
		ssd1.setTitle("Samsung970EVOPlus");
		ssd1.setCapacity(1024);
		ssd1.setSataSpeed(0);
		ssd1.setRpm(0);
		ssd1.setType("m.2");
		
		RAM ram1  = new RAM();
		ram1.setTitle("GSkillRipJawsV16GB");
		ram1.setMemory(16);
		ram1.setSpeed(3200);
		ram1.setType("DDR4");
		ram1.setRgb(false);
		
		CPU cpu2 = new CPU();
		cpu2.setCoreClock(2900);
		cpu2.setCoreClockBoost(4800);
		cpu2.setCoreCount(8);
		cpu2.setIntegratedGraphics(true);
		cpu2.setPowerUsage(65);
		cpu2.setTitle("i710700");
		cpu2.setSeries("7");
		cpu2.setSocket("LGA1200");
		
		GPU gpu2 = new GPU();
		gpu2.setTitle("GTX1660");
		gpu2.setChipset("Nvidia");
		gpu2.setBoostClock(1785);
		gpu2.setClock(1830);
		gpu2.setConnector("PCI Express 3.0");
		gpu2.setDpPorts(3);
		gpu2.setDviPorts(1);
		gpu2.setHashRate((float) 27.5);
		gpu2.setMemory(6144);
		gpu2.setMemoryClock(8002);
		gpu2.setMemoryType("GDDR6");
		gpu2.setHdmiPorts(1);
		gpu2.setPowerUsage(100);
		gpu2.setVgaPorts(0);
		
		Motherboard motherboard2 = new Motherboard();
		motherboard1.setTitle("GigabyteB660GamingXAX");
		motherboard1.setChipset("Intel B660");
		motherboard1.setForm("ATX");
		motherboard1.setM2Slots(3);
		motherboard1.setMemoryMax(128);
		motherboard1.setMemoryMaxFrequency(4400);
		motherboard1.setMemorySlots(4);
		motherboard1.setMemoryType("DDR4");
		motherboard1.setPcieSlots(3);
		motherboard1.setSataPorts(4);
		motherboard1.setUsbPorts(4);
		motherboard1.setRgb(false);
		motherboard1.setSocket("LGA1700");
		
		HDD hdd2 = new HDD();
		hdd2.setTitle("Seagate1TB7200rmp");
		hdd2.setCapacity(1024);
		hdd2.setRpm(7200);
		hdd2.setSataSpeed(500);
		hdd2.setType("SATA");
		
		SSD ssd2 = new SSD();
		ssd2.setTitle("Samsung970EVOPlus500GB");
		ssd2.setCapacity(500);
		ssd2.setSataSpeed(3500);
		ssd2.setRpm(0);
		ssd2.setType("m.2");
		
		RAM ram2  = new RAM();
		ram2.setTitle("KingstonHyperXFury16GB");
		ram2.setMemory(16);
		ram2.setSpeed(3200);
		ram2.setType("DDR4");
		ram2.setRgb(false);
		
		PersonalComputer pc1 = new PersonalComputer();
		pc1.setCpu(cpu1);
		pc1.setGpu(gpu1);
		pc1.setMotherboard(motherboard1);
		pc1.setHdd(hdd1);
		pc1.setRam(ram1);
		pc1.setSsd(ssd1);
		
		PersonalComputer pc2 = new PersonalComputer();
		pc2.setCpu(cpu2);
		pc2.setGpu(gpu2);
		pc2.setMotherboard(motherboard2);
		pc2.setHdd(hdd2);
		pc2.setRam(ram2);
		pc2.setSsd(ssd2);
		
		PersonalComputer pc3 = new PersonalComputer();
		pc3.setCpu(cpu1);
		pc3.setGpu(gpu2);
		pc3.setMotherboard(motherboard2);
		pc3.setHdd(hdd1);
		pc3.setRam(ram2);
		pc3.setSsd(ssd1);
		
		CBRCase cbrCase1 = new CBRCase();
		CBRCase cbrCase2 = new CBRCase();
		CBRCase cbrCase3 = new CBRCase();
		
		cbrCase1.setDescription(pc1);
		cbrCase2.setDescription(pc2);
		cbrCase3.setDescription(pc3);
		cbrs.add(cbrCase1);
		cbrs.add(cbrCase2);
		cbrs.add(cbrCase3);
		}

		return cbrs;
	}

	@Override
	public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeCases(Collection<CBRCase> arg0) {
		// TODO Auto-generated method stub

	}

}
