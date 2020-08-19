package haydende.spring5mysqldemo.controller;

import haydende.spring5mysqldemo.domain.Student;
import haydende.spring5mysqldemo.domain.Subject;
import haydende.spring5mysqldemo.domain.Teacher;
import haydende.spring5mysqldemo.service.StudentService;
import haydende.spring5mysqldemo.service.SubjectService;
import haydende.spring5mysqldemo.service.TeacherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

class IndexControllerTest {

    @Mock
    TeacherService teacherService;

    @Mock
    SubjectService subjectService;

    @Mock
    StudentService studentService;

    @InjectMocks
    IndexController indexController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    void getAll() throws Exception {
        BDDMockito
            .given(teacherService.findAll())
            .willReturn(
                Arrays.asList(Teacher.builder().build()));

        BDDMockito
            .given(studentService.findAll())
            .willReturn(
                Arrays.asList(
                    Student.builder().build()));

        BDDMockito
            .given(subjectService.findAll())
            .willReturn(
                Arrays.asList(
                    Subject.builder().build()));

        mockMvc
            .perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("index"))
            .andExpect(model().attributeExists("teachers", "students", "subjects"));
    }
}