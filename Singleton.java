//import java.lang.System;

class Singleton {
    private static Singleton instance = null;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {
            System.out.println("new");
            instance =  new Singleton();
        }
        return instance;
    }
    
    // test
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        
        System.out.println("tst:" + (s1 == s2));
        
    }
}
