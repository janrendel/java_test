package book_project.repository;

import book_project.DTO.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<BookDTO> books = new ArrayList<BookDTO>();

    public void addBook(BookDTO book) {
        books.add(book);
    }

    public List<BookDTO> getBooks() {
        return books;
    }
    public BookDTO getBookByIsbn(String isbn) {
        for (BookDTO book : books) {
            if(book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public boolean removeBook(String isbn) {
        return books.removeIf(book -> book.getIsbn().equals(isbn));
    }
}
