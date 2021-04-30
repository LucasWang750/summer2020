package Input;

public class Node
{
    public Animal data; // data item
    public Node next; // pointer to next node in list

    public Node(Animal data)
    {
        this.data = data;
        next = null;
    }

    public void displayNode()
    {
        System.out.println("Animal: " + data);
    }
}
