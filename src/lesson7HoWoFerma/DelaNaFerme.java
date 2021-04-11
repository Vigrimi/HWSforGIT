package lesson7HoWoFerma;

public interface DelaNaFerme
{
        default void SoberiResursy(DomashZhivotnye[] domashZhivotnyes, DikieZhivotnye[] dikieZhivotnyes, int resursDlyaFermera)
    //домашние животные, которые дают ресурсы:  Корова, Курица
    {
        resursDlyaFermera = 0;
        for (int i = 0; i < domashZhivotnyes.length; i++)
        {
            if ( (domashZhivotnyes[i].tipZhivotnogo.equals("Корова") && domashZhivotnyes[i].resursZhivotnogo > 0) ||
                    (domashZhivotnyes[i].tipZhivotnogo.equals("Курица") && domashZhivotnyes[i].resursZhivotnogo > 0) )
            {
                System.out.print("\nРесурс домашнего животного " + domashZhivotnyes[i].tipZhivotnogo
                        + " составляет: " + domashZhivotnyes[i].resursZhivotnogo + ", был собран фермером, уменьшился и " +
                        "теперь составляет: ");
                domashZhivotnyes[i].resursZhivotnogo -= 1;
                resursDlyaFermera++;
                System.out.print(domashZhivotnyes[i].resursZhivotnogo + ".");
            } else if ( (domashZhivotnyes[i].tipZhivotnogo.equals("Корова") && domashZhivotnyes[i].resursZhivotnogo == 0) ||
                    (domashZhivotnyes[i].tipZhivotnogo.equals("Курица") && domashZhivotnyes[i].resursZhivotnogo == 0) )
            {
                System.out.println("\nРесурс домашнего животного " + domashZhivotnyes[i].tipZhivotnogo
                + " исчерпан и составляет: " + domashZhivotnyes[i].resursZhivotnogo + ".");
            }
        }
        //System.out.println("res " + resursDlyaFermera);
    }
}
