package contatos.ryan.contatosdoryan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contatos.ryan.contatosdoryan.entities.contatos;


@Repository
public interface contatosrepositories extends JpaRepository<contatos, Long> {

    
}  