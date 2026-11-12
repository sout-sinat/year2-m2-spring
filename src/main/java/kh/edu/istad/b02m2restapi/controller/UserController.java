package kh.edu.istad.b02m2restapi.controller;

import kh.edu.istad.b02m2restapi.model.User;
import kh.edu.istad.b02m2restapi.service.impl.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//UI standard
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable UUID id){
        return userService.getById(id);
    }
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }
}
