import java.text.NumberFormat;


public class Classes {

	
		String name;
		double price;
		int quantity;
		
		public Classes (String name, double price, int quantity){
			this.name = name;
			this.price = price;
			this.quantity = quantity;
			
		}

		public String getName ()
		{
			return name;
		}
		public double getPrice ()
		{
			return price;
		}
		public int getQuantity ()
		{
			return quantity;
		}
		public String toString ()
		{
			NumberFormat fmt = NumberFormat.getCurrencyInstance();
			return (name + "\t" + fmt.format (price) + "\t" + fmt.format (price*quantity));
		}
}
