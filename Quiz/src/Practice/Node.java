package Practice;






public class Node
{
    public Car data; // data item
    public Node next; // pointer to next node in list

    public Node(Car data)
    {
        this.data = data;
        next = null;
    }
}