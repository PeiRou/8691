package _03_Orders.model;

import java.util.Date;

public class OrdersTotalBean {

	private	String	Orders_total_UID;  
	private	String	Member_UID;
	private	String	Orders_ID;
	private	String	status;
	private	String	name;
	private	String	cel;
	private	String	GUAR_CT;
	private	String	GUAR_AR;
	private	String	GUAR_ROAD;
	private	String	GUAR_NO;
	private	String	pay_metho;
	private	java.util.Date	insdate;
	private	int	ship_price;
	private	int	food_price;
	private	int	total_amount;
	
	
	public String getOrders_total_UID() {
		return Orders_total_UID;
	}
	public void setOrders_total_UID(String orders_total_UID) {
		Orders_total_UID = orders_total_UID;
	}
	public String getMember_UID() {
		return Member_UID;
	}
	public void setMember_UID(String member_UID) {
		Member_UID = member_UID;
	}
	public String getOrders_ID() {
		return Orders_ID;
	}
	public void setOrders_ID(String orders_ID) {
		Orders_ID = orders_ID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		this.cel = cel;
	}
	public String getGUAR_CT() {
		return GUAR_CT;
	}
	public void setGUAR_CT(String gUAR_CT) {
		GUAR_CT = gUAR_CT;
	}
	public String getGUAR_AR() {
		return GUAR_AR;
	}
	public void setGUAR_AR(String gUAR_AR) {
		GUAR_AR = gUAR_AR;
	}
	public String getGUAR_ROAD() {
		return GUAR_ROAD;
	}
	public void setGUAR_ROAD(String gUAR_ROAD) {
		GUAR_ROAD = gUAR_ROAD;
	}
	public String getGUAR_NO() {
		return GUAR_NO;
	}
	public void setGUAR_NO(String gUAR_NO) {
		GUAR_NO = gUAR_NO;
	}
	public String getPay_metho() {
		return pay_metho;
	}
	public void setPay_metho(String pay_metho) {
		this.pay_metho = pay_metho;
	}
	public java.util.Date getInsdate() {
		return insdate;
	}
	public void setInsdate(java.util.Date insdate) {
		this.insdate = insdate;
	}
	public int getShip_price() {
		return ship_price;
	}
	public void setShip_price(int ship_price) {
		this.ship_price = ship_price;
	}
	public int getFood_price() {
		return food_price;
	}
	public void setFood_price(int food_price) {
		this.food_price = food_price;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public OrdersTotalBean(String orders_total_UID, String member_UID, String orders_ID, String status, String name,
			String cel, String gUAR_CT, String gUAR_AR, String gUAR_ROAD, String gUAR_NO, String pay_metho,
			Date insdate, int ship_price, int food_price, int total_amount) {
		super();
		Orders_total_UID = orders_total_UID;
		Member_UID = member_UID;
		Orders_ID = orders_ID;
		this.status = status;
		this.name = name;
		this.cel = cel;
		GUAR_CT = gUAR_CT;
		GUAR_AR = gUAR_AR;
		GUAR_ROAD = gUAR_ROAD;
		GUAR_NO = gUAR_NO;
		this.pay_metho = pay_metho;
		this.insdate = insdate;
		this.ship_price = ship_price;
		this.food_price = food_price;
		this.total_amount = total_amount;
	}
	public OrdersTotalBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrdersTotalBean [Orders_total_UID=" + Orders_total_UID + ", Member_UID=" + Member_UID + ", Orders_ID="
				+ Orders_ID + ", status=" + status + ", name=" + name + ", cel=" + cel + ", GUAR_CT=" + GUAR_CT
				+ ", GUAR_AR=" + GUAR_AR + ", GUAR_ROAD=" + GUAR_ROAD + ", GUAR_NO=" + GUAR_NO + ", pay_metho="
				+ pay_metho + ", insdate=" + insdate + ", ship_price=" + ship_price + ", food_price=" + food_price
				+ ", total_amount=" + total_amount + "]";
	}

	

	
}
