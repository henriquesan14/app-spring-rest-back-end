package apirest.services;

import apirest.DTO.ClienteDTO;
import apirest.domain.Cliente;
import apirest.repositories.ClienteRepository;
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

//    public Cliente insert(Cliente obj){
//        obj.setId(null);
//        return categorias.save(obj);
//    }

    public Cliente update(Cliente obj){
        Cliente newObj = find(obj.getId());
        updateData(newObj, obj);
        return clientes.save(newObj);
    }

    public void delete(Integer id){
        find(id);
        try{
            clientes.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possivel excluir porque há entidades relacionadas");
        }

    }

    public Page<Cliente> findPage(Integer page, Integer linesPorPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPorPage, Sort.Direction.valueOf(direction), orderBy);
        return clientes.findAll(pageRequest);
    }

    public Cliente fromDto(ClienteDTO objDto){
        return new Cliente(objDto.getId(),objDto.getNome(),objDto.getEmail(),null,null);
    }

    private void updateData(Cliente newObj, Cliente obj){
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

}
