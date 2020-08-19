package haydende.spring5mysqldemo.controller;

import haydende.spring5mysqldemo.domain.Student;
import haydende.spring5mysqldemo.service.StudentService;
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

class StudentControllerTest {

    public static final String URL = "/students/";

    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    void findAll() throws Exception {

        BDDMockito
            .given(studentService.findAll())
            .willReturn(
                Arrays.asList(
                    Student.builder().build(),
                    Student.builder().build()));

        mockMvc.perform(get(URL))
            .andExpect(status().isOk())
            .andExpect(view().name("/students/students"))
            .andExpect(model().attributeExists("students"));
    }
}