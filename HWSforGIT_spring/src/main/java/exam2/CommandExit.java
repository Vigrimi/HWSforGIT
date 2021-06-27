package exam2;

// команды для работы с Меню
// ConcreteCommand
public class CommandExit implements Command
{
    public Menu menu;

    public CommandExit(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.exit();
    }
}
