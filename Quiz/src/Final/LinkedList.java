package Final;


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

    public void insertAtFront(Student data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void removeAtFront()
    {
        if (head == null)
        {

        }
        else
        {
            head = head.next;
        }
    }

    public void insertAtEnd(Student data)
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
    public String getList()
    {
        String list = "";

        Node current = head;
        while (current != null)
        {
            list += current.data;
            list += ";";
            current = current.next;
        }

        return list;
    }

    public void displayList()
    {
        Node current = head;
        while (current != null)
        {
            current.displayNode();
            current = current.next;
        }
    }

    public int size()
    {
        int size = 0;
        Node current = head;
        while(current!=null)
        {
            current = current.next;
            size++;
        }
        return size;
    }

    public Student get(int index)
    {
        Node current = head;
        if(index <= size()) {
            for (int i = 0; i < index; i++)
            {
                current = current.next;
            }
        }
        return current.data;
    }

}
