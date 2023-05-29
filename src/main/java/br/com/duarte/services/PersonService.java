package br.com.duarte.services;

import br.com.duarte.data.vo.v1.PersonDTO;
import br.com.duarte.data.vo.v2.PersonDTOV2;
import br.com.duarte.exceptions.ResourceNotFoundException;

import br.com.duarte.mapper.MyModelMapper;
import br.com.duarte.mapper.custom.PersonMapper;
import br.com.duarte.models.Person;
import br.com.duarte.repositories.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonService {

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper mapper;

    public List<PersonDTO> findAll() {
        log.info("Looking for people.");
        return MyModelMapper.parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        log.info("Looking for a person.");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return MyModelMapper.parseObject(entity, PersonDTO.class);
    }

    public PersonDTO insert(PersonDTO person) {
        log.info("Inserting a person.");

        var entity = MyModelMapper.parseObject(person, Person.class);
        return MyModelMapper.parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 insertV2(PersonDTOV2 person) {
        log.info("Inserting a person.");

        var entity = mapper.convertDtoToEntity(person);
        return mapper.convertEntityToDto(repository.save(entity));
    }

    public PersonDTO update(PersonDTO person) {
        log.info("Updating a person.");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return MyModelMapper.parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        log.info("Remove a person.");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

}
