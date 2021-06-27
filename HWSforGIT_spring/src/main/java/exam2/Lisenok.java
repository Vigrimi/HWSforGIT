package exam2;

import java.io.File;
import java.util.Scanner;

public class Lisenok
{
    private int pointOfGame;
    private Scanner scanner;
    private MenuStarting menuStarting;
    private FileWriteIn fileWriteIn;

    public Lisenok(int pointOfGame) {
        this.pointOfGame = pointOfGame;
        scanner = new Scanner(System.in);
        menuStarting = new MenuStarting();
        fileWriteIn = new FileWriteIn(new File("lisenok.txt"));
    }

    public void begin()
    { // 1 3 4 6 7 8 9 12 13
        //System.out.println("let's go " + pointOfGame);
        if(pointOfGame == 1) getBlock1();
        else if(pointOfGame == 3) getBlock3();
        else if(pointOfGame == 4) getBlock4();
        else if(pointOfGame == 6) getBlock6();
        else if(pointOfGame == 7) getBlock7();
        else if(pointOfGame == 8) getBlock8();
        else if(pointOfGame == 9) getBlock9();
        else if(pointOfGame == 12) getBlock12();
        else if(pointOfGame == 13) getBlock13();
    }

    public void getBlock1()
    {
        System.out.println("Нууу, пахнали...:\nКаждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. \nЭто утро не " +
                "было исключением. Лисёнок пришёл на их обычное место встречи, но Бельчонка там не было. \nЛисёнок " +
                "ждал, ждал, но так и не смог дождаться своего друга. \n\"Бельчонок не пропустил еще ни одной " +
                "встречи, вдруг он попал в беду.\" - подумал Лисёнок. \nКак поступить Лисенку?" +
                "\nНадо выбрать: \n1.Вернуться домой\n2.Отправиться на поиски");
        System.out.println("***###***###***###***\n0.Выйти с сохранением игры\n3.Выйти без сохранения");
        int decision = scanner.nextInt();
        if (decision == 3)
        {
            System.out.println("Ну, так, на всякий случай, точно Выйти без сохранения? \nЕщё есть время передумать, " +
                    "но это последний шанс:");
            decision = scanner.nextInt();
        }
        if (decision == 0)
        {
            fileWriteIn.writeToFileString(1);
            menuStarting.getMenuStartingDigit(4);
        }
        if (decision == 1) getBlock2();
        if (decision == 2) getBlock3();
        if (decision == 3) menuStarting.getMenuStartingDigit(decision);
    }
    public void getBlock2()
    {
        System.out.println("Вернувшись домой, Лисёнок нашёл там Бельчонка. \nОказалось, что Бельчонок пришёл на " +
                "место встречи раньше и увидел там рой злобных пчел. \nОн поспешил предупредить об этом Лисёнка, " +
                "но они разминулись. \nНаконец-то друзья нашли друг друга! \nИгра завершилась успехом!!!))) " +
                "\n                                  - = H A P P Y   E N D = -");
    }
    public void getBlock3()
    {
        System.out.println("Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка " +
                "и его проблему. \nНо вдруг кто-нибудь видел Бельчонка... \nЛисёнок не знал, что ему делать. " +
                "Помогите ему.\n1.Попытаться разузнать о Бельчонке у лесных жителей\n2.Искать Бельчонка в одиночку");
        System.out.println("***###***###***###***\n0.Выйти с сохранением игры\n3.Выйти без сохранения");
        int decision = scanner.nextInt();
        if (decision == 3)
        {
            System.out.println("Ну, так, на всякий случай, точно Выйти без сохранения? \nЕщё есть время передумать, " +
                    "но это последний шанс:");
            decision = scanner.nextInt();
        }
        if (decision == 0)
        {
            fileWriteIn.writeToFileString(3);
            menuStarting.getMenuStartingDigit(4);
        }
        if (decision == 1) getBlock4();
        if (decision == 2) getBlock5();
        if (decision == 3) menuStarting.getMenuStartingDigit(decision);
    }
    public void getBlock4()
    {
        System.out.println("Пока Лисёнок принимал решение, лесные жители разошлись кто куда. Остались только Сова " +
                "и Волк. \nНо у Совы бывают проблемы с памятью, а Волк может сильно разозлиться из-за расспросов. " +
                "\nКого выбрать?\n1.Расспросить Сову\n2.Расспросить Волка");
        System.out.println("***###***###***###***\n0.Выйти с сохранением игры\n3.Выйти без сохранения");
        int decision = scanner.nextInt();
        if (decision == 3)
        {
            System.out.println("Ну, так, на всякий случай, точно Выйти без сохранения? \nЕщё есть время передумать, " +
                    "но это последний шанс:");
            decision = scanner.nextInt();
        }
        if (decision == 0)
        {
            fileWriteIn.writeToFileString(4);
            menuStarting.getMenuStartingDigit(4);
        }
        if (decision == 1) getBlock7();
        if (decision == 2) getBlock6();
        if (decision == 3) menuStarting.getMenuStartingDigit(decision);
    }
    public void getBlock5()
    {
        System.out.println("Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как " +
                "заблудился. \nТеперь его самого нужно искать. \nИгра завершилась неудачей! \n          " +
                "                       -=G A M E  O V E R=-");
    }
    public void getBlock6()
    {
        System.out.println("Волк оказался вполне дружелюбным, но помочь не смог. \nЛишь сказал, что маленькому " +
                "лисенку не стоит бродить по лесу одному. \nИ как теперь поступить?\n1.Волк прав -> Вернуться " +
                "домой\n2.Искать Бельчонка в одиночку");
        System.out.println("***###***###***###***\n0.Выйти с сохранением игры\n3.Выйти без сохранения");
        int decision = scanner.nextInt();
        if (decision == 3)
        {
            System.out.println("Ну, так, на всякий случай, точно Выйти без сохранения? \nЕщё есть время передумать, " +
                    "но это последний шанс:");
            decision = scanner.nextInt();
        }
        if (decision == 0)
        {
            fileWriteIn.writeToFileString(6);
            menuStarting.getMenuStartingDigit(4);
        }
        if (decision == 1) getBlock2();
        if (decision == 2) getBlock5();
        if (decision == 3) menuStarting.getMenuStartingDigit(decision);
    }
    public void getBlock7()
    {
        System.out.println("Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, " +
                "бежавшего вглубь леса. \nВсе лесные жители знают, что в глубине леса опасно, если Бельчонок " +
                "там, то ему срочно нужна помощь.\n1.Поверить Сове и отправиться в глубь леса\n2.Сове не стоит " +
                "верить -> Искать Бельчонка в одиночку");
        System.out.println("***###***###***###***\n0.Выйти с сохранением игры\n3.Выйти без сохранения");
        int decision = scanner.nextInt();
        if (decision == 3)
        {
            System.out.println("Ну, так, на всякий случай, точно Выйти без сохранения? \nЕщё есть время передумать, " +
                    "но это последний шанс:");
            decision = scanner.nextInt();
        }
        if (decision == 0)
        {
            fileWriteIn.writeToFileString(7);
            menuStarting.getMenuStartingDigit(4);
        }
        if (decision == 1) getBlock8();
        if (decision == 2) getBlock5();
        if (decision == 3) menuStarting.getMenuStartingDigit(decision);
    }
    public void getBlock8()
    {
        System.out.println("В глубине леса Лисёнок встретил Медвежонка. \nЛенивый Медвежонок был готов рассказать " +
                "всё, что знает, если Лисёнок принесёт ему мёда.\n1.Нет, потрачено слишком много времени, " +
                "нужно идти дальше -> Искать Бельчонка в одиночку\n2.Нужно воспользоваться шансом и раздобыть мёд");
        System.out.println("***###***###***###***\n0.Выйти с сохранением игры\n3.Выйти без сохранения");
        int decision = scanner.nextInt();
        if (decision == 3)
        {
            System.out.println("Ну, так, на всякий случай, точно Выйти без сохранения? \nЕщё есть время передумать, " +
                    "но это последний шанс:");
            decision = scanner.nextInt();
        }
        if (decision == 0)
        {
            fileWriteIn.writeToFileString(8);
            menuStarting.getMenuStartingDigit(4);
        }
        if (decision == 1) getBlock5();
        if (decision == 2) getBlock9();
        if (decision == 3) menuStarting.getMenuStartingDigit(decision);
    }
    public void getBlock9()
    {
        System.out.println("Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. \nЛисёнок всегда боялся " +
                "пчёл, но и не найти друга он тоже боялся.\n1.Подождать, вдруг пчёлы улетят\n2.Нужно попытаться " +
                "выкрасть мёд немедленно");
        System.out.println("***###***###***###***\n0.Выйти с сохранением игры\n3.Выйти без сохранения");
        int decision = scanner.nextInt();
        if (decision == 3)
        {
            System.out.println("Ну, так, на всякий случай, точно Выйти без сохранения? \nЕщё есть время передумать, " +
                    "но это последний шанс:");
            decision = scanner.nextInt();
        }
        if (decision == 0)
        {
            fileWriteIn.writeToFileString(9);
            menuStarting.getMenuStartingDigit(4);
        }
        if (decision == 1) getBlock12();
        if (decision == 2) getBlock10();
        if (decision == 3) menuStarting.getMenuStartingDigit(decision);
    }
    public void getBlock10()
    {
        System.out.println("Это была не лучшая идея. Пчёлы покусали Лисёнка, теперь ему самому нужна " +
                "помощь. \nИгра завершилась неудачей! \n                                 -=G A M E  O V E R=-");
    }
    public void getBlock11()
    {
        System.out.println("Пока Лисёнок ел, злобные пчёлы вернулись и покусали его. \nЛисёнку нужна помощь, " +
                "он не сможет продолжить поиски. Игра завершилась неудачей! \n                       " +
                "          -=G A M E  O V E R=-");
    }
    public void getBlock12()
    {
        System.out.println("Лисёнок подождал немного, и пчёлы разлетелись. Лисёнок без проблем набрал мёда. \nВдруг " +
                "он понял, что очень голоден. Что же делать?\n1.Поесть немного и передохнуть\n2.Скорее отнести " +
                "мёд Медвежонку");
        System.out.println("***###***###***###***\n0.Выйти с сохранением игры\n3.Выйти без сохранения");
        int decision = scanner.nextInt();
        if (decision == 3)
        {
            System.out.println("Ну, так, на всякий случай, точно Выйти без сохранения? \nЕщё есть время передумать, " +
                    "но это последний шанс:");
            decision = scanner.nextInt();
        }
        if (decision == 0)
        {
            fileWriteIn.writeToFileString(12);
            menuStarting.getMenuStartingDigit(4);
        }
        if (decision == 1) getBlock11();
        if (decision == 2) getBlock13();
        if (decision == 3) menuStarting.getMenuStartingDigit(decision);
    }
    public void getBlock13()
    {
        System.out.println("Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок и уверен, " +
                "что Бельчонок никогда не пошёл бы в глубь леса. \nОн заверял Лисёнка, что Белки не попадают в " +
                "неприятности, и что Совам нельзя верить, и он также уговаривал Лисёнка вернуться домой.\n" +
                "1.Медвежонок ничего не знает, нужно продолжить поиски -> Искать Бельчонка в одиночку\n" +
                "2.Может быть он прав и Лисёнок просто паникует -> Вернуться домой");
        System.out.println("***###***###***###***\n0.Выйти с сохранением игры\n3.Выйти без сохранения");
        int decision = scanner.nextInt();
        if (decision == 3)
        {
            System.out.println("Ну, так, на всякий случай, точно Выйти без сохранения? \nЕщё есть время передумать, " +
                    "но это последний шанс:");
            decision = scanner.nextInt();
        }
        if (decision == 0)
        {
            fileWriteIn.writeToFileString(13);
            menuStarting.getMenuStartingDigit(4);
        }
        if (decision == 1) getBlock5();
        if (decision == 2) getBlock2();
        if (decision == 3) menuStarting.getMenuStartingDigit(decision);
    }
}
