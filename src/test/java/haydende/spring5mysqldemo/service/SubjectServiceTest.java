package haydende.spring5mysqldemo.service;

import haydende.spring5mysqldemo.domain.Subject;
import haydende.spring5mysqldemo.repository.SubjectRepository;
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

class SubjectServiceTest {

    public static final String NAME = "Chemistry";

    @Mock
    SubjectRepository subjectRepository;

    SubjectService subjectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        subjectService = new SubjectServiceImpl(subjectRepository);
    }

    @Test
    void findByName() {
        Subject subject = Subject.builder().name(NAME).build();

        BDDMockito
            .given(subjectRepository.findById(anyString()))
            .willReturn(Optional.of(subject));

        Subject actualSubject = subjectService.findByName(NAME);

        assertEquals(NAME, actualSubject.getName());
    }

    @Test
    void findAll() {
        BDDMockito
            .given(subjectRepository.findAll())
            .willReturn(
                Arrays.asList(
                    Subject.builder().build(),
                    Subject.builder().build()));

        List<Subject> actualSubjects = subjectService.findAll();

        assertEquals(2, actualSubjects.size());
    }

    @Test
    void save() {
        Subject subject = Subject.builder().name(NAME).build();

        BDDMockito
            .given(subjectRepository.save(any(Subject.class)))
            .willReturn(subject);

        Subject actualSubject = subjectService.save(Subject.builder().name(NAME).build());

        assertEquals(subject, actualSubject);
    }

    @Test
    void testSave() {
        BDDMockito
            .given(subjectRepository.saveAll(anyIterable()))
            .willReturn(
                Arrays.asList(
                    Subject.builder().build(),
                    Subject.builder().build()));

        List<Subject> actualSubjects = subjectService.save(
            Subject.builder().build(),
            Subject.builder().build());

        assertEquals(2, actualSubjects.size());
    }

    @Test
    void delete() {
        subjectService.delete(Subject.builder().build());
        BDDMockito.verify(subjectRepository, Mockito.times(1)).delete(any(Subject.class));
    }

    @Test
    void deleteMany() {
        subjectService.delete(Subject.builder().build(), Subject.builder().build());
        BDDMockito.verify(subjectRepository, Mockito.times(2)).delete(any(Subject.class));
    }

    @Test
    void deleteByName() {
        subjectService.deleteByName(NAME);
        BDDMockito.verify(subjectRepository, Mockito.times(1)).deleteById(anyString());
    }

    @Test
    void deleteAll() {
        subjectService.deleteAll();
        BDDMockito.verify(subjectRepository, Mockito.times(1)).deleteAll();
    }
}