package one.digitalinnovation.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repository.PersonRepository;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople= personRepository.findAll();
        return allPeople.stream()
                        .map(personMapper::toDTO)
                        .collect(Collectors.toList());
    }

/*     public List<Person> getPersonList() {
        List<Person> personList = personRepository.findAll();
        return personList;
    }

    public Person getPersonById(Long id){
        Person personById = personRepository.getById(id);
        return personById;
    }

    public MessageResponseDTO deletePersonById(Long id){
        try {
            personRepository.deleteById(id);
            return MessageResponseDTO
                    .builder()
                    .message("The person with id = " + id + " has been deleted!")
                    .build();
        } catch (EmptyResultDataAccessException e) {
            return MessageResponseDTO
                    .builder()
                    .message("The person with id = " + id + " does not exist!")
                    .build();
        }
    }

    public Person updatePerson(Person person) {
        Person personUpdated = personRepository.save(person);
        return personUpdated;
    } */
}
