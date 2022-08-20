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
public class RAM implements CaseComponent {
	private String title;
	private String type;
	private Integer memory;
	private Integer speed;
	private boolean rgb;

	@JsonIgnore
	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id", this.getClass());
	}
}
