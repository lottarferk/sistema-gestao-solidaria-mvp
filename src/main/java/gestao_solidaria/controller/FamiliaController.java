package gestao_solidaria.controller;

import gestao_solidaria.model.Familia;
import gestao_solidaria.service.FamiliaService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/familias")
public class FamiliaController {

    private final FamiliaService service;

    public FamiliaController(FamiliaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Familia> buscar(@RequestParam(defaultValue = "") String q) {
        return service.buscar(q);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody Familia familia,
                                       @RequestParam(defaultValue = "false") boolean confirmar) {
        List<Familia> parecidas = service.parecidas(familia);
        if (!parecidas.isEmpty() && !confirmar) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                "alerta", "Já existe um cadastro com nome e telefone parecidos.",
                "existentes", parecidas));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(familia));
    }
}