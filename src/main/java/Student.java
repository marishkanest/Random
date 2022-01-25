public class Student {

    int team;
    String name;

    public Student(int team, String name) {
        this.team = team;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "team=" + team +
                ", name='" + name + '\'' +
                '}';
    }


}

