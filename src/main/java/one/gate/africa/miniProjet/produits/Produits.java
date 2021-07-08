package one.gate.africa.miniProjet.produits;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import one.gate.africa.miniProjet.categorie.Categorie;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Produits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private int quantite ;
    private Boolean disponible;
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp dateCreation ;
    private Timestamp dateModification;
    @ManyToOne
    private Categorie categorie;

    public Produits (){}

    public Produits(String nom, int quantite) {
        this.nom = nom;
        this.quantite = quantite;
    }
}
