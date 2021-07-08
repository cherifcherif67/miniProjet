package one.gate.africa.miniProjet.services;

import one.gate.africa.miniProjet.modules.Produits;
import one.gate.africa.miniProjet.repository.ProduitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProduitsService {
    @Autowired
    ProduitsRepository produitsRepository ;
    @Autowired
    CategorieService categorieService;

    public List<Produits> getProduits(){
        List<Produits>produitsList = new ArrayList<>();
        produitsRepository.findAll().forEach(produitsList::add);
        return produitsList;
    }

    public Produits getProduitById(Long id){
        return (Produits) produitsRepository.findById(id).get();
    }

    public  List<Produits> getProduitsByIdCategorie(Long id){
        List<Produits>produitsList = new ArrayList<>();
        produitsRepository.findByCategorieId(id).forEach(produitsList::add);
        return produitsList;
    }

    public void addProduit (Produits produit,Long idCategorie){
        produit.setCategorie(categorieService.findById(idCategorie));
        Date aujourdhui = new Date();
        Timestamp ts=new Timestamp(aujourdhui.getTime());
        produit.setDateCreation(ts);
        if((produit.getQuantite())==0){produit.setDisponible(false);}else{ produit.setDisponible(true);}
        produitsRepository.save(produit);
    }

    public void deleteProduit(Long id){
        produitsRepository.deleteById(id);
    }

    public void updateProduit(Produits produit,Long id){
        Produits produits = this.getProduitById(id);
        produits.setId(id);
        produits.setNom(produit.getNom());
        produits.setQuantite(produit.getQuantite());
        produits.setCategorie(produit.getCategorie());
        Date aujourdhui = new Date();
        Timestamp ts=new Timestamp(aujourdhui.getTime());
        produits.setDateModification(ts);
        if((produit.getQuantite())==0){produits.setDisponible(false);}else{ produits.setDisponible(true);}
        produitsRepository.save(produits);
    }
}
