package contatos.ryan.contatosdoryan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contatos.ryan.contatosdoryan.entities.contatos;
import contatos.ryan.contatosdoryan.repositories.contatosrepositories;
import jakarta.persistence.EntityNotFoundException;
@Service
public class contatosservice {
    @Autowired
    private contatosrepositories repository;

    public List<contatos> getAll(){
        return repository.findAll();
    }
    
    public contatos save(contatos contatos){
        return repository.save(contatos);
    }
    public void update(contatos contatos, Long id){
        contatos aux = repository.getReferenceById(id);

        aux.setNome(contatos.getNome());
        aux.setSobrenome(contatos.getSobrenome());
        aux.setEmail(contatos.getEmail());
        aux.setTelefone(contatos.getTelefone());
        aux.setCelular(contatos.getCelular());
        aux.setEndereco(contatos.getEndereco());
        aux.setCidade(contatos.getCidade());
        aux.setEstado(contatos.getEstado());
        aux.setCategoria(contatos.getCategoria());

        repository.save(aux);
    }

    public void delete(long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Não encontrado");
        }
    }
}
