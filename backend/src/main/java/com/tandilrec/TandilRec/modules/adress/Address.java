package com.tandilrec.TandilRec.modules.adress;

import com.tandilrec.TandilRec.modules.citizen.Citizen;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;


@Data
 @Entity
 @Table(name = "address")
 public class Address {

   @Id
   @Column(name = "id" , nullable = false, unique = true)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
   private List<Citizen> citizens;

   @Column(name = "city" , nullable = false)
   @NotNull
   private String city;

   @Column(name = "street" , nullable = false)
   @NotNull
   private String street;

   @Column(name = "number", nullable = false)
   @NotNull
   private String number;

   @Column(name = "floor")
   private String floor;

   @Column(name = "apartment")
   private String apartment;

 }


