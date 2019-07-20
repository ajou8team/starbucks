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
    public List<Menu> findAllMenu(){
        return cafeRepository.findAll();
    }

    public Menu findByName(String name){
        Menu menu = cafeRepository.findByName(name);
        return menu;
    }

    public void addMenu(Menu menu){
        Menu addMenu = new Menu(menu.getMenuName(), menu.getMenuPrice());
        cafeRepository.addMenu(addMenu);
        return;
    }

    public void addCustomer(Customer customer){
        Customer addCustomer = new Customer(customer.getCustomerName(), customer.getNumber());
        cafeRepository.addCustomer(addCustomer);
    }

//    public Menu updatePriceByName(String name, int price){
//        Menu menu = findByName(name);
//        menu.setMenuPrice(price);
//        return menu;
//
//    }


}
