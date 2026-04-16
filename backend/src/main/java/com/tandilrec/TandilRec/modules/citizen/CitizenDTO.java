package com.tandilrec.TandilRec.modules.citizen;
import com.tandilrec.TandilRec.modules.adress.AddressDTO;
import com.tandilrec.TandilRec.modules.user.SignUpDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CitizenDTO {
    private SignUpDTO  signUpDTO;

    @NotBlank
    @Pattern(regexp = "\\d{7,8}", message = "El DNI debe tener 7 u 8 dígitos numéricos")
    private String dni;

    private AddressDTO address;

}
