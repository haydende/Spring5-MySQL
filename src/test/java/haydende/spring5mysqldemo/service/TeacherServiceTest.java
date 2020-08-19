package haydende.spring5mysqldemo.service;

import haydende.spring5mysqldemo.domain.Teacher;
import haydende.spring5mysqldemo.repository.TeacherRepository;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

class TeacherServiceTest {

    public static final Long ID = Long.valueOf(1L);

    @Mock
    TeacherRepository teacherRepository;

    TeacherService teacherService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        teacherService = new TeacherServiceImpl(teacherRepository);
    }

    @Test
    void findById() {
        Teacher teacher = Teacher.builder().id(ID).build();

        BDDMockito
            .given(teacherRepository.findById(anyLong()))
            .willReturn(Optional.of(teacher));

        Teacher actualTeacher = teacherService.findById(ID);

        assertEquals(ID, actualTeacher.getId());
    }

    @Test
    void findAll() {
        BDDMockito
            .given(teacherRepository.findAll())
            .willReturn(
                Arrays.asList(
                    Teacher.builder().build(),
                    Teacher.builder().build()));

        List<Teacher> actualTeachers = teacherService.findAll();

        assertEquals(2, actualTeachers.size());
    }

    @Test
    void save() {
        Teacher teacher = Teacher.builder().id(ID).build();

        BDDMockito
            .given(teacherRepository.save(any(Teacher.class)))
            .willReturn(teacher);

        Teacher actualTeacher = teacherService.save(teacher);

        assertEquals(teacher.getId(), actualTeacher.getId());
    }

    @Test
    void testSave() {
        BDDMockito
            .given(teacherRepository.save(any(Teacher.class)))
            .willReturn(Teacher.builder().build());

        List<Teacher> savedTeachers = teacherService.save(
                Teacher.builder().build(),
                Teacher.builder().build()
        );

        assertEquals(2, savedTeachers.size());

        BDDMockito.verify(teacherRepository, Mockito.times(2)).save(any(Teacher.class));
    }

    @Test
    void delete() {
        teacherService.delete(Teacher.builder().build());
        BDDMockito.verify(teacherRepository, Mockito.times(1)).delete(any(Teacher.class));
    }

    @Test
    void deleteById() {
        teacherService.deleteById(anyLong());
        BDDMockito.verify(teacherRepository, Mockito.times(1)).deleteById(anyLong());
    }

    @Test
    void deleteAll() {
        teacherService.deleteAll();
        BDDMockito.verify(teacherRepository, Mockito.times(1)).deleteAll();
    }
}