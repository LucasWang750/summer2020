
import java.util.*;
import java.io.Serializable;

public class StudentCourseRelationList implements Serializable{

    private List<StudentCourseRelation> studentCourseRelationList;

    public StudentCourseRelationList(){
        studentCourseRelationList = new ArrayList<>();
    }

    public void addStudentCourseRelation(StudentCourseRelation scr)
    {
        for(int i = 0; i < studentCourseRelationList.size(); i++){
            if(scr.getStudentID().equals(studentCourseRelationList.get(i).getStudentID())){
                studentCourseRelationList.remove(studentCourseRelationList.get(i));
            }
        }
        studentCourseRelationList.add(scr);
    }

    public void deleteStudentCourseRelation(String studentID)
    {
        for(StudentCourseRelation scr : studentCourseRelationList){
            if(scr.getStudentID().equals(studentID)){
                studentCourseRelationList.remove(scr);
            }
        }
    }

    public List<StudentCourseRelation> getStudentCourseRelationList(){
        return studentCourseRelationList;
    }



}
