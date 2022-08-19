package IZ.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HDD {
    private String title;
    private String type;
    private Integer capacity;
    private Integer rpm;
    private Integer sataSpeed;
    
}
