package lesson6HoWoBooks;

import java.util.UUID;

public class Warehouse
{
    private UUID uuid;

    public void setUuid() {
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "Складской " +
                "номер: " + uuid +
                '.';
    }

}
