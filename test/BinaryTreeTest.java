public class BinaryTreeTest
{
    public static void main(String[] args)
    {
        try
        {
            BinaryTree t = new BinaryTree(1);
            System.out.println("t.insert(2)  : " + t.insert(t.getRoot(), 2));
            System.out.println("t.insert(3)  : " + t.insert(t.getRoot(), 3));
            System.out.println("t.insert(4)  : " + t.insert(t.getRoot().leftChild(), 4));
            System.out.println("t.insert(5)  : " + t.insert(t.getRoot().leftChild(), 5));
            System.out.println("t.insert(6)  : " + t.insert(t.getRoot().rightChild(), 6));
            System.out.println("t.insert(7)  : " + t.insert(t.getRoot().rightChild(), 7));

            System.out.println("Size : " + t.getSize());
            System.out.println("Elements : " + t.getElements());
            System.out.println("Positions : " + t.getPositions());
        }
        catch (BinaryTreeException ex)
        {
            ex.printStackTrace();
        }
    }

}
