package com.example.Library.Management.Controller;

import com.example.Library.Management.Service.EmailService;
import com.example.Library.Management.Service.PasswordService;
import com.example.Library.Management.Service.SignUp;
import com.example.Library.Management.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {


    @Autowired
    private SignUp signUp;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordService passwordService;

    String name="";

    @GetMapping("/reg")
    public String showRegistrationForm() {
        return "login";
    }

    @PostMapping("/reg")
    public String register(@RequestParam String usernameR, @RequestParam String nameR, @RequestParam String passwordR, @RequestParam String email , Model model) {
        if(!passwordService.noRepeatingPassword(passwordR)){
            model.addAttribute("errorPassword", "Password already Exist repeat another password ");
            return "login";
        }
        if(!emailService.noRepeatingEmail(email)){
            model.addAttribute("errorPassword", "Email already Exist repeat another email ");
            return "login";
        }
        if(!passwordService.goodPassword(passwordR)){
            model.addAttribute("errorPassword", "WEEK password");
            return "login";
        }

        Member userR = new Member(nameR,email,usernameR,passwordR);
        signUp.save(userR);

        model.addAttribute("message", "Hi   "+nameR);
        return "login";

    }



    @GetMapping("/payment")
    public String showPaymentPage(Model model) {
        model.addAttribute("Uname", "Hello "+name+"               ");
        return "Payment";
    }



    @GetMapping("/AfterLogin")
    public String showAfterPage(Model model) {
        model.addAttribute("Uname", "Hello "+name+"               ");
        return "AfterLogin";
    }


}
