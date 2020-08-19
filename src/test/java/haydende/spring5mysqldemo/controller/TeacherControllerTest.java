package haydende.spring5mysqldemo.controller;

import haydende.spring5mysqldemo.domain.Teacher;
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

class TeacherControllerTest {

    public static final String URL = "/teachers/";

    @Mock
    TeacherService teacherService;

    @InjectMocks
    TeacherController teacherController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(teacherController).build();
    }

    @Test
    void findAll() throws Exception {
        BDDMockito
            .given(teacherService.findAll())
            .willReturn(
                Arrays.asList(
                    Teacher.builder().build(),
                    Teacher.builder().build()));

        mockMvc
            .perform(get(URL))
            .andExpect(status().isOk())
            .andExpect(view().name("teachers/teachers"))
            .andExpect(model().attributeExists("teachers"));
    }
}