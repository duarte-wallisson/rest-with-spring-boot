package br.com.duarte.mapper.custom;

import br.com.duarte.data.vo.v2.PersonDTOV2;
import br.com.duarte.models.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {
    public PersonDTOV2 convertEntityToDto(Person person) {
        PersonDTOV2 personDTOV2 = new PersonDTOV2();
        personDTOV2.setId(person.getId());
        personDTOV2.setFirstName(person.getFirstName());
        personDTOV2.setLastName(person.getLastName());
        personDTOV2.setAddress(person.getAddress());
        personDTOV2.setBirthday(String.valueOf(new Date()));
        return personDTOV2;
    }

    public Person convertDtoToEntity(PersonDTOV2 personDTOV2) {
        Person entity = new Person();
        entity.setId(personDTOV2.getId());
        entity.setFirstName(personDTOV2.getFirstName());
        entity.setLastName(personDTOV2.getLastName());
        entity.setAddress(personDTOV2.getAddress());
//        entity.setBirthday(String.valueOf(new Date()));
        return entity;
    }

}
