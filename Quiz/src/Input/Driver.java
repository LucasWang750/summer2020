package Input;

import java.io.*;
import java.util.StringTokenizer;

public class Driver {
    static final String DELIMITER = ";";
    static LinkedList list_of_dogs = new LinkedList();

    public static void main(String[] args) {

//        readFile();
//        list_of_dogs.displayList();
//
//        int[] arr = new int[list_of_dogs.size()];
//        int length = arr.length;
//        for(int i = 0; i < length; i++)
//        {
//            arr[i] = list_of_dogs.get(i).getAge();
//        }
//
////        for(int i = 0; i < length-1; i++ )
////        {
////            for(int j = i+1; j < length;j++)
////            {
////                if(arr[i] > arr[j])
////                {
////                    int temp = arr[i];
////                    arr[i] = arr[j];
////                    arr[j] = temp;
////                }
////            }
////        }
//        list_of_dogs.orderList();
//
//        for(int i = 0; i < length; i++)
//        {
//            System.out.println("arr[" + i + "]: " + arr[i] );
//        }
//
//        list_of_dogs.displayList();
        System.out.println(pascal(3,2));

    }

    public static void readFile()
    {
        String line = null;
        try {

            File dir = new File(".");
            File fin = new File(dir.getCanonicalPath() + File.separator + "in.txt");
            //File fin = new File("C:\\Users\\Lucas\\IdeaProjects" + "in.txt");
            //System.out.println(dir.getCanonicalPath());
            BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(fin)));

            line = br.readLine();
            while (line != null)
            {

                StringTokenizer stringTokenizer = new StringTokenizer(line, DELIMITER);

                while (stringTokenizer.hasMoreElements())
                {
                    String animal = stringTokenizer.nextElement().toString().trim();
                    int age = Integer.parseInt(stringTokenizer.nextElement().toString().trim());
                    String color = stringTokenizer.nextElement().toString().trim();
                    Animal currentAnimal = new Animal(animal, age, color);
                    list_of_dogs.insertAtEnd(currentAnimal);
                }
                line = br.readLine();
            }
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static int pascal(int row, int column) {
        if (column == 0) {
            return 1;
        } else if (column == row) {
            return 1;
        } else {
            return pascal(row - 1, column - 1) + pascal(row - 1, column);
        }

    }
}