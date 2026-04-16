package com.tandilrec.TandilRec.modules.user;
import com.tandilrec.TandilRec.modules.citizen.Citizen;
import com.tandilrec.TandilRec.modules.municipal.Municipal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false, unique = true)
    private Long id;

    @NotBlank
    @Column(name = "name" , nullable = false)
    private String name;

    @NotBlank
    @Column(name = "surname" , nullable = false)
    private String surname;

    @NotBlank
    @Column(name = "password" , nullable = false)
    private String password;

    @NotBlank
    @Column(name = "email" , nullable = false, unique = true)
    private String email;

    @OneToOne(mappedBy = "user", optional = true)
    private Municipal municipal;

    @OneToOne(mappedBy = "user")
    private Citizen citizen;

    // Advertise: Be VERY careful with deleting/editing this enum. DB data may be extremely affected
    @Column(name = "role" , nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "created_at" , updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt = null;

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @Column(name = "deleted_at" , nullable = true)
    private LocalDateTime deletedAt = null;

}
