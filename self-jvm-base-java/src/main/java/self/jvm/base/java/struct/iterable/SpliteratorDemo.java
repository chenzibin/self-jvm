package self.jvm.base.java.struct.iterable;

import java.util.ArrayList;
import java.util.Spliterator;

/**
 * SpliteratorDemo
 *
 * @author chenzb
 * @date 2020/11/23
 */
public class SpliteratorDemo {

	public static void main(String[] args) {
		ArrayList<String> arrays = new ArrayList<String>();

		arrays.add("a");
		arrays.add("b");
		arrays.add("c");
		arrays.add("d");
		arrays.add("e");
		arrays.add("f");
		arrays.add("g");
		arrays.add("h");
		arrays.add("i");
		arrays.add("j");

		arrays.remove("j");

		Spliterator<String> p = arrays.spliterator();

		Spliterator<String> s1 = p.trySplit();

		Spliterator<String> s2 = p.trySplit();

		System.out.println("p.consume :");
		p.forEachRemaining(System.out::println);

		System.out.println("s1.consume");
		s1.forEachRemaining(System.out::println);

		System.out.println("s2.consume");
		s2.forEachRemaining(System.out::println);

	}
}
