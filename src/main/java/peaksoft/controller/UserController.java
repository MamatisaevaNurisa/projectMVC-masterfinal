package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.User;
import peaksoft.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user/users";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user/saveUser";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user")User user){
        userService.addUser(user, user.getRoleName());
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("updateUser", user);
        return "user/updateUser";
    }
    @PatchMapping("/{id}")
    public String saveUpdateUser(@PathVariable("id")Long id, @ModelAttribute("user") User user){
        userService.updateUser(id, user, user.getRoleName());
        return "redirect:/users";
    }
    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id")Long id){
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        return "redirect:/users";
    }

}
