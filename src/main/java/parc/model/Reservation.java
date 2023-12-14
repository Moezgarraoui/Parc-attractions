package parc.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dateReservation;
    private LocalDate dateFinReservation;
    private double prixTotal;

    @OneToOne
    @JoinColumn(name = "repas")
    private Repas repas;  

    @OneToOne
    @JoinColumn(name = "hotel")
    private Hotel hotel; 

    
}
