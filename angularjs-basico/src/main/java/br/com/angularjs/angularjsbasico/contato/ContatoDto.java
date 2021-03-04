package br.com.angularjs.angularjsbasico.contato;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.angularjs.angularjsbasico.operadora.Operadora;
import br.com.angularjs.angularjsbasico.operadora.OperadoraDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ContatoDto {
    
    private String nome;
    
    private String telefone;
    
    private Date data;
    
    private OperadoraDto operadora;
    
    public String getNome() {
        return this.nome;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
    
    public Date getData() {
        return this.data;
    }
    
    public OperadoraDto getOperadora() {
        return this.operadora;
    }
    
    public ContatoDto(final String nome, final String telefone, final Date data, final Operadora operadora) {
        this.nome = nome;
        this.telefone = telefone;
        this.data = data;
        this.operadora = operadora.entidadeEmDto();
    }
    
    public ContatoDto(final Contato contato) {
        this.nome = contato.getNome();
        this.telefone = contato.getTelefone();
        this.data = contato.getData();
    }
    
    public ContatoDto() {}
    
    public Contato dtoEmEntidade() {
        return new Contato(this.nome, this.telefone, this.data, this.operadora.dtoEmEntidade());
    }
}
