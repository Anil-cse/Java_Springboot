package coding10march;

import java.util.*;

public class CollectionCube {

	public static void main(String[] args) {

		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		list.stream().filter(x -> x%2==0).forEach(System.out::println);
		
		System.out.println("operation number to cube");
		list.stream().map(a -> a * a * a).forEach(System.out::println);

		
		System.out.println("sum of first 50 number using stream reduce");
		List<Integer> num = new ArrayList<>();

		for (int i = 1; i <= 50; i++) {
			num.add(i);
		}

		// Integer sum = num.stream().reduce(0, (a, b) -> a + b);
		int sum = num.stream().reduce(0, Integer::sum);
		System.out.println(sum);

		
		System.out.println("sum of first 50 number using iteration");
		int sum1 = 0;
		for (Integer x : num) {
			sum1 += x;
		}

		System.out.println(sum1);

		
		
	}
}
