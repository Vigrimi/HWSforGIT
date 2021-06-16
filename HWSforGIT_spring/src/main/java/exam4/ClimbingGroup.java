package exam4;

import java.util.Arrays;
import java.util.Objects; // класс Обжектс почти как и класс Arrays

public class ClimbingGroup
{
    private Mountain mountain; //ссылка на какаую-то гору
    private Climber[] climbers; //создали массив альпинистов кот-е пойдут на гору

    public ClimbingGroup(Mountain mountain, int climberCount) // конструктор
    {
        this.mountain = Objects.requireNonNull(mountain, "bad mountain name = null"); // проверка на null, если НАЛ, то сразу эксепшн
        climbers = new Climber[climberCount]; //массиву задали кол-во альпинистов
    }

    public void addClimber(Climber climber) // принимать ссылку на какого-то альпиниста
    {
        Objects.requireNonNull(climber, "climber must be not null");
        for (int i = 0; i < climbers.length; i++)
        {
            if (climbers[i] == null)
            {
                climbers[i] = climber;
                return; // в void вместо break для выхода исп-ся ретурн
            }
        }
        System.out.println("Мест нет"); // нет НАЛов в массиве, значит некуда записывать нового альпиниста

    }
    ClimbingGroup first = new ClimbingGroup(mountain,3);
    ClimbingGroup second = first.clone();
    boolean vb = first.equals(second);

    @Override // переопр клон
    public ClimbingGroup clone() { // throws CloneNotSupportedException {
        Mountain copyM = this.mountain.clone(); // переопределеить метод клон в маунтэйн и тогда красное пропадёт
        ClimbingGroup copyGr = new ClimbingGroup(copyM,climbers.length);
        copyGr.climbers = climbers.clone();
        return copyGr;
    }

    @Override // переопр иквэлз
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClimbingGroup)) return false;
        ClimbingGroup that = (ClimbingGroup) o;
        return Objects.equals(mountain, that.mountain) && Arrays.equals(climbers, that.climbers); // так как клаймберс массив
        // то надо переопределять иквэлз ещё и в классе клаймбер для массива клаймбер
    }


    @Override
    public int hashCode() {
        int result = Objects.hash(mountain);
        result = 31 * result + Arrays.hashCode(climbers);
        return result;
    }

    @Override
    public String toString() {
        return "ClimbingGroup{" +
                "mountain=" + mountain +
                ", climbers=" + Arrays.toString(climbers) +
                '}';
    }
}
