package IZ.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalComputer implements CaseComponent {
	private CPU cpu;
	private GPU gpu;
	private HDD hdd;
	private Motherboard motherboard;
	private RAM ram;
	private SSD ssd;
	
	@JsonIgnore
	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id",this.getClass());
	}
}
