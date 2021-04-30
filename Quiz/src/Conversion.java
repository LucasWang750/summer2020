//public class Conversion {
//    private final static int LIST_TABLE_SIZE = 5;
//    private LinkedList[] lists;
//
//    public Conversion()
//    {
//        lists = new LinkedList[]
//                {
//                    new LinkedList(),
//                    new LinkedList(),
//                    new LinkedList(),
//                    new LinkedList(),
//                    new LinkedList()
//                };
//    }
//
//    // Implement this method to store a given integer (0 to 20) into the table. There are 5 single
//    // linked lists in the table. The data must be distributed evenly between these 5 by using modulus operation
//    // linked lists. We cannot store all data in 1 linked list.
//    public void store(int data)
//    {
//        int listSeparator = data % 5;
//        switch(listSeparator)
//        {
//            case 0:
//                lists[0].insertAtEnd(data);
//                break;
//            case 1:
//                lists[1].insertAtEnd(data);
//                break;
//            case 2:
//                lists[2].insertAtEnd(data);
//                break;
//            case 3:
//                lists[3].insertAtEnd(data);
//                break;
//            case 4:
//                lists[4].insertAtEnd(data);
//                break;
//        }
//    }
//
//    // Implement this method to display all data in the linked list table by
//    // using 1 for loop
//    public void displayListTable()
//    {
//        for(int i = 0; i < 5; i++)
//        {
//            lists[i].displayList();
//        }
//    }
//
//}
