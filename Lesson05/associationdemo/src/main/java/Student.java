import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue
    @Column(name="studentId")
    private Long id;
    private String name;
    private int age;
    @OneToMany
    private List<Enrollment> Courses;
}

