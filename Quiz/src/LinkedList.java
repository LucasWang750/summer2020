
public class LinkedList {
    public Node head;

    public LinkedList()
    {
        head = null;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public void insertAtFront(int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public Node removeAtFront()
    {
        if (head == null)
            return null;
        else
        {
            Node temp = head;
            head = head.next;
            return temp;
        }
    }

    public void insertAtEnd(int data)
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

    public Node removeAtEnd()
    {
        Node temp = head;
        if (isEmpty())
            return null;
        if (head.next == null)
        {
            head = null;
            return temp;
        }
        else
        {
            Node current = head;
            while(current.next.next != null)
            {
                current = current.next;
            }
            temp = current.next;
            current.next = null;
            return temp;
        }
    }
    public String getList()
    {
        String list = new String();

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

    public int get(int index)
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
