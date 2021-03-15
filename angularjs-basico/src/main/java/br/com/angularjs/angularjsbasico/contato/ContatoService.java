package br.com.angularjs.angularjsbasico.contato;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.angularjs.angularjsbasico.operadora.Operadora;
import br.com.angularjs.angularjsbasico.operadora.OperadoraService;

@Service
public class ContatoService {
    
    @Autowired
    private ContatoRepository contatoRepository;
    
    @Autowired
    private OperadoraService operadoraService;
    
    public List<ContatoDto> listarTodosContatos() {
        return this.contatoRepository.listarTodosContatos();
    }
    
    public Optional<ContatoDto> contatoPorId(final Long id) {
        return this.contatoRepository.contatoPorId(id);
    }
    
    @Transactional
    public ContatoDto salvarContato(final ContatoDto contatoDto) {
        final Contato contato = contatoDto.dtoEmEntidade();
        final Operadora operadora = this.operadoraService.verificarOperadora(contatoDto.getOperadora());
        contato.setOperadora(operadora);
        try {
            this.contatoRepository.salvarContato(contato);
            return contatoDto;
        } catch (final NoResultException resultException) {
            throw new IllegalStateException("Erro ao cadastrar pessoa");
        }
    }
}
