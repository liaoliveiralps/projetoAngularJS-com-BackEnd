package br.com.angularjs.angularjsbasico.contato;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("/contato")
public class ContatoAPI {
    
    @Autowired
    private ContatoService contatoService;
    
    @GetMapping
    public List<ContatoDto> listarTodosContatos() {
        return this.contatoService.listarTodosContatos();
    }
    
    @GetMapping(path = "/{id}")
    public ContatoDto contatoPorId(@PathVariable("id") final Long id) {
        final Optional<ContatoDto> optional = this.contatoService.contatoPorId(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado");
        }
    }
    
    @PostMapping
    public ContatoDto salvarContato(@RequestBody final ContatoDto contatoDto) {
        return this.contatoService.salvarContato(contatoDto);
    }
    
    @DeleteMapping(path = "/{id}")
    public void excluirContato(@PathVariable("id") final Long id) {
        this.contatoService.excluirContato(id);
    }
}
