package ajouTeam8.service;

import ajouTeam8.domain.Customer;
import ajouTeam8.domain.Menu;
import ajouTeam8.rpository.CafeRepository;

import java.util.List;

public class CafeService {

    private final CafeRepository cafeRepository;

    public CafeService(CafeRepository cafeRepository){

        this.cafeRepository = cafeRepository;

    }
    public List<Menu> findAll(){
        return cafeRepository.findAll();
    }

    public Menu findByName(String name){
        Menu menu = cafeRepository.findByName(name);
        return menu;
    }

    public void addMenu(Menu menu){
        Menu addMenu = new Menu(menu.getMenuName(), menu.getMenuPrice());
        cafeRepository.addMenu(addMenu);

    }

    public void addCustomer(Customer customer){
        Customer addCustomer = new Customer(customer.getCustomerName(), customer.getNumber(), customer.getMoneyOfCustomer());
        cafeRepository.addCustomer(addCustomer);
    }



    public List<Customer> CheckCustomerList(){
        return cafeRepository.CustomerList();
    }

    public Customer findCustomerByName(String name){
        Customer customer = cafeRepository.findCustomerByName(name);
        return customer;
    }


    public int purchase(Customer Customername ,Menu Menuname){

    int MoneyLeft = cafeRepository.purchase(Customername,Menuname);


    MoneyLeft = Customername.getMoneyOfCustomer() - Menuname.getMenuPrice();
    cafeRepository.purchase(Customername,Menuname);


    return MoneyLeft;
    }

    public int findMoneyOfCustomer(Customer customer){


        int TheMoneyLeft = customer.getMoneyOfCustomer();

        cafeRepository.findMoneyofCustomer(customer);
        return TheMoneyLeft;
    }




}
