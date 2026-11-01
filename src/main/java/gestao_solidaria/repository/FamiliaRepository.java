package gestao_solidaria.repository;

import gestao_solidaria.model.Familia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaRepository extends JpaRepository<Familia, Long> {
    List<Familia> findByNomeNormalizadoContainingOrDocumento(String nome, String documento);
    List<Familia> findByNomeNormalizadoAndTelefone(String nomeNormalizado, String telefone);
}