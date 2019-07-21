package ajouTeam8.repository;

import ajouTeam8.domain.Customer;
import ajouTeam8.domain.Menu;

import java.util.List;

public interface CafeRepository {
    List<Menu> findAll();

    Menu findByName(String name);

    void addMenu(Menu menu);

    void addCustomer(Customer customer);




    List<Customer> CustomerList();
    int purchase(Customer Customername, Menu menuname);
    int findMoneyofCustomer(Customer customer);
    Customer findCustomerByName(String name);
}
