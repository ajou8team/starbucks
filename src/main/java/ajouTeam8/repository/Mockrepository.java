package ajouTeam8.repository;
import ajouTeam8.domain.Customer;
import ajouTeam8.domain.Menu;

import java.util.List;

public interface Mockrepository {

    List<Menu> MenuList();
    Menu findmenu(String name);
    Menu updatePrice(String name,int price);

    void addMenu(Menu menu);

    List<Customer> CustomerList();
    Customer purchase(String Customername, String menuname);
    Customer findMoneyofCustomer(String name);
    void addNewCustomer(Customer customer);
}
