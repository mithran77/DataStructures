import java.util.*;

public abstract class Heap<T>
{
    protected int capacity;
    protected int size;
    protected T[] heap;
    protected NaturalComparator comparator;

    public Heap()
    {
        capacity = 10;
        size = 0;
        heap = (T[]) new Object[capacity];
        comparator = new NaturalComparator();
    }

    public boolean isFull()
    {
        return (size == capacity);
    }

    public void isEmpty()
    {
        if (size == 0)
        {
            throw new IllegalStateException("Heap is empty, cannot perform operation.");
        }
    }

    
    public int getParentIndex(int index)
    {
        return ((index - 1) / 2);
    }

    public int getRightChildIndex(int index)
    {
        return ((index * 2) + 2);
    }

    public int getLeftChildIndex(int index)
    {
        return ((index * 2) + 1);
    }

    public boolean hasLeftChild(int index)
    {
        //System.out.println("index, getLeftChildIndex(index),  size : " + index + " " + getLeftChildIndex(index) + " " + size);
        return (getLeftChildIndex(index) < size);
    }

    public boolean hasRightChild(int index)
    {
        return (getRightChildIndex(index) < size);
    }
    
    public T leftChild(int index)
    {
        return heap[getLeftChildIndex(index)];
    }


    public T rightChild(int index)
    {
        return heap[getRightChildIndex(index)];
    }

    public boolean hasParent(int index)
    {
        return (getParentIndex(index) >= 0);
    }

    public T parent(int index)
    {
        return heap[getParentIndex(index)];
    }
    
    public void swapElements(int indexOne, int indexTwo)
    {
        T temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    public void add(T element)
    {
        heap[size] = element;
        size++;
        heapifyUp();
    }

    public T poll()
    {
        isEmpty();
        T temp = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();        
        return temp;
    }

    public T peek()
    {
        isEmpty();
        return heap[0];
    }

    public T[] getHeap()
    {
        return heap;
    }
    
    public abstract void heapifyUp();
    public abstract void heapifyDown();
    
}



