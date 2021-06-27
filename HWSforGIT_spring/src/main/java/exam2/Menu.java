package exam2;

import java.io.File;
import static java.lang.Thread.sleep;

//Reciever
public class Menu
{
    private FileReadFrom fileReadFrom;

    public Menu() {
        fileReadFrom = new FileReadFrom(new File("lisenok.txt"));
    }

    public void start() // Меню: 1. Начать игру
    {
        //System.out.println("1. Начать игру - текст из класса меню");
        Lisenok lisenok = new Lisenok(1);
        lisenok.begin();
    }
    public void loadSavesEarlier() // Меню: 2. Загрузить игру - если не сохранял - то вывести Облом
    {
        System.out.println("Начинается загрузка ранее сохранённых параметров.");
            try {
                String fromFile = new String(fileReadFrom.readFromFile()); //читать из файла
                System.out.println("      *");
                sleep(600);
                System.out.println(" *   ***   *");
                sleep(600);
                System.out.println("  ***   ***");
                sleep(600);
                System.out.println("   * * * *");
                sleep(600);
                System.out.println("   *     *");
                sleep(600);

                if(fromFile.equals("")) //System.out.println(" if fromFile == null");
                {
                    System.out.println("\nОй, а ранее-то вы не играли. Нет данных для загрузки ранее сохранённых " +
                            "параметров. \nВы можете выбрать один из других пунктов меню:");
                    MenuStarting menuStarting = new MenuStarting();
                    menuStarting.getMenuStarting();
                } else
                {
                    System.out.println("\nПараметры удачно загружены. Продолжаем продолжать...: ");
                    int pointFromSavedEarlier = Integer.parseInt(fromFile);
                    Lisenok lisenok = new Lisenok(pointFromSavedEarlier);
                    lisenok.begin();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    public void exit() // Меню: 3. Выйти - если нажал выход, то надо запросить Сохранить
    {
        //System.out.println("3. Выйти");
        System.out.println("Игра окончена без сохранения результата. Всё, дасвидос ;о)\n\n\n\n\n\n\n");
    }
    public void exit1()
    {
        System.out.println("Промежуточные результаты игры удачно сохранены. Выход совершён. ;о)");
    }
}
