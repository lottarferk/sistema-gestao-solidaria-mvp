package gestao_solidaria.repository;

import gestao_solidaria.model.ItemEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemEstoqueRepository extends JpaRepository<ItemEstoque, Long> {
}