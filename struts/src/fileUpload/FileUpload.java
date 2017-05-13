package fileUpload;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 空指针异常可能会导致页面访问不到，把xml删掉重新加载
 * @author weiyongle
 *
 */
public class FileUpload extends ActionSupport{
	//自动获取文件，名称要与表单中的一致
	private File file1;
	//文件名(名称+FileName)
	private String file1FileName;
	//文件类型
	private String file1ContentType;
	public void setFile1(File file1){
		this.file1 = file1;
	}
	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}
	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}
	@Override
	public String execute() throws Exception {
		//获取上传的目录路径
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		//创建目标文件对象
		if(file1FileName!=null)
		{
			File destFile = new File(path,file1FileName);
			//把上传的文件拷贝到目标文件
			FileUtils.copyFile(file1, destFile);
			return "success";
		}
		return "success";
	}
}
