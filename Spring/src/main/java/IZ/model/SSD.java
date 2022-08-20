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
public class SSD implements CaseComponent {
	private String title;
	private String type;
	private Integer capacity;
	private Integer rpm;
	private Integer sataSpeed;

	@JsonIgnore
	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id", this.getClass());
	}

}
