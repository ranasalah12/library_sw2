package com.example.Library.Management.Controller;

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


@Controller
public class SingInController {
    @Autowired
    private SingInService singInService;

    @Autowired
    private SignUp signU;



    @GetMapping("/sing")
    public String showSignInForm(Model model) {
        model.addAttribute("message", "");
        return "login";
    }

    /**
     * @PostMapping  This annotation maps HTTP POST requests to the /sing URL to the singIn() method.
     * This method takes two parameters (username and password) sent from the login form.
     * It then tries to find a user in the database with the provided username and password using the UserRepository.
     * If a user is found, it redirects to the success page (/success), otherwise,
     * it redirects back to the login page with an error parameter.
     */
    @PostMapping("/sing")
    public String signIn(@RequestParam String username, @RequestParam String password, Model model) {
        // for no repeating password and not small
        Member user = singInService.login(username, password);

        if (user != null) {
            model.addAttribute("Uname", "Hello "+signU.getName()+"               ");
            return "redirect:/AfterLogin";
        } else {

            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
