package ajouTeam8;

import ajouTeam8.domain.Customer;
import ajouTeam8.domain.Menu;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;
    private List<Menu> menuList =new ArrayList<>();

    @Before
    public void setUp(){

        Menu firstMenu = new Menu("아메리카노",3000);
        Menu secondMenu = new Menu("블루베리요거트스무디", 5500);
        Menu thridMenu = new Menu("카페라뗴",4500);

        menuList.add(firstMenu);
        menuList.add(secondMenu);
        menuList.add(thridMenu);
    }

    @Test
    public void add(){

        customCalculator = new CustomCalculator();
        int result = customCalculator.add(menuList.get(0).getMenuPrice(),menuList.get(1).getMenuPrice());

        assertThat(result, is(8500));

        System.out.println("result : "+result);
    }


    @Test
    public void subtract(){


    }



}
