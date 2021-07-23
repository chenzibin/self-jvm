package self.jvm.base.java.struct.iterable;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * MyIterator
 *
 * @author chenzb
 * @date 2020/11/20
 */
public class IteratorDemo implements Iterable {

	@Override
	public Iterator iterator() {
		return new MyIterator();
	}

	@Override
	public void forEach(Consumer action) {
		Objects.requireNonNull(action);
	}

	class MyIterator implements Iterator {

		int i = 0;

		@Override
		public boolean hasNext() {
			return i < 3;
		}

		@Override
		public Object next() {
			return i++;
		}
	}

	public static void main(String[] args) {
		IteratorDemo iterator = new IteratorDemo();
		for (Object i : iterator) {
			System.out.println(i);
		}
		System.out.println(Integer.toBinaryString(Spliterator.DISTINCT | Spliterator.SORTED | Spliterator.ORDERED));
	}
}
