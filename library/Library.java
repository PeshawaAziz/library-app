package library;

import exceptions.*;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) throws InvalidBookException {
        if (book == null)
            throw new InvalidBookException("Book should not be null.");
        this.books.add(book);
    }

    private Book findBook(String title) {
        for (Book book : this.books)
            if (book.getTitle().equals(title))
                return book;
        return null;
    }

    public void borrowBook(String title) throws BookNotFoundException, EmptyLibraryException {
        Book book;

        if (this.books.isEmpty())
            throw new EmptyLibraryException("Library is empty, no books to borrow.");
        else if ((book = findBook(title)) == null)
            throw new BookNotFoundException("Book with title " + title + " not found.");
        else if (book != null)
            System.out.println("Borrowed " + book.toString() + " successfully.");
    }

    public void returnBook(String title) throws BookNotFoundException {
        Book book = findBook(title);
        if (book == null)
            throw new BookNotFoundException("Cannot return book. Book with title " + title + " not found.");
        else {
            System.out.println("Returned " + book.toString() + " successfully.");
        }
    }

    public void listBooks() throws EmptyLibraryException {
        if (this.books.isEmpty())
            throw new EmptyLibraryException("Library is empty.");
        else {
            System.out.println("Books in the library:");

            for (Book book : this.books) {
                System.out.println(book.toString());
            }
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
