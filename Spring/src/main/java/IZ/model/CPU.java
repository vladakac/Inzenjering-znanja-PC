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
public class CPU implements CaseComponent {
	private String title;
	private String socket;
	private String series;
	private Integer coreCount;
	private Integer coreClock;
	private boolean integratedGraphics;
	private Integer coreClockBoost;
	private Integer powerUsage;

	@JsonIgnore
	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id", this.getClass());
	}
}
