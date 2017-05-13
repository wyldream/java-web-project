package fileUpload;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ��ָ���쳣���ܻᵼ��ҳ����ʲ�������xmlɾ�����¼���
 * @author weiyongle
 *
 */
public class FileUpload extends ActionSupport{
	//�Զ���ȡ�ļ�������Ҫ����е�һ��
	private File file1;
	//�ļ���(����+FileName)
	private String file1FileName;
	//�ļ�����
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
		//��ȡ�ϴ���Ŀ¼·��
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		//����Ŀ���ļ�����
		if(file1FileName!=null)
		{
			File destFile = new File(path,file1FileName);
			//���ϴ����ļ�������Ŀ���ļ�
			FileUtils.copyFile(file1, destFile);
			return "success";
		}
		return "success";
	}
}
