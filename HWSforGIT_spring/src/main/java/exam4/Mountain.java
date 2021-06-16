package exam4;

import java.util.Objects;

public class Mountain implements Cloneable
{
    private String name;
    private int height;

    //конструктор , new Scanner - это вызов конструктора
    public Mountain()
    {
        this("Гора по умолчанию", 300); // вызов какого-то другого конструктора
    }

    public Mountain(String name, int height)
    {
        setName(name); // вызвать сеттер для проверки данных, которые внесены в конструктор в мэйне
        setHeight(height);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 2) throw new IllegalArgumentException("name < 2");
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    private void setHeight(int height) {
        if (height < 100) throw new IllegalArgumentException("heigh < 100");
        this.height = height;
    }

    @Override // переопр клон
    public Mountain clone() {// throws CloneNotSupportedException {
        try { return (Mountain) super.clone();}
        catch (CloneNotSupportedException e)
        {
            return null;
        }
    }

    @Override // переопр иквэлз
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mountain)) return false;
        Mountain mountain = (Mountain) o;
        return height == mountain.height && Objects.equals(name, mountain.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, height);
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
