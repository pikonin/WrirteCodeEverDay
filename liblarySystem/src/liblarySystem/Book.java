package liblarySystem;

/**
 * 書籍の情報(タイトル、著者、ISBN、貸出状態)を保持し、書籍の状態を操作するクラス
 * 
 */
public class Book {
  private String title;
  private String author;
  private String isbn;
  private boolean isBorrowed;

  public Book(String title, String author, String isbn) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.isBorrowed = false;

  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getIsbn() {
    return isbn;
  }

  public boolean isBorrowed() {
    return isBorrowed;
  }


  /**
   * 対象の本が貸し出しされているかの確認。
   */
  public void borrowBook() {
    if (!isBorrowed) {
      isBorrowed = true;
      System.out.println(title + " has been borrowed.");
    } else {
      System.out.println(title + " is already borrowed.");
    }
  }

  /**
   * 対象の本がすでに返されているかの確認
   */
  public void returnBook() {
    if (isBorrowed) {
      isBorrowed = false;
      System.out.println(title + " has been returned.");
    } else {
      System.out.println(title + " was not borrowed.");
    }
  }

  /**
   * Bookクラスのオブジェクトを文字列で表示できるように表現
   */
  @Override
  public String toString() {
    return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Borrowed: "
        + isBorrowed;
  }
}
