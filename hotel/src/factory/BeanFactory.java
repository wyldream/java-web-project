package factory;

import java.util.ResourceBundle;

/**
 * �����࣬���������ļ�����������������
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
		//����key��ȡֵ
        String className = bundle.getString(key);//�Ӵ���Դ��������ĳ�������л�ȡ���������ַ�����
        try {
			return (T)Class.forName(className).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
