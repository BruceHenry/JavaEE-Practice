package shoppingCart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
	private List<Item> items = new ArrayList<Item>();

	public void save(Item newItem) {
		for (Item item : items) {
			if (item.getId().equals(newItem.getId())) {
				item.setNum(item.getNum() + newItem.getNum());
				return;
			}
		}
		items.add(newItem);
	}
	

	public void delete(String id) {
		for (Iterator<Item> it = items.iterator(); it.hasNext();) {
			Item item = it.next();
			if (item.getId().equals(id)) {
				it.remove();
			}
		}
	}
	
	public Double getTotalPrice(){
		Double totalPrice = 0D;
		for(Item item:items){
			totalPrice += item.getPrice()*item.getNum();
		}
		return totalPrice;
	}
	

	public List<Item> getItems() {
		return items;
	}


	@Override
	public String toString() {
		return "Cart [items=" + items + "]"+getTotalPrice();
	}

}
