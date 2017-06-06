
class LinkedNode
{
    protected int data;
    private LinkedNode previousNode;
    private LinkedNode nextNode;
    
    public LinkedNode()
    {
        data = 0;
        previousNode = null;
        nextNode = null;
    }

    //Overloaded constructor
    public LinkedNode(int dataValue)
    {
        data = dataValue;
        previousNode = null;
        nextNode = null;
    }
        
    public boolean setData(int dataValue)
    {
        data = dataValue;
        return true;
    }

    public int getData()
    {
        return data;
    }        
        
    public boolean setNext(LinkedNode next)
    {
        nextNode = next;
        return true;
    }

    public boolean setPrevious(LinkedNode previous)
    {
        previousNode = previous;
        return true;
    }

    public LinkedNode getNext()
    {
        return nextNode;
    }

    public LinkedNode getPrevious()
    {
        return previousNode;
    }

}


class LinkedList
{
    private LinkedNode head;
    private LinkedNode tail;
    
    public LinkedList()
    {
        head = new LinkedNode();
        tail = new LinkedNode();
        head.setNext(tail);
        tail.setPrevious(head);	

    }

    public boolean isEmpty()
    {
        boolean result = false;
	
        if ((head.getNext() == tail) && (tail.getPrevious() == head))
            {
                result = true;
            }
        return result;
    }

    public int size()
    {
        int size = 0;
        LinkedNode node = head;

        while(node.getNext() != tail)
            {
                size++;
                node = node.getNext();
            }

        return size;
    }
    
    public LinkedNode first() throws LinkedListError
    {
        if (isEmpty())
            {
                throw new LinkedListError("Linked list is empty");
            }
        return head.getNext();
    }

    public LinkedNode last() throws LinkedListError
    {
        if (isEmpty())
            {
                throw new LinkedListError("Linked list is empty");
            }
        return head.getPrevious();
    }    
    
    public boolean isFirst(LinkedNode node)
    {
        boolean result = false;
        if (node.getPrevious() == head)
            {
                result = true;
            }
        return result;
    }

    public boolean isLast(LinkedNode node)
    {
        boolean result = false;
        if (node.getNext() == tail)
            {
                result = true;
            }
        return result;
    }    

    public LinkedNode before(LinkedNode node) throws LinkedListError
    {
        if (isFirst(node) == true)
            {
                throw new LinkedListError("Element is first node, cannot get previous element");
            }
        return node.getPrevious();
    }

    public LinkedNode after(LinkedNode node) throws LinkedListError
    {
        if (isLast(node) == true)
            {
                throw new LinkedListError("Element is last node, cannot get next element");
            }
        return node.getNext();
    }


    public int replaceElement(LinkedNode p, LinkedNode e) throws LinkedListError
    {
        if (isEmpty())
            {
                throw new LinkedListError("List is empty");
            }
        LinkedNode node = p;
        p.getPrevious().setNext(e);
        p.getNext().setPrevious(e);
        e.setNext(p.getNext());
        e.setPrevious(p.getPrevious());

        return p.getData();
    }

    public void swapElements(LinkedNode p, LinkedNode e) throws LinkedListError
    {
        if (isEmpty())
            {
                throw new LinkedListError("List is empty");
            }
        LinkedNode tempNode = e;
        // Swap for p's neighbours
        p.getPrevious().setNext(e);
        p.getNext().setPrevious(e);
        // Swap for e
        e.setNext(p.getNext());
        e.setPrevious(p.getPrevious());
        // Swap for p
        p.setNext(tempNode.getNext());
        p.setPrevious(tempNode.getPrevious());
        // Swap for e's neighbours
        tempNode.getPrevious().setNext(p);
        tempNode.getNext().setPrevious(p);
    }

    public boolean insertFirst(LinkedNode node)
    {
        LinkedNode second = head.getNext();
        head.setNext(node);
        second.setPrevious(node);
        node.setPrevious(head);
        node.setNext(second);
        return true;
    }

    public boolean insertLast(LinkedNode node)
    {
        LinkedNode secondLast = tail.getPrevious();
        tail.setPrevious(node);
        secondLast.setNext(node);
        node.setPrevious(secondLast);
        node.setNext(tail);
        return true;
    }

    public boolean insertBefore(LinkedNode p, LinkedNode e) throws LinkedListError
    {
        if (isFirst(p))
            {
                throw new LinkedListError("Element is the first");
            }
        LinkedNode tempNode = e;
        // Wiring for p's predecessor
        p.getPrevious().setNext(e);
        // Wiring for e
        e.setPrevious(p.getPrevious());
        e.setNext(p);
        // Set p
        p.setPrevious(e);
        return true;
    }

    public boolean insertAfter(LinkedNode p, LinkedNode e) throws LinkedListError
    {
        if (isLast(p))
            {
                throw new LinkedListError("Element is the last");
            }
	
        LinkedNode tempNode = e;
        // Wiring for p's sucessor
        p.getNext().setPrevious(e);
        // Wiring for e
        e.setNext(p.getNext());
        e.setPrevious(p);
        // Set p
        p.setNext(e);
        return true;
    }    

    public void remove(LinkedNode node) throws LinkedListError
    {
        if (isEmpty())
            {
                throw new LinkedListError("List is empty");
            }
        // Predecessor wiring
        node.getPrevious().setNext(node.getNext());
        // Sucessor wiring
        node.getNext().setPrevious(node.getPrevious());
        node.setPrevious(null);
        node.setNext(null);
    }
    
}


class LinkedListError extends Exception
{
    public LinkedListError(String message)
    {
        super(message);
    }
}


public class DoublyLinkedListTest
{
    LinkedList myList;

    public static void main(String[] args)
    {
        // Data initialization
        LinkedList myList = new LinkedList();
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
