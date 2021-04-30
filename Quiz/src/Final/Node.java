package Final;

public class Node
{
    public Student data;
    public Node next;

    public Node(Student data)
    {
        this.data = data;
    }

    public void displayNode()
    {
        System.out.println(data);
    }
}
