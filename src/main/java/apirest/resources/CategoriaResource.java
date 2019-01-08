package apirest.resources;

import apirest.domain.Categoria;
import apirest.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar(){
        return categoriaService.buscar();
    }

    @GetMapping("{id}")
    public Optional<Categoria> listarPorId(@PathVariable Integer id){
        return categoriaService.buscarPorId(id);
    }
}
