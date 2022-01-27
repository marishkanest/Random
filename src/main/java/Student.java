public class Student {

    int team;
    String name;
    int sprosil =0;
    int otvetil =0;

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

