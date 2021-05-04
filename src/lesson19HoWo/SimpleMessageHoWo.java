package lesson19HoWo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SimpleMessageHoWo implements Serializable
{
    private String sender;
    private String text;
    private LocalDateTime dateTime;

    public SimpleMessageHoWo(String sender, String text, LocalDateTime dateTime) {
        this.sender = sender;
        this.text = text;
        this.dateTime = dateTime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateTime(){
        dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    public static SimpleMessageHoWo getMessage(String sender, String text, LocalDateTime dateTime)
    {
         return new SimpleMessageHoWo(sender, text, dateTime);
    }

    public static SimpleMessageHoWo getServerMessage(String sender, String text, LocalDateTime dateTime)
    {
        String text1 = "была введена команда \"help\" - список доступных команд следующий: \n\u2708 help - " +
                "пользователь хочет узнать список " +
                "доступных команд; \n\u2708 count - пользователь хочет узнать количество клиентов, которые " +
                "подключались к серверу; \n\u2708 ping - пользователь хочет узнать время за которое сообщение " +
                "доходит до сервера и возвращается обратно; \n\u2708 exit - пользователь хочет выйти из " +
                "программы (завершение программы); \n\u2708 image - передача изображения(й) от клиента на сервер.";
        if (text.equalsIgnoreCase("help")) return new SimpleMessageHoWo(sender, text1, dateTime);
      //  else if ()
        if (sender.equalsIgnoreCase("serverT"))
        {
            LocalDateTime parseDate = LocalDateTime.parse(text);
            return new SimpleMessageHoWo(sender,
                    "\nвремя за которое сообщение доходит до сервера и возвращается обратно = " +
                            ChronoUnit.NANOS.between(parseDate,dateTime)
                            + " наносекунд.",
                            dateTime);
        }
        else return new SimpleMessageHoWo(sender, text, dateTime);
    }
}
