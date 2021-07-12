package one.gate.africa.miniProjet.controllers;

import one.gate.africa.miniProjet.modules.Produits;
import one.gate.africa.miniProjet.services.ProduitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProduitsController {

    private final ProduitsService produitsService;
    @Autowired
    public ProduitsController(ProduitsService produitsService){
        this.produitsService=produitsService;
    }

    @GetMapping("/produits")
    public List<Produits> produitsList (){
        return produitsService.getProduits();
    }

    @GetMapping("/{id}/produits")
    public List<Produits> produitsListByCategories (@PathVariable Long id){
        return produitsService.getProduitsByIdCategorie(id);
    }

    @GetMapping("/produits/{idProduits}")
    public Produits getProduits(@PathVariable("idProduits") Long id){
        return produitsService.getProduitById(id);
    }

    @PostMapping("/categorie/{idCategorie}/produits")
    public void addProduits(@RequestBody Produits produit,@PathVariable Long idCategorie){
        produitsService.addProduit(produit,idCategorie);
    }

    @PutMapping( "/produits/{id}")
    public void updateProduits(@RequestBody Produits produit,@PathVariable long id){
        produitsService.updateProduit(produit,id);
    }

    @DeleteMapping( "/produits/{idProduit}" )
    public void deleteProduit(@PathVariable ("idProduit") long idProduit){
        produitsService.deleteProduit(idProduit);
    }

}
