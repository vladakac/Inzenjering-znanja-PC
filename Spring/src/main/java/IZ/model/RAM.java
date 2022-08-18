package IZ.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RAM {
    private String name;
    private String type;
    private Integer memory;
    private Integer speed;
}
