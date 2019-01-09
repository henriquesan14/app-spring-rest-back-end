package apirest.services;

import apirest.domain.Categoria;
import apirest.repositories.CategoriaRepository;
import apirest.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categorias;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = categorias.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+id+", Tipo: "+Categoria.class.getName()));
    }

    public List<Categoria> findAll(){
        return categorias.findAll();
    }

    public Categoria insert(Categoria obj){
        obj.setId(null);
        return categorias.save(obj);
    }

    public Categoria update(Categoria obj){
        return categorias.save(obj);
    }

}
