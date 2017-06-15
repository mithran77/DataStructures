public class MinHeap extends Heap
{
    public void heapifyDown()
    {
        int index = 0;
        //System.out.println("hasLeftChild(index) " + hasLeftChild(index));
        while (hasLeftChild(index))
        {
            int smallestChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && (comparator.compare(rightChild(index), leftChild(index)) < 0))
            {
                smallestChildIndex = getRightChildIndex(index);
            }

            //System.out.println("heap[index], heap[smallestChildIndex]" + heap[index] + " " + heap[smallestChildIndex]);
            if (comparator.compare(heap[index], heap[smallestChildIndex]) < 0)
            {
                break;
            }
            else
            {
                swapElements(smallestChildIndex, index);
            }
            index = smallestChildIndex;            
        }
    }

    public void heapifyUp()
    {
        int index = size - 1;
        while (hasParent(index) && (comparator.compare(heap[index], parent(index)) < 0))
        {
            swapElements(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

}
