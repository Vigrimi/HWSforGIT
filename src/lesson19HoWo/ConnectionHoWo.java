package lesson19HoWo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionHoWo implements AutoCloseable // соединение, трай-кэтч сделали для close
{
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public ConnectionHoWo(Socket socket) throws IOException { // при открытии последов-сть  важна: сначала аутпут и только потом инпут
        this.socket = socket;
        output = new ObjectOutputStream(socket.getOutputStream()); // позволит по сокету отправлять данные
        // между клиентом и сервером
        input = new ObjectInputStream(socket.getInputStream()); // позволит по сокету принимать данные
    }

    public void sendMessage(SimpleMessageHoWo message) throws IOException {
        message.setDateTime();
        output.writeObject(message); // создали поток байтов, но они пока висят в нашей программе
        output.flush(); // чтобы байты ушли по каналу
    }

    public SimpleMessageHoWo readMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessageHoWo) input.readObject();
    }


    @Override
    public void close() throws Exception { // при закрытии последов-сть не важна
        input.close();
        output.close();
        socket.close();
    }
}
