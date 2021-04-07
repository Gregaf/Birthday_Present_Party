package Java;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Birthday {
    public AtomicInteger presentsAdded;
    public AtomicInteger thankNotes;

    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<Worker>();
        GiftBag bag = new GiftBag(50);

        for (int i = 0; i < 4; i++) {
            Worker newWorker = new Worker("Worker " + i, bag);

            workers.add(newWorker);
        }

        for (Worker worker : workers) {
            worker.begin();

        }

        for (Worker worker : workers) {
            try {
                worker.t.join();
            } catch (InterruptedException e) {

            }
        }

        bag.PrintResults();
    }
}
