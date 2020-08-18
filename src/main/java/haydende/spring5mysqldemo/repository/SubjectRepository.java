package haydende.spring5mysqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<String, SubjectRepository> {
}
