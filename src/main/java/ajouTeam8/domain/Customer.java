package ajouTeam8.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Customer {
    private String customerName;
    private int number;
    private int MoneyOfCustomer;
}
