package com.tandilrec.TandilRec.modules.CitizenAddress;

import com.tandilrec.TandilRec.modules.adress.Address;
import com.tandilrec.TandilRec.modules.citizen.Citizen;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "citizen_address")
public class CitizenAddress {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizen_id", nullable = false)
    private Citizen citizen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "is_default", nullable = false)
    private Boolean isDefault = false;
}
