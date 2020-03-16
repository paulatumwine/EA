import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Grades")
@NoArgsConstructor
@Getter
@Setter
public class Enrollment {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 3)
    private String grade;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Student student;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Course course;
}
