package contatos.ryan.contatosdoryan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import contatos.ryan.contatosdoryan.entities.contatos;
import contatos.ryan.contatosdoryan.services.contatosservice;

@CrossOrigin
@RestController
@RequestMapping("contatos")
public class contatoscontroller {
    @Autowired
    private contatosservice service;
    @GetMapping
    public ResponseEntity<List<contatos>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    
    @PostMapping
    public ResponseEntity<contatos> save(@RequestBody contatos contatos){
        return ResponseEntity.ok(service.save(contatos));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void>delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updata(@PathVariable long id,
    @RequestBody contatos contatos){
        service.update(contatos, id);
        return ResponseEntity.noContent().build();
    }
}
