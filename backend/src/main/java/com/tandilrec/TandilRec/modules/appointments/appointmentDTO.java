package com.tandilrec.TandilRec.modules.appointments;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class appointmentDTO {

    @NotNull
    private LocalDateTime scheduled_date;

    private String citizen_notes;

    @NotEmpty
    private List<Long> materialTypeIds;

}
