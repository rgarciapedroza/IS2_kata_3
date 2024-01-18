import java.util.Objects;

public class Student {
    private final int age;
    private final String gender;
    private final double weight;
    private final double height;

    public Student(int age, String gender, double weight, double height) {
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o){
        return o != null && getClass() == o.getClass() && (this == o || equals((Student)o));
    }

    @Override
    public int hashCode(){
        return Objects.hash(age, gender, height, weight);
    }

    @Override
    public String toString(){
        return "Student{" +
                " age: " + getAge() +
                " gender: " + getGender() +
                " height: " + getHeight() +
                " weight: " + getWeight() + "}";
    }
}
