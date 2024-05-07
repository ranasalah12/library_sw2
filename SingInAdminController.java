package com.example.Library.Management.Controller;

import com.example.Library.Management.Service.AdminService;
import com.example.Library.Management.Service.SignUp;
import com.example.Library.Management.Service.SingInService;
import com.example.Library.Management.models.Member;
import com.example.Library.Management.models.RepositoryAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class SingInAdminController {
    @Autowired
    private AdminService adminService;


    @GetMapping("/sinAdmin")
    public String adminPage(Model model) {
        return "SingInAdmain";
    }

    @PostMapping("/singA")
    public String signInAdmin(@RequestParam String username, @RequestParam String password, Model model) {

        if (username.equals("root") && password.equals("root")) {
            List<Member> members =adminService.showAllUsers();
            model.addAttribute("members", members);
            return "AfterLoginAdmain";
        } else {

            model.addAttribute("error", "Invalid username or password");
            return "SingInAdmain";
        }
    }
}
