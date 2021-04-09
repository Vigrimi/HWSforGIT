package kursovaya1;

import java.time.LocalDateTime;

public class Abonement
{
    //public static VidyAbonementov[] arrVidyAbonementov;
    public static VidyAbonementov abonement;

    public static VidyAbonementov getAbonement()
    {
        VidyAbonementov[] arrVidyAbonementov = {VidyAbonementov.DNEVNOY,VidyAbonementov.POLNIY,VidyAbonementov.RAZOVIY};
        int a = (int) (Math.random() * 3);
        if (a == 0) abonement = arrVidyAbonementov[0];
        else if (a == 1) abonement = arrVidyAbonementov[1];
        else if (a == 2) abonement = arrVidyAbonementov[2];
        return abonement;
    }
}
