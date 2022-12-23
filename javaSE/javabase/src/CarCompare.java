public class CarCompare {
    public static void main(String[] args) {
        Car self =  new Car(40,9.0F);
        self.showMe();
        System.out.println(self.compare(new Car()));
    }
}

class Car {
    private int maxspeed = 200;
    private Float price = 10.0F;

    public Car() {
    }

    public Car(int maxspeed, Float price) {
        this.maxspeed = maxspeed;
        this.price = price;
    }

    public void showMe() {
        System.out.println("CarMaxSpeed=" + maxspeed + ",price=" + price);
    }

    public int compare(Car other) {
        int flag = 0;
        if (this.maxspeed > other.maxspeed) {
            flag = 1;
        } else if (this.maxspeed == other.maxspeed) {
            flag = this.price < other.price ? 1 : -1;
        } else {
            flag = -1;
        }
        return flag;
    }

}