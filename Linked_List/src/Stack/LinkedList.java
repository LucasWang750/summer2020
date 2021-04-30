package Stack;

class LinkedList {
    Node head = new Node();

    public void insertFront(Vertex newData)
    {
        Node newNode = new Node(newData);
        if(!isEmpty())
        {
            newNode.next = head.next;
        }
        head.next = newNode;
    }

    public void insertEnd(Vertex newData)
    {
        Node newNode = new Node(newData);
        Node temp = null;

        if(isEmpty())
        {
            head.next = newNode;
        }
        else
        {
            temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public Vertex removeFront()
    {
        Node firstNode = null;
        if(isEmpty())
        {
            return null;
        }
        else
        {
            firstNode = head.next;
            head.next = firstNode.next;
            return firstNode.data;
        }
    }
    public Vertex removeEnd() //from end
    {
        Node temp = null;
        Node deletedNode = null;

        if(isEmpty())
        {
            return null;
        }
        else
        {
            temp = head;
            while(temp.next.next != null){  //if there's no node 2 ahead
                temp = temp.next;
            }
            deletedNode = temp.next;          // saves last node
            temp.next = null;             // deletes last node
            return deletedNode.data;          // returns deleted data
        }
    }

    public boolean isEmpty() {
        return (head.next == null);
    }


     public void print(String dataStructure)
     {
     if (head.next == null)
     {
     System.out.println("The" + dataStructure +  " is empty.");
     return;
     }
     Node temp = head;
     while (temp.next != null)
     {
//     System.out.print(temp.next.data.getName());
//     System.out.println("-Distance cost = " + temp.next.data.getShortestPath());
         System.out.println(temp.next.data);
     temp = temp.next;
     }
     }


    //for testing purposes
    @Override
    public String toString(){
        String description = "";
        Node temp = null;

        if(isEmpty())
        {
            description = "List is empty\n";
        }
        else
        {
            temp = head.next; // do not want to print out the special node first node
            while(temp != null){
                description += "Node: " + temp.data + "\n";
                temp = temp.next;
            }
        }
        return description;
    }
}
