package com.tandilrec.TandilRec.modules.municipal;
import com.tandilrec.TandilRec.modules.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "municipal")
public class Municipal {
    @Id
    @Column(name = "id" , nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id" ,  nullable = false)
    private User user;

    @NotBlank
    @Column(name = "DNI" , nullable = false, unique = true)
    private String dni;

    @Column(name = "department")
    private String department = null;

    @NotBlank
    @Column(name = "city" , nullable = false)
    private String city;

}
