public class TreeTest
{
    public static void main(String[] args)
    {
        ImplementedTree t = new ImplementedTree(1);
        Node root = t.getRoot();
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        System.out.println("root.addChild(node2)  : " + root.addChild(node2));
        System.out.println("root.addChild(node3)  : " + root.addChild(node3));
        System.out.println("node2.addChild(node4) : " + node2.addChild(node4));
        System.out.println("node2.addChild(node5) : " + node2.addChild(node5));
        System.out.println("node3.addChild(node6) : " + node3.addChild(node6));
        System.out.println("node3.addChild(node7) : " + node3.addChild(node7));

        System.out.println("Size : " + t.getSize());
        System.out.println("Height : " + t.getHeight());
        System.out.println("Depth : " + t.getDepth(node7));
        System.out.println("Elements : " + t.getElements());
        System.out.println("Positions : " + t.getPositions());
        System.out.println("Swap Elements : " + t.swapElements(node3, node4));
        System.out.println("Replace Elements : " + t.replaceElement(node5, 0));
        System.out.println("Positions : " + t.getPositions());
    }

}
