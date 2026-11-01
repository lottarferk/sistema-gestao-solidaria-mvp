package gestao_solidaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "item_estoque")
public class ItemEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String nome;

    @NotBlank
    @Column(nullable = false)
    private String unidade;

    @Min(0)
    @Column(nullable = false)
    private int saldoAtual;

    private Integer estoqueMinimo;

    @Column(nullable = false)
    private String status = "ATIVO";

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String v) { this.nome = v; }
    public String getUnidade() { return unidade; }
    public void setUnidade(String v) { this.unidade = v; }
    public int getSaldoAtual() { return saldoAtual; }
    public void setSaldoAtual(int v) { this.saldoAtual = v; }
    public Integer getEstoqueMinimo() { return estoqueMinimo; }
    public void setEstoqueMinimo(Integer v) { this.estoqueMinimo = v; }
    public String getStatus() { return status; }
    public void setStatus(String v) { this.status = v; }
}