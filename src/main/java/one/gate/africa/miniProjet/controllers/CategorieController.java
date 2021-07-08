package one.gate.africa.miniProjet.controllers;

import one.gate.africa.miniProjet.modules.Categorie;
import one.gate.africa.miniProjet.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CategorieController {


    private final CategorieService categorieService;
    @Autowired
    public  CategorieController(CategorieService categorieService){
        this.categorieService=categorieService;
    }

    @GetMapping("/categorie")
    public List<Categorie> categorieList(){
        return categorieService.findAllCategorie();
    }

    @RequestMapping("/categorie/{id}")
    public Categorie getCategorieById(@PathVariable long id){
        return categorieService.findById(id);
    }

    @DeleteMapping("/categorie/{id}")
    public void deleteCategorie(@PathVariable long id){
        categorieService.deleteCategorie(id);
    }

    @PutMapping( "/categorie/{id}")
    public void updateCategorie(@RequestBody Categorie categorie,@PathVariable long id){
        categorieService.updateCategorie(categorie,id);
    }

    @PostMapping("/categorie")
    public void addCategorie(@RequestBody Categorie categorie){
        categorieService.addCategorie(categorie);
    }
}
