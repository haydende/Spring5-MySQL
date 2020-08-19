package haydende.spring5mysqldemo.controller;

import haydende.spring5mysqldemo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/students/")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("")
    public String findAll(Model model) {
        log.error("Invoking StudentController.findAll()");
        model.addAttribute("students", studentService.findAll());
        return "/students/students";
    }

}
