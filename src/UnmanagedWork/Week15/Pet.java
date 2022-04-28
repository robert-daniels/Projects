package UnmanagedWork.Week15;

public abstract class Pet {
    
    private static String DEF_SOUND = "???";
    private static String DEF_NAME = "pet";
    protected String name;
    protected String sound;

    public Pet() {
        name = DEF_NAME;
        sound = DEF_SOUND;
    }

    public Pet(String name) {
        this.name = name;
        sound = DEF_SOUND;
    }

    public Pet(String name, String sound){
        this.name = name;
        this.sound = sound;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void speak(){
        System.out.println(name + " says: " + sound);
    }

}
