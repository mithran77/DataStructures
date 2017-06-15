import java.util.*;

public class PriorityQueueTest
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int range = scanner.nextInt();
        scanner.close();

        // Insert random values into PQ:
        PriorityQueue priorityQueue = new PriorityQueue();

        System.out.println("Insert Priority Sequence:");
        for(int i = 0; i < range; i++)
        {
            int value1 = (int) (Math.random() * 100);
            int value2 = (int) (Math.random() * 100);
            
            priorityQueue.add(new Task(value1, value2));
            System.out.print(+ value2 + " ");
        }
        
        // Remove values from heaps:
        System.out.println("\n\nPoll Values:\n------------\nPriority          Data");
        for(int i = 0; i < range; i++)
        {
            System.out.println(priorityQueue.poll());
        }
        try
        {
            priorityQueue.peek();
        }
        catch(IllegalStateException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
