package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("allUsers", userService.listUsers());
        return "users";
    }

    @GetMapping("/addUser")
    public String newUser(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/editUser")
    public String edit(Model model, @RequestParam int id) {
        model.addAttribute("user", userService.getUser(id));
        return "editUser";
    }

    @PostMapping("/editUser")
    public String update(@ModelAttribute("user") User user, @RequestParam("id") int id){
        userService.update(id, user);
        return "redirect:/users";
    }

    @GetMapping("/deleteUser")
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
