package apirest.services;

import apirest.domain.Pedido;
import apirest.repositories.PedidoRepository;
import apirest.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidos;

    public Pedido find(Integer id) {
        Optional<Pedido> obj = pedidos.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+id+", Tipo: "+Pedido.class.getName()));
    }

    public List<Pedido> buscar(){
        return pedidos.findAll();
    }
}
