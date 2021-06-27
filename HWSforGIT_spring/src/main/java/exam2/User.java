package exam2;

//Invoker
public class User
{
    Command start;
    Command loadSavesEarlier;
    Command exit;
    Command exit1;

    public User(Command start, Command loadSavesEarlier, Command exit, Command exit1) {
        this.start = start;
        this.loadSavesEarlier = loadSavesEarlier;
        this.exit = exit;
        this.exit1 = exit1;
    }

    public void startMenu()
    {
        start.execute();
    }

    public void loadSavesEarlierMenu()
    {
        loadSavesEarlier.execute();
    }

    public void exitMenu()
    {
        exit.execute();
    }

    public void exitMenu1()
    {
        exit1.execute();
    }
}
