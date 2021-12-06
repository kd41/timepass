package ee.alex.timepass.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ee.alex.timepass.dto.UserDTO;
import ee.alex.timepass.service.DataAcessException;
import ee.alex.timepass.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@EnableAutoConfiguration
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // @GetMapping(value = { "/user", "/{id}" })
    public String showRegisterForm(Model model, @PathVariable("id") Long id) throws DataAcessException {

        UserDTO user = userService.getById(id);
        model.addAttribute("user", user);

        return "user_add";
    }

    @GetMapping()
    public String getAllUsers(Model model) {

        model.addAttribute("userList", getUserList());

        model.addAttribute("user", new UserDTO());

        return "user_add";
    }

    @PostMapping()
    public String postRegisterForm(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult, Model model, Locale locale) {

        Boolean registered = false;
        try {

            if (bindingResult.hasErrors()) {
                // hasError = true;
            }

            userService.addUser(userDTO);
            registered = true;

        } catch (Exception ex) {
            registered = false;
        }

        model.addAttribute("registered", registered);
        model.addAttribute("userList", getUserList());

        return "user_add";
    }

    private List<UserDTO> getUserList() {
        List<UserDTO> userList = userService.getAll();
        Collections.sort(userList, new Comparator<UserDTO>() {
            @Override
            public int compare(UserDTO lhs, UserDTO rhs) {
                return lhs.getId() > rhs.getId() ? -1 : (lhs.getId() < rhs.getId()) ? 1 : 0;
            }
        });
        return userList;
    }
}
