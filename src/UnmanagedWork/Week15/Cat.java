package UnmanagedWork.Week15;

public class Cat extends Pet {
    
    public Cat() {

        super("cat", "meow");
    }

    public Cat(String name) {
        super(name, "meow");
    }

    public Cat(String name, String sound) {
        super(name, sound);
    }


    public void fetch() {
        System.out.println(getName() + " ignores me...");
    }

}
