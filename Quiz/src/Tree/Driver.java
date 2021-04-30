package Tree;

public class Driver
{
    public static void main(String[] args)
    {
        Tree tree = new Tree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        tree.print();
        System.out.println("Hello");
    }
}
