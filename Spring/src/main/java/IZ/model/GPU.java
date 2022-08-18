package IZ.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GPU {
    private String name;
    private String chipset;
    private String memoryType;
    private Integer memory;
    private Integer memoryClock;
    private Integer clock;
    private Integer boostClock;
    private Integer hashrate;
    private Integer powerUsage;
    private String connector;
    private Integer vgaPorts;
    private Integer dpPorts;
    private Integer hdmiPorts;
    private Integer dviPorts;

}