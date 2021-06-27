package exam2;

public class CommandExit1 implements Command
{
    public Menu menu;

    public CommandExit1(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.exit1();
    }
}
