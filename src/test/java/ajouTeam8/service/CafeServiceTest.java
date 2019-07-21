package ajouTeam8.service;


import ajouTeam8.domain.Customer;
import ajouTeam8.domain.Menu;
import ajouTeam8.rpository.CafeRepository;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Null;


import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
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

    @Test
    public void 메뉴리스트_크기메서드_실행_테스트(){
        List<Menu> menuList = mock(List.class);
        menuList.size();
        verify(menuList,atLeastOnce()).size();
    }

    @Test
    public void 모든_메뉴_리턴메서드_1이상_실행여부_확인(){
        List<Menu> menuList = mock(List.class);
        when(cafeService.findAll()).thenReturn(menuList);
        cafeService.findAll();
        verify(cafeRepository,atLeastOnce()).findAll();
    }

    @Test
    public void 메뉴를_더하는_메서드_실행_여부확인(){
        Menu menu = mock(Menu.class);
        cafeService.addMenu(menu);
        verify(cafeRepository).addMenu(any(Menu.class));

    }

    @Test
    public void 손님을_더하는_메서드_실행_여부확인(){
        Customer customer = mock(Customer.class);
        cafeService.addCustomer(customer);
        verify(cafeRepository).addCustomer(any(Customer.class));

    }

    @Test
    public void 고객리스트를_반환하는_메서드_작성(){
        List<Customer> customerList = mock(List.class);
        when(customerList.size()).thenReturn(10);
        when(cafeService.CheckCustomerList()).thenReturn(customerList);

        assertThat(cafeService.CheckCustomerList().size(),is(10));
        verify(cafeRepository).CustomerList();

    }

    

    //홍지호
    @Test
    public void verify_findByName_method_call(){
        Mockito.when(cafeService.findByName("아아")).thenReturn(new Menu("americano", 4000));
        Menu menu = cafeService.findByName("아아");
        assertThat(menu.getMenuName(), is("americano"));
        verify(cafeRepository, times(1)).findByName("아아");
    }

    @Test
    public void verify_findByName_by_BDD(){
        given(cafeRepository.findByName("americano")).willReturn(new Menu("americano", 4000));
        Menu menu = cafeService.findByName("americano");
        verify(cafeRepository, times(1)).findByName("americano");
    }


    @Test
   public void 고객의잔액조회메소드확인(){

        Mockito.when(cafeService.findCustomerByName("치완")).thenReturn(new Customer("치완", 2, 10000));
        int MoneyCheck = cafeService.findCustomerByName("치완").getMoneyOfCustomer();
        assertThat(MoneyCheck, Is.is(10000));

        Customer testcustomer = new Customer("송",2,100);
       int Money = cafeService.findMoneyOfCustomer(testcustomer);
       assertThat(Money, Is.is(100));


        verify(cafeRepository, times(1)).findCustomerByName(anyString());


   }
   @Test
    public void 고객이주문시금액차감여부확인(){

       Mockito.when(cafeService.findCustomerByName("치완")).thenReturn(new Customer("치완",3,500));
       Mockito.when(cafeService.findByName("치즈케이크")).thenReturn(new Menu("치즈케이크",400));

       Customer customer = cafeService.findCustomerByName("치완");
       Menu menu = cafeService.findByName("치즈케이크");

       int MoneyLeft = cafeService.purchase(customer,menu);
       assertEquals(MoneyLeft,100);

   }










}