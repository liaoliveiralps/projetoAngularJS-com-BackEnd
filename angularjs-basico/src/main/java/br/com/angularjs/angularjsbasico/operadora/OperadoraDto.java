package br.com.angularjs.angularjsbasico.operadora;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class OperadoraDto {
    
    private String nome;
    
    private Long codigo;
    
    private String categoria;
    
    public String getNome() {
        return this.nome;
    }
    
    public Long getCodigo() {
        return this.codigo;
    }
    
    public String getCategoria() {
        return this.categoria;
    }
    
    public OperadoraDto(final String nome, final Long codigo, final String categoria) {
        this.nome = nome;
        this.codigo = codigo;
        this.categoria = categoria;
    }
    
    public OperadoraDto() {}
    
    public Operadora dtoEmEntidade() {
        return new Operadora(this.nome, this.codigo, this.categoria);
    }
}
