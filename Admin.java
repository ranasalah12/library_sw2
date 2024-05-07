package com.example.Library.Management.Controller;

import com.example.Library.Management.Service.AdminService;
import com.example.Library.Management.Service.EmailService;
import com.example.Library.Management.Service.PasswordService;
import com.example.Library.Management.Service.SignUp;
import com.example.Library.Management.models.Member;
import com.example.Library.Management.models.RepositoryAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class Admin {


    @Autowired
    private RepositoryAPI repositoryAPI;

    @Autowired
    private AdminService adminService1;


    @Autowired
    private SignUp signUp;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordService passwordService;
    @PostMapping("/Adelete")
    public String deleteUser(@RequestParam("userId") Long userId, Model model) {
        Optional<Member> userOptional = repositoryAPI.findById(userId);
        if (userOptional.isPresent()) {
            repositoryAPI.delete(userOptional.get());
            List<Member> members =adminService1.showAllUsers();
            model.addAttribute("members", members);
            model.addAttribute("message", "Deleting Successfully");
        } else {
            model.addAttribute("message", "No change");
        }
             return "AdminActions";
    }


    @PostMapping("/ADD")
    public String ADD(@RequestParam String usernameR, @RequestParam String nameR, @RequestParam String passwordR, @RequestParam String email , Model model) {
        if(!passwordService.noRepeatingPassword(passwordR)){
            model.addAttribute("errorPassword", "Password already Exist repeat another password ");
            return "AdminActions";
        }
        if(!emailService.noRepeatingEmail(email)){
            model.addAttribute("errorPassword", "Email already Exist repeat another email ");
            return "AdminActions";
        }
        if(!passwordService.goodPassword(passwordR)){
            model.addAttribute("errorPassword", "WEEK password");
            return "AdminActions";
        }

        Member userR = new Member(nameR,email,usernameR,passwordR);
        signUp.save(userR);
        List<Member> members =adminService1.showAllUsers();
        model.addAttribute("members", members);
        model.addAttribute("message", "USER ADD SUCCESSFULLY");
        return "AdminActions";

    }
}
