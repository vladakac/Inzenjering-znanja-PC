package IZ.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BayesDTO {
    private List<String> computerSymptomsList;
    private List<String> malfunctionCausesList;
}