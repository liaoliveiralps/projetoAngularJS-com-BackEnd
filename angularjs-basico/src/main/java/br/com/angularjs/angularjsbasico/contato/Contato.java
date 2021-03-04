package br.com.angularjs.angularjsbasico.contato;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.angularjs.angularjsbasico.operadora.Operadora;

@Entity
@Table(name = "contato")
public class Contato {
    
    @Id
    @SequenceGenerator(name = "seq_contato", sequenceName = "seq_contato", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contato")
    @Column(name = "id", nullable = true)
    private Long id;
    
    @Column(name = "nome", nullable = true)
    private String nome;
    
    @Column(name = "telefone", nullable = true)
    private String telefone;
    
    @Column(name = "data", nullable = true)
    private Date data;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operadora")
    private Operadora operadora;
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(final String telefone) {
        this.telefone = telefone;
    }
    
    public Date getData() {
        return this.data;
    }
    
    public void setData(final Date data) {
        this.data = data;
    }
    
    public Operadora getOperadora() {
        return this.operadora;
    }
    
    public void setOperadora(final Operadora operadora) {
        this.operadora = operadora;
    }
    
    public Contato() {}
    
    public Contato(final String nome, final String telefone, final Date data, final Operadora operadora) {
        this.nome = nome;
        this.telefone = telefone;
        this.data = data;
        this.operadora = operadora;
    }
    
}
