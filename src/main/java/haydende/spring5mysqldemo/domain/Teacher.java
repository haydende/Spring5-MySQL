package haydende.spring5mysqldemo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToOne
    private Subject subject;
}
