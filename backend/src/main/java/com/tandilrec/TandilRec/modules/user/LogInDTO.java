package com.tandilrec.TandilRec.modules.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LogInDTO {

    @NotBlank
    private String dni;

    @NotBlank
    private String password;
}
