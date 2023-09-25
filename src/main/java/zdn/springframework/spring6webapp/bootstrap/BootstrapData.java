package zdn.springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import zdn.springframework.spring6webapp.domain.Author;
import zdn.springframework.spring6webapp.domain.Book;
import zdn.springframework.spring6webapp.domain.Publisher;
import zdn.springframework.spring6webapp.repositories.AuthorRepository;
import zdn.springframework.spring6webapp.repositories.BookRepository;
import zdn.springframework.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("45665465");

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("46346632");

        Publisher publisher = new Publisher();
        publisher.setPublisherName("New publisher");
        publisher.setAddress("Maslak");
        publisher.setState("TR");
        publisher.setCity("Istanbul");
        publisher.setZip(34096);

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);
        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);
        Publisher publisherSaved = publisherRepository.save(publisher);

        dddSaved.setPublisher(publisherSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.setPublisher(publisherSaved);
        noEJBSaved.getAuthors().add(rodSaved);
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        publisherSaved.getBooks().add(dddSaved);
        publisherSaved.getBooks().add(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);
        publisherRepository.save(publisherSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());


    }
}
