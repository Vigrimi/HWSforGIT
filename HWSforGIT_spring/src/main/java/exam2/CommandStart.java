package exam2;

// команды для работы с Меню
// ConcreteCommand
public class CommandStart implements Command
{
    public Menu menu;

    public CommandStart(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.start();
    }
}
