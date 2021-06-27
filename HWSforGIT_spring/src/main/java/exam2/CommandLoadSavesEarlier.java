package exam2;

// команды для работы с Меню
// ConcreteCommand
public class CommandLoadSavesEarlier implements Command
{
    public Menu menu;

    public CommandLoadSavesEarlier(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.loadSavesEarlier();
    }
}
