package haydende.spring5mysqldemo.repository;

import haydende.spring5mysqldemo.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Long, Teacher> {
}
