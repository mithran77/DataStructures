import java.util.*;
import java.lang.Math;


class BinaryNode<T>
{
    private T data;
    private BinaryNode parent;
    private BinaryNode leftChild;
    private BinaryNode rightChild;
    //private int height;

    public BinaryNode(T dataVal)
    {
        this.data = dataVal;
        parent = null;
        leftChild = null;
        rightChild = null;
    }

    public boolean setData(T dataVal)
    {
        this.data = dataVal;
        return true;
    }

    public T getData()
    {
        return this.data;
    }

    public boolean setLeftChild(BinaryNode node)
    {
        this.leftChild = node;
        return true;
    }

    public BinaryNode leftChild()
    {
        return this.leftChild;
    }
    
    public boolean setRightChild(BinaryNode node)
    {
        this.rightChild = node;
        return true;
    }

    public BinaryNode rightChild()
    {
        return this.rightChild;
    }
    
    public BinaryNode getParent()
    {
        return this.parent;
    }

    public boolean setParent(BinaryNode node)
    {
        this.parent = node;
        return true;
    }    
    
}


public class BinaryTree<T>
{
    private BinaryNode root;
    private int height;
    private ArrayList<T> elements;
    private ArrayList<BinaryNode> positions;
    private int size;
    
    @SuppressWarnings("unchecked")
    public BinaryTree(T dataVal)
    {
        root = (new BinaryNode(dataVal));
        root.setParent(null);
    }

    @SuppressWarnings("unchecked")
    public BinaryTree()
    {
        root = new BinaryNode(0);
        root.setParent(null);
        root.setLeftChild(null);
        root.setRightChild(null);
    }

    public BinaryNode getRoot()
    {
        return root;
    }

    public boolean isInternal(BinaryNode node)
    {
        if (node.leftChild() != null || node.rightChild() != null)
        {
            return true;
        }
        return false;
    }

    public boolean isExternal(BinaryNode node)
    {
        if ((node.leftChild() == null && node.rightChild() == null) || node == null)
        {
            return true;
        }
        return false;
    }

    public boolean insert(BinaryNode node, T value)  throws BinaryTreeException
    {
        if (node == null)
        {
            node = new BinaryNode(value);
        }
        else if (node.leftChild() == null)
        {
            BinaryNode temp = new BinaryNode(value);
            temp.setParent(node);
            node.setLeftChild(temp);
        }
        else if (node.rightChild() == null)
        {
            BinaryNode temp = new BinaryNode(value);
            temp.setParent(node);
            node.setRightChild(temp);
        }
        return true;
    }
        
    
    public BinaryNode getLeftChild(BinaryNode node) throws BinaryTreeException
    {
        if (isExternal(node))
        {
            throw new BinaryTreeException("Node is External. External nodes don't have children.");
        }
        return node.leftChild();
    }

    public BinaryNode getRightChild(BinaryNode node) throws BinaryTreeException
    {
        if (isInternal(node))
        {
            throw new BinaryTreeException("Node is External. External nodes don't have children.");
        }
        return node.rightChild();
    }

    public BinaryNode getSibling(BinaryNode node) throws BinaryTreeException
    {
        if (node == root)
        {
            throw new BinaryTreeException("Node is Root. Root has no siblings.");
        }
        if (getLeftChild(node.getParent()) == node)
        {
            return getRightChild(node.getParent());
        }
        else
        {
            return getLeftChild(node.getParent());
        }
    }

    public ArrayList<BinaryNode> getChildren(BinaryNode node)  throws BinaryTreeException
    {
        ArrayList<BinaryNode> tempList = new ArrayList<BinaryNode>();
        tempList.add(this.getLeftChild(node));
        tempList.add(this.getRightChild(node));
        return tempList;
    }

    // Overide for root
    public ArrayList<T> getElements() throws BinaryTreeException
    {
        return getElements(this.root);
    }

    // Wrapped for pre-order traversal
    @SuppressWarnings("unchecked")
    public ArrayList<T> getElements(BinaryNode node) throws BinaryTreeException
    {
        elements = new ArrayList<T>();
        addElementsToList(node);
        return elements;
    }

    // Pre-order traversal
    @SuppressWarnings("unchecked")    
    private void addElementsToList(BinaryNode node)  throws BinaryTreeException
    {
        elements.add((T) node.getData());
        if (this.isInternal(node))
        {
            addElementsToList(node.leftChild());
            addElementsToList(node.rightChild());
        }
    }

    // Overide for root
    public ArrayList<BinaryNode> getPositions() throws BinaryTreeException
    {
        return getPositions(this.root);
    }

    // Wrapped for post-order traversal
    public ArrayList<BinaryNode> getPositions(BinaryNode node) throws BinaryTreeException
    {
        positions = new ArrayList<BinaryNode>();
        addPositionsToList(node);
        return positions;
    }

    // Post-order traversal
    public void addPositionsToList(BinaryNode node) throws BinaryTreeException
    {
        if (this.isInternal(node))
        {
            addPositionsToList(node.leftChild());
            addPositionsToList(node.rightChild());
        }            
        positions.add(node);        
    }

    // Root wrapper
    public int getSize() throws BinaryTreeException
    {
        return getSize(this.root);
    }
    
    public int getSize(BinaryNode node) throws BinaryTreeException
    {
        size = 0;
        countNodes(node);
        return size;
    }

    // In-order traversal to determine size
    public void countNodes(BinaryNode node) throws BinaryTreeException
    {
        if (this.isInternal(node))
        {
            countNodes(node.leftChild());
        }
        
        size += 1;
        
        if (this.isInternal(node))
        {
            countNodes(node.rightChild());
        }
    }

}


class BinaryTreeException extends Exception
{
    public BinaryTreeException(String message)
    {
        super(message);
    }
}




// public class BinaryTreeTest
// {
//     public static void main(String[] args)
//     {
//         try
//         {
//             BinaryTree t = new BinaryTree(1);
//             BinaryNode root = t.getRoot();
//             System.out.println("t.insert(2)  : " + t.insert(root, 2));
//             System.out.println("t.insert(3)  : " + t.insert(root, 3));
//             System.out.println("t.insert(4)  : " + t.insert(root, 4));
//             System.out.println("t.insert(5)  : " + t.insert(root, 5));
//             System.out.println("t.insert(6)  : " + t.insert(root, 6));
//             System.out.println("t.insert(7)  : " + t.insert(root, 7));

//             System.out.println("Size : " + t.getSize());
//             //System.out.println("Height : " + t.getHeight());
//             //System.out.println("Depth : " + t.getDepth(node7));
//             System.out.println("Elements : " + t.getElements());
//             System.out.println("Positions : " + t.getPositions());
//             //System.out.println("Swap Elements : " + t.swapElements(node3, node4));
//             //System.out.println("Replace Elements : " + t.replaceElement(node5, 0));
//         }
//         catch (BinaryTreeException ex)
//         {
//             ex.printStackTrace();
//         }
//     }

// }
