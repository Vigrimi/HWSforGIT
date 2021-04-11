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
    public static int qtyAbonentov = 45;
    public static int randomNomerArrAbonenty;
    public int seichasVBasseine;
    public int seichasVZalTrenazher;
    public int seichasVZalGruppovZanyatiya;

    public Fitness() // (int maxQtyLyudeyBassein)
    {
        this.maxQtyLyudeyBassein = ZalBasseyn.maxQtyLyudeyBassein;
    }

    public void DelaNaFitnese()
    {
        generateArrFioAbonenta();
        System.out.println("\nВ фитнесс-центре зарегистрированны следующие абоненты возрастом " +
                "более 16 лет и менее 120 лет:  " + Arrays.toString(arrAbonenty));
        System.out.println("Наш фитнесс-центр работает с 8 до 22 часов каждый день недели. " +
                "\nНа часах 07ч 59минут и фитнесс-центр готов распахнуть свои двери. " +
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
        if (kudaHochetAbonent == 1) // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
        {
            System.out.println("Сейчас в бассейне " + seichasVBasseine + " человек.");
            if (seichasVBasseine == maxQtyLyudeyBassein)
            {
                System.out.println("Сейчас в бассейне находится максимально разрешённое количество " +
                        "посетителей = " + maxQtyLyudeyBassein + " человек.");
            }
        } else if (kudaHochetAbonent == 2)
        {
            System.out.println("Сейчас в тренажёрном зале " + seichasVZalTrenazher + " человек." );
        } else if (kudaHochetAbonent == 3)
        {
            System.out.println("Сейчас в зале групповых занятий " + seichasVZalTrenazher + " человек.");
        }

    }
    public static int getRandomNomerArrAbonenty()
    {
        int randomNomerArrAbonenty = (int) ( Math.random() * qtyAbonentov );
        return randomNomerArrAbonenty;
    }
//    public static FioAbonenta generateRandomAbonent() //void
//    {
//        getRandomNomerArrAbonenty();
//        FioAbonenta randomFioabonenta = arr;
//    }
    public void generateArrFioAbonenta()
    {
        arrAbonenty = new FioAbonenta[qtyAbonentov];
        for (int i = 0; i < arrAbonenty.length; i++)
        {
            arrAbonenty[i] = FioAbonenta.getFioAbonenta();
        }
    }

    public void generateArrAbonentyZalBasseyn()
    {
        ZalBasseyn zalBasseyn = new ZalBasseyn();
        int a = zalBasseyn.getGdeNahoditsyaAbonent();
        int b = zalBasseyn.getMaxQtyLyudeyBassein();
        int c = Randoms.getRandomFm12To26();
        int d = 1;
        if (c > b) d = c - b;
        arrAbonentyZalBasseyn = new FioAbonenta[maxQtyLyudeyBassein];
        arrNePopal = new FioAbonenta[d];
        ktoChemZanimaetsya(this.arrAbonenty,this.arrAbonentyZalBasseyn,this.arrNePopal,a,b,c);
    }

    public static FioAbonenta[] getArrAbonentyZalTrenazher() {
        return arrAbonentyZalTrenazher;
    }

    public static FioAbonenta[] getArrAbonentyZalGruppovZanyatiya() {
        return arrAbonentyZalGruppovZanyatiya;
    }
}
