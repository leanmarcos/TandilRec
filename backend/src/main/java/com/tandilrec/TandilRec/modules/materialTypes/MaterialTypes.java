package com.tandilrec.TandilRec.modules.materialTypes;
import com.tandilrec.TandilRec.modules.materialAppointment.MaterialTypeAppointment;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "material_types")
public class MaterialTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @OneToMany(mappedBy = "materialType")
    private List<MaterialTypeAppointment> materialTypeAppointments;

    @NotBlank
    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "description" , nullable = false)
    private String description;

    @NotNull
    @Column(name = "created_at" , nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at" , nullable = true)
    @ColumnDefault("null")
    private LocalDateTime updatedAt = null;

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @Column(name = "deleted_at")
    @ColumnDefault("null")
    private LocalDateTime deletedAt = null;




}
