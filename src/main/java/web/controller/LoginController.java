package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDao;
import web.dao.UserDaoImpl;

@Controller
@RequestMapping("")
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage() {

        return "login/login";
    }
}
