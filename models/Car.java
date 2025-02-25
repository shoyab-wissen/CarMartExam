package Test.models;

public class Car {
    private int carId;
    private Company company;
    private Fuel fuel;
    private Type type;
    private int seater;
    private double price;
    private int model;
    private boolean sold;

    private Car(CarBuilder builder) {
        this.carId = builder.carId;
        this.company = builder.company;
        this.fuel = builder.fuel;
        this.type = builder.type;
        this.seater = builder.seater;
        this.price = builder.price;
        this.model = builder.model;
        this.sold = builder.sold;
    }

    public int getCarId() {
        return carId;
    }

    public Company getCompany() {
        return company;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public Type getType() {
        return type;
    }

    public int getSeater() {
        return seater;
    }

    public double getPrice() {
        return price;
    }

    public int getModel() {
        return model;
    }

    public boolean isSold() {
        return sold;
    }

    public static class CarBuilder {
        private int carId;
        private Company company;
        private Fuel fuel;
        private Type type;
        private int seater;
        private double price;
        private int model;
        private boolean sold;

        public CarBuilder carId(int carId) {
            this.carId = carId;
            return this;
        }

        public CarBuilder company(Company company) {
            this.company = company;
            return this;
        }

        public CarBuilder fuel(Fuel fuel) {
            this.fuel = fuel;
            return this;
        }

        public CarBuilder type(Type type) {
            this.type = type;
            return this;
        }

        public CarBuilder seater(int seater) {
            this.seater = seater;
            return this;
        }

        public CarBuilder price(double price) {
            this.price = price;
            return this;
        }

        public CarBuilder model(int model) {
            this.model = model;
            return this;
        }

        public CarBuilder sold(boolean sold) {
            this.sold = sold;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

}
