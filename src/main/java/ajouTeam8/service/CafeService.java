package ajouTeam8.service;

import ajouTeam8.domain.Menu;
import ajouTeam8.rpository.CafeRepository;

public class CafeService {

    private final CafeRepository cafeRepository;

    public CafeService(CafeRepository cafeRepository){

        this.cafeRepository = cafeRepository;

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



}
