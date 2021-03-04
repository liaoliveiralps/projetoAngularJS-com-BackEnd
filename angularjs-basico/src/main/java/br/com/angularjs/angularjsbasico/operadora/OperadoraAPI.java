package br.com.angularjs.angularjsbasico.operadora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operadora")
public class OperadoraAPI {
    
    @Autowired
    private OperadoraService operadoraService;
    
    @CrossOrigin
    @GetMapping
    public List<OperadoraDto> listarTodasOperadoras() {
        return this.operadoraService.listarTodasOperadoras();
    }
}
