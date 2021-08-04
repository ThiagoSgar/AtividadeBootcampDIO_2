package thiagoSgar.projeto2.dto.mapper;

import thiagoSgar.projeto2.dto.request.PersonDTO;
import thiagoSgar.projeto2.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper{

    @Mapping(source = "birthDate",target = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
