package Input;

public class Animal {

    private int age;
    private String color;
    private String name;

    public Animal()
    {
        this.age = -1;
        this.color = null;
        this.name = null;
    }

    public Animal(String name, int age, String color)
    {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString()
    {
        return "Type: " + name + " Age: " + age + " Color: " + color;
    }
}
