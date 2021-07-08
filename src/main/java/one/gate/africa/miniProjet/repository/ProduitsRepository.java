package one.gate.africa.miniProjet.repository;

import one.gate.africa.miniProjet.modules.Produits;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProduitsRepository extends JpaRepository<Produits,Long> {
    public List<Produits> findByCategorieId(Long id);
}
