import DogCat.Cat;
import DogCat.Dog;

public class PackagePractice {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        DogCat.Dog dog2 = new DogCat.Dog();
        Cat cat1 = new Cat();
        DogCat.Cat cat2 = new DogCat.Cat();
    }
}
