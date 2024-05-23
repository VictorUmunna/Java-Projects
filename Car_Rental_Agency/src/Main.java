import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vehicle Information System");
        System.out.println("Choose a vehicle type to create (1. Car, 2. Motorcycle, 3. Truck): ");
        
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createCar(scanner);
                    break;
                case 2:
                    createMotorcycle(scanner);
                    break;
                case 3:
                    createTruck(scanner);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        } finally {
            scanner.close();
        }
    }

    private static void createCar(Scanner scanner) {
        try {
            System.out.println("Enter the make of the car: ");
            String make = scanner.nextLine();

            System.out.println("Enter the model of the car: ");
            String model = scanner.nextLine();

            System.out.println("Enter the year of manufacture: ");
            int year = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            Car car = new Car(make, model, year);

            System.out.println("Enter the number of doors: ");
            int doors = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            car.setNumberOfDoors(doors);

            System.out.println("Enter the fuel type (petrol, diesel, electric): ");
            String fuelType = scanner.nextLine();
            car.setFuelType(fuelType);

            System.out.println("Car Details:");
            System.out.println("Make: " + car.getMake());
            System.out.println("Model: " + car.getModel());
            System.out.println("Year: " + car.getYearOfManufacture());
            System.out.println("Doors: " + car.getNumberOfDoors());
            System.out.println("Fuel Type: " + car.getFuelType());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine();  // Consume the invalid input
        }
    }

    private static void createMotorcycle(Scanner scanner) {
        try {
            System.out.println("Enter the make of the motorcycle: ");
            String make = scanner.nextLine();

            System.out.println("Enter the model of the motorcycle: ");
            String model = scanner.nextLine();

            System.out.println("Enter the year of manufacture: ");
            int year = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            Motorcycle motorcycle = new Motorcycle(make, model, year);

            System.out.println("Enter the number of wheels: ");
            int wheels = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            motorcycle.setNumberOfWheels(wheels);

            System.out.println("Enter the type of motorcycle (sport, cruiser, off-road): ");
            String type = scanner.nextLine();
            motorcycle.setMotorcycleType(type);

            System.out.println("Motorcycle Details:");
            System.out.println("Make: " + motorcycle.getMake());
            System.out.println("Model: " + motorcycle.getModel());
            System.out.println("Year: " + motorcycle.getYearOfManufacture());
            System.out.println("Wheels: " + motorcycle.getNumberOfWheels());
            System.out.println("Type: " + motorcycle.getMotorcycleType());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine();  // Consume the invalid input
        }
    }

    private static void createTruck(Scanner scanner) {
        try {
            System.out.println("Enter the make of the truck: ");
            String make = scanner.nextLine();

            System.out.println("Enter the model of the truck: ");
            String model = scanner.nextLine();

            System.out.println("Enter the year of manufacture: ");
            int year = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            Truck truck = new Truck(make, model, year);

            System.out.println("Enter the cargo capacity (in tons): ");
            double capacity = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            truck.setCargoCapacity(capacity);

            System.out.println("Enter the transmission type (manual, automatic): ");
            String transmission = scanner.nextLine();
            truck.setTransmissionType(transmission);

            System.out.println("Truck Details:");
            System.out.println("Make: " + truck.getMake());
            System.out.println("Model: " + truck.getModel());
            System.out.println("Year: " + truck.getYearOfManufacture());
            System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " tons");
            System.out.println("Transmission: " + truck.getTransmissionType());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine();  // Consume the invalid input
        }
    }
}

// Interfaces

interface Vehicle {
    String getMake();
    String getModel();
    int getYearOfManufacture();
}

interface CarVehicle extends Vehicle {
    void setNumberOfDoors(int doors);
    int getNumberOfDoors();
    
    void setFuelType(String fuelType);
    String getFuelType();
}

interface MotorVehicle extends Vehicle {
    void setNumberOfWheels(int wheels);
    int getNumberOfWheels();
    
    void setMotorcycleType(String type);
    String getMotorcycleType();
}

interface TruckVehicle extends Vehicle {
    void setCargoCapacity(double capacity);
    double getCargoCapacity();
    
    void setTransmissionType(String transmission);
    String getTransmissionType();
}

// Classes

class Car implements CarVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private int numberOfDoors;
    private String fuelType;

    public Car(String make, String model, int yearOfManufacture) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    @Override
    public void setNumberOfDoors(int doors) {
        this.numberOfDoors = doors;
    }

    @Override
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String getFuelType() {
        return fuelType;
    }
}

class Motorcycle implements MotorVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private int numberOfWheels;
    private String motorcycleType;

    public Motorcycle(String make, String model, int yearOfManufacture) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    @Override
    public void setNumberOfWheels(int wheels) {
        this.numberOfWheels = wheels;
    }

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public void setMotorcycleType(String type) {
        this.motorcycleType = type;
    }

    @Override
    public String getMotorcycleType() {
        return motorcycleType;
    }
}

class Truck implements TruckVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private double cargoCapacity;
    private String transmissionType;

    public Truck(String make, String model, int yearOfManufacture) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    @Override
    public void setCargoCapacity(double capacity) {
        this.cargoCapacity = capacity;
    }

    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public void setTransmissionType(String transmission) {
        this.transmissionType = transmission;
    }

    @Override
    public String getTransmissionType() {
        return transmissionType;
    }
}
