package IZ.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BayesResultDTO {
    List<BayesResponseDTO> results;
    public BayesResultDTO() {
        results = new ArrayList<>();
    }
}
