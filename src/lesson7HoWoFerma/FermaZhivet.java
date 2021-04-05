package lesson7HoWoFerma;

import java.util.Scanner;

public class FermaZhivet implements DelaNaFerme
{
    public static int resursDlyaFermera;
    public void DenFermy()
    {
        SoberiResursy(DomashZhivotnye.arrDomashZhivotnyes, DikieZhivotnye.arrDikieZhivotnyes, FermaZhivet.resursDlyaFermera);
        /*DelaNaFerme delaNaFerme = new DelaNaFerme() {
            @Override
            public void SoberiResursy(DomashZhivotnye[] domashZhivotnyes, DikieZhivotnye[] dikieZhivotnyes, int resursDlyaFermera) {

            }
        } ;*/
        //resursDlyaFermera = resursDlyaFermera + DelaNaFerme(resursDlyaFermera);
        //System.out.println("nfnbgndbgdjbkjd" + resursDlyaFermera);

    }

}
