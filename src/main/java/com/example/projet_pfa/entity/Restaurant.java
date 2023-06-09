package com.example.projet_pfa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFermeture;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOuverture;
    private int latitude;
    private int longitude;
    private String adresse;
   // private double rank;
   @Column(length =50000)
   private String photo;

    @ManyToOne
    private Serie serie;


    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    @ManyToOne
    private Specialite specialite;



    @OneToMany(mappedBy = "restaurant")
    @JsonIgnore
    private List<Produit> produitList;

    @OneToMany(mappedBy = "restaurant")
    @JsonIgnore
    private List<Reservation> reservationList;







}
