package zdn.springframework.spring6webapp.services;

import zdn.springframework.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
