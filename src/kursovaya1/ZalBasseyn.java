package kursovaya1;

public class ZalBasseyn
{
    public static int maxQtyLyudeyBassein = 20; //static // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
    public int gdeNahoditsyaAbonent;
    //public static FioAbonenta[] fioAbonentas; //arrAbonenty; //static
    public  FioAbonenta[] arrLyudiVBasseine; //static
    //public  int vBassHotyatPopast; //static
    public static int seichasVBasseine;


    public ZalBasseyn() {
        maxQtyLyudeyBassein = 20; //getMaxQtyLyudeyBassein();
        this.gdeNahoditsyaAbonent = 1;
    }

    public FioAbonenta[] getArrLyudiVBasseine() {
        FioAbonenta[] getArrLyudiVBasseine = new FioAbonenta[maxQtyLyudeyBassein];
        return arrLyudiVBasseine;
    }

    public int getMaxQtyLyudeyBassein() {
        return maxQtyLyudeyBassein;
    }

    public static int getSeichasVBasseine() {
        seichasVBasseine++;
        return seichasVBasseine;
    }

    public int getGdeNahoditsyaAbonent() {
        return gdeNahoditsyaAbonent;
    }
    /*public ZalBasseyn(int vBassHotyatPopast, FioAbonenta[] fioAbonentas) {
        //ZalBasseyn.arrAbonenty = FioAbonenta.arrAbonenty;
        //this.arrAbonenty = arrAbonenty;
        //this;
        //this.fioAbonentas = FioAbonenta.arrAbonenty; // fioAbonentas;
        FioAbonenta.arrAbonenty = fioAbonentas;
        this.vBassHotyatPopast = vBassHotyatPopast;
    }

    public static FioAbonenta[] getArrLyudiVBasseine() //(FioAbonenta[] arrAbonenty, FioAbonenta[] arrLyudiVBasseine) //FioAbonenta[]
    {
        //FioAbonenta[] fioAbonentas = FioAbonenta[] a
        int vBassHotyatPopast = (int) ( Math.random() * 15 + 12 );
        arrLyudiVBasseine = new FioAbonenta[maxQtyLyudeyBassein];
        System.out.println(arrLyudiVBasseine[1]);
        System.out.println(fioAbonentas[0]); //FioAbonenta.getFioAbonenta()[0]; // arrAbonenty[2];

        if (vBassHotyatPopast <= maxQtyLyudeyBassein)
        {
            for (int i = 0; i < arrLyudiVBasseine.length; i++)
            {
                for (int j = 0; j < arrLyudiVBasseine.length; j++)
                {
                    if (arrAbonenty[j].gdeNahoditsyaAbonent == 0)  // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
                    {
                        arrLyudiVBasseine[i] = arrAbonenty[j];
                        arrAbonenty[j].gdeNahoditsyaAbonent = 1;
                        break;
                    }
                }
            }
        }
        if (vBassHotyatPopast > maxQtyLyudeyBassein)
        {
            for (int i = 0; i < arrLyudiVBasseine.length; i++)
            {
                for (int j = 0; j < arrLyudiVBasseine.length; j++)
                {
                    if (arrAbonenty[j].gdeNahoditsyaAbonent == 0)  // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
                    {
                        arrLyudiVBasseine[i] = arrAbonenty[j];
                        arrAbonenty[j].gdeNahoditsyaAbonent = 1;
                        break;
                    }
                }
            }
            for (int k = 0; k < (vBassHotyatPopast - maxQtyLyudeyBassein); k++)
            {
                if (arrAbonenty[k].gdeNahoditsyaAbonent != 1)  // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
                {
                    System.out.println("Абонент " + arrAbonenty[k].nameAbonenta + " " + arrAbonenty[k].surnameAbonenta +
                            " номер абоненемента " + arrAbonenty[k].unikNomerAbonementa + " хотел попасть в бассейн, но " +
                            "в нём уже находится максимально число посетитетелей в количестве " + maxQtyLyudeyBassein +
                            " человек.");
                }
            }
        }

        return arrLyudiVBasseine;
    }

    @Override
    public String toString()
    {
        return "ZalBasseyn{" +
                "vBassHotyatPopast=" + vBassHotyatPopast +
                '}' + fioAbonentas[0].gdeNahoditsyaAbonent;
    }*/
}
