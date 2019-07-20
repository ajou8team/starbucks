package ajouTeam8.rpository;

import ajouTeam8.domain.Customer;
import ajouTeam8.domain.Menu;

import java.util.List;

public interface CafeRepository {
    List<Menu> findAll();

    Menu findByName(String name);

    void addMenu(Menu menu);

    void addCustomer(Customer customer);



    Menu updatePrice(String name,int price);
    List<Customer> CustomerList();
    Customer purchase(String Customername, String menuname);
    Customer findMoneyofCustomer(String name);

}
