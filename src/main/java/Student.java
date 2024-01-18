public class Student {
    private final int age;
    private final String gender;
    private final int weight;
    private final int height;

    public Student(int age, String gender, int weight, int height) {
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

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o){
        return o != null && getClass() == o.getClass() && (this == o || equals((Student) o));
    }

    @Override
    public int hashCode(){
        return Object.hash(age, gender, weight, height);
    }

    @Override
    public String toString(){
        return "Student{" +
                "age = " + getAge() +
                ", gender = " + getGender() +
                ", weight = " + getWeight() +
                ", height = " + getHeight() + "}";
    }
}
