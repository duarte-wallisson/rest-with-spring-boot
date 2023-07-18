package br.com.duarte.services;

import br.com.duarte.controllers.BookController;
import br.com.duarte.data.dto.v1.BookDTO;
import br.com.duarte.exceptions.RequiredObjectIsNullException;
import br.com.duarte.exceptions.ResourceNotFoundException;
import br.com.duarte.mapper.MyModelMapper;
import br.com.duarte.models.Book;
import br.com.duarte.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@Slf4j
public class BookService {

    @Autowired
    BookRepository repository;

    public List<BookDTO> findAll() {
        log.info("Looking for books.");
        var books = MyModelMapper.parseListObjects(repository.findAll(), BookDTO.class);
        books.forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getId())).withSelfRel()));
        return books;
    }

    public BookDTO findById(Long id) {
        log.info("Looking for a book.");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var bookDTO = MyModelMapper.parseObject(entity, BookDTO.class);
        bookDTO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return bookDTO;
    }

    public BookDTO insert(BookDTO book) {
        if (book == null) throw new RequiredObjectIsNullException();

        log.info("Inserting a book.");

        var entity = MyModelMapper.parseObject(book, Book.class);
        var bookDTO = MyModelMapper.parseObject(repository.save(entity), BookDTO.class);
        bookDTO.add(linkTo(methodOn(BookController.class).findById(bookDTO.getId())).withSelfRel());
        return bookDTO;
    }
    public BookDTO update(BookDTO book) {
        if (book == null) throw new RequiredObjectIsNullException();

        log.info("Updating a book.");

        var entity = repository.findById(book.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        var bookDTO = MyModelMapper.parseObject(repository.save(entity), BookDTO.class);
        bookDTO.add(linkTo(methodOn(BookController.class).findById(bookDTO.getId())).withSelfRel());
        return bookDTO;
    }

    public void delete(Long id) {
        log.info("Remove a book.");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

}
