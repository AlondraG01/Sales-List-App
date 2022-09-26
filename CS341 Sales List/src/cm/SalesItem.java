package cm;

/**
 * SalesItem Object should have a name, price, and qty.
 * Use methods set, get, and perform calculation operations
 * Write a toString() method to construct the string for a complete
 * SalesItem Obj that includes name, price, and qty
 * 
 * @author Alondra
 *
 */
public class SalesItem {
	private String item;
	private double price;
	private int qty;
	
	public SalesItem(String i, double p, int q) {
		item = i;
		price = p;
		qty = q;
	}
	
	public double getTotal() {
		return qty * price;
	}
	
	public String toString() {
		return item + "\t\t$" + price + "\t" + qty;
	}
}