package _03_Orders.model;

public class OrdersDetailBean {
	private	String	Orders_detail_UID;
	private	String	Orders_ID;
	private	int	Food_ID;
	private	String	Drink_name;
	private	int	Food_count;
	private	int	Food_original_price;
	private	String	Note;
	
	
	public String getOrders_detail_UID() {
		return Orders_detail_UID;
	}
	public void setOrders_detail_UID(String orders_detail_UID) {
		Orders_detail_UID = orders_detail_UID;
	}
	public String getOrders_ID() {
		return Orders_ID;
	}
	public void setOrders_ID(String orders_ID) {
		Orders_ID = orders_ID;
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
	public int getFood_count() {
		return Food_count;
	}
	public void setFood_count(int food_count) {
		Food_count = food_count;
	}
	public int getFood_original_price() {
		return Food_original_price;
	}
	public void setFood_original_price(int food_original_price) {
		Food_original_price = food_original_price;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public OrdersDetailBean(String orders_detail_UID, String orders_ID, int food_ID, String drink_name, int food_count,
			int food_original_price, String note) {
		super();
		Orders_detail_UID = orders_detail_UID;
		Orders_ID = orders_ID;
		Food_ID = food_ID;
		Drink_name = drink_name;
		Food_count = food_count;
		Food_original_price = food_original_price;
		Note = note;
	}
	public OrdersDetailBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrdersDetailBean [Orders_detail_UID=" + Orders_detail_UID + ", Orders_ID=" + Orders_ID + ", Food_ID="
				+ Food_ID + ", Drink_name=" + Drink_name + ", Food_count=" + Food_count + ", Food_original_price="
				+ Food_original_price + ", Note=" + Note + "]";
	}

	
	
	
	
	
}
