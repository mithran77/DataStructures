
public class PrintParenthesizedExpression extends BinaryTree
{

    public PrintParenthesizedExpression(String data)
    {
        super(data);
    }

    
    public void printExpression(BinaryNode node)
    {
        if (this.isExternal(node))
        {
            System.out.print(node.getData());
        }
        else
        {
            System.out.print(" ( ");
            this.printExpression(node.leftChild());
            System.out.print(node.getData());
            this.printExpression(node.rightChild());
            System.out.print(" ) ");
        }
    }

    public static void main(String[] args)
    {
        PrintParenthesizedExpression expTree = new PrintParenthesizedExpression("/");
        try
        {
            expTree.insert(expTree.getRoot(), "-");
            expTree.insert(expTree.getRoot(), "*");
            expTree.insert(expTree.getRoot().leftChild(), "+");
            expTree.insert(expTree.getRoot().leftChild().leftChild(), "5");
            expTree.insert(expTree.getRoot().leftChild().leftChild(), "6");
            expTree.insert(expTree.getRoot().leftChild(), "7");
            expTree.insert(expTree.getRoot().rightChild(), "8");
            expTree.insert(expTree.getRoot().rightChild(), "9");
            System.out.println("Elements : " + expTree.getElements());
            expTree.printExpression(expTree.getRoot());
            System.out.println();
        }
        catch (BinaryTreeException ex)
        {
            ex.printStackTrace();
        }
    }

}


                  //          /
                  //      -        *
                  //   +     7   8   9
                  // 5   6      
