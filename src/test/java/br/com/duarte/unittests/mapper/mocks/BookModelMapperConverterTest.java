package br.com.duarte.unittests.mapper.mocks;

import br.com.duarte.data.dto.v1.BookDTO;
import br.com.duarte.mapper.MyModelMapper;
import br.com.duarte.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookModelMapperConverterTest {
    MockBook inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockBook();
    }

    @Test
    public void parseEntityToDTOTest() {
        BookDTO output = MyModelMapper.parseObject(inputObject.mockEntity(), BookDTO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Author Test0", output.getAuthor());
        assertEquals("Launch Date Test0", output.getLaunchDate());
        assertEquals(Double.valueOf(0D), output.getPrice());
        assertEquals("Title Test0", output.getTitle());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<BookDTO> outputList = MyModelMapper.parseListObjects(inputObject.mockEntityList(), BookDTO.class);
        BookDTO outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Author Test0", outputZero.getAuthor());
        assertEquals("Launch Date Test0", outputZero.getLaunchDate());
        assertEquals(Double.valueOf(0D), outputZero.getPrice());
        assertEquals("Title Test0", outputZero.getTitle());

        BookDTO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Author Test7", outputSeven.getAuthor());
        assertEquals("Launch Date Test7", outputSeven.getLaunchDate());
        assertEquals(Double.valueOf(7D), outputSeven.getPrice());
        assertEquals("Title Test7", outputSeven.getTitle());

        BookDTO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Author Test12", outputTwelve.getAuthor());
        assertEquals("Launch Date Test12", outputTwelve.getLaunchDate());
        assertEquals(Double.valueOf(12D), outputTwelve.getPrice());
        assertEquals("Title Test12", outputTwelve.getTitle());
    }

    @Test
    public void parseDTOToEntityTest() {
        Book output = MyModelMapper.parseObject(inputObject.mockDTO(), Book.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Author Test0", output.getAuthor());
        assertEquals("Launch Date Test0", output.getLaunchDate());
        assertEquals(Double.valueOf(0D), output.getPrice());
        assertEquals("Title Test0", output.getTitle());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<Book> outputList = MyModelMapper.parseListObjects(inputObject.mockDTOList(), Book.class);
        Book outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Author Test0", outputZero.getAuthor());
        assertEquals("Launch Date Test0", outputZero.getLaunchDate());
        assertEquals(Double.valueOf(0D), outputZero.getPrice());
        assertEquals("Title Test0", outputZero.getTitle());

        Book outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Author Test7", outputSeven.getAuthor());
        assertEquals("Launch Date Test7", outputSeven.getLaunchDate());
        assertEquals(Double.valueOf(7D), outputSeven.getPrice());
        assertEquals("Title Test7", outputSeven.getTitle());

        Book outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Author Test12", outputTwelve.getAuthor());
        assertEquals("Launch Date Test12", outputTwelve.getLaunchDate());
        assertEquals(Double.valueOf(12D), outputTwelve.getPrice());
        assertEquals("Title Test12", outputTwelve.getTitle());
    }
}
