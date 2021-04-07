package Java;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;


// Going to have to optimize the locks, but want to test first.
public class GiftBag 
{
    private ConcurrentHashMap<Integer, Integer> collection;
    //private HashSet<Integer> collection;
    private int numberOfGifts;
    private Random rand;
    ReentrantLock lock = new ReentrantLock();
    private int numberDeleted;

    GiftBag (int numberOfGifts)  
    {   
        this.numberOfGifts = numberOfGifts;
        rand = new Random();
        collection = CreateCollection();
    }
    
    // Create a hashset that contains the number of gifts. (Hashset is unordered)
    private ConcurrentHashMap<Integer, Integer> CreateCollection()
    {  
        ConcurrentHashMap<Integer, Integer> newCollection = new ConcurrentHashMap<Integer, Integer>(numberOfGifts);

        for(int i = 0; i < numberOfGifts; i++)
        {
            newCollection.put(i, i);
        }

        return newCollection;
    }

    // If it fails to get the gift then return -1.
    public Integer TakeGift()
    {
        int targetNumber = rand.nextInt(numberOfGifts);
        
        if(collection.contains(targetNumber))
        {
            collection.remove(targetNumber, targetNumber);

            return targetNumber;
        }
        

        return -1;
    }

    public boolean isEmpty()
    {
        return collection.isEmpty();
    }

    public void PrintResults()
    {
        System.out.println("There was " + numberDeleted + " gifts");
    }

}
