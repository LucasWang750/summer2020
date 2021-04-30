package Practice;

public class Car
{
    private String color;
    private String size;

    public Car()
    {
        this.color = null;
        this.size = null;
    }

    public Car(String newColor, String newSize)
    {
        this.color = newColor;
        this.size = newSize;
    }

    public String getColor()
    {
        return this.color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getSize()
    {
        return this.size;
    }

    public void setSize(String newSize)
    {
        this.size = newSize;
    }


    public void drive()
    {
        System.out.println("The car drove.");
    }

}
