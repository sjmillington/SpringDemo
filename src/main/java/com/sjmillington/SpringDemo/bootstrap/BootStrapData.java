package com.sjmillington.SpringDemo.bootstrap;

import com.sjmillington.SpringDemo.model.Author;
import com.sjmillington.SpringDemo.model.Book;
import com.sjmillington.SpringDemo.model.Publisher;
import com.sjmillington.SpringDemo.repositories.AuthorRepository;
import com.sjmillington.SpringDemo.repositories.BookRepository;
import com.sjmillington.SpringDemo.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Autowired
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1wd1c1233212");
        ddd.getAuthors().add(eric);
        eric.getBooks().add(ddd);

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setAddressLine("Some Address");
        publisher.setCounty("Oxon");

        publisherRepository.save(publisher);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Develop without EJB", "13132hui3h21h");

        noEJB.getAuthors().add(rod);
        rod.getBooks().add(noEJB);
        publisher.getBooks().add(noEJB);
        noEJB.setPublisher(publisher);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Added bootstrap data");
        System.out.println("Number of books " + bookRepository.count());


    }
}
