package thiagoSgar.projeto2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import thiagoSgar.projeto2.Entity.Person;
import thiagoSgar.projeto2.dto.MessageResponseDTO;
import thiagoSgar.projeto2.repository.PersonRepository;
@Service
public class PersonService {

    private PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO.builder()
                .message("Created person with ID" + savedPerson.getId())
                .build();
    }
}
