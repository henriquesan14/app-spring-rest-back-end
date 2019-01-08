package apirest.services;

import apirest.domain.Categoria;
import apirest.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categorias;

    public Optional<Categoria> buscarPorId(Integer id){
        return categorias.findById(id);
    }

    public List<Categoria> buscar(){
        return categorias.findAll();
    }
}
