package kursovaya1;

public enum VidyAbonementov
{
    RAZOVIY(8,22,1,1,0), // 1-yes, 0-no
    DNEVNOY(8,16,0,1,1),
    POLNIY(8,22,1,1,1);

    private int vremyaOt;
    private int vremyaDo;
    private int basseinDaNet;
    private int trenazhZalDaNet;
    private int gruppZanyatDaNet;

    VidyAbonementov(int vremyaOt, int vremyaDo, int basseinDaNet, int trenazhZalDaNet, int gruppZanyatDaNet)
    {
        this.vremyaOt = vremyaOt;
        this.vremyaDo = vremyaDo;
        this.basseinDaNet = basseinDaNet;
        this.trenazhZalDaNet = trenazhZalDaNet;
        this.gruppZanyatDaNet = gruppZanyatDaNet;
    }

    public int getVremyaOt() {
        return vremyaOt;
    }

    public void setVremyaOt(int vremyaOt) {
        this.vremyaOt = vremyaOt;
    }

    public int getVremyaDo() {
        return vremyaDo;
    }

    public void setVremyaDo(int vremyaDo) {
        this.vremyaDo = vremyaDo;
    }

    public int getBasseinDaNet() {
        return basseinDaNet;
    }

    public void setBasseinDaNet(int basseinDaNet) {
        this.basseinDaNet = basseinDaNet;
    }

    public int getTrenazhZalDaNet() {
        return trenazhZalDaNet;
    }

    public void setTrenazhZalDaNet(int trenazhZalDaNet) {
        this.trenazhZalDaNet = trenazhZalDaNet;
    }

    public int getGruppZanyatDaNet() {
        return gruppZanyatDaNet;
    }

    public void setGruppZanyatDaNet(int gruppZanyatDaNet) {
        this.gruppZanyatDaNet = gruppZanyatDaNet;
    }
}
