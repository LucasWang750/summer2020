import java.util.*;
import java.io.Serializable;

public class StudentCourseRelation implements Serializable{

    private String studentID;
    private List<String> courseList;

    public StudentCourseRelation()
    {
        this.studentID = null;
        this.courseList = null;
    }

    public StudentCourseRelation(String ID, List<String> enrolledCourseList){
        this.studentID = ID;
        this.courseList = enrolledCourseList;
    }

    public String getStudentID(){
        return studentID;
    }



    public List<String> getCourseList(){
        return courseList;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();

        str.append("COURSE IDs = ");
        for (String course : courseList)
        {
            str.append(course + ";");
        }
        return str.toString();
    }
}
