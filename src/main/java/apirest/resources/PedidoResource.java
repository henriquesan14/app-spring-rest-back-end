package apirest.resources;

import apirest.domain.Pedido;
import apirest.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listar(){
        return pedidoService.buscar();
    }

    @GetMapping("{id}")
    public Pedido listarPorId(@PathVariable Integer id){
        return pedidoService.find(id);
    }
}
