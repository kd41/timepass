package ee.alex.timepass.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ee.alex.timepass.dto.CourseDTO;
import ee.alex.timepass.service.CourseService;
import lombok.RequiredArgsConstructor;

@Controller
@EnableAutoConfiguration
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping()
    public String getAllCourses(Model model) {

        model.addAttribute("courseList", getCourseList());

        model.addAttribute("course", new CourseDTO());

        return "course_add";
    }

    @PostMapping()
    public String postRegisterForm(@Valid @ModelAttribute("course") CourseDTO courseDTO, BindingResult bindingResult, Model model, Locale locale) {
        Boolean registered = false;
        try {

            if (bindingResult.hasErrors()) {
                // hasError = true;
            }

            courseService.addCourse(courseDTO);
            registered = true;

        } catch (Exception ex) {
            registered = false;
        }

        model.addAttribute("registered", registered);
        model.addAttribute("courseList", getCourseList());

        return "course_add";
    }

    private List<CourseDTO> getCourseList() {
        List<CourseDTO> userList = courseService.getAll();
        Collections.sort(userList, new Comparator<CourseDTO>() {
            @Override
            public int compare(CourseDTO lhs, CourseDTO rhs) {
                return lhs.getId() > rhs.getId() ? -1 : (lhs.getId() < rhs.getId()) ? 1 : 0;
            }
        });
        return userList;
    }
}
