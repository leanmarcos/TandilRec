package com.tandilrec.TandilRec.modules.citizen;

import com.tandilrec.TandilRec.modules.adress.Address;
import com.tandilrec.TandilRec.modules.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Data
@Entity(name = "citizen")
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @NotNull
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    @Column(name="DNI",  nullable = false)
    private String DNI;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adress_id")
    private Address address;

    @Column(name= "suspended", nullable = false)
    @ColumnDefault("false")
    private boolean suspended = false;

    @Column(name = "suspended_date", nullable = true)
    private LocalDateTime suspendedAt = null;


}
