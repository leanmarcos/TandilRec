package com.tandilrec.TandilRec.modules.adress;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTOResponse {
        @NotBlank
        private String city;

        @NotBlank
        private String street;

        @NotNull
        private Integer number;

        private String floor;

        private String apartment;
}
