package self.jvm.base.java.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * MyClassLoader
 *
 * @author chenzb
 * @date 2020/9/21
 */
public class MyClassLoader extends ClassLoader {

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class log = null;
		// 获取该class文件字节码数组
		byte[] classData = getData();

		if (classData != null) {
			// 将class的字节码数组转换成Class类的实例
			log = defineClass(name, classData, 0, classData.length);
		}
		return log;
	}

	private byte[] getData() {

		File file = new File("");
		if (file.exists()) {
			FileInputStream in = null;
			ByteArrayOutputStream out = null;
			try {
				in = new FileInputStream(file);
				out = new ByteArrayOutputStream();

				byte[] buffer = new byte[1024];
				int size = 0;
				while ((size = in.read(buffer)) != -1) {
					out.write(buffer, 0, size);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			return out.toByteArray();
		} else {
			return null;
		}

	}
}
