package com.sxkl.project.graphqldemo.repository;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sxkl.project.graphqldemo.entity.Author;
import com.sxkl.project.graphqldemo.entity.Book;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class MyRepository {

    private static List<Book> books = Lists.newArrayList();
    private static List<Author> authors = Lists.newArrayList();

    @PostConstruct
    private void initData(){
        Author author1 = new Author(1L, "wy");
        Author author2 = new Author(2L, "qy");

        Book book1 = new Book(1L, "java", "SDF001");
        Book book2 = new Book(2L, "python", "SDF002");
        Book book3 = new Book(3L, "go", "SDF003");

        author1.addBook(book1);
        author2.addBook(book2);
        author2.addBook(book3);

        book1.setAuthor(author1);
        book2.setAuthor(author2);
        book3.setAuthor(author2);

        authors.add(author1);
        authors.add(author2);

        books.add(book1);
        books.add(book2);
        books.add(book3);

        authors.forEach(author -> {

        });
    }

    public List<Book> findAllBooks() {
        return books;
    }

    public List<Author> findAllAuthors() {
        return authors;

    }

    public Long countBook() {
        return new Long(books.size());
    }

    public Author findOneAuthor(Long authorId) {
        Optional<Author> authorOptional = authors.stream().filter(author -> author.getId().equals(authorId)).findFirst();
        return authorOptional.isPresent() ? authorOptional.get() : null;
    }

    public Long countAllByAuthor(Author author) {
        return new Long(author.getBooks().size());
    }

    public void saveAuthor(Author author) {
        authors.add(author);
    }

    public void saveBook(Book book) {
        books.add(book);
    }
}
