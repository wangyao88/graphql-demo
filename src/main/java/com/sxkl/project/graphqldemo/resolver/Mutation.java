package com.sxkl.project.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sxkl.project.graphqldemo.entity.Author;
import com.sxkl.project.graphqldemo.entity.Book;
import com.sxkl.project.graphqldemo.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private MyRepository repository;

    public Author newAuthor(Long id, String nickname) {
        Author author = new Author();
        author.setId(id);
        author.setNickname(nickname);
        repository.saveAuthor(author);
        return author;
    }

    public Book newBook(Long id, String title, String isbn, Long authorId) throws Exception {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setIsbn(isbn);
        Author author = repository.findOneAuthor(authorId);
        if (author == null) throw new Exception("未找到作者"+authorId);
        book.setAuthor(author);
       repository.saveBook(book);
        return book;
    }
}
