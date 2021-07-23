package self.jvm.base.java.compute;

/**
 * BitComputeDemo
 *
 * @author chenzb
 * @date 2020/11/24
 */
public class BitCompute {

	public static void main(String[] args) {
		long l = 6L;
		System.out.println(l & 1);
		System.out.println(l & 2);
		System.out.println(l & 4);


		System.out.println(l | 1);
		System.out.println(l | 4);
	}
}
