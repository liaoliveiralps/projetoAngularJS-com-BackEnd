package br.com.angularjs.angularjsbasico.operadora;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OperadoraService {
    
    @Autowired
    private OperadoraRepository operadoraRepository;
    
    public List<OperadoraDto> listarTodasOperadoras() {
        return this.operadoraRepository.listarTodasOperadoras();
    }
    
    public Operadora verificarOperadora(final OperadoraDto operadoraDto) {
        final Operadora operadora = operadoraDto.dtoEmEntidade();
        final Optional<Operadora> operadoraOptional = this.operadoraRepository.procurarPorNome(operadora.getNome());
        if (operadoraOptional.isPresent()) {
            return operadoraOptional.get();
        } else {
            throw new IllegalStateException("Operadora não existe");
        }
    }
}
