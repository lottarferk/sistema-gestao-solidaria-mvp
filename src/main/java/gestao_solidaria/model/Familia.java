package gestao_solidaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "familia")
public class Familia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nomeResponsavel;

    @Column(nullable = false)
    private String nomeNormalizado;

    @Column(unique = true)
    private String documento;

    private String telefone;
    private String bairro;

    @Min(1)
    @Column(nullable = false)
    private int qtdPessoas;

    @Column(nullable = false)
    private LocalDate dataCadastro = LocalDate.now();

    @Column(nullable = false)
    private String status = "ATIVO";

    public Long getId() { return id; }
    public String getNomeResponsavel() { return nomeResponsavel; }
    public void setNomeResponsavel(String v) { this.nomeResponsavel = v; }
    public String getNomeNormalizado() { return nomeNormalizado; }
    public void setNomeNormalizado(String v) { this.nomeNormalizado = v; }
    public String getDocumento() { return documento; }
    public void setDocumento(String v) { this.documento = v; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String v) { this.telefone = v; }
    public String getBairro() { return bairro; }
    public void setBairro(String v) { this.bairro = v; }
    public int getQtdPessoas() { return qtdPessoas; }
    public void setQtdPessoas(int v) { this.qtdPessoas = v; }
    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate v) { this.dataCadastro = v; }
    public String getStatus() { return status; }
    public void setStatus(String v) { this.status = v; }
}