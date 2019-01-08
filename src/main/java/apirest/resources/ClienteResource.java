package apirest.resources;

import apirest.domain.Cliente;
import apirest.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar(){
        return clienteService.buscar();
    }

    @GetMapping("{id}")
    public Cliente listarPorId(@PathVariable Integer id){
        return clienteService.find(id);
    }
}
