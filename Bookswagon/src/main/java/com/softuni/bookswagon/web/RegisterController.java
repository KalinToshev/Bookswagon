package com.softuni.bookswagon.web;

import com.softuni.bookswagon.model.dto.RegisterUserEntityDTO;
import com.softuni.bookswagon.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users/register")
public class RegisterController {
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping
    public String registerUser(@Valid RegisterUserEntityDTO registerUserEntityDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (!registerUserEntityDTO.getPassword().equals(registerUserEntityDTO.getConfirmPassword())) {
            bindingResult.addError(
                    new FieldError(
                            "differentConfirmPassword",
                            "confirmPassword",
                            "Passwords must be the same."
                    ));
        }

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("registerUserEntityDTO", registerUserEntityDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerUserEntityDTO", bindingResult);
            return "redirect:/users/register";
        }

        this.userService.registerUser(registerUserEntityDTO);

        return "redirect:/users/login";
    }

    @ModelAttribute
    public RegisterUserEntityDTO registerUserEntityDTO() {
        return new RegisterUserEntityDTO();
    }
}
