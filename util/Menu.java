package Test.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import Test.DaoImpl.CompanyDaoImpl;
import Test.DaoImpl.FuelDaoImpl;
import Test.DaoImpl.TypeDaoImpl;
import Test.models.Company;
import Test.models.Fuel;
import Test.models.Type;
import Test.repository.CompanyRepo;
import Test.repository.FuelRepo;
import Test.repository.TypeRepo;

public class Menu {
    static CompanyRepo cr = new CompanyDaoImpl();
    static FuelRepo fr = new FuelDaoImpl();
    static TypeRepo tr = new TypeDaoImpl();

    public static Company readCompany(List<Company> companies) {
        System.out.println("Select a Company : ");
        for (int i = 0; i < companies.size(); i++) {
            System.out.println((i + 1) + ". " + companies.get(i).getName());
        }

        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int choice = Integer.parseInt(br.readLine());
                if (choice < 1)
                    throw new Exception();
                if (choice == companies.size() + 1) {
                    System.out.println("Enter Company name to add: ");
                    String company = br.readLine();
                    Company obj = new Company();
                    obj.setName(company);
                    boolean added = cr.addCompany(obj);
                    if (added) {
                        return obj;
                    }
                } else {
                    return companies.get(choice - 1);
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid choice.");
            }
        }
    }

    public static int readModel() {
        System.out.println("Enter the model year : ");
        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int model = Integer.parseInt(br.readLine());
                if (model < 1800 || model > 2025) {
                    System.out.println("Invalid model year. Please enter a valid model year.");
                } else {
                    return model;
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid model year.");
            }
        }
    }

    public static int readSeater() {
        System.out.println("Enter the number of seats : ");
        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int seats = Integer.parseInt(br.readLine());
                if (seats < 2 || seats > 10) {
                    System.out.println("Invalid number of seats. Please enter a valid number of seats.");
                } else {
                    return seats;
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid number of seats.");
            }
        }
    }

    public static Fuel readFuelType(List<Fuel> fuelTypes) {
        System.out.println("Select a Fuel Type : ");
        for (int i = 0; i < fuelTypes.size(); i++) {
            System.out.println((i + 1) + ". " + fuelTypes.get(i).getFuelType());
        }

        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int choice = Integer.parseInt(br.readLine());
                if (choice < 1)
                    throw new Exception();
                if (choice == fuelTypes.size() + 1) {
                    System.out.println("Enter Fuel name to add: ");
                    String company = br.readLine();
                    Fuel obj = new Fuel();
                    obj.setFuelType(company);
                    boolean added = fr.addFuelType(obj);
                    if (added) {
                        return obj;
                    }
                }
                return fuelTypes.get(choice - 1);
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid choice.");
            }
        }
    }

    public static Type readModelType(List<Type> models) {
        System.out.println("Select a Model Type : ");
        for (int i = 0; i < models.size(); i++) {
            System.out.println((i + 1) + ". " + models.get(i).getTypeName());
        }

        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int choice = Integer.parseInt(br.readLine());
                if (choice == 1)
                    throw new Exception();
                if (choice == models.size() + 1) {
                    System.out.println("Enter Type name to add: ");
                    String company = br.readLine();
                    Type obj = new Type();
                    obj.setTypeName(company);
                    boolean added = tr.addType(obj);
                    if (added) {
                        return obj;
                    }
                }
                return models.get(choice - 1);
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid choice.");
            }
        }
    }

    public static double readPrice() {
        System.out.println("Enter the price : ");
        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                double price = Double.parseDouble(br.readLine());
                if (price < 0) {
                    System.out.println("Invalid price. Please enter a valid price.");
                } else {
                    return price;
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid price.");
            }
        }
    }

    public static boolean readSold() {
        System.out.println("Is the car sold?\n1. true\n2. false : ");
        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                return Integer.parseInt(br.readLine()) == 1;
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid choice.");
            }
        }
    }

    public static int readChoice(int max) {
        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int choice = Integer.parseInt(br.readLine());
                if (choice < 1 || choice > max) {
                    System.out.println("Invalid choice. Please enter a valid choice.");
                } else {
                    return choice;
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid choice.");
            }
        }
    }

    public static int readId() {
        System.out.println("Enter the id of the car : ");
        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int id = Integer.parseInt(br.readLine());
                if (id < 1) {
                    System.out.println("Invalid id. Please enter a valid id.");
                } else {
                    return id;
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid id.");
            }
        }
    }
}
