package ajouTeam8;

import ajouTeam8.domain.Customer;
import ajouTeam8.domain.Menu;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "test용" );

        int count =0;
        Scanner scan = new Scanner(System.in);

        System.out.println( "당신의 이름을 입력하시오" );
        String name=scan.next();
        System.out.println( "당신의 소지금액을 입력하시오" );
        int Money= scan.nextInt();
        count++;
        System.out.println( "menu를 입력하시오" );
        String menuname=scan.next();
        System.out.println( "menu의 가격을 입력하시오" );
        int menuprice= scan.nextInt();

        Customer testCustomer = new Customer(name,count,Money);
        Menu testMenu = new Menu(menuname,menuprice);
    }
}
