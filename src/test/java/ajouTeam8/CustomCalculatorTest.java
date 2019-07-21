package ajouTeam8;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;

    @Test
    public void add(){

        customCalculator = new CustomCalculator();
        int result = customCalculator.add(3500, 5500);

        assertThat(result, is(9000));

        System.out.println("result : "+result);
    }


}
