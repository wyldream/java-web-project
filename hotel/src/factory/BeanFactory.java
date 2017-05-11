package factory;

import java.util.ResourceBundle;

/**
 * 工厂类，根据配置文件创建对象（生产对象）
 * @author weiyongle
 *
 */
public class BeanFactory {
	private static ResourceBundle bundle;
	static{
		bundle = ResourceBundle.getBundle("instance");
	}
	public static <T> T getInstance(String key,Class<T> clazz) {
		// TODO Auto-generated method stub
		//根据key获取值
        String className = bundle.getString(key);//从此资源包或它的某个父包中获取给定键的字符串。
        try {
			return (T)Class.forName(className).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
