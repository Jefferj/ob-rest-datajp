package com.example.obrestdatajp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ObRestDatajpApplication.class, args);
        BookRepository repository = context.getBean(BookRepository.class);

        //CRUD

        //Create Book
        Book book1 = new Book(null, "Homo Deus", "Yuval Noah", 450, 29.99, LocalDate.of(2018, 12, 1), true);
        Book book2 = new Book(null, "Homo Sapiens", "Yuval Noah", 450, 19.99, LocalDate.of(2013, 12, 1), true);

        //Save Book
        System.out.println("El número de libros en base de datos es " + repository.findAll().size());
        repository.save(book1);
        repository.save(book2);

        //Recover All Books
        System.out.println("El número de libros en base de datos es " + repository.findAll().size());

        //Delete Book
        repository.deleteById(1L);
        System.out.println("El número de libros en base de datos es " + repository.findAll().size());

    }

}
