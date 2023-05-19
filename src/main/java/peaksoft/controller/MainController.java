package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entities.User;
import peaksoft.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {
    private final UserService userService;
    @GetMapping()
    public String getMainPage() {
        return "mainPage";
    }
    @GetMapping("/profile")
    public String profile(HttpServletRequest request, Model model){
        Principal principal = request.getUserPrincipal();
        User user = userService.getUserByUserName(principal.getName());
        model.addAttribute("user", user);
        return "profile";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}

