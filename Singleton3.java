//import java.lang.System;

class Singleton3 {
    private Singleton3() {}
    
    private static class Holder {
        private final static Singleton3 instance = new Singleton3();
    }
    
    public static Singleton3 getInstance() {
        return Holder.instance;
    }
    
    // test
    public static void main(String[] args) {
        Singleton3 s1 = Singleton3.getInstance();
        Singleton3 s2 = Singleton3.getInstance();
        
        System.out.println("tst:" + (s1 == s2));
        
    }
    
}
