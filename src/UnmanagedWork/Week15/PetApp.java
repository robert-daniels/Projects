package UnmanagedWork.Week15;

public class PetApp {
    
    public static void main(String[] args){

        //Pet myPet = new Pet();
        
        //System.out.println(myPet.getName());
        //myPet.setName("toby");

        //System.out.println(myPet.getName());

        //myPet.speak();

        Cat myOtherPet = new Cat("babs", "meowww");

        myOtherPet.speak();

        Dog myDog = new Dog();

        myDog.speak();

        myDog.fetch();
        myDog.bark();


        Dog myOtherDog = new Dog("rufus", "wuuf");
        myOtherDog.bark();

        myDog.speak();

    }
}
