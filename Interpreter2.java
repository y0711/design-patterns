import java.util.*;

/**
 * Created by yabinh on 26/08/2017.
 */
public class Interpreter2 {
    public static void main(String[] args) {
        final String instruction =
                "LOOP 2 PRINT YangGuo SPACE SPACE PRINT XiaoLongNu BREAK END PRINT GuoJing SPACE SPACE PRINT HuangRong";
        Context context = new Context(instruction);
        Node expressionNode = new ExpressionNode();
        expressionNode.interpret(context);
        expressionNode.execute();
    }
}

class Context {
    private String[] tokens;
    private int index;


    Context(String instruction) {
        tokens = instruction.split(" ");
        index = 0;
    }
    String currentToken() {
        if (index >= tokens.length) {
            return null;
        }
        return tokens[index];
    }
    boolean skipToken(String token) {
        if (index >= tokens.length) {
            return false;
        }
        if (!tokens[index].equals(token)) {
            System.out.println("Extected token [" + token + "], but got [" + tokens[index] + "].");
            return false;
        }
        ++ index;
        return true;
    }
    int getNumber() {
        if (index >= tokens.length) {
            System.out.println("Expected number but no tokens.");
            return -1;
        }
        int num = Integer.parseInt(tokens[index]);
        ++index;
        return num;
    }
}

interface Node {
    void interpret(Context context);
    void execute();
}

class PrimitiveCommandNode implements Node {
    private static HashSet<String> dic = new HashSet<String>(3);
    static {
        dic.add("PRINT");
        dic.add("SPACE");
        dic.add("BREAK");
    }
    private String name;
    private String text;

    @Override
    public void interpret(Context context) {
        if (context.currentToken() == null) {
            System.out.println("End of tokens!");
            return;
        }
        if (!dic.contains(context.currentToken())) {
            System.out.println("Invalid token: [" + context.currentToken() + "]");
            return;
        }
        name = context.currentToken();
        context.skipToken(name);
        if (name.equals("PRINT")) {
            text = context.currentToken();
            context.skipToken(text);
        }
    }
    @Override
    public void execute() {
        if (name.equals("PRINT")) {
            System.out.print(text);
        } else if (name.equals("SPACE")) {
            System.out.print(" ");
        } else {
            System.out.print("\n");
        }
    }

}

class LoopCommandNode implements Node {
    private int number;
    private Node expressionNode;
    @Override
    public void interpret(Context context) {
        if (!context.skipToken("LOOP")) {
            return;
        }
        number = context.getNumber();
        expressionNode = new ExpressionNode();
        expressionNode.interpret(context);
    }
    @Override
    public void execute() {
        for (int i = 0; i < number; i++) {
            expressionNode.execute();
        }
    }
}

class CommandNode implements Node {
    private Node node;
    @Override
    public void interpret(Context context) {
        if (context.currentToken().equals("LOOP")) {
            node = new LoopCommandNode();
            node.interpret(context);
        } else {
            node = new PrimitiveCommandNode();
            node.interpret(context);
        }
    }
    @Override
    public void execute() {
        node.execute();
    }
}

class ExpressionNode implements Node {
    private ArrayList<Node> list = new ArrayList<Node>();

    @Override
    public void interpret(Context context) {
        while (context.currentToken() != null) {
            if (context.currentToken().equals("END")) {
                context.skipToken("END");
                break;
            }
            Node commandNode = new CommandNode();
            commandNode.interpret(context);
            list.add(commandNode);
        }
    }
    @Override
    public void execute() {
        Iterator<Node> iterator = list.iterator();
        while (iterator.hasNext()) {
            Node node = (Node)iterator.next();
            node.execute();
        }
    }
}

