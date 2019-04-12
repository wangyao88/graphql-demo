package com.sxkl.project.graphqldemo.entity;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Author {

    private Long id;
    private String nickname;
    private List<Book> books = Lists.newArrayList();

    public Author(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public void addBook(Book book){
        this.books.add(book);
    }
}
