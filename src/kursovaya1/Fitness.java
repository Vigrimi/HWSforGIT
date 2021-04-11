package kursovaya1;

import java.util.Arrays;

public class Fitness implements KtonGde
{
    public  FioAbonenta[] arrAbonenty; //static
    public  FioAbonenta[] arrAbonentyZalBasseyn; //static
    public static FioAbonenta[] arrAbonentyZalTrenazher;
    public static FioAbonenta[] arrAbonentyZalGruppovZanyatiya;
    public  FioAbonenta[] arrNePopal;
    public int maxQtyLyudeyBassein;
    public int maxQtyLyudeyTrenazher;
    public int maxQtyLyudeyGruppZanyatiya;
    public static int qtyAbonentov = 55;
    public static int randomNomerArrAbonenty;
    public int seichasVBasseine;
    public int seichasVZalTrenazher;
    public int seichasVZalGruppovZanyatiya;

    public Fitness() // (int maxQtyLyudeyBassein)
    {
        this.maxQtyLyudeyBassein = ZalBasseyn.maxQtyLyudeyBassein;
        this.maxQtyLyudeyTrenazher = ZalTrenazher.maxQtyLyudeyTrenazher;
        this.maxQtyLyudeyGruppZanyatiya = ZalGruppovZanyatiya.maxQtyLyudeyGruppZanyatiya;
    }

    public void DelaNaFitnese()
    {
        generateArrFioAbonenta();
        System.out.println("\nВ фитнесс-центре зарегистрированны следующие абоненты возрастом " +
                "более 16 лет и менее 120 лет:  " + Arrays.toString(arrAbonenty));
        System.out.println("\nНаш фитнесс-центр работает с 8 до 22 часов каждый день недели. " +
                "\nНа часах 07ч 59минут и фитнесс-центр готов распахнуть свои двери. :p)" +
                "\nПогнали? 8- да; 9-нет");
//        generateArrAbonentyZalBasseyn();
//        System.out.println("\nФитнесс-центр открыт и абоненты расходятся по секциям: ");
//        System.out.println("\nв бассейне сейчас находятся: " + Arrays.toString(arrAbonentyZalBasseyn));
        //System.out.println("\n55 " + Arrays.toString(fitness.arrAbonenty));
    }
    public void DelaNaFitneseFm8To22Hours()
    {
        System.out.println("\nПришёл абонент: ");
        randomNomerArrAbonenty = getRandomNomerArrAbonenty();
        //System.out.println("проверка рандом номер абон в массиве " + randomNomerArrAbonenty);
        System.out.println(arrAbonenty[randomNomerArrAbonenty].nameAbonenta + " " +
                arrAbonenty[randomNomerArrAbonenty].surnameAbonenta + ", ID абонемента " +
                arrAbonenty[randomNomerArrAbonenty].unikNomerAbonementa +
                ", вид абонемента " + arrAbonenty[randomNomerArrAbonenty].abonement.name() + ".");
        int kudaHochetAbonent = Randoms.getRandomFm0To2() + 1;
        //System.out.println("проверка рандом зал " + a); // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
        System.out.println("И абонент хочет посетить" +
                ( (kudaHochetAbonent == 1) ? " бассейн" :
                        ( (kudaHochetAbonent == 2) ? " тренажёрный зал" :
                                /*( (gdeNahoditsyaAbonent == 3) ?*/ " зал групповых занятий" /* ) */ ) ) + ".");
        //seichasVBasseine = ZalBasseyn.getSeichasVBasseine();
        //System.out.println("проверка seichasVBasseine " + seichasVBasseine);
    // БАССЕЙН
        if (kudaHochetAbonent == 1) // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
        {
            System.out.println("Сейчас в бассейне " + seichasVBasseine + " человек.");
            if (seichasVBasseine == maxQtyLyudeyBassein)
            {
                System.out.println("Сейчас в бассейне находится максимально разрешённое количество " +
                        "посетителей = " + maxQtyLyudeyBassein + " человек. Поэтому в доступе отказано. ");
            }
            else if (seichasVBasseine < maxQtyLyudeyBassein)
            {
                if(arrAbonenty[randomNomerArrAbonenty].abonement.getBasseinDaNet() != 1)
                {
                    System.out.println("По данному виду абонемента нельзя попасть в бассейн.");
                }
                else if(arrAbonenty[randomNomerArrAbonenty].abonement.getBasseinDaNet() == 1)
                {
                    System.out.println("По данному виду абонемента можно попасть в бассейн.");
                    if (arrAbonenty[randomNomerArrAbonenty].gdeNahoditsyaAbonent == 1)
                        System.out.println("ОШИБКА производимых действий!! Абонент с данным абонементом " +
                                "уже находится в бассейне и не может быть одновременно в двух местах!");
                    else if (arrAbonenty[randomNomerArrAbonenty].gdeNahoditsyaAbonent == 2)
                        System.out.println("ОШИБКА производимых действий!! Абонент с данным абонементом " +
                                "уже находится в тренажёрном зале и не может быть одновременно в двух местах!");
                    else if (arrAbonenty[randomNomerArrAbonenty].gdeNahoditsyaAbonent == 3)
                        System.out.println("ОШИБКА производимых действий!! Абонент с данным абонементом " +
                                "уже находится в зале групповых занятий и не может быть одновременно в двух местах!");
                    else if (arrAbonenty[randomNomerArrAbonenty].gdeNahoditsyaAbonent == 0)
                    {
                        System.out.println("Абонент " + arrAbonenty[randomNomerArrAbonenty].nameAbonenta + " " +
                                arrAbonenty[randomNomerArrAbonenty].surnameAbonenta + ", ID абонемента " +
                                arrAbonenty[randomNomerArrAbonenty].unikNomerAbonementa +
                                ", вид абонемента " + arrAbonenty[randomNomerArrAbonenty].abonement.name() +
                                " пошёл заниматься в бассейн.");
                        arrAbonenty[randomNomerArrAbonenty].gdeNahoditsyaAbonent = 1;
                        seichasVBasseine = ZalBasseyn.getSeichasVBasseine();
                    }
                }
            }
        }

    // ТРЕНАЖЁРКА
        else if (kudaHochetAbonent == 2) // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
        {
            System.out.println("Сейчас в тренажёрном зале " + seichasVZalTrenazher + " человек." );
            if (seichasVZalTrenazher == maxQtyLyudeyTrenazher)
            {
                System.out.println("Сейчас в тренажёрном зале находится максимально разрешённое количество " +
                        "посетителей = " + maxQtyLyudeyTrenazher + " человек. Поэтому в доступе отказано. ");
            }
            else if (seichasVZalTrenazher < maxQtyLyudeyTrenazher)
            {
                if(arrAbonenty[randomNomerArrAbonenty].abonement.getTrenazhZalDaNet() != 1)
                {
                    System.out.println("По данному виду абонемента нельзя попасть в тренажёрный зал.");
                }
                else if(arrAbonenty[randomNomerArrAbonenty].abonement.getTrenazhZalDaNet() == 1)
                {
                    System.out.println("По данному виду абонемента можно попасть в тренажёрный зал.");
                    if (arrAbonenty[randomNomerArrAbonenty].gdeNahoditsyaAbonent == 1)
                        System.out.println("ОШИБКА производимых действий!! Абонент с данным абонементом " +
                                "уже находится в бассейне и не может быть одновременно в двух местах!");
                    else if (arrAbonenty[randomNomerArrAbonenty].gdeNahoditsyaAbonent == 2)
                        System.out.println("ОШИБКА производимых действий!! Абонент с данным абонементом " +
                                "уже находится в тренажёрном зале и не может быть одновременно в двух местах!");
                    else if (arrAbonenty[randomNomerArrAbonenty].gdeNahoditsyaAbonent == 3)
                        System.out.println("ОШИБКА производимых действий!! Абонент с данным абонементом " +
                                "уже находится в зале групповых занятий и не может быть одновременно в двух местах!");
                    else if (arrAbonenty[randomNomerArrAbonenty].gdeNahoditsyaAbonent == 0)
                    {
                        System.out.println("Абонент " + arrAbonenty[randomNomerArrAbonenty].nameAbonenta + " " +
                                arrAbonenty[randomNomerArrAbonenty].surnameAbonenta + ", ID абонемента " +
                                arrAbonenty[randomNomerArrAbonenty].unikNomerAbonementa +
                                ", вид абонемента " + arrAbonenty[randomNomerArrAbonenty].abonement.name() +
                                " пошёл заниматься в тренажёрный зал.");
                        arrAbonenty[randomNomerArrAbonenty].gdeNahoditsyaAbonent = 2;
                        seichasVZalTrenazher = ZalTrenazher.getSeichasVZalTrenazher();
                    }
                }
            }
        }

    // ГРУППОВЫЕ
        else if (kudaHochetAbonent == 3) // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
        {
            System.out.println("Сейчас в зале групповых занятий " + seichasVZalGruppovZanyatiya + " человек.");
            if (seichasVZalGruppovZanyatiya == maxQtyLyudeyGruppZanyatiya)
            {
                System.out.println("Сейчас в зале групповых занятий находится максимально разрешённое количество " +
                        "посетителей = " + maxQtyLyudeyGruppZanyatiya + " человек. Поэтому в доступе отказано. ");
            }
            else if (seichasVZalGruppovZanyatiya < maxQtyLyudeyGruppZanyatiya)
            {
                if(arrAbonenty[randomNomerArrAbonenty].abonement.getGruppZanyatDaNet() != 1)
                {
                    System.out.println("По данному виду абонемента нельзя попасть в зал групповых занятий.");
                }
                else if(arrAbonenty[randomNomerArrAbonenty].abonement.getGruppZanyatDaNet() == 1)
                {
                    System.out.println("По данному виду абонемента можно попасть в зал групповых занятий.");
                    if (arrAbonenty[randomNomerArrAbonenty].gdeNahoditsyaAbonent == 1)
                        System.out.println("ОШИБКА производимых действий!! Абонент с данным абонементом " +
                                "уже находится в бассейне и не может быть одновременно в двух местах!");
                    else if (arrAbonenty[randomNomerArrAbonenty].gdeNahoditsyaAbonent == 2)
                        System.out.println("ОШИБКА производимых действий!! Абонент с данным абонементом " +
                                "уже находится в тренажёрном зале и не может быть одновременно в двух местах!");
                    else if (arrAbonenty[randomNomerArrAbonenty].gdeNahoditsyaAbonent == 3)
                        System.out.println("ОШИБКА производимых действий!! Абонент с данным абонементом " +
                                "уже находится в зале групповых занятий и не может быть одновременно в двух местах!");
                    else if (arrAbonenty[randomNomerArrAbonenty].gdeNahoditsyaAbonent == 0)
                    {
                        System.out.println("Абонент " + arrAbonenty[randomNomerArrAbonenty].nameAbonenta + " " +
                                arrAbonenty[randomNomerArrAbonenty].surnameAbonenta + ", ID абонемента " +
                                arrAbonenty[randomNomerArrAbonenty].unikNomerAbonementa +
                                ", вид абонемента " + arrAbonenty[randomNomerArrAbonenty].abonement.name() +
                                " пошёл заниматься в зале групповых занятий.");
                        arrAbonenty[randomNomerArrAbonenty].gdeNahoditsyaAbonent = 3;
                        seichasVZalGruppovZanyatiya = ZalGruppovZanyatiya.getSeichasVZalGruppovZanyatiya();
                    }
                }
            }
        }

    }
    public static int getRandomNomerArrAbonenty()
    {
        int randomNomerArrAbonenty = (int) ( Math.random() * qtyAbonentov );
        return randomNomerArrAbonenty;
    }

    public void generateArrFioAbonenta()
    {
        arrAbonenty = new FioAbonenta[qtyAbonentov];
        for (int i = 0; i < arrAbonenty.length; i++)
        {
            arrAbonenty[i] = FioAbonenta.getFioAbonenta();
        }
    }

    public void generateArrAbonentyKtoGde()
    {
        /*ZalBasseyn zalBasseyn = new ZalBasseyn();
        int a = zalBasseyn.getGdeNahoditsyaAbonent();
        int b = zalBasseyn.getMaxQtyLyudeyBassein();
        int c = Randoms.getRandomFm12To26();
        int d = 1;
        if (c > b) d = c - b;
        arrAbonentyZalBasseyn = new FioAbonenta[maxQtyLyudeyBassein];
        arrNePopal = new FioAbonenta[d];*/
        ktoChemZanimaetsya(this.arrAbonenty); //(this.arrAbonenty,this.arrAbonentyZalBasseyn,this.arrNePopal,a,b,c);
    }
    public void generateVseUhodyatNaNoch()
    {
        vseUhodyatNaNoch(this.arrAbonenty); //(this.arrAbonenty,this.arrAbonentyZalBasseyn,this.arrNePopal,a,b,c);
    }
    public static FioAbonenta[] getArrAbonentyZalTrenazher() {
        return arrAbonentyZalTrenazher;
    }

    public static FioAbonenta[] getArrAbonentyZalGruppovZanyatiya() {
        return arrAbonentyZalGruppovZanyatiya;
    }
}
