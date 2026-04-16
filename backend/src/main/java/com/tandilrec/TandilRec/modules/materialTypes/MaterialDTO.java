package com.tandilrec.TandilRec.modules.materialTypes;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MaterialDTO {

    @NotBlank
    private String name;

    private String description;


}
