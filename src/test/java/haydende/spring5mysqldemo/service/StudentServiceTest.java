package haydende.spring5mysqldemo.service;

import haydende.spring5mysqldemo.domain.Student;
import haydende.spring5mysqldemo.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;

class StudentServiceTest {

    public static final Long ID = Long.valueOf(1L);

    @Mock
    StudentRepository studentRepository;

    StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    void findById() {
        Student student = Student
            .builder()
            .id(ID)
            .build();

        BDDMockito
            .given(studentRepository.findById(anyLong()))
            .willReturn(Optional.of(student));

        Student actualStudent = studentService.findById(ID);

        assertEquals(ID, actualStudent.getId());
    }

    @Test
    void findAll() {
        BDDMockito
            .given(studentRepository.findAll())
            .willReturn(
                Arrays.asList(
                    Student.builder().build(),
                    Student.builder().build()
                ));

        List<Student> actualStudents = studentService.findAll();

        assertEquals(2, actualStudents.size());
    }

    @Test
    void save() {
        Student student = Student.builder().id(ID).build();

        BDDMockito
            .given(studentRepository.save(any(Student.class)))
            .willReturn(student);

        Student actualStudent = studentService.save(Student.builder().id(ID).build());

        assertEquals(student, actualStudent);
    }

    @Test
    void testSave() {
        List<Student> students = Arrays.asList(
            Student.builder().build(),
            Student.builder().build()
        );

        BDDMockito
            .given(studentRepository.saveAll(anyIterable()))
            .willReturn(students);

        List<Student> actualStudents = studentService.save(
            Student.builder().build(),
            Student.builder().build()
        );

        assertEquals(2, actualStudents.size());
    }

    @Test
    void deleteById() {
        studentService.deleteById(ID);
        BDDMockito.verify(studentRepository, Mockito.times(1)).deleteById(anyLong());
    }

    @Test
    void delete() {
        studentService.delete(Student.builder().build());
        BDDMockito.verify(studentRepository, Mockito.times(1)).delete(any(Student.class));
    }

    @Test
    void deleteMany() {
        studentService.delete(
            Student.builder().build(),
            Student.builder().build());

        BDDMockito.verify(studentRepository, Mockito.times(2)).delete(any(Student.class));
    }

    @Test
    void deleteAll() {
        studentService.deleteAll();

        BDDMockito.verify(studentRepository, Mockito.times(1)).deleteAll();
    }
}