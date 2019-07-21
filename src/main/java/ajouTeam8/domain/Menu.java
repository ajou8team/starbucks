package ajouTeam8.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Menu {
    private String menuName;
    private int menuPrice;
}
