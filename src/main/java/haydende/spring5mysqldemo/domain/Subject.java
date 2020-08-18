package haydende.spring5mysqldemo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Subject {

    @Id
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Student> students;
}
