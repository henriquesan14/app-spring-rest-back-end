package apirest.services;

import apirest.domain.Cliente;
import apirest.repositories.ClienteRepository;
import apirest.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clientes;

    public Cliente find(Integer id) {
        Optional<Cliente> obj = clientes.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+id+", Tipo: "+Cliente.class.getName()));
    }

    public List<Cliente> findAll(){
        return clientes.findAll();
    }
}
