package thiagoSgar.projeto2.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import thiagoSgar.projeto2.dto.mapper.PersonMapper;
import thiagoSgar.projeto2.entities.Person;
import thiagoSgar.projeto2.dto.request.PersonDTO;
import thiagoSgar.projeto2.dto.response.MessageResponseDTO;
import thiagoSgar.projeto2.repository.PersonRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static thiagoSgar.projeto2.utils.PersonUtils.*;

@ExtendWith(MockitoExtension.class) //para rodar com o mockito
public class PersonServiceTest {

    @Mock // criar objeto mock (fake)
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks // injetar o mock feito, dentro do @Autowired em PersonService
    private PersonService personService;

    public PersonServiceTest(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    @Test
    void testeGivenPersonDTOThenReturnSavedMessage(){
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        //Quando for chamar o metodo save na classe de serviço, passando o objeto de entidade, retorne o objeto

        MessageResponseDTO expectedMessage = MessageResponseDTO
                .builder().message("Created person with ID"+ expectedSavedPerson.getId())
                .build();

        MessageResponseDTO successMessage = personService.createPerson(personDTO);
        assertEquals(expectedMessage, successMessage);


    }

}
