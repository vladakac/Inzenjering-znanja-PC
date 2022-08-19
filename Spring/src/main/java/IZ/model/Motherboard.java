package IZ.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Motherboard {
    private String name;
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

}
