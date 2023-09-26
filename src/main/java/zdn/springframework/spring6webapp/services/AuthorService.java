package zdn.springframework.spring6webapp.services;

import zdn.springframework.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();

}
