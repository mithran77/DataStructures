public class MaxHeap extends Heap
{
    public void heapifyDown()
    {
        int index = 0;
        while (hasLeftChild(index))
        {
            int largestChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && (comparator.compare(rightChild(index), leftChild(index)) > 0))
            {
                largestChildIndex = getRightChildIndex(index);
            }

            if (comparator.compare(heap[index], heap[largestChildIndex]) > 0)
            {
                break;
            }
            else
            {
                swapElements(largestChildIndex, index);
            }
            index = largestChildIndex;            
        }
    }

    public void heapifyUp()
    {
        int index = size - 1;
        while (hasParent(index) && (comparator.compare(heap[index], parent(index)) > 0))
        {
            swapElements(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

}
