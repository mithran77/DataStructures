public class DoublyLinkedListTest
{
    //LinkedList myList;

    public static void main(String[] args)
    {
        // Data initialization
        DoublyLinkedList myList = new DoublyLinkedList();
        LinkedNode first = new LinkedNode(10);
        LinkedNode second = new LinkedNode(12);
        LinkedNode third = new LinkedNode(19);
        try
        {
            System.out.println("Size : " + myList.size());
            System.out.println("Insert First : " + myList.insertFirst(first));
            System.out.println("Size : " + myList.size());
            System.out.println("Insert Last : " + myList.insertLast(third));
            System.out.println("Size : " + myList.size());
            System.out.println("Insert Before : " + myList.insertBefore(third, second));
            System.out.println("Size : " + myList.size());
        }
        catch (LinkedListError ex)
        {
            ex.printStackTrace();
        }
    }
}
