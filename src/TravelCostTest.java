import java.util.ArrayList;
import java.util.Comparator;

public class TravelCostTest {
    public static void main(String[] args) {
        ArrayList<Customer> customerArrayList = new ArrayList<>();

        Customer customerLee = new Customer("이순신", 40, 100);
        Customer customerKim = new Customer("김유신", 20, 100);
        Customer customerHong = new Customer("홍길동", 13, 50);

        customerArrayList.add(customerLee);
        customerArrayList.add(customerKim);
        customerArrayList.add(customerHong);

        // 고객의 명단 전체 출력하기.
        customerArrayList.stream().forEach(s -> System.out.print(s + "\t")); // toString()을 override 했기 때문에 toString() 메서드를 호출하지 않고 객체만 출력해도 toString()으로 출력된다.
        System.out.println();

        // 고객의 명단 이름 출력하기.
        customerArrayList.stream().map(s -> s.getName()).forEach(s -> System.out.print(s + "\t"));
        System.out.println();

        // 총 여행 비용 출력하기.
        int totalCost = customerArrayList.stream().map(s -> s.getCost()).mapToInt(s -> s.intValue()).sum();
        System.out.println(totalCost);

        // 고객 중 20세 이상인 사람의 이름을 정렬하여 전체 출력하기.
        customerArrayList.stream().filter(s -> s.getAge() >= 20).sorted(Comparator.comparing(Customer::getName)).forEach(s -> System.out.print(s + "\t"));
        System.out.println(totalCost);

        // 고객 중 20세 이상인 사람의 이름을 정렬하여 이름 출력하기.
        customerArrayList.stream().filter(s -> s.getAge() >= 20).map(s -> s.getName()).sorted().forEach(s -> System.out.print(s + "\t"));

        // 결과
        // Customer{name='이순신', age=40, cost=100}	Customer{name='김유신', age=20, cost=100}	Customer{name='홍길동', age=13, cost=50}
        // 이순신	김유신	홍길동
        // 250
        // Customer{name='김유신', age=20, cost=100}	Customer{name='이순신', age=40, cost=100}	250
        // 김유신	이순신
    }
}
