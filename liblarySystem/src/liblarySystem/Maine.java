package liblarySystem;

import java.util.Scanner;

public class Maine {

  public static void main(String[] args) {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);

    // init date
    library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "123456789"));
    library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "987654321"));
    library.addBook(new Book("1984", "George Orwell", "112233445"));

    boolean running = true;
    while (running) {
      System.out.println("\nLibrary Menu:");
      System.out.println("1. List all books");
      System.out.println("2. Borrow a book");
      System.out.println("3. Return a book");
      System.out.println("4. Add a new book");
      System.out.println("5. Exit");
      System.out.print("Choose an option: ");

      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          library.listBooks();
          break;
        case 2:
          scanner.nextLine();
          System.out.print("Enter the title of the book to borrow: ");
          String borrowTitle = scanner.nextLine();
          library.borrowBook(borrowTitle);
          break;
        case 3:
          scanner.nextLine();
          System.out.print("Enter the title of the book to return: ");
          String returnTitle = scanner.nextLine();
          library.returnBook(returnTitle);
          break;
        case 4:
          scanner.nextLine();
          System.out.print("Enter the title of the book: ");
          String title = scanner.nextLine();
          System.out.print("Enter the author of the book: ");
          String author = scanner.nextLine();
          System.out.print("Enter the ISBN of the book: ");
          String isbn = scanner.nextLine();
          library.addBook(new Book(title, author, isbn));
          break;
        case 5:
          running = false;
          System.out.println("Exiting the library system.");
          break;
        default:
          System.out.println("Invalid choice, please try again.");
      }
    }
    scanner.close();

  }

}
