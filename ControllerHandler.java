package com.example.Library.Management.Controller;

import com.example.Library.Management.Service.EmailService;
import com.example.Library.Management.Service.PasswordService;
import com.example.Library.Management.Service.SingInService;
import com.example.Library.Management.models.Member;
import com.example.Library.Management.Service.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *  ABOUt ALL class
 *  class defines the behavior of handling login-related requests.
 *  It provides methods for showing the login form, processing login attempts,
 *  and displaying a success page. Additionally,
 *  it interacts with the database through the UserRepository to authenticate users.
 */
@Controller
public class ControllerHandler {
    /**
     *  This annotation tells Spring to automatically inject an instance of UserRepository
     *  into the controller. UserRepository is an interface that
     *  provides CRUD operations for the User entity.
     */






}