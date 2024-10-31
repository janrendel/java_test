package book_project.Service;

import book_project.repository.BookRepository;
import book_project.DTO.BookDTO;

public class BookService {
    private BookRepository bookRepository = new BookRepository();

    public void addBook(BookDTO book) {
        bookRepository.addBook(book);
    }

    public BookDTO findBook(String isbn) {
        return bookRepository.getBookByIsbn(isbn);
    }
    public boolean deleteBook(String isbn) {
        return bookRepository.removeBook(isbn);
    }

    public void showAllBooks() {
        for (BookDTO book : bookRepository.getBooks()) {
            System.out.println(book);
        }
    }
}
