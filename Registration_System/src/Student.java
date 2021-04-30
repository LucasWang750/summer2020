import java.io.Serializable;


public class Student implements Serializable{
    private String ID;
    private String firstName;
    private String lastName;

    public Student()
    {
        this.ID = null;
        this.firstName = null;
        this.lastName = null;
    }

    public Student(String ID, String firstName, String lastName)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public String getID()
    {
        return ID;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    @Override
    public String toString()
    {
        return "Student ID: " + this.ID + ", Name: " + getFullName();
    }
}