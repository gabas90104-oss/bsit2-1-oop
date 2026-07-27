import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Add Book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // List Books
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n========== Library Books ==========");

        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    // Borrow Book
    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {

                if (!book.isBorrowed()) {
                    book.borrow();
                    System.out.println("You borrowed \"" + book.getTitle() + "\".");
                } else {
                    System.out.println("That book is already borrowed.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Return Book
    public void returnBook(String title) {

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {

                if (book.isBorrowed()) {
                    book.returnBook();
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("That book is already available.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Search Book
    public void searchBook(String title) {

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found!");
                System.out.println(book);
                return;
            }
        }

        System.out.println("Book not found.");
    }
}
