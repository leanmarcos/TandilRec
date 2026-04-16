package com.tandilrec.TandilRec.modules.user;
import com.tandilrec.TandilRec.modules.adress.AddressDTO;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SignUpDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank(message = "Email is required")
    @Email(message = "Must be a valid email")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8 , max = 20 , message = "Passwords must be in a length between 8 and 20")
    private String password;

    @NotBlank
    private String confirmPassword;

    @AssertTrue(message = "Passwords do not match")
    public boolean isPasswordMatching() {
        if (password == null) return confirmPassword == null;
        return password.equals(confirmPassword);
    }

}
