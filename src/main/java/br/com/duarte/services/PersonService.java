package br.com.duarte.services;

import br.com.duarte.data.vo.v1.PersonVO;
import br.com.duarte.exceptions.ResourceNotFoundException;

import br.com.duarte.mapper.MyModelMapper;
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

    public List<PersonVO> findAll() {
        log.info("Looking for people.");
        return MyModelMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }
    public PersonVO findById(Long id) {
        log.info("Looking for a person.");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return MyModelMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO insert(PersonVO person) {
        log.info("Inserting a person.");

        var entity = MyModelMapper.parseObject(person, Person.class);
        return MyModelMapper.parseObject(repository.save(entity), PersonVO.class);
    }

    public PersonVO update(PersonVO person) {
        log.info("Updating a person.");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return MyModelMapper.parseObject(repository.save(entity), PersonVO.class);
    }

    public void delete(Long id) {
        log.info("Remove a person.");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

}
