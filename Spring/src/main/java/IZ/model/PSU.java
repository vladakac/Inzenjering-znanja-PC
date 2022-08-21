package IZ.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PSU {
	private String title;
	private Integer wattage;
	private String type;
	private Boolean modular;
	private Boolean fanless;
}
