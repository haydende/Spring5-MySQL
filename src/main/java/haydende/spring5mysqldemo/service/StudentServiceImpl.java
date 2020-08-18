package haydende.spring5mysqldemo.service;

import haydende.spring5mysqldemo.domain.Student;
import haydende.spring5mysqldemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }
        throw new RuntimeException("No Student with an ID of " + id + " has been found!");
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> save(Student... students) {
        List<Student> savedStudents = new ArrayList<>();
        for (Student s: students) {
            savedStudents.add(studentRepository.save(s));
        }
        return savedStudents;
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void delete(Student... students) {
        for (Student s: students) {
            studentRepository.delete(s);
        }
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }
}
