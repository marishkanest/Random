
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Student {

    int id;
    int team;
    String name;
    int points;
    int sprosil =0;
    int otvetil =0;


    public Student(int team, String name) {
        this.team=team;
        this.name=name;
     }
}

