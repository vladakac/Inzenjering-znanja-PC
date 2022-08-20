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
public class GPU implements CaseComponent {
	private String title;
	private String chipset;
	private String memoryType;
	private Integer memory;
	private Integer memoryClock;
	private Integer clock;
	private Integer boostClock;
	private Float hashRate;
	private Integer powerUsage;
	private String connector;
	private Integer vgaPorts;
	private Integer dpPorts;
	private Integer hdmiPorts;
	private Integer dviPorts;

	@JsonIgnore
	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id", this.getClass());
	}

}
