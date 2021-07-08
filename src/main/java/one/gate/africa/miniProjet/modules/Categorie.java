package one.gate.africa.miniProjet.modules;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import one.gate.africa.miniProjet.modules.Produits;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom ;
    private int quantite ;
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp dateCreation ;
    private Timestamp dateModification;
    @JsonIgnore
    @OneToMany( mappedBy = "categorie", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Produits> products ;

    public Categorie(){}

    public Categorie(String nom, int quantité) {
        this.nom = nom;
        this.quantite = quantite;
    }
}
