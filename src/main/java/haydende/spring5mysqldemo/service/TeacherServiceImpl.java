package haydende.spring5mysqldemo.service;

import haydende.spring5mysqldemo.domain.Teacher;
import haydende.spring5mysqldemo.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher findById(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            return teacher.get();
        }
        throw new RuntimeException("No Teacher with the ID of " + id + " has been found!");
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> save(Teacher... teachers) {
        List<Teacher> savedTeachers = new ArrayList<>();
        for (Teacher t: teachers) {
            savedTeachers.add(teacherRepository.save(t));
        }
        return savedTeachers;
    }

    @Override
    public void delete(Teacher... teachers) {
        for (Teacher t: teachers) {
            teacherRepository.delete(t);
        }
    }

    @Override
    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        teacherRepository.deleteAll();
    }
}
