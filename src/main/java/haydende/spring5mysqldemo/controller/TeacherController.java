package haydende.spring5mysqldemo.controller;

import haydende.spring5mysqldemo.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/teachers/")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping("")
    public String findAll(Model model) {
        log.error("Invoking TeacherController.findAll()");
        model.addAttribute("teachers", teacherService.findAll());
        return "teachers/teachers";
    }

}
