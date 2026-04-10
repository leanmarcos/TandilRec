package com.tandilrec.TandilRec.modules.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public static void login(){

    }

    @PostMapping("/signup")
    public static void signup(){

    }

    @PostMapping("/logout")
    public static void logout(){

    }
}
