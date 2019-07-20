package ajouTeam8.service;


import ajouTeam8.domain.Customer;
import ajouTeam8.domain.Menu;
import ajouTeam8.repository.CafeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


public class CafeServiceTest {

    @Mock
    private CafeRepository cafeRepository;

    @InjectMocks
    private CafeService cafeService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this); //without this you will get NPE
    }

    @Test
    public void 고객_이름을_불러오면_무조건_해진을_리턴한다() {
        Customer customer = mock(Customer.class);
        when(customer.getCustomerName()).thenReturn("해진");
        assertThat(customer.getCustomerName(), is("해진"));
    }

    @Test
    public void 고객_번호를_불러오면_무조건_3을_리턴한다() {
        Customer customer = mock(Customer.class);
        when(customer.getNumber()).thenReturn(3);
        assertThat(customer.getNumber(), is(3));
    }

    @Test
    public void 고객이가진_돈을_불러오면_무조건_100000을_리턴한다() {
        Customer customer = mock(Customer.class);
        when(customer.getMoneyOfCustomer()).thenReturn(100000);
        assertThat(customer.getMoneyOfCustomer(), is(100000));
    }

    @Test
    public void 고객이름이_저장되었나_테스트(){
        Customer customer = mock(Customer.class);
        customer.setCustomerName("해진");
        verify(customer).setCustomerName(anyString());
    }

    @Test
    public void 고객번호가_저장되었나_테스트(){
        Customer customer = mock(Customer.class);
        customer.setNumber(1);
        verify(customer).setNumber(anyInt());
    }
    @Test
    public void 고객돈이_저장되었나_테스트(){
        Customer customer = mock(Customer.class);
        customer.setMoneyOfCustomer(100000);
        verify(customer).setMoneyOfCustomer(anyInt());
    }

    //홍지호
    @Test
    public void verify_findByName_method_call(){
        Mockito.when(cafeService.findByName("아아")).thenReturn(new Menu("americano", 4000));
        Menu menu = cafeService.findByName("아아");
        assertThat(menu.getMenuName(), is("americano"));
        verify(cafeRepository, times(1)).findByName("아아");
    }

}