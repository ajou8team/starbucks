package ajouTeam8.rpository;

import ajouTeam8.domain.Menu;

import java.util.List;

public interface cafaRepository {
    List<Menu>  findAll();

    Menu findByName(String name);

}