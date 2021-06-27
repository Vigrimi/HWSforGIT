package exam2;

import java.util.Scanner;

public class MenuStarting
{
    public Menu menu;
    public User user;
    private Scanner scanner;

    public MenuStarting() {
        scanner = new Scanner(System.in);
    }

    public void getMenuStarting()
    {
        Menu menu = new Menu();
        User user = new User(new CommandStart(menu),new CommandLoadSavesEarlier(menu),new CommandExit(menu),new CommandExit1(menu));
        System.out.println("\n1. Начать игру\n2. Загрузить игру из ранее сохранённого\n3. Выйти " +
                "\nВведи цифру с выбранным пунктом меню: ");
        int pointMenu = scanner.nextInt();
        if(pointMenu == 1) //1. Начать игру
        {
            user.startMenu();
        } else if(pointMenu == 2)
        {
            user.loadSavesEarlierMenu();
        } else if(pointMenu == 3)
        {
            user.exitMenu();
        }
    }

    public void getMenuStartingDigit(int pointMenuA)
    {
        Menu menu = new Menu();
        User user = new User(new CommandStart(menu),new CommandLoadSavesEarlier(menu),new CommandExit(menu)
                ,new CommandExit1(menu));
        if(pointMenuA == 1) //1. Начать игру
        {
            user.startMenu();
        } else if(pointMenuA == 2)
        {
            user.loadSavesEarlierMenu();
        } else if(pointMenuA == 3)
        {
            user.exitMenu();
        }
        else if(pointMenuA == 4)
        {
            user.exitMenu1();
        }
    }
}
