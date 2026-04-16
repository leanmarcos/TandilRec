package com.tandilrec.TandilRec.modules.collections;

import com.tandilrec.TandilRec.modules.appointments.Appointment;
import com.tandilrec.TandilRec.modules.municipal.Municipal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "collection")
public class Collection {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id" , nullable = false,  unique = false)
    private Appointment appointment;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "municipal" , nullable = false, unique = false)
    private Municipal municipal;

    @Column(name = "municipal_notes", nullable = true)
    private String municipalNotes;

    @NotNull
    @Column(name = "visited_at", nullable = false)
    private LocalDateTime visitedAt;

    @NotNull
    @Column(name = "result" , nullable = false)
    @Enumerated(EnumType.STRING)
    private CollectionResult result;
}
