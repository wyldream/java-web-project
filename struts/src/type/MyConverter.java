package type;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;



/**
 * 自定义转换器类
 * 写一个类继承自StrutsTypeConverter，重写其中的方法
 * @author weiyongle
 *
 */
public class MyConverter extends StrutsTypeConverter {

	// 先定义项目中支持的转换的格式
	DateFormat[] df = { new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyyMMdd"),
			new SimpleDateFormat("yyyy年MM月dd日") };
	/**
	 * 把String转换为指定的类型 【String To Date】
	 * 
	 * @param context
	 *            当前上下文环境
	 * @param values
	 *            jsp表单提交的字符串的值
	 * @param toClass
	 *            要转换为的目标类型
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		// TODO Auto-generated method stub
		// 判断: 内容不能为空
		if (values == null || values.length == 0) {
			return null;
		}
		// 判断类型必须为Date
		if (Date.class != toClass) {
			return null;
		}
		
		// 迭代：转换失败继续下一个格式的转换； 转换成功就直接返回
		for (int i=0; i<df.length; i++) {
			try {
				return df[i].parse(values[0]);//解析字符串的文本，生成 Date。
			} catch (ParseException e) {
				continue;
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
