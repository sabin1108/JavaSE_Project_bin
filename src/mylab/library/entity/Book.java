package mylab.library.entity;

public class Book {

	//도서 정보를 담는 멤버변수를 private으로 정의
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	//초기 생성 시 도서는 대출 가능 상태로 설정
	public Book() {
		isAvailable = true;
	}

	//도서 정보를 초기화하고 대출 가능 상태로 설정
	public Book(String title, String author, String isbn, int publishYear) {
		this();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
	}

	//멤버변수에 대한 getter와 setter 메서드 작성
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	//대출 가능한 경우 isAvailable을 false로 변경하고 true 반환
	public boolean checkOut() {
		if (!isAvailable) {
			return false;
		}
		isAvailable = false;
		return true;
	}

	public void returnBook() {
		isAvailable = true;
	}

	@Override
	public String toString() {
		return "책 제목: " + title + "\t저자: " + author + "\tISBN: " + isbn
				+ "\t출판년도: " + publishYear + "\t대출 가능 여부: "
				+ (isAvailable ? "가능" : "대출 중");
	}
}
