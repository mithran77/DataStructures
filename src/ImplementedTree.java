import java.util.*;
import java.lang.Math;

class Node<T>
{
    private T data;
    private Node parent;
    private ArrayList<Node> children;
    int height;

    public Node(T dataVal)
    {
        this.data = dataVal;
        this.children = new ArrayList<Node>();
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

    public boolean addChild(Node child)
    {
        this.children.add(child);
        child.setParent(this);
        return true;
    }

    public ArrayList<Node> getChildren()
    {
        return this.children;
    }

    public Node getParent()
    {
        return this.parent;
    }

    public boolean setParent(Node node)
    {
        this.parent = node;
        return true;
    }    
    
}

class ImplementedTree<T>
{
    private Node root;
    private int height;
    private ArrayList<Node> elements;
    private ArrayList<T> positions;
    private int size;
    @SuppressWarnings("unchecked")
    public Tree(T dataVal)
    {
        root = (new Node(dataVal));
        root.setParent(null);
        elements = new  ArrayList<Node>();
    }

    @SuppressWarnings("unchecked")
    public Tree()
    {
        root = new Node(0);
        root.setParent(null);
        elements = new  ArrayList<Node>();
    }

    public Node getRoot()
    {
        return root;
    }

    public boolean isInternal(Node node)
    {
        if (node.getChildren().size() == 0)
        {
            return false;
        }
        return true;
    }

    public boolean isExternal(Node node)
    {
        if (node.getChildren().size() == 0)
        {
            return true;
        }
        return false;
    }

    public boolean isRoot(Node node)
    {
        if (node.getParent() == null)
        {
            return true;
        }
        return false;
    }    

    public int getSize()
    {
        return getSize(this.root);
    }

    public int getSize(Node node)
    {
        size = 0;
        countNodes(node);
        return size;
    }
    
    public void countNodes(Node node)
    {
        size += 1;
        ArrayList<Node> childrenList = node.getChildren();
        for (Node child : childrenList)
        {
            countNodes(child);
        }
    }

    public int getDepth()
    {
        return getDepth(this.root);
    }
        
    
    public int getDepth(Node node)
    {
        if (isRoot(node) == true)
        {
            return 0;
        }
        else
        {
            return 1 + (getDepth(node.getParent()));
        }
    }

    public int getHeight()
    {
        return getHeight(this.root);
    }
    
    public int getHeight(Node node)
    {
        if (isExternal(node) == true)
        {
            return 0;
        }
        else
        {
            height = 0;
            ArrayList<Node> childrenList = node.getChildren();
            for (Node child : childrenList)
            {
                height = Math.max(height, getHeight(child));
            }
            return 1 + height;
        }
    }

    public ArrayList<T> getPositions()
    {
        return getPositions(this.root);
    }
        
    @SuppressWarnings("unchecked")
    public ArrayList<T> getPositions(Node node)
    {
        positions = new ArrayList<T>();
        addPositionsToList(node);
        return positions;
    }

    @SuppressWarnings("unchecked")    
    private void addPositionsToList(Node node)
    {
        positions.add((T) node.getData());
        ArrayList<Node> childrenList = node.getChildren();
        for (Node child : childrenList)
        {
            addPositionsToList(child);
        }

    }

    public ArrayList<Node> getElements()
    {
        return getElements(this.root);
    }

    public ArrayList<Node> getElements(Node node)
    {
        elements = new ArrayList<Node>();
        addElementsToList(node);
        return elements;
    }
    
    public void addElementsToList(Node node)
    {
        elements.add(node);
        ArrayList<Node> childrenList = node.getChildren();
        for (Node child : childrenList)
        {
            addElementsToList(child);
        }

    }    

    @SuppressWarnings("unchecked")
    public boolean swapElements(Node left, Node right)
    {
        T temp = (T) left.getData();
        left.setData(right.getData());
        right.setData(temp);
        return true;
    }

    @SuppressWarnings("unchecked")    
    public T replaceElement(Node node, T element)
    {
        T temp = (T) node.getData();
        node.setData(element);
        return temp;
    }
}
