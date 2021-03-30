package Lesson6HoWoCats;

public class Mouse
{
    private double speedMouse;

    public double getSpeedMouse() //Double speedMouse
    {
        int a = (int) (Math.random() * 100);
        speedMouse = a;
        return speedMouse;
    }

    public void setSpeedMouse() //double speedMouse
    {
        this.speedMouse = speedMouse;
    }

    @Override
    public String toString() {
        return "Скорость " +
                "мышки: " + speedMouse +
                " км/секунду " + '\u2708';
    }
}
