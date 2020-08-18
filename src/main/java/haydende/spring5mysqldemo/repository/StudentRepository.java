package haydende.spring5mysqldemo.repository;

import haydende.spring5mysqldemo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
