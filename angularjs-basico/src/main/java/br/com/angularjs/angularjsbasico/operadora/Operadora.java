package br.com.angularjs.angularjsbasico.operadora;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.angularjs.angularjsbasico.contato.Contato;

@Entity
@Table(name = "operadora")
public class Operadora {
    
    @Column(name = "nome", nullable = true)
    private String nome;
    
    @Id
    @Column(name = "codigo", unique = true, nullable = false, updatable = false)
    private Long codigo;
    
    @Column(name = "categoria", nullable = true)
    private String categoria;
    
    @OneToMany(mappedBy = "operadora", fetch = FetchType.LAZY)
    private List<Contato> contato;
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    
    public Long getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Long codigo) {
        this.codigo = codigo;
    }
    
    public String getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(final String categoria) {
        this.categoria = categoria;
    }
    
    public List<Contato> getContato() {
        return this.contato;
    }
    
    public void setContato(final List<Contato> contato) {
        this.contato = contato;
    }
    
    public Operadora() {}
    
    public Operadora(final String nome, final Long codigo, final String categoria) {
        this.nome = nome;
        this.codigo = codigo;
        this.categoria = categoria;
    }
    
    public OperadoraDto entidadeEmDto() {
        return new OperadoraDto(this.nome, this.codigo, this.categoria);
    }
}
