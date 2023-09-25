package service;

public class Sub extends Test {
    static {
        System.out.println("sub static");
    }

    public static Test test = new Test();

    {
        System.out.println("sub block");
    }

    public Sub(){
        System.out.println("sub construct");
    }

}
