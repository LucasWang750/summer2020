import java.util.Comparator;

public class Course {
    private String ID;
    private String startDate;
    private String endDate;
    private String name;
    private String shortDescription;
    private int numOfSeats;
    private int numOfTakenSeats;

    // Default constructor
    public Course()
    {
        ID = "";
        startDate = "";
        endDate = "";
        name = "";
        shortDescription = "";
        numOfSeats = 0;
        numOfTakenSeats = 0;
    }

    // Constructor with all parameters
    public Course(String ID, String startDate, String endDate, String name, String description, int numOfSeats, int numOfTakenSeats)
    {
        this.ID = ID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.shortDescription= description;
        this.numOfSeats = numOfSeats;
        this.numOfTakenSeats = numOfTakenSeats;
    }

    public void setID(String id)
    {
        this.ID = id;
    }

    public String getID()
    {
        return ID;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setShortDescription(String description)
    {
        this.shortDescription = description;
    }

    public String getShortDescription()
    {
        return shortDescription;
    }

    public void setNumOfSeats(int seats)
    {
        this.numOfSeats = seats;
    }

    public int getNumOfSeats()
    {
        return numOfSeats;
    }

    public int getAvailableSeats()
    {
        return numOfSeats - numOfTakenSeats;
    }

    public void oneNewEnrollemnt()
    {
        numOfTakenSeats++;
    }

    public void oneLessEnrollment()
    {
        numOfTakenSeats--;
    }

    public int getnumOfTakenSeats()
    {
        return numOfTakenSeats;
    }

    // To compare courses by their name
    public static Comparator<Course> courseNameComparator = new Comparator<Course>()
    {
        public int compare(Course c1, Course c2)
        {
            String courseName1 = c1.getName().toUpperCase();
            String courseName2 = c2.getName().toUpperCase();

            return courseName1.compareTo(courseName2);
        }
    };

    @Override
    public String toString()
    {
        return "COURSE ID = " + this.ID + ", Name = " + this.name + "\nSTART DATE = " + this.startDate +
                ", END DATE = " + this.endDate + "\nEnrollment Limit = " + this.numOfSeats + ", Current Enrollment= " + this.numOfTakenSeats +
                ", Available Seats = " + getAvailableSeats() +
                "\nShort Description = " + this.shortDescription;
    }
}
