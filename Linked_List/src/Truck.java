public class Truck {
    Container head;

    public Truck(){
        head = null;
    }


    // add the new container at the end of the list of containers
    public void addNewContainer(int data){
        Container current = new Container(data);
        Container temp = head;
        if(head == null){
            head = new Container(0);
            head.hook = current;
        } else {
            while (temp.hook != null) {
                temp = temp.hook;
            }
            temp.hook = current;
        }
    }

    // return the value of the first container in the list of containers.
    public int peek(){
        if(head == null){
            return 0;
        }
        return head.hook.value;
    }


     // the first container in the list of containers.
    public void removeContainer(){
        if(head == null) {
           head = new Container(0);
        } else if(head.hook == null) {

        } else if(head.hook.hook == null) {
            head.hook = null;
        } else {
            Container temp = head.hook.hook;
            head.hook = temp;
        }
    }


    // display the list of containers staring from the first container in the list
    public void displayListOfContainers(){
        Container temp = head;
        String sentence = "";
        int i = 0;
        while(temp != null) {
            sentence += "Container" + i++ + " " + temp.value + "\n";
            temp = temp.hook;
        }
        System.out.println(sentence);
    }
}
