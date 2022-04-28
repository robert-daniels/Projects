package UnmanagedWork.Week15;

public class Dog extends Pet {
    
    public Dog() {
        // sound = "woof";
        // setName("toby");

        super("dog", "woof");
    }

    public Dog(String name) {
        super(name, "woof");
    }

    public Dog(String name, String sound) {
        super(name, sound);
    }


    public void fetch() {
        System.out.println(getName() + " is getting a ball..");
    }

    public void bark() {
        super.speak();
    }

    @Override
    public void speak() {
        System.out.println(getName() + " says: " + sound + " " + sound );
    }
}
