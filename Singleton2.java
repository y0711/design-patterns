//import java.lang.System;

class Singleton2 {
    private static Singleton2 instance = new Singleton2();
    
    private Singleton2() {}
    
    public static Singleton2 getInstance() {
        return instance;
    }
    
    // test
    public static void main(String[] args) {
        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        
        System.out.println("tst:" + (s1 == s2));
    }
}
