package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {

	private String name;
	private List<Book> books;

	//도서관 이름을 초기화하고 빈 도서 목록 생성
	public Library(String name) {
		this.name = name;
		books = new ArrayList<Book>();
	}

	public String getName() {
		return name;
	}

	public void addBook(Book book) {
		books.add(book);
		System.out.println("도서가 추가되었습니다: " + book.getTitle());
	}

	public Book findBookByTitle(String title) {
		for (Book book : books) {
			if (title.equals(book.getTitle())) {
				return book;
			}
		}
		return null;
	}

	//저자로 도서를 검색하는 메서드
	public List<Book> findBooksByAuthor(String author) {
		List<Book> foundBooks = new ArrayList<Book>();
		for (Book book : books) {
			if (author.equals(book.getAuthor())) {
				foundBooks.add(book);
			}
		}
		return foundBooks;
	}

	public Book findBookByISBN(String isbn) {
		for (Book book : books) {
			if (isbn.equals(book.getIsbn())) {
				return book;
			}
		}
		return null;
	}
	// 대출 반납 메서드 
	public boolean checkOutBook(String isbn) {
		Book book = findBookByISBN(isbn);
		return book != null && book.checkOut();
	}

	public boolean returnBook(String isbn) {
		Book book = findBookByISBN(isbn);
		if (book == null) {
			return false;
		}
		book.returnBook();
		return true;
	}
	// 출 가능한 도서 목록이나 전체 도서 목록을 반환하는 메서드
	public List<Book> getAvailableBooks() {
		List<Book> availableBooks = new ArrayList<Book>();
		for (Book book : books) {
			if (book.isAvailable()) {
				availableBooks.add(book);
			}
		}
		return availableBooks;
	}

	public List<Book> getAllBooks() {
		return books;
	}
	//도서 수량 관련 정보를 반환하는 메서드
	public int getTotalBooks() {
		return books.size();
	}

	public int getAvailableBooksCount() {
		int count = 0;
		for (Book book : books) {
			if (book.isAvailable()) {
				count++;
			}
		}
		return count;
	}

	public int getBorrowedBooksCount() {
		return getTotalBooks() - getAvailableBooksCount();
	}
}
