package ajouTeam8.service;

import ajouTeam8.domain.Customer;
import ajouTeam8.domain.Menu;
import ajouTeam8.repository.Mockrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeService {


    @Autowired
    Mockrepository mockrepository;



    public CafeService(Mockrepository mockrepository) {
        this.mockrepository = mockrepository;
    }

     public List<Menu> CheckMenuList(){
        return mockrepository.MenuList();
     }
     public Menu findMenu(String name){

        Menu menu = mockrepository.findmenu(name);
        return menu;
    }

    public Menu updatePrice(String name, int price){
        Menu menu = findMenu(name);
        menu.setMenuPrice(price);

        return menu;
    }

    public void addmenu(Menu menu){

        Menu addmenu = new Menu(menu.getMenuName(), menu.getMenuPrice());

        mockrepository.addMenu(addmenu);

    }
    public List<Customer> CheckCustomerList(){
        return mockrepository.CustomerList();
    }
    public Customer purchase(String Customername ,String Menuname){

        Customer customer = mockrepository.purchase(Customername,Menuname);

        customer.setMoneyOfCustomer(customer.getMoneyOfCustomer()-findMenu(Menuname).getMenuPrice());
        return customer;
    }

    public int findMoneyOfCustomer(String Customername){
        Customer customer = mockrepository.findMoneyofCustomer(Customername);


        return customer.getMoneyOfCustomer();
    }

    public void addCustomer(Customer customer){

        Customer addcustomer = new Customer(customer.getCustomerName(), customer.getMoneyOfCustomer());

        mockrepository.addNewCustomer(addcustomer);

    }





}
