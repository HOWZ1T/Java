import java.math.BigDecimal;
import java.util.Scanner;

public class FloorTiles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Double cost = 0.0;
		
		boolean validDecimals = false;
		
		// Ask for unit type
		System.out.print("Enter unit of length: ");
		String unit = sc.nextLine();
		
		// Ask for floor tile cost, error if more than two decimals entered
		while (!validDecimals) {
			System.out.print("Enter cost per tile in dollars up to two decimal places: ");
			cost = sc.nextDouble();
			
			if (BigDecimal.valueOf(cost).scale() <= 2) {
				validDecimals = true;
				break;
			}
			else {
				System.out.println("ERROR: More than two decimals entered");
			}
		}
		
		// Ask for width and height
		System.out.print("Enter width of floor: ");
		Double width = sc.nextDouble();
		
		System.out.print("Enter height of floor: ");
		Double height = sc.nextDouble();
		
		System.out.println("The total cost for a " + width + " x " + height + " " + unit + " floor is $" + (width*height*cost));

		
	}
}

