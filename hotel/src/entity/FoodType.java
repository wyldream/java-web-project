package entity;
/**
 * 菜系模块实体类设计
 * @author weiyongle
 *
 */
public class FoodType {
	private int id;//类别主键
	private String typeName;//类别名称
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
