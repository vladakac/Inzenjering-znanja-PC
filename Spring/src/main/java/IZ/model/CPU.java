package IZ.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CPU {
    private String name;
    private String socket;
    private String series;
    private Integer coreCount;
    private Integer coreClock;
    private boolean integratedGraphics;
    private Integer coreClockBoost;
    private Integer powerUsage;
}
