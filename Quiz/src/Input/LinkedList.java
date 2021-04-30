package Input;

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

    public void insertAtFront(Animal data)
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

    public void insertAtEnd(Animal data)
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

    public Animal get(int index)
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

    public void orderList()
    {
        Node current = null;
        Node temp = null;
        if(isEmpty())
        {

        }
        else
        {

            current = head;
            temp = current;
            while(current!=null)
            {
                while(temp != null)
                {
                    if(current.data.getAge() > temp.data.getAge())
                    {
                        Animal temporary = current.data;
                        current.data = temp.data;
                        temp.data = temporary;
                    }
                    temp = temp.next;
                }
                current = current.next;
                temp = current;
            }
        }
    }

}
