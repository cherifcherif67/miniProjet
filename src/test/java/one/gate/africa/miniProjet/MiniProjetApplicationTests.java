package one.gate.africa.miniProjet;

import one.gate.africa.miniProjet.categorie.Categorie;
import one.gate.africa.miniProjet.categorie.CategorieService;
import one.gate.africa.miniProjet.produits.Produits;
import one.gate.africa.miniProjet.produits.ProduitsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MiniProjetApplicationTests {
	@Autowired
	CategorieService categorieService;
	@Autowired
	ProduitsService produitsService;

	@Test
	void contextLoads() {
	}

	//test de l'Entity categorie

	@Test
	public void addCategorieTest(){
		Categorie categorie = new Categorie("aerospace",30);
		categorieService.addCategorie(categorie);
	}

	@Test
	public void getCategorieByIdTest(){
		categorieService.findById(12L);
	}

	@Test
	public void getAllCategorieTest(){
		categorieService.findAllCategorie();
	}

	@Test
	public void updateCategoorieTest(){
		Categorie categorie = new Categorie("cat2",40);
		categorieService.updateCategorie(categorie,12L);
	}

	@Test
	public void deleteCategorieTest(){
		categorieService.deleteCategorie(11L);
	}




	//test de l'Entity Produits

	@Test
	public void addProduitTest(){
		Produits produit = new Produits("p1",20);
		produitsService.addProduit(produit,12L);
	}

	@Test
	public void getProduitByIdTest(){
		produitsService.getProduitById(11L);
	}

	@Test
	public void getAllProduitsTest(){
		produitsService.getProduits();
	}

	@Test
	public void updateProduits(){
		Produits produit = new Produits("p2",300);
		produitsService.updateProduit(produit,2L);
	}

	@Test
	public void deleteProduits(){
		produitsService.deleteProduit(11L);
	}

}
