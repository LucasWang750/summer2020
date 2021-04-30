import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Driver {
    static final String DELIMITER = ";";
    static final String COURSE_DATA = "course.txt";
    static final String STUDENT_COURSE_RELATION_LIST = "student_course_relation_list.ser";
    static Menu menu;
    static FileUtility fileUtility;
    static BufferedReader bufferedReader;
    static File dir;
    static File fin;
    static List<Course> courseList;
    static List<Student> studentList;
    static List<String> enrolledCourseList;
    static List<String> droppedCourseList;
    static List<Course> afterEnrolledCourseList;
    static List<String> afterDroppedCourseList;
    static StudentCourseRelationList studentCourseRelationList;

    public static void main(String[] args)
    {

        menu = new Menu();
        fileUtility = new FileUtility();

        bufferedReader = fileUtility.readInputFromConsole();
        dir = new File(".");

        try
        {
            menu.displayMenu();
            String readLine = bufferedReader.readLine();

            while(!readLine.equals("0"))
            {
                int command = Integer.parseInt(readLine);

                handleCommand(command);
                menu.displayMenu();
                readLine = readInputLine();
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private static void handleCommand(int command)
    {
        switch (command)
        {
            case 1:
                try
                {
                    courseList = new ArrayList<Course>();
                    afterEnrolledCourseList = new ArrayList<Course>();

                    String line = null;
                    fin = new File(dir.getCanonicalPath() + File.separator + COURSE_DATA);
                    BufferedReader br = fileUtility.getFile(fin);

                    while ((line = br.readLine()) != null)
                    {
                        StringTokenizer stringTokenizer = new StringTokenizer(line, DELIMITER);

                        while (stringTokenizer.hasMoreElements())
                        {
                            String ID = stringTokenizer.nextElement().toString().trim();
                            String startDate = stringTokenizer.nextElement().toString().trim();
                            String endDate = stringTokenizer.nextElement().toString().trim();
                            String name = stringTokenizer.nextElement().toString().trim();
                            String description = stringTokenizer.nextElement().toString().trim();
                            int numOfSeats = Integer.parseInt(stringTokenizer.nextElement().toString().trim());
                            int numOfTakenSeats = Integer.parseInt(stringTokenizer.nextElement().toString().trim());

                            Course course = new Course(ID, startDate, endDate, name, description, numOfSeats, numOfTakenSeats);
                            courseList.add(course);
                        }
                    }
                    printCourseList(courseList);
                    br.close();
                    break;
                }
                catch(IOException ex)
                {
                    ex.printStackTrace();
                }
            case 2:

                try{
                    studentList = new ArrayList<Student>();
                    String line = null;
                    fin = new File(dir.getCanonicalPath() + File.separator + "student.txt");
                    BufferedReader br = fileUtility.getFile(fin);

                    while ((line = br.readLine()) != null)
                    {
                        StringTokenizer stringTokenizer = new StringTokenizer(line, DELIMITER);

                        while (stringTokenizer.hasMoreElements())
                        {
                            String ID = stringTokenizer.nextElement().toString().trim();
                            String firstName = stringTokenizer.nextElement().toString().trim();
                            String lastName = stringTokenizer.nextElement().toString().trim();

                            Student student = new Student(ID, firstName, lastName);
                            studentList.add(student);
                        }
                    }
                    printStudentList();
                    br.close();
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }

                System.out.println("Please enter your student's ID: ");
                String studentID = readInputLine();

                boolean isStudentIDValid = validateStudentID(studentID);

                if (isStudentIDValid)
                {
                    System.out.println("Your student's id is verifying...");
                    enrollCourse(studentID);
                }
                else
                {
                    System.out.println("Your student ID is not in the system. Please contact the school's administration.");
                }

                writeStudentCourseRelationListToFile();
                writeCourseListToFile();

                break;
            case 3:
                System.out.println("Please enter your student's ID: ");
                studentID = readInputLine();

                isStudentIDValid = validateStudentID(studentID);

                if (isStudentIDValid)
                {
                    System.out.println("Your student's id is verifying...");
                    dropCourse(studentID);
                }
                else
                {
                    System.out.println("Your student ID is not in the system. Please contact the school's administration.");
                }

                writeStudentCourseRelationListToFile();
                writeCourseListToFile();

                break;
            case 4:
                System.out.println("Please enter your student's ID: ");
                studentID = readInputLine();

                isStudentIDValid = validateStudentID(studentID);

                if (isStudentIDValid)
                {
                    System.out.println("Your student's id is verifying...");
                    displayEnrolledSchedule(studentID);
                }
                else
                {
                    System.out.println("Your student ID is not in the system. Please contact the school's administration.");
                    break;
                }

                break;
        }
    }

    private static void displayEnrolledSchedule(String studentID)
    {
        try
        {
            File in = new File(dir.getCanonicalPath() + File.separator + STUDENT_COURSE_RELATION_LIST);
            ObjectInputStream ois = fileUtility.getObjectInputStream(in);

            StudentCourseRelationList scrl = (StudentCourseRelationList) ois.readObject();

            List<StudentCourseRelation> scrList = scrl.getStudentCourseRelationList();


            for (StudentCourseRelation scr : scrList)
            {
                if (scr.getStudentID().toUpperCase().equals(studentID.trim().toUpperCase()))
                {
                    System.out.println("THE LIST OF ENROLLED COURSES");
                    System.out.println(scr);
                    ois.close();
                }
            }
            //System.out.println("STUDENT ID = " + studentID + " does not exist in the enrolling list. Please contact the school admin.");
            ois.close();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

    private static void writeCourseListToFile()
    {
        try
        {
            File fout = new File(dir.getCanonicalPath() + File.separator + COURSE_DATA);
            BufferedWriter bWriter = fileUtility.getBufferedWriter(fout);

            for (Course course : afterEnrolledCourseList)
            {
                String ID = course.getID();
                String startDate = course.getStartDate();
                String endDate = course.getEndDate();
                String name = course.getName();
                String description = course.getShortDescription();
                int numOfSeats = course.getNumOfSeats();
                int numOfTakenSeats = course.getnumOfTakenSeats();

                bWriter.write(ID + ";");
                bWriter.write(startDate + ";");
                bWriter.write(endDate + ";");
                bWriter.write(name + ";");
                bWriter.write(description + ";");
                bWriter.write((Integer.valueOf(numOfSeats)).toString() + ";");
                bWriter.write((Integer.valueOf(numOfTakenSeats)).toString());
                bWriter.write("\n");
            }

            bWriter.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private static void writeStudentCourseRelationListToFile()
    {
        try
        {
            File fout = new File(dir.getCanonicalPath() + File.separator + STUDENT_COURSE_RELATION_LIST);
            ObjectOutputStream oos = fileUtility.getObjectOutputStream(fout);
            oos.writeObject(studentCourseRelationList);

            oos.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private static void readStudentCourseRelationListFromFile()
    {
        try
        {
            ObjectInputStream ois = null;
            File in = new File(dir.getCanonicalPath() + File.separator + STUDENT_COURSE_RELATION_LIST);

            ois = fileUtility.getObjectInputStream(in);

            studentCourseRelationList =  (StudentCourseRelationList) ois.readObject();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

    private static void enrollCourse(String studentID)
    {
        studentCourseRelationList = new StudentCourseRelationList();
        enrolledCourseList = new ArrayList<>();


        System.out.println("Please enter Y (Yes) to continue. Enter N (No) to quit.");
        String input = readInputLine().trim().toUpperCase();

        while(input.contains("Y"))
        {
            input = enrollCourseAction();
        }

        StudentCourseRelation studentCourseRelation = new StudentCourseRelation(studentID, enrolledCourseList);
        studentCourseRelationList.addStudentCourseRelation(studentCourseRelation);
    }

    private static void dropCourse(String studentID)
    {
        System.out.println("Please enter Y (Yes) to continue. Enter N (No) to quit.");
        String input = readInputLine().trim().toUpperCase();

        enrolledCourseList = getCourseIDList(studentID);
        droppedCourseList = new ArrayList<>();

        while(input.contains("Y"))
        {
            input = dropCourseAction(studentID);
        }

        readStudentCourseRelationListFromFile();
        afterDroppedCourseList = getAfterDroppedCourseList();

        StudentCourseRelation studentCourseRelation = new StudentCourseRelation(studentID, afterDroppedCourseList);
        studentCourseRelationList.addStudentCourseRelation(studentCourseRelation);
    }

    private static List<String> getAfterDroppedCourseList()
    {
        for (String droppedCourse : droppedCourseList)
        {
            enrolledCourseList.remove(droppedCourse);
        }
        return enrolledCourseList;
    }

    private static List<String> getCourseIDList(String studentID)
    {
        try
        {
            ObjectInputStream ois = null;
            File in = new File(dir.getCanonicalPath() + File.separator + STUDENT_COURSE_RELATION_LIST);

            ois = fileUtility.getObjectInputStream(in);

            StudentCourseRelationList studentCourseRelationList =  (StudentCourseRelationList) ois.readObject();

            List<StudentCourseRelation> scrList = studentCourseRelationList.getStudentCourseRelationList();

            for (StudentCourseRelation scr : scrList)
            {
                String sID = scr.getStudentID().trim().toUpperCase();
                if (sID.equals(studentID.toUpperCase()))
                {
                    return scr.getCourseList();
                }

            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    private static String enrollCourseAction()
    {
        System.out.println("Please enter the course ID: ");
        String courseID = readInputLine();

        boolean isCourseIDValid = validateCourseID(courseID);
        if (isCourseIDValid)
        {
            for(Course course: courseList){
                if(course.getID().toUpperCase().equals(courseID.toUpperCase())){
                    course.oneNewEnrollemnt();
                    enrolledCourseList.add(course.getID());
                }
            }
            afterEnrolledCourseList = courseList;
        }
        else
        {
            System.out.println("The course's id is invalid.");
        }
        System.out.println("Please enter Y (Yes) to continue. Enter N (No) to quit.");
        String input = readInputLine().trim().toUpperCase();
        return input;
    }

    private static String dropCourseAction(String studentID)
    {
        System.out.println("Please enter the course ID: ");
        String courseID = readInputLine();

        boolean isCourseIDValid = validateDropCourseID(courseID);
        if (isCourseIDValid)
        {
            for(String cID: enrolledCourseList){
                if(cID.trim().toUpperCase().equals(courseID.trim().toUpperCase())){
                    droppedCourseList.add(cID);
                }
            }
            for(Course course:courseList){
                if(courseID.toUpperCase().equals(course.getID().toUpperCase())){
                    course.oneLessEnrollment();
                }
            }
            afterEnrolledCourseList = courseList;
        }
        else
        {
            System.out.println("The course's id is invalid.");
        }
        System.out.println("Please enter Y (Yes) to continue. Enter N (No) to quit.");
        String input = readInputLine().trim().toUpperCase();
        return input;
    }

    private static boolean validateCourseID(String courseID)
    {
        boolean isValid = false;
        for (Course course : courseList)
        {
            if (course.getID().equals(courseID.toUpperCase()))
            {
                isValid = true;
            }

        }
        return isValid;
    }

    private static boolean validateDropCourseID(String courseID)
    {
        for (String cID : enrolledCourseList)
        {
            if (cID.trim().toUpperCase().equals(courseID.trim().toUpperCase()))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean validateStudentID(String studentID)
    {
        getStudentList();
        for (Student student : studentList)
        {
            if (student.getID().equals(studentID))
            {
                return true;
            }
        }
        return false;
    }

    private static String readInputLine()
    {
        String input = null;
        try
        {
            input = bufferedReader.readLine().trim();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return input;
        }
        return input;
    }

    private static void getStudentList()
    {
        try
        {
            studentList = new ArrayList<Student>();
            String line = null;
            fin = new File(dir.getCanonicalPath() + File.separator + "student.txt");
            BufferedReader br = fileUtility.getFile(fin);

            while ((line = br.readLine()) != null)
            {
                StringTokenizer stringTokenizer = new StringTokenizer(line, DELIMITER);

                while (stringTokenizer.hasMoreElements())
                {
                    String ID = stringTokenizer.nextElement().toString().trim();
                    String firstName = stringTokenizer.nextElement().toString().trim();
                    String lastName = stringTokenizer.nextElement().toString().trim();

                    Student student = new Student(ID, firstName, lastName);
                    studentList.add(student);
                }
            }
            br.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private static void printCourseList(List<Course> courseList)
    {
        for (Course course : courseList)
        {
            System.out.println(course);
            System.out.println();
        }
    }

    private static void printStudentList()
    {
        for (Student student : studentList)
        {
            System.out.println(student);
            System.out.println();
        }
    }
}
