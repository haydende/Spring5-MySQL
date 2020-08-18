package haydende.spring5mysqldemo.service;

import haydende.spring5mysqldemo.domain.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher findById(Long id);

    List<Teacher> findAll();

    Teacher save(Teacher teacher);

    List<Teacher> save(Teacher... teachers);

    void delete(Teacher teacher);

    void deleteById(Long id);

    void deleteAll();
}
