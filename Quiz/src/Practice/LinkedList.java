package Practice;

public class LinkedList
{

    private Node head;

    public LinkedList()
    {
        head = null;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public void insertAtFront(Car data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void removeAtFront()
    {
        if (head == null)
            return;
        else
        {
            head = head.next;
        }
    }

    public void insertAtEnd(Car data)
    {
        Node newNode = new Node(data);

        if (isEmpty())
        {
            head = newNode;
        }
        else
        {
            Node current = head;

            while(current.next != null)
            {
                current = current.next;
            }

            current.next = newNode;
        }
    }

    public void removeAtEnd()
    {
        if (isEmpty())
            return;
        if (head.next == null)
        {
            head = null;
        }
        else
        {
            Node current = head;
            while(current.next.next != null)
            {
                current = current.next;
            }
            current.next = null;
        }
    }




}
