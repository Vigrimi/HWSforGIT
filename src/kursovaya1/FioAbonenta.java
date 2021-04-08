package kursovaya1;

import java.util.Arrays;

public class FioAbonenta
{
    public String nameAbonenta;
    public String surnameAbonenta;
    public static FioAbonenta[] arrAbonenty;

    public FioAbonenta(String nameAbonenta, String surnameAbonenta) //конструктор
    {
        this.nameAbonenta = nameAbonenta;
        this.surnameAbonenta = surnameAbonenta;
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
            FioAbonenta fioAbonenta = new FioAbonenta(nameToArray,surnameToArray);
            arrAbonenty[i] = fioAbonenta;
        }
        return arrAbonenty;
    }

    public void setNameAbonenta(String nameAbonenta) {
        this.nameAbonenta = nameAbonenta;
    }

    public void setSurnameAbonenta(String surnameAbonenta) {
        this.surnameAbonenta = surnameAbonenta;
    }

    @Override
    public String toString() {
        return "-" +
                "> " + nameAbonenta + ' ' +
                " " + surnameAbonenta + ' ' +
                ' ';
    }
}
