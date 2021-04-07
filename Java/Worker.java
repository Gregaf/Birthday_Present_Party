package Java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable {
    public Thread t;
    private String name;
    private GiftBag bag;

    // Each thread has individual numbers of these that should add up to numberOfGifts
    private int presentsAdded;
    private Integer thankYouNotes;

    Worker(String name, GiftBag bag) {
        this.name = name;
        this.bag = bag;
        System.out.println("Creating " + name);
    }

    @Override
    public void run() {
        while (!bag.isEmpty())
        {
            Integer gift = bag.TakeGift();

            if(gift < 0)
            {
                continue;
            }
            else
            {   
                System.out.println(name + " retreived the gift " + gift);
                presentsAdded++;
            }

        }

        System.out.println(name + " added " + presentsAdded);
    }

    

    public void begin() {
        System.out.println("Starting " + name);

        if (t == null) {
            t = new Thread(this, name);
            t.start();
        }
    }

}
