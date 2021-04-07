package Java;

public class ConcurrentLinkedList<T extends Object>
{
    

    
    public boolean add(T item)
    {
        int key = item.hashCode();

        while(true)
        {
            // Window window = find(head, key);
            // Node pred = window.pred, curr = window.curr;

            /*  if (curr.key == key)
                {
                    return false;
                }
                else
                {
                    Node node = new Node(item);
                    node.next = new AtomicMarkableReference(curr, false);
                    if(pred.next.compareAndSet(curr, node, false, false))
                    {
                        return true;
                    }
                }
            */

        }
    }

    class Node 
    {

    }

}
