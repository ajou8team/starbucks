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

//    public Menu updatePriceByName(String name, int price){
//        Menu menu = findByName(name);
//        menu.setMenuPrice(price);
//        return menu;
//
//    }



     public Menu updatePrice(String name, int price){
       Menu menu = findByName(name);
       menu.setMenuPrice(price);

       return menu;
       }


    public List<Customer> CheckCustomerList(){
        return cafeRepository.CustomerList();
    }
    public Customer purchase(String Customername ,String Menuname){

        Customer customer = cafeRepository.purchase(Customername,Menuname);

        customer.setMoneyOfCustomer(customer.getMoneyOfCustomer()-findByName(Menuname).getMenuPrice());
        return customer;
    }

    public int findMoneyOfCustomer(String Customername){
        Customer customer =cafeRepository.findMoneyofCustomer(Customername);


        return customer.getMoneyOfCustomer();
    }




}
