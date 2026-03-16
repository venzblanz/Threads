package threader;

public class Threader implements Runnable{
    private String name;
    private int age;
    public Threader(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {return name;}
    @Override
    public void run() {
        try{
            Thread.sleep(500);
            System.out.println(this.name + " STARTED");
        }catch(InterruptedException e){}
//        System.out.println("TERMINATED " + this.name);

    }
}
