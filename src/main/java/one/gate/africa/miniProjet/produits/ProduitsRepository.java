package one.gate.africa.miniProjet.produits;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProduitsRepository extends JpaRepository<Produits,Long> {
    public List<Produits> findByCategorieId(Long id);
}
