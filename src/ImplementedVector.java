class ImplementedVector<T>
{
    private T[] vector;
    private int vectorSize;

    public ImplementedVector(int s)
    {
        vector = (T[]) new Object[s];
        vectorSize = 0;
    }
    
    public int size()
    {
        return vectorSize;
    }

    public boolean isEmpty()
    {
        if (size() == 0)
            {
                return true;
            }
        return false;
    }

    public T elemAtRank(int r) throws RankOutOfRange
    {
        if (r < 0 || r > size())
            {
                throw new RankOutOfRange("The rank was out of range 0 - " + size());
            }
        return vector[r];
    }

    public T replaceAtRank(int r, T e) throws RankOutOfRange
    {
        if (r < 0 || r > size())
            {
                throw new RankOutOfRange("The rank was out of range 0 - " + size());
            }
        vector[r] = e;
        return e;
    }

    public boolean insertAtRank(int r, T e) throws RankOutOfRange
    {
        if ((r < 0) || (r > (size() + 1)))
            {
                throw new RankOutOfRange("The rank was out of range 0 - " + size() + 1);
            }

        T[] temp = (T[]) new Object[size() +1];
        for (int i = r; i < size(); i++)
            {
                temp[i+1] = vector[i];

            }

        temp[r] = e;
        vectorSize++;
        vector = temp;
        return true;
    }

    public T removeAtRank(int r) throws RankOutOfRange
    {
	
        if (r < 0 || r > size())
            {
                throw new RankOutOfRange("The rank was out of range 0 - " + size());
            }

        T[] temp = (T[]) new Object[size() - 1];
        T removedVal = vector[r];
        for (int i = r; i < (size() - 1); i++)
            {
                temp[i] = vector[i+1];
            }

        vectorSize--;
        vector = temp;
        return removedVal;
    }
}




class RankOutOfRange extends Exception
{
    public RankOutOfRange(String message)
    {
	super(message);
    }
}
