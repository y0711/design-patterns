import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by yabinh on 20/08/2017.
 */
public class ChainOfResponsibility {
    public static void main(String[] args) {
        Approver m = new Manager();
        Approver d = new Director();
        Approver b = new Boss();

        m.setSuccessor(d);
        d.setSuccessor(b);

        Request request1 = new Request(2000);
        Request request2 = new Request(30000);
        Request request3 = new Request(4000000);

        m.process(request1);
        m.process(request2);
        m.process(request3);
    }
}

class Request {
    private int num;
    Request(int num) {
        this.num = num;
    }
    int getNum() { return num;}
}

abstract class Approver {
    protected Approver successor;
    void setSuccessor(Approver successor) {
        this.successor = successor;
    }
    abstract void process(Request request);
}

class Manager extends Approver {
    @Override
    void process(Request request) {
        if(request.getNum() < 10000) {
            System.out.println("Manager approved an order of " + request.getNum() + " dollar");
        } else {
            successor.process(request);
        }
    }
}

class Director extends Approver {
    @Override
    void process(Request request) {
        if(request.getNum() < 100000) {
            System.out.println("Director approved an order of " + request.getNum() + " dollar");
        } else {
            successor.process(request);
        }
    }
}

class Boss extends Approver {
    @Override
    void process(Request request) {
        System.out.println("Boss approved an order of " + request.getNum() + " dollar");

    }
}
