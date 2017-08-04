import java.util.HashMap;

/**
 * Created by yabinh on 03/08/2017.
 */
public class FlyWeight {
    public static void main(String[] args) {
        ChessFactory factory = ChessFactory.getInstance();
        Chess chess1 = factory.getChess("b");
        Chess chess2 = factory.getChess("b");
        System.out.println(chess1 == chess2);

        Chess chess3 = factory.getChess("w");
        Chess chess4 = factory.getChess("w");
        System.out.println(chess3 == chess4);

        chess1.display(new Coordiantes(10, 15));
        chess2.display(new Coordiantes(14, 22));
    }
}

class Coordiantes {
    int x;
    int y;

    Coordiantes(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

abstract class Chess {
    abstract String getColor();
    void display(Coordiantes coordiantes) {
        System.out.println(
                "color is: " + getColor() + ", coordiantes is [" + coordiantes.x + ", " + coordiantes.y + "]");
    }
}

class BlackChess extends Chess {
    @Override
    String getColor() {
        return "black";
    }
}

class WhiteChess extends Chess {
    @Override
    String getColor() {
        return "white";
    }
}

class ChessFactory {
    private static ChessFactory instance = new ChessFactory();
    private HashMap<String, Chess> hm;

    private ChessFactory() {
        hm = new HashMap<String, Chess>();
        Chess black = new BlackChess();
        //Chess white = new WhiteChess();
        hm.put("b", black);
        //hm.put("w", white);
    }
    public static ChessFactory getInstance() {
        return instance;
    }
    public Chess getChess(String key) {
        if(hm.containsKey(key)) {
            return (Chess)hm.get(key);
        }
        // Returns a concrete flyweight.
        Chess chess = new WhiteChess();
        hm.put(key, chess);
        return chess;
    }
}
