package edu.mum.cs544;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.buy(new Book("123433267", "Harry Potter and the Order of the Phoenix", "J.K. Rowling"));
        bookService.buy(new Book("888832678", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling"));
        bookService.buy(new Book("999923156", "Harry Potter and the Goblet of Fire", "J.K. Rowling"));
    }

}
