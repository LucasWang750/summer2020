package Final;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

public class Driver
{
    static final String DELIMITER = ",";
    static final String FILE_NAME = "InputFile.txt";
    static LinkedList list_of_student = new LinkedList();
    static int length = 0;

    public static void main(String[] args)
    {
        readFile();
//        list_of_student.displayList();
//        changeSSN();
//        System.out.println("After SSN Change--------------------------------------");
//        list_of_student.displayList();
//        System.out.println("After sorting By Name----------------------------------");
//        displaySortByName();
//        System.out.println("Display grade frequency---------------------------------");
//        displayGrades();
//        System.out.println("Display Last name frequency-----------------------------");
//        displayLastNameFrequency();
        System.out.println(combine(2,3));
    }

    public static void readFile()
    {
        FileUtility fileUtility = new FileUtility();
        String line = null;

        try {

            File dir = new File(".");
            File fin = new File(dir.getCanonicalPath() + File.separator + FILE_NAME);
            BufferedReader br = fileUtility.getFile(fin);

            line = br.readLine();
            while (line != null)
            {

                StringTokenizer stringTokenizer = new StringTokenizer(line, DELIMITER);

                while (stringTokenizer.hasMoreElements())
                {
                    String firstName = stringTokenizer.nextElement().toString().trim();
                    String lastName = stringTokenizer.nextElement().toString().trim();
                    String ssn = stringTokenizer.nextElement().toString().trim();
                    String grade = stringTokenizer.nextElement().toString().trim();
                    Student currentStudent = new Student(firstName,lastName,ssn,grade);
                    list_of_student.insertAtEnd(currentStudent);
                }
                line = br.readLine();
            }
            br.close();
            length = list_of_student.size();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void changeSSN()
    {
        for(int i = 0; i < length; i++)
        {
            Student student = list_of_student.get(i);
            String pastSSN = student.getSsn();
            String newSSN = "111" + pastSSN.substring(3);
            student.setSsn(newSSN);
        }
    }

    public static void displaySortByName() {
        String[] nameList = new String[length];

        for (int i = 0; i < length; i++)
        {
            Student student = list_of_student.get(i);
            nameList[i] = student.toString();
        }


        for(int i = 0; i < length; i++)
        {
            String name1 = nameList[i];

            for(int j = 0; j < length; j++)
            {
                String name2 = nameList[j];

                if(name1.compareTo(name2) < 0)
                {
                    String temp = nameList[i];
                    nameList[i] = nameList[j];
                    nameList[j] = temp;
                }
            }
        }
        for(int i = 0; i < length; i++)
        {
            System.out.println(nameList[i]);
        }
    }

    public static void displayGrades()
    {
        char[] gradeList = new char[length];
        int[] gradeCount = new int[5];

        for (int i = 0; i < length; i++)
        {
            Student student = list_of_student.get(i);
            gradeList[i] = student.getGrade().toUpperCase().charAt(0);
        }

        for(int i = 0; i < length; i++)
        {
            switch(gradeList[i])
            {
                case 'A':
                    gradeCount[0]++;
                    break;
                case 'B':
                    gradeCount[1]++;
                    break;
                case 'C':
                    gradeCount[2]++;
                    break;
                case 'D':
                    gradeCount[3]++;
                    break;
                case 'F':
                    gradeCount[4]++;
                    break;
            }
        }
        System.out.println("[A] = " + gradeCount[0]);
        System.out.println("[B] = " + gradeCount[1]);
        System.out.println("[C] = " + gradeCount[2]);
        System.out.println("[D] = " + gradeCount[3]);
        System.out.println("[F] = " + gradeCount[4]);
    }

    public static void displayLastNameFrequency()
    {
        String[] lastNameList = new String[length];
        int[] lastNameCount = new int[length];
        for(int i = 0; i < length; i++)
        {
            Student student = list_of_student.get(i);
            lastNameList[i] = student.getLastName();
        }

        for(int i = 0; i < length; i++)
        {
            int count = 1;
            for(int j = i+1; j < length; j++)
            {
                if(lastNameList[i].equals(lastNameList[j]))
                {
                    count++;
                    lastNameCount[j] = -1;
                }
            }

            if(lastNameCount[i] != -1) {
                lastNameCount[i] = count;
            }
        }
        for(int i = 0; i < length; i++)
        {
            if(lastNameCount[i] != -1)
            {
                System.out.println("[" + lastNameList[i] + "]: " + lastNameCount[i]);
            }
        }
    }



    public static int combine(int column, int row) {
        if(column == 0)
        {
            return 1;
        }
        else if(row == 0)
        {
            return 0;
        }
        else
        {
            return combine(column, row-1) + combine(column-1, row-1);
        }
    }
}
