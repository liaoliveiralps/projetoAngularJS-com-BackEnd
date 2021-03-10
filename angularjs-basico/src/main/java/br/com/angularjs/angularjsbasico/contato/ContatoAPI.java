package br.com.angularjs.angularjsbasico.contato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    @PostMapping
    public ContatoDto salvarContato(@RequestBody final ContatoDto contatoDto) {
        return this.contatoService.salvarContato(contatoDto);
    }
}
