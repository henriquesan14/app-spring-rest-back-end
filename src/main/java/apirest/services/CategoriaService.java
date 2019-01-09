package apirest.services;

import apirest.DTO.CategoriaDTO;
import apirest.domain.Categoria;
import apirest.repositories.CategoriaRepository;
import apirest.services.exceptions.DataIntegrityException;
import apirest.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        find(obj.getId());
        return categorias.save(obj);
    }

    public void delete(Integer id){
        find(id);
        try{
            categorias.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
        }

    }

    public Page<Categoria> findPage(Integer page,Integer linesPorPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPorPage, Sort.Direction.valueOf(direction), orderBy);
        return categorias.findAll(pageRequest);
    }

    public Categoria fromDto(CategoriaDTO objDto){
        return new Categoria(objDto.getId(),objDto.getNome());
    }
}
