/**
 * 
 */
package liblarySystem;

import java.util.ArrayList;

/**
 * 'Book'オブジェクトを管理する図書館クラスです。 書籍の追加、リスト表示、貸出や返却などを行います。
 */
public class Library {
  private ArrayList<Book> books;

  public Library() {
    books = new ArrayList<Book>();
  }

  /**
   * 書籍の追加を行います。
   */
  public void addBook(Book book) {
    books.add(book);
    System.out.println("Added: " + book.getTitle());
  }

  /**
   * 本の情報を管理
   */
  public void listBooks() {
    if (books.isEmpty()) {
      System.out.println("No books in the library.");
    } else {
      for (Book book : books) {
        System.out.println(book);
      }
    }
  }

  /**
   * 本の貸出を行う。
   * 
   * @param title
   */
  public void borrowBook(String title) {
    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(title)) {
        book.borrowBook();
        return;
      }

      System.out.println("Book nor found:" + title);
    }
  }

  /**
   * 本の返却を行う。
   * 
   * @param title
   */
  public void returnBook(String title) {
    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(title)) {
        book.returnBook();
        return;
      }
    }
    System.out.println("Book not found: " + title);
  }
}
