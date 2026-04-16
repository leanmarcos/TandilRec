package com.tandilrec.TandilRec.modules.user;
import com.tandilrec.TandilRec.modules.adress.AddressDTO;
import com.tandilrec.TandilRec.modules.citizen.CitizenDTO;
import com.tandilrec.TandilRec.modules.citizen.CitizenService;
import com.tandilrec.TandilRec.modules.municipal.MunicipalDTO;
import com.tandilrec.TandilRec.modules.municipal.municipalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Validated()
@RequiredArgsConstructor()
public class UserController {

    private final UserService userService;
    private final CitizenService citizenService;
    private final municipalService  municipalService;



    @PostMapping("/signup/citizen")
    public ResponseEntity<String> signup(@Valid @RequestBody CitizenDTO citizen, BindingResult bindingResult){
            if(bindingResult.hasErrors()){
                return ResponseEntity.badRequest().body("Validation error" +  bindingResult.getAllErrors());
            }

            return ResponseEntity.ok("Account created successfully!");
    }

    @PostMapping("/signup/municipal")
    public ResponseEntity<String> signup(@Valid @RequestBody MunicipalDTO mun, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("Validation error" +  bindingResult.getAllErrors());
        }

        return ResponseEntity.ok("Correct mode");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LogInDTO user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("Validation error" +  bindingResult.getAllErrors());
        }

        return ResponseEntity.ok("Correct mode");
    }

    @PostMapping("/logout")
    public void logout(){

    }

    @PostMapping("/deleteAccount")
    public void deleteAccount(){

    }
}
