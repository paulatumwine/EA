import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private short year;
    private String model;
    private String maker;
    @ManyToOne
    private Person owner;

    public Car(short year, String model, String maker, Person owner) {
        this.year = year;
        this.model = model;
        this.maker = maker;
    }
}
