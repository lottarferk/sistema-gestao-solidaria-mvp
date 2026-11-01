package gestao_solidaria.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import gestao_solidaria.model.Familia;
import gestao_solidaria.repository.FamiliaRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FamiliaServiceTest {

    @Mock
    FamiliaRepository repo;

    @InjectMocks
    FamiliaService service;

    @Test
    void normalizaNomeSemAcentoEmMinusculas() {
        assertEquals("joao da silva", FamiliaService.normalizar("  João da Silva "));
    }

    @Test
    void detectaPossivelDuplicidadePorNomeETelefone() {
        Familia nova = new Familia();
        nova.setNomeResponsavel("Ana Exemplo");
        nova.setTelefone("(00) 90000-0000");
        when(repo.findByNomeNormalizadoAndTelefone("ana exemplo", "(00) 90000-0000"))
            .thenReturn(List.of(new Familia()));
        assertFalse(service.parecidas(nova).isEmpty());
    }

    @Test
    void salvaComNomeNormalizado() {
        Familia f = new Familia();
        f.setNomeResponsavel("Ana Exemplo");
        when(repo.save(any(Familia.class))).thenAnswer(i -> i.getArgument(0));
        assertEquals("ana exemplo", service.salvar(f).getNomeNormalizado());
    }
}