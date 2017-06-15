import java.util.*;

public class HeapTest
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int range = scanner.nextInt();
        scanner.close();
        
        // Insert random values into heaps:
        Heap minHeap = new MinHeap();
        Heap maxHeap = new MaxHeap();
        System.out.println("Insert Number Sequence:");
        for(int i = 0; i < range; i++)
        {
            int value = (int) (Math.random() * 100);
            minHeap.add(value);
            maxHeap.add(value);
            System.out.print(+ value + " ");
        }

        // System.out.print("minHeap : ");
        // for (Object o : minHeap.getHeap())
        // {
        //     System.out.print(o + " ");
        // }
        // System.out.println();
        
        // Remove values from heaps:
        System.out.println("\n\nPoll Values:\n------------\nMinHeap MaxHeap");
        for(int i = 0; i < range; i++)
        {
            System.out.format("  %-12d", minHeap.poll());
            System.out.format("%-6d\n", maxHeap.poll());
        }
        try
        {
            minHeap.peek();
        }
        catch(IllegalStateException e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            maxHeap.peek();
        }
        catch(IllegalStateException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
