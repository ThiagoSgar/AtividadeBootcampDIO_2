package thiagoSgar.projeto2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import thiagoSgar.projeto2.Entity.Person;
import thiagoSgar.projeto2.dto.MessageResponseDTO;
import thiagoSgar.projeto2.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService= personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
}
