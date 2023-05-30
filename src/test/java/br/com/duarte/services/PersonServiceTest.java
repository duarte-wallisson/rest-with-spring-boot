package br.com.duarte.services;

import br.com.duarte.exceptions.RequiredObjectIsNullException;
import br.com.duarte.models.Person;
import br.com.duarte.repositories.PersonRepository;
import br.com.duarte.unittests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static  org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
    MockPerson input;

    @InjectMocks
    private PersonService service;

    @Mock
    PersonRepository repository;

    @BeforeEach
    void setUpMocks() {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void findAll() {
        List<Person> entities = input.mockEntityList();
        when(repository.findAll()).thenReturn(entities);

        var people = service.findAll();
        assertNotNull(people);
        assertEquals(14, people.size());

        var person1 = people.get(1);
        assertNotNull(person1);
        assertNotNull(person1.getId());
        assertNotNull(person1.getFirstName());
        assertNotNull(person1.getLastName());
        assertNotNull(person1.getAddress());
        assertNotNull(person1.getLinks());
        assertEquals("</api/person/v1/1>;rel=\"self\"", person1.getLinks().toString());

        var person4 = people.get(4);
        assertNotNull(person4);
        assertNotNull(person4.getId());
        assertNotNull(person4.getFirstName());
        assertNotNull(person4.getLastName());
        assertNotNull(person4.getAddress());
        assertNotNull(person4.getLinks());
        assertEquals("</api/person/v1/4>;rel=\"self\"", person4.getLinks().toString());
    }

    @Test
    void findById() {
        var id  = 1L;
        Person entity = input.mockEntity(1);
        entity.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(entity));

        var result = service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getFirstName());
        assertNotNull(result.getLastName());
        assertNotNull(result.getAddress());
        assertNotNull(result.getLinks());
        assertEquals("</api/person/v1/1>;rel=\"self\"", result.getLinks().toString());
    }

    @Test
    void insert() {
        var id  = 1L;
        var entity = input.mockEntity(1);
        entity.setId(id);

        var dto = input.mockDTO(1);
        dto.setId(id);

        when(repository.save(entity)).thenReturn(entity);

        var result = service.insert(dto);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getFirstName());
        assertNotNull(result.getLastName());
        assertNotNull(result.getGender());
        assertNotNull(result.getAddress());
        assertNotNull(result.getLinks());
        assertEquals("</api/person/v1/1>;rel=\"self\"", result.getLinks().toString());
    }

    @Test
    void insertWithNullPerson(){
        Exception exception = assertThrows(RequiredObjectIsNullException.class, ()->service.insert(null));
        String expectedMessage = "It is not allowed to persist a null object";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void update() {
        var id  = 1L;
        var entity = input.mockEntity(1);
        entity.setId(id);

        var dto = input.mockDTO(1);
        dto.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(entity);

        var result = service.update(dto);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getFirstName());
        assertNotNull(result.getLastName());
        assertNotNull(result.getGender());
        assertNotNull(result.getAddress());
        assertNotNull(result.getLinks());
        assertEquals("</api/person/v1/1>;rel=\"self\"", result.getLinks().toString());
    }

    @Test
    void updateWithNullPerson(){
        Exception exception = assertThrows(RequiredObjectIsNullException.class, ()->service.update(null));
        String expectedMessage = "It is not allowed to persist a null object";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void delete() {
        var id  = 1L;
        Person entity = input.mockEntity(1);
        entity.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(entity));

        service.delete(1L);
    }
}