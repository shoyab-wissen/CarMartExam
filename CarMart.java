package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Test.util.Menu;
import Test.models.CarMeta;
import Test.service.CarService;

public class CarMart {
    /*
     * java CarMart
     * ---------------
     * 1. Add
     * 2. Search
     * 3. Update (only price to be updated of specific car)
     * 4. Sold
     * 5. Exit
     * ---------------
     * Enter choice :-
     * 
     * 
     * CarID
     * Company
     * Model
     * Seater
     * FuelType
     * Type
     * Price
     * Sold true/false
     * 
     * 2. Search
     * ----------
     * 1. ALL (All unsold cars)
     * 2. Company (All cars of specific company)
     * 3. Type (eg. Hatchback, Sedan, SUV)
     * 4. Price range (to display all cars in the range of min to max)
     * 5. Exit
     * -----------
     * 
     * 
     * 4. Sold
     * ------------
     * 1. ALL (All sold cars)
     * 2. Update (unsold cars to be updated as sold out)
     * 3. Exit
     * ------------
     */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CarMeta carMeta = CarMeta.getCarMeta();
        CarService cs = new CarService(carMeta);
        int choice = 0;
        do {
            System.out.println("1. Add");
            System.out.println("2. Search");
            System.out.println("3. Update");
            System.out.println("4. Sold");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = Menu.readChoice(5);
            switch (choice) {
                case 1:
                    cs.addCar();
                    break;
                case 2:
                    cs.searchCar();
                    break;
                case 3:
                    cs.updateCar();
                    break;
                case 4:
                    // cs.soldCar();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }
}
