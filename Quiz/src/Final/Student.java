package Final;

public class Student
{
    private String lastName;
    private String firstName;
    private String ssn;
    private String grade;
    public Student()
    {

    }

    public Student(String firstName, String lastName, String ssn, String grade)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.ssn = ssn;
        this.grade = grade;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString()
    {
        return lastName + ", " + firstName + " SSN:" + ssn + " Grade: " + grade;
    }
}
