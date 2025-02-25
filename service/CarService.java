package Test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Test.DaoImpl.CarDaoImpl;
import Test.models.Car;
import Test.models.CarMeta;
import Test.models.Company;
import Test.models.Fuel;
import Test.models.Type;
import Test.repository.CarRepo;
import Test.util.Menu;

public class CarService {

    private static List<Company> companies = new ArrayList<>();
    private static List<Type> type = new ArrayList<>();
    private static List<Fuel> fuelTypes = new ArrayList<>();
    private static CarRepo carRepo = new CarDaoImpl();

    public CarService(CarMeta carMeta) {
        // populate companies, models and fuelTypes using the data from the database
        companies = carMeta.getCompany();
        type = carMeta.getType();
        fuelTypes = carMeta.getFuel();
    }

    public static List<Car> getCars() {
        return carRepo.findAll();
    }

    public void addCar() {
        System.out.println("Adding car to the database");
        Company company = Menu.readCompany(companies);
        int model = Menu.readModel();
        int seater = Menu.readSeater();
        Fuel fuelType = Menu.readFuelType(fuelTypes);
        Type types = Menu.readModelType(type);
        double price = Menu.readPrice();
        boolean sold = Menu.readSold();
        Car car = new Car.CarBuilder()
                .company(CarMeta.getCarMeta().getCompany().stream()
                        .filter((Company comp) -> company.getName() == company.getName())
                        .collect(Collectors.toList()).get(0))
                .fuel(CarMeta.getCarMeta().getFuel().stream()
                        .filter((Fuel fuel) -> fuel.getFuelType() == fuelType.getFuelType())
                        .collect(Collectors.toList()).get(0))
                .type(CarMeta.getCarMeta().getType().stream()
                        .filter((Type typese) -> typese
                                .getTypeName() == types.getTypeName())
                        .collect(Collectors.toList()).get(0))
                .model(model)
                .seater(seater)
                .price(price)
                .sold(sold)
                .build();
        carRepo.save(car);
        System.out.println("New Car has been added...");
    }

    public void searchCar() {
        // 2. Search

        // ----------

        // 1. ALL (All unsold cars)

        // 2. Company (All cars of specific company)

        // 3. Type (eg. Hatchback, Sedan, SUV)

        // 4. Price range (to display all cars in the range of min to max)

        System.out.println("Search using..");
        System.out.println("1. All");
        System.out.println("2. Company");
        System.out.println("3. Type");
        System.out.println("4. Price range");
        System.out.print("Enter your choice: ");
        int choice = Menu.readChoice(4);
        switch (choice) {
            case 1:
                List<Car> cars = carRepo.findAll();
                for (Car car : cars) {
                    System.out.println(car);
                }
                break;
            case 2:
                // Company company = Menu.readCompany(companies);
                // List<Car> carsByCompany = DatabaseOperations.getCarsByCompany(company);
                // for (Car car : carsByCompany) {
                // System.out.println(car);
                // }
                break;
            case 3:
                // Model type = Menu.readModelType(models);
                // List<Car> carsByType = DatabaseOperations.getCarsByType(type);
                // for (Car car : carsByType) {
                // System.out.println(car);
                // }
                break;
            case 4:
                // double min = Menu.readPrice();
                // double max = Menu.readPrice();
                // List<Car> carsByPrice = DatabaseOperations.getCarsByPrice(min, max);
                // for (Car car : carsByPrice) {
                // System.out.println(car);
                // }
                break;
            case 5:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void updateCar() {
        System.out.println("Updating car in the database");
        System.out.println("Enter the id of the car to be updated: ");
        int id = Menu.readId();
        // Car car = DatabaseOperations.getCar(id);
        // System.out.println("Car to be update is : " + car);
        // DatabaseOperations.updateCar(car);
        System.out.println("Car has been updated...");
    }

}