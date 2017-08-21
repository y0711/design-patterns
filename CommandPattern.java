/**
 * Created by yabinh on 20/08/2017.
 */
public class CommandPattern {
    public static void main(String[] args) {
        FunctionButton button = new FunctionButton();
        Command c1 = new HelpCommand();
        Command c2 = new WindowCommand();

        button.setCommand(c1);
        button.onClick();

        button.setCommand(c2);
        button.onClick();
    }
}

class FunctionButton {
    private Command command;
    void setCommand(Command command) { this.command = command;}
    void onClick() {
        System.out.println("Click button!");
        command.execute();
    }
}

interface Command {
    void execute();
}

class HelpCommand implements Command {
    private HelpHandler handler;
    HelpCommand() { handler = new HelpHandler();}
    @Override
    public void execute() {
        handler.display();
    }
}

class HelpHandler {
    void display() {
        System.out.println("Display help doc.");
    }
}

class WindowCommand implements Command {
    private WindowHandler handler;
    WindowCommand() { handler = new WindowHandler();}
    @Override
    public void execute() {
        handler.minimize();
    }
}

class WindowHandler {
    void minimize() {
        System.out.println("Minimize window.");
    }
}
