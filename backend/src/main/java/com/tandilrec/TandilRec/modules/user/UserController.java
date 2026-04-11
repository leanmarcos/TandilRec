package com.tandilrec.TandilRec.modules.user;

import com.tandilrec.TandilRec.modules.citizen.CitizenService;
import com.tandilrec.TandilRec.modules.adress.adressService;
import com.tandilrec.TandilRec.modules.municipal.municipalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    private UserService userService;
    private CitizenService citizenService;
    private municipalService  municipalService;
    private adressService addresService;

    public UserController(){
        this.userService = new UserService();
        this.citizenService = new CitizenService();
        this.municipalService  = new municipalService();
        this.addresService  = new adressService();
    }

    @GetMapping("/signup")
    public void signup(){

    }

    @GetMapping("/login")
    public void login(){

    }

    @GetMapping("/logout")
    public void logout(){

    }

    @GetMapping("/deleteAccount")
    public void deleteAccount(){

    }
}
