class Task<T> implements Comparable<Task>
{
    private int priority;
    private T data;

    public Task(T dataVal, int pri)
    {
        priority = pri;
        data = dataVal;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setPriority(int pri)
    {
        priority = pri;
    }
    
    public T getData()
    {
        return data;
    }

    public void setData(T dataVal)
    {
        data = dataVal;
    }

    public int compareTo(Task other)
    {
        if (this.priority > other.priority)
        {
            return 1;
        }
        else if (this.priority == other.priority)
        {
            return 0;
        }
        return -1;
    }

    public String toString()
    {
        return "    " + getPriority() + "     " + "     " + getData();
    }
    
    
}
