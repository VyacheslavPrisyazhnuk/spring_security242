package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;


import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }



    @GetMapping("user")
    public String user(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "admin/show";
    }

    @GetMapping()
    @Transactional
    public String index(Model model) {
        model.addAttribute("users", userService.index());

        return "admin/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "admin/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "admin/new";
    }



    @PostMapping()
    public String create(@ModelAttribute("user") User user, @RequestParam("my_roles[]") String[] my_roles) {
        Set<Role> roles = new HashSet<>();
        for (String my_role: my_roles) {
            System.out.println(my_role);
            Role role = new Role((my_role.equals("ROLE_ADMIN") ? 2L : 1L), my_role);
            roles.add(role);
        }
        user.setRoles(roles);
        userService.save(user);
        return "redirect:/admin";
    }



    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.show(id));
        return "admin/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id,
                         @RequestParam("my_roles[]") String[] my_roles) {
        Set<Role> roles = new HashSet<>();
        for (String my_role: my_roles) {
            System.out.println(my_role);
            Role role = new Role((my_role.equals("ROLE_ADMIN") ? 2L : 1L), my_role);
            roles.add(role);
        }
        user.setRoles(roles);
        userService.update(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
