package cm;

import java.util.*;

/**
 * Model the list of items. Use an ArrayList (or Linked List) to create the
 * SalesItem objects as they are added to the list. Use methods for adding a
 * sales item, computing the total sales, etc. Write a toString() method to
 * construct the complete list of sales items
 * 
 * @author Alondra
 *
 */
public class SalesSlip {
	/**
	 * Data members salesItem is the list object that will hold the information
	 * 
	 */
	private ArrayList<SalesItem> salesList;

	/**
	 * Constructor
	 * @param str 
	 * 
	 */
	public SalesSlip() {
		salesList = new ArrayList<SalesItem>();
	}

	public void addNewItem(SalesItem s) {
		salesList.add(s);
	}
	
	public String toString() {
		String completeStr = "";
		
		for(int i = 0; i < salesList.size(); i++) {
			completeStr += salesList.get(i).toString() + "\n";
		}
		
		return completeStr;
	}
	
	public String addTotal() {
			Double total = 0.0;
			
			for(int i = 0; i < salesList.size(); i++) {
				total += salesList.get(i).getTotal();
			}
			
			return "$" + total;
	}

}
