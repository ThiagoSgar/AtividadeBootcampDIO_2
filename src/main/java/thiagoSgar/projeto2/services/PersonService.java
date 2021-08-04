package thiagoSgar.projeto2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thiagoSgar.projeto2.dto.mapper.PersonMapper;
import thiagoSgar.projeto2.entities.Person;
import thiagoSgar.projeto2.dto.response.MessageResponseDTO;
import thiagoSgar.projeto2.dto.request.PersonDTO;
import thiagoSgar.projeto2.exceptions.PersonNotFoundException;
import thiagoSgar.projeto2.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;


    @Autowired
    public PersonService(PersonRepository personRepository, PersonMapper personMapper){
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);  //convertemos o dto
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException{
//        Optional<Person> optionalPerson =  personRepository.findById(id);
        Person person = personRepository.findById(id)
                .orElseThrow(()-> new PersonNotFoundException(id));
//        if(optionalPerson.isEmpty()){
//            throw new PersonNotFoundException(id);
//        }
        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException{
        Person person = personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException(id));
        personRepository.deleteById(id);
    }

    public MessageResponseDTO uptade(Long id, PersonDTO personDTO) throws PersonNotFoundException{
        //verifyIfExistis
        personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException(id));

        Person personToUpdate = personMapper.toModel(personDTO);  //convertemos o dto
        Person savedPerson = personRepository.save(personToUpdate);
        return MessageResponseDTO
                .builder()
                .message("Updated person with ID " + savedPerson.getId())
                .build();
    }
}
