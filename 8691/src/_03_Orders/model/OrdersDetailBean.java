package _03_Orders.model;

public class OrdersDetailBean {
	private	String	Orders_detail_UID;
	private	String	ordersID;
	private	int	Food_ID;
	private	String	Drink_name;
	private	int	quantity;
	private	int	originalPrice;
	private	String	note;
	public String getOrders_detail_UID() {
		return Orders_detail_UID;
	}
	public void setOrders_detail_UID(String orders_detail_UID) {
		Orders_detail_UID = orders_detail_UID;
	}
	public String getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(String ordersID) {
		this.ordersID = ordersID;
	}
	public int getFood_ID() {
		return Food_ID;
	}
	public void setFood_ID(int food_ID) {
		Food_ID = food_ID;
	}
	public String getDrink_name() {
		return Drink_name;
	}
	public void setDrink_name(String drink_name) {
		Drink_name = drink_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(int originalPrice) {
		this.originalPrice = originalPrice;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public OrdersDetailBean(String orders_detail_UID, String ordersID, int food_ID, String drink_name, int quantity,
			int originalPrice, String note) {
		super();
		Orders_detail_UID = orders_detail_UID;
		this.ordersID = ordersID;
		Food_ID = food_ID;
		Drink_name = drink_name;
		this.quantity = quantity;
		this.originalPrice = originalPrice;
		this.note = note;
	}
	public OrdersDetailBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrdersDetailBean [Orders_detail_UID=" + Orders_detail_UID + ", ordersID=" + ordersID + ", Food_ID="
				+ Food_ID + ", Drink_name=" + Drink_name + ", quantity=" + quantity + ", originalPrice=" + originalPrice
				+ ", note=" + note + "]";
	}
	
	
	
	
}
