package com.tandilrec.TandilRec.modules.appointments;
import com.tandilrec.TandilRec.modules.citizen.Citizen;
import com.tandilrec.TandilRec.modules.collections.Collection;
import com.tandilrec.TandilRec.modules.materialAppointment.MaterialTypeAppointment;
import com.tandilrec.TandilRec.modules.materialTypes.MaterialTypes;
import com.tandilrec.TandilRec.modules.municipal.Municipal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizen_id" ,  nullable = false)
    private Citizen citizen;

    @OneToMany(mappedBy =  "appointment", fetch = FetchType.LAZY)
    private List<MaterialTypeAppointment> materialTypeAppointment;

    @OneToOne(mappedBy = "appointment")
    private Collection collection;

    @NotBlank
    @Column(name = "verification_code", length = 6, nullable = false)
    private String verificationCode;

    @Column(name = "status" , nullable = false)
    @Enumerated(EnumType.STRING)
    private AppointmentState status =AppointmentState.PENDING;

    @NotNull
    @Column(name= "scheduled_date" , nullable = false)
    private LocalDateTime scheduledDate = LocalDateTime.now();

    @Column(name = "citizen_notes" , nullable = true)
    private String citizenNotes;

}
