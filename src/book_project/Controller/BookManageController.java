package book_project.Controller;

import book_project.Service.BookService;
import book_project.DTO.BookDTO;

import java.util.Scanner;

public class BookManageController {
    private BookService bookService = new BookService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while(true) {
            System.out.println("==== 도서 관리 시스템 ====");
            System.out.println("1. 도서 추가");
            System.out.println("2. 도서 검색");
            System.out.println("3. 도서 삭제");
            System.out.println("4.전체 도서 목록 보기");
            System.out.println("5. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    bookService.showAllBooks();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void addBook() {
        System.out.print("도서번호 입력: ");
        String isbn = scanner.nextLine();
        System.out.print("제목 입력: ");
        String title = scanner.nextLine();
        System.out.print("저자 입력: ");
        String author = scanner.nextLine();
        System.out.print("출판사 입력: ");
        String publisher = scanner.nextLine();
        System.out.print("가격 입력:");
        int price = scanner.nextInt();

        BookDTO book = new BookDTO(isbn, title, author, publisher, price);
        bookService.addBook(book);
        System.out.println("도서가 추가되었습니다");
    }

    private void searchBook() {
        System.out.print("검색할 도서의 ISBN 입력: ");
        String isbn = scanner.nextLine();
        BookDTO book = bookService.findBook(isbn);
        if (book != null) {
            System.out.println(book);
        }else{
            System.out.println("도서를 찾을 수 없습니다.");
        }
    }

    private void deleteBook() {
        System.out.println("삭제할 도서의 ISBN 입력: ");
        String isbn = scanner.nextLine();
        boolean isDeleted = bookService.deleteBook(isbn);
        if (isDeleted) {
            System.out.println("도서가 삭제되었습니다.");
        }else{
            System.out.println("도서를 찾을 수 없습니다.");
        }
    }
}
