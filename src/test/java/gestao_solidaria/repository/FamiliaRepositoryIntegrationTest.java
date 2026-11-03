package gestao_solidaria.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import gestao_solidaria.model.Familia;
import gestao_solidaria.service.FamiliaService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class FamiliaRepositoryIntegrationTest {

    @Autowired
    FamiliaRepository repo;

    @Autowired
    FamiliaService service;

    @Test
    void salvaEBuscaFamiliaPorNomeNormalizado() {
        Familia f = new Familia();
        f.setNomeResponsavel("Ana Exemplo");
        f.setTelefone("(00) 90000-0000");
        f.setQtdPessoas(4);
        service.salvar(f);

        List<Familia> achadas = service.buscar("ANA");

        assertEquals(1, repo.count());
        assertEquals(1, achadas.size());
        assertEquals("ana exemplo", achadas.get(0).getNomeNormalizado());
    }

    @Test
    void detectaDuplicidadeNoBancoPorNomeETelefone() {
        Familia primeira = new Familia();
        primeira.setNomeResponsavel("Ana Exemplo");
        primeira.setTelefone("(00) 90000-0000");
        primeira.setQtdPessoas(4);
        service.salvar(primeira);

        Familia nova = new Familia();
        nova.setNomeResponsavel("ANA exemplo");
        nova.setTelefone("(00) 90000-0000");
        nova.setQtdPessoas(4);

        assertFalse(service.parecidas(nova).isEmpty());
        assertTrue(service.cadastrar(nova, false).temAlerta());
    }
}