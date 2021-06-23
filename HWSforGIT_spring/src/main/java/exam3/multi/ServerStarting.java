package exam3.multi;

import java.util.concurrent.ArrayBlockingQueue;

public class ServerStarting
{
    public static void main(String[] args)
    {
        new Server().run();

       /* //BlockingQueue q = new SomeQueueImplementation();
        ArrayBlockingQueue<SimpleMessage> msgsBlQuq = new ArrayBlockingQueue<>(15);
        Producer p = new Producer(msgsBlQuq);
        Consumer c1 = new Consumer(msgsBlQuq);
        Consumer c2 = new Consumer(msgsBlQuq);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();*/
    }
}
