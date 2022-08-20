package IZ.service.CBR;

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
import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CBRCaseBase;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.ExecutionException;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.EqualsStringIgnoreCase;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

@Service
public class CBRService implements StandardCBRApplication {
	@Autowired
	private SparqlConnector connector;
	private Connector _connector;
	private CBRCaseBase _caseBase;
	private NNConfig _simConfig;
	private List<PersonalComputer> result;

	@Override
	public void configure() throws ExecutionException {
		_connector = connector;

		_caseBase = new LinealCaseBase();

		_simConfig = new NNConfig();
		_simConfig.setDescriptionSimFunction(new Average());

		_simConfig.addMapping(new Attribute("cpu", PersonalComputer.class), new Average());
		_simConfig.addMapping(new Attribute("gpu", PersonalComputer.class), new Average());
		_simConfig.addMapping(new Attribute("hdd", PersonalComputer.class), new Average());
		_simConfig.addMapping(new Attribute("motherboard", PersonalComputer.class), new Average());
		_simConfig.addMapping(new Attribute("ram", PersonalComputer.class), new Average());
		_simConfig.addMapping(new Attribute("ssd", PersonalComputer.class), new Average());
		
		_simConfig.addMapping(new Attribute("coreCount", CPU.class), new Interval(16));
		_simConfig.addMapping(new Attribute("series", CPU.class), new EqualsStringIgnoreCase());
		_simConfig.addMapping(new Attribute("coreClock", CPU.class), new Interval(2000));
		
		_simConfig.addMapping(new Attribute("memory", GPU.class), new Interval(2000));
		_simConfig.addMapping(new Attribute("hashRate", GPU.class), new Interval(10));
		_simConfig.addMapping(new Attribute("powerUsage", GPU.class), new Interval(2));
		_simConfig.addMapping(new Attribute("memoryType", GPU.class), new EqualsStringIgnoreCase());
		
		_simConfig.addMapping(new Attribute("capacity", HDD.class), new Interval(100));
		_simConfig.addMapping(new Attribute("type", HDD.class), new EqualsStringIgnoreCase());
		
		_simConfig.addMapping(new Attribute("chipset", Motherboard.class), new EqualsStringIgnoreCase());
		_simConfig.addMapping(new Attribute("memoryType", Motherboard.class), new EqualsStringIgnoreCase());
		_simConfig.addMapping(new Attribute("memoryMax", Motherboard.class), new Interval(100));
		_simConfig.addMapping(new Attribute("memorySlots", Motherboard.class), new Interval(2));
		
		_simConfig.addMapping(new Attribute("memory", RAM.class), new Interval(2));
		_simConfig.addMapping(new Attribute("type", RAM.class), new EqualsStringIgnoreCase());
		_simConfig.addMapping(new Attribute("speed", RAM.class), new Interval(100));
		
		_simConfig.addMapping(new Attribute("capacity", SSD.class), new Interval(100));
		_simConfig.addMapping(new Attribute("sataSpeed", SSD.class), new Interval(100));
		_simConfig.addMapping(new Attribute("type", SSD.class), new EqualsStringIgnoreCase());

	}

	@Override
	public void cycle(CBRQuery cbrQuery) throws ExecutionException {
		result = new ArrayList<>();
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), cbrQuery,
				_simConfig);
		eval = SelectCases.selectTopKRR(eval, 5);
		System.out.println("Retrieved cases:");
		for (RetrievalResult nse : eval) {
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
			result.add((PersonalComputer) nse.get_case().getDescription());
		}
	}

	@Override
	public void postCycle() throws ExecutionException {
		// TODO Auto-generated method stub

	}

	@Override
	public CBRCaseBase preCycle() throws ExecutionException {
		_caseBase.init(_connector);
		java.util.Collection<CBRCase> cases = _caseBase.getCases();
		for (CBRCase c : cases)
			System.out.println(c.getDescription());
		return _caseBase;
	}
	
	public List<PersonalComputer> start(PersonalComputer pc){
        try{
            configure();
            preCycle();
            CBRQuery query = new CBRQuery();
            query.setDescription(pc);
            cycle(query);
            postCycle();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
