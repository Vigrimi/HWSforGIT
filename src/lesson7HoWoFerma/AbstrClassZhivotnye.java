package lesson7HoWoFerma;

abstract public class AbstrClassZhivotnye
{
    protected String tipZhivotnogo;
    public int vesZhivotnogo;
    protected int skorostZhivotnogo;
        //protected int zdorovyeZhivotnogo;
        //protected int flagSyedobnoeZhivotnoe; // флаг (пригодно в пищу = 1 или нет = 0),
        //protected int resursZhivotnogo; //количество ресурсов (у каждого свое и 0, если животное не дает ресурс).

    //public AbstrClassZhivotnye(){}

    public AbstrClassZhivotnye(String tipZhivotnogo, int vesZhivotnogo, int skorostZhivotnogo) //, int zdorovyeZhivotnogo, int flagSyedobnoeZhivotnoe, int resursZhivotnogo) {
    {
        this.tipZhivotnogo = tipZhivotnogo;
        this.vesZhivotnogo = vesZhivotnogo;
        this.skorostZhivotnogo = skorostZhivotnogo;
            //this.zdorovyeZhivotnogo = zdorovyeZhivotnogo;
            //this.flagSyedobnoeZhivotnoe = flagSyedobnoeZhivotnoe;
            //this.resursZhivotnogo = resursZhivotnogo;
    }
}
