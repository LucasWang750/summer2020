package Quiz2;

public class Node {
    public int data; // data item
    public Node next; // pointer to next node in list

    public Node(int data)
    {
        this.data = data;
        next = null;
    }

    public void displayNode()
    {
        System.out.println("Data: " + data);
    }

}
