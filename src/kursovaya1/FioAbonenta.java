package kursovaya1;

import java.time.LocalDateTime;
import java.util.Arrays;

public class FioAbonenta
{
    public String nameAbonenta;
    public String surnameAbonenta;
    public static FioAbonenta[] arrAbonenty;
    public VidyAbonementov abonement; //static
    public LocalDateTime nachaloAbonementa;
    public LocalDateTime konetsAbonementa;
    public String unikNomerAbonementa; //static

    public FioAbonenta(String nameAbonenta,
                       String surnameAbonenta,
                       VidyAbonementov abonement,
                       LocalDateTime nachaloAbonementa,
                       LocalDateTime konetsAbonementa,
                       String unikNomerAbonementa) //конструктор
    {
        this.nameAbonenta = nameAbonenta;
        this.surnameAbonenta = surnameAbonenta;
        //FioAbonenta.abonement = abonement;
        this.abonement = abonement;
        this.nachaloAbonementa = nachaloAbonementa;
        this.konetsAbonementa = konetsAbonementa;
        this.unikNomerAbonementa = unikNomerAbonementa;
    }

    public static FioAbonenta[] getFioAbonenta()
    {
        String[] arrNames = {"Алан","Александр","Алексей","Альберт","Альфред","Анатолий","Бернар","Богдан","Боголюб",
                "Болеслав","Бонифаций","Борис","Борислав","Варвара","Василиса","Венера","Вера","Вероника","Веселина",
                "Веста","Велизар","Венедикт","Вениамин","Виктор","Вилен","Вилли","Вильгельм","Виссарион","Галина",
                "Гаянэ","Гелена","Гелла","Генриетта","Геннадий","Генрих","Георгий","Геральд","Герасим","Герман",
                "Глеб","Ева","Евгения","Евдокия","Денис","Джордан","Дмитрий","Дональд","Донат","Светлана","Северина",
                "Серафима","Игорь","Измаил","Израиль","Илиан","Илларион"};
        int qtyArrNames = arrNames.length;

        String[] arrSurnames = {"АВРОСИМОВ","АВРОСИНОВ","АВСЕЕВ","АВСЕЕНКО","АКУСТЬЕВ","АКЦИПЕТРОВ","АКЧУРИН","АЛАБЕРДИЕВ","АЛАБИН","АЛАБУШЕВ",
                "БАЖИНБАЖОВ","БАЖУКОВ","БАЖУТИН","БАЖУТКИН","БАЗАНИН","БАЗАНОВ","БАЗАРНОВ","БАЗАРОВ","БАЗИЛЕВСКИЙ","ВАРЮХИН","ВАРЮШИН",
                "ВАСЕЙКИН","ВАСЕНЕВ","ВАСЕНИН","ВАСЕНКИН","ГАЛЧЕНКОВ","ГАЛЫГИН","ГАЛЫКИН","ГАЛЬЧЕНКО","ГАЛЬЯНОВ","ГАМАЮНОВ","ГАМБАРОВ","ГАМБУРЦЕВ",
                "ГАМЗИН","ДАШКОВ","ДАШКОВСКИЙ","ДАШУК","ДВИНСКИХ","ДВИНЯНИН","ДВИНЯТИН","ДВОРКИН","ЕВСЮШКИН","ЕВТЕЕВ","ЕВТЕХЕЕВ","ЕВТЕХОВ",
                "ЕВТИН","ЕВТИФЕЕВ","КАЗЫМОВ","КАЗЮКОВ","КАИРЕВ","КАИРОВ","ЛАЗЛОВ","ЛАЗОРЕНКО","ЛАЗУКИН","ЛАЗУНИН","ЛАНОВОЙ","ЛАНСКИХ",
                "ЛАНСКОВ","МАКАРЕВИЧ","МАКАРЕНКО","МАКАРЕНКОВ","НАЛЕТОВ","НАЛИМОВ","НАМАЗОВ","НАМЕТКИН","ОВСЯНОВ","ОВТУХОВ","ПАКШИН","ПАЛАГИН"};
        int qtyArrSurnames = arrSurnames.length;
        int qtyAbonentov = 45;
        arrAbonenty = new FioAbonenta[qtyAbonentov];
        for (int i = 0; i < arrAbonenty.length; i++)
        {
            String nameToArray = arrNames[(int) (Math.random() * 56)];
            String surnameToArray = arrSurnames[(int) (Math.random() * 56)];
            VidyAbonementov abonement = getAbonementFIO();
            LocalDateTime nachaloAbonementa = getNachaloAbonementa();
            LocalDateTime konetsAbonementa = nachaloAbonementa.plusYears(1);
            String unikNomerAbonementa = getUnikNomerAbonementa();
            FioAbonenta fioAbonenta = new FioAbonenta(nameToArray,
                    surnameToArray,abonement,nachaloAbonementa,konetsAbonementa,unikNomerAbonementa);
                    //setNachaloAbonementa(getNachaloAbonementa()));
            arrAbonenty[i] = fioAbonenta;
        } // climber1.setFullName(getFullName);
        return arrAbonenty;
    }

    public void setNameAbonenta(String nameAbonenta) {
        this.nameAbonenta = nameAbonenta;
    }

    public void setSurnameAbonenta(String surnameAbonenta) {
        this.surnameAbonenta = surnameAbonenta;
    }

    public static LocalDateTime getNachaloAbonementa() {
        LocalDateTime nachaloAbonementa = Randoms.getDateTime();
        return nachaloAbonementa;
    }

    public static VidyAbonementov getAbonementFIO() {
        //VidyAbonementov abonement = Abonement.getAbonement();
        return Abonement.getAbonement(); // abonement;
    }
    //    public static LocalDateTime getKonetsAbonementa() {
//        LocalDateTime konetsAbonementa = nachaloAbonementa.plusYears(1);
//        return konetsAbonementa;
//    }


    public static String getUnikNomerAbonementa() {
        int x= (int) (Math.random() * 10 );
        int y= (int) (Math.random() * 10 );
        int z= (int) (Math.random() * 10 );
        int a = (int) (Math.random() * 10 );
        String unikNomerAbonementa = "" + x + y + z + a;
        return unikNomerAbonementa;
    }

    public static LocalDateTime setNachaloAbonementa(LocalDateTime nachaloAbonementa) {
        if (nachaloAbonementa == null) throw new IllegalArgumentException("дата НАЛЛ пачимута((");
        //this.nachaloAbonementa = nachaloAbonementa;
        return nachaloAbonementa;
    }

    @Override
    public String toString() {
        return "\n-" +
                "> " + nameAbonenta +
                " " + surnameAbonenta + ';' +
                " вид абонемента: " + abonement.name() + "; начало действия абонемента: " + nachaloAbonementa +
                ',' + " окончание действия абонемента: " + konetsAbonementa +
                "; уникальный номер абонемента " + unikNomerAbonementa + ".";
    }
}
