package gestao_solidaria.service;

import gestao_solidaria.model.Familia;
import gestao_solidaria.repository.FamiliaRepository;
import java.text.Normalizer;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FamiliaService {

    private final FamiliaRepository repo;

    public FamiliaService(FamiliaRepository repo) {
        this.repo = repo;
    }

    public static String normalizar(String texto) {
        if (texto == null) return "";
        String semAcento = Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        return semAcento.trim().toLowerCase();
    }

    public List<Familia> buscar(String termo) {
        String t = normalizar(termo);
        return repo.findByNomeNormalizadoContainingOrDocumento(t, termo == null ? "" : termo.trim());
    }

    public List<Familia> parecidas(Familia f) {
        return repo.findByNomeNormalizadoAndTelefone(normalizar(f.getNomeResponsavel()), f.getTelefone());
    }

    public Familia salvar(Familia f) {
        f.setNomeNormalizado(normalizar(f.getNomeResponsavel()));
        return repo.save(f);
    }
}