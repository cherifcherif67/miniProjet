package one.gate.africa.miniProjet.services;

import one.gate.africa.miniProjet.modules.Categorie;
import one.gate.africa.miniProjet.repository.ProduitsRepository;
import one.gate.africa.miniProjet.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CategorieService {

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    ProduitsRepository produitsRepository;

    public Categorie findById(Long id){
        return  categorieRepository.findById(id).get();
    }

    public List<Categorie> findAllCategorie(){
        List<Categorie> categorieList = new ArrayList<>();
        categorieRepository.findAll().forEach(categorieList::add);
        return categorieList;
    }

    public void addCategorie(Categorie categorie){

        categorieRepository.save(categorie);
    }

    public void deleteCategorie(Long id){
        categorieRepository.deleteById(id);
    }

    public void updateCategorie(Categorie categorie,Long id){
        Categorie c = this.findById(id);
        categorie.setId(id);
        categorie.setDateCreation(c.getDateCreation());
        Date aujourdhui = new Date();
        Timestamp ts=new Timestamp(aujourdhui.getTime());
        categorie.setDateModification(ts);
        categorieRepository.save(categorie);
    }
}
