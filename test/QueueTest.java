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
