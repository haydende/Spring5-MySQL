package haydende.spring5mysqldemo.service;

import haydende.spring5mysqldemo.domain.Student;

import java.util.List;

public interface StudentService {

    Student findById(Long id);

    List<Student> findAll();

    Student save(Student student);

    List<Student> save(Student... students);

    void deleteById(Long id);

    void delete(Student... students);

    void deleteAll();
}
