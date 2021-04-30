package Practice;

public class Driver
{


    //Initialize a linked list of cars.
    //add 10 yellow big cars into the linked list
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList(); //good

        for(int i = 0 ; i < 10; i++) //good
        {
            list.insertAtEnd(new Car("yellow", "big"));
        }
    }

}