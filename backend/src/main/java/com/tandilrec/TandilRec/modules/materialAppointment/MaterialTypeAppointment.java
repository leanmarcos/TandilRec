package com.tandilrec.TandilRec.modules.materialAppointment;
import com.tandilrec.TandilRec.modules.appointments.Appointment;
import com.tandilrec.TandilRec.modules.materialTypes.MaterialTypes;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "material_type_appointment")
public class MaterialTypeAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "material_type_id" , nullable = false)
    private MaterialTypes materialType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id" , unique = true, nullable = false)
    private Appointment appointment;
}
