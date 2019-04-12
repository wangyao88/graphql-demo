package com.sxkl.project.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sxkl.project.graphqldemo.entity.Author;
import com.sxkl.project.graphqldemo.entity.Book;
import com.sxkl.project.graphqldemo.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private MyRepository repository;

    public List<Book> findAllBooks() {
        return repository.findAllBooks();
    }

    public List<Author> findAllAuthors() {
        return repository.findAllAuthors();
    }

    public Long countBook(Long authorId) throws Exception {
        if (authorId == null) return repository.countBook();
        Author author = repository.findOneAuthor(authorId);
        if (author == null) throw new Exception("未找到"+authorId);
        return repository.countAllByAuthor(author);
    }

}
