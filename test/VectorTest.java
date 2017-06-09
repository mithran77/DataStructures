public class VectorTest
{
    public static void main(String[] args)
    {

	ImplementedVector vector = new ImplementedVector(10);
	try
	{
	    System.out.println("isEmpty()           : " + vector.isEmpty());
	    System.out.println("insertAtRank(0, 12) : " + vector.insertAtRank(0, 12));
	    System.out.println("replaceAtRank(0, 5) : " + vector.replaceAtRank(0, 5));
	    System.out.println("elemAtRank(0)       : " + vector.elemAtRank(0));
	    System.out.println("isEmpty()           : " + vector.isEmpty());
	    System.out.println("removeAtRank(0)     : " + vector.removeAtRank(0));
	    System.out.println("size()              : " + vector.size());

	}
	catch (RankOutOfRange ex)
	{
	    ex.printStackTrace();
	}
    }
}
