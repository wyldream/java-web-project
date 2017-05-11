package entity;

import java.util.Date;
/**
 * ²Í×ÀÊµÌåÀà
 * @author weiyongle
 *
 */
public class DinnerTable {
	private int id;
	private String tableName;
	private String tableStatus;
	private Date dateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableStatus() {
		return tableStatus;
	}
	public void setTableStatus(String tableStatus) {
		this.tableStatus = tableStatus;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
}
