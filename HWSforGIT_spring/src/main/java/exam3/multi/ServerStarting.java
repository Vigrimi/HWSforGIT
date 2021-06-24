package exam3.multi;

import java.io.IOException;

public class ServerStarting
{
    public static void main(String[] args) throws IOException
    {
        new ServerClientProducerConsumer().run();
    }
}
