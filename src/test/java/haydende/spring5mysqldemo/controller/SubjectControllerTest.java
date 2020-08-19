package haydende.spring5mysqldemo.controller;

import haydende.spring5mysqldemo.domain.Subject;
import haydende.spring5mysqldemo.service.SubjectService;
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

class SubjectControllerTest {

    public static final String URL = "/subjects/";

    @Mock
    SubjectService subjectService;

    @InjectMocks
    SubjectController subjectController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(subjectController).build();
    }

    @Test
    void findAll() throws Exception {
        BDDMockito
            .given(subjectService.findAll())
            .willReturn(
                Arrays.asList(
                    Subject.builder().build(),
                    Subject.builder().build()));

        mockMvc
            .perform(get(URL))
            .andExpect(status().isOk())
            .andExpect(view().name("subjects/subjects"))
            .andExpect(model().attributeExists("subjects"));
    }
}