class ImplementedQueue<T>
{
    private T[] queue;
    private int queueSize;
    private int f;
    private int r;

    public ImplementedQueue(int size)
    {
        queueSize = size;
        queue = (T[]) new Object[queueSize];
        f = 0;
        r = 0;
    }

    public int size()
    {
        return ((queueSize - f + r) % queueSize);
    }

    public boolean isEmpty()
    {
	// boolean result = false;
	// if (f == r)
	// {
	//     result = true;
	// }
	// return result;
        if (size() == 0)
            {
                return true;
            }
        return false;
    }

    public boolean isFull()
    {
        boolean result = false;
        if (size() == (queueSize - 1))
            {
                result = true;
            }
        return result;
    }

    public T front() throws QueueEmptyException
    {
        if (isEmpty())
            {
                throw new QueueEmptyException("Queue is empty, Cannot return Front");
            }
        return queue[f];
    }

    public boolean enqueue(T element) throws QueueFullException
    {
        if (size() == (queueSize - 1))
            {
                throw new QueueFullException("Queue is full, Cannot Insert new element");
            }
        //System.out.println(element);
        queue[r] = element;
        r = ((r + 1) % queueSize);
        return true;
    }

    public T dequeue() throws QueueEmptyException
    {
        if (isEmpty())
            {
                throw new QueueEmptyException("Queue is empty, Cannot pop an element");
            }	
        T temp = queue[f];
        f = ((f + 1) % queueSize);
        return temp;
    }
}



class QueueException extends Exception {

    public QueueException(String message)
    {
	super(message);
    }
}

class QueueEmptyException extends QueueException
{
    public QueueEmptyException(String message)
    {
	super(message);
    }
}

class QueueFullException extends QueueException
{
    public QueueFullException(String message)
    {
	super(message);
    }
}








public class QueueTest

{
    public static void main(String[] args)
    {
	ImplementedQueue queue = new ImplementedQueue(5);

	try
	{
	    System.out.println("Enqueue 5  : " + queue.enqueue(5));
	    System.out.println("Enqueue 12 : " + queue.enqueue(12));
	    System.out.println("Dequeue    : " + queue.dequeue());
	    System.out.println("Enqueue 7  : " + queue.enqueue(7));
	    System.out.println("Dequeue    : " + queue.dequeue());
	    //System.out.println("Enqueue 5 : " + queue.enqueue(5));
	    //System.out.println("Enqueue 5 : " + queue.enqueue(5));
	    //System.out.println("Enqueue 5 : " + queue.enqueue(5));
	    //System.out.println("Enqueue 5 : " + queue.enqueue(5));
	    System.out.println("Size       : " + queue.size());
	    System.out.println("Dequeue    : " + queue.dequeue());
	    System.out.println("Dequeue    : " + queue.dequeue());

	}
	catch (QueueException ex)
	{
	    ex.printStackTrace();
	}
    }

}
