package haydende.spring5mysqldemo.repository;

import haydende.spring5mysqldemo.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}
