package Quiz2;

public class LinkedList {
    private Node head;

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

    public void removeAtFront()
    {
        if (head == null)
            return;
        else
        {
            head = head.next;
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

    public int getMaxValue()
    {
        int max = head.data;
        Node current = head;

        if(isEmpty())
        {
            return 0;
        }
        else
        {
            while (current != null)
            {
                if (current.data > max)
                {
                    max = current.data;
                }
                current = current.next;
            }
        }
        return max;
    }

    public int getIndex(int data)
    {
        int index = -1;
        Node current = null;

        if(isEmpty())
        {
            return -1;
        }
        else
        {
            current = head;
            while(current != null)
            {
                index++;
                if(current.data == data)
                {
                    return index;
                }
                current = current.next;
            }
        }

        return -1;
    }
}
