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
public class Motherboard implements CaseComponent {
	private String title;
	private String form;
	private String socket;
	private String chipset;
	private String memoryType;
	private Integer memoryMaxFrequency;
	private Integer memoryMax;
	private Integer memorySlots;
	private Integer m2Slots;
	private Integer pcieSlots;
	private Integer usbPorts;
	private Integer sataPorts;
	private boolean rgb;

	@JsonIgnore
	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id", this.getClass());
	}

}
