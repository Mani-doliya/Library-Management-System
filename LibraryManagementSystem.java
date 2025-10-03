import java.util.ArrayList;
import java.util.Scanner;

class Book{
    String title;
    String author;
    int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    void displayInfo(){
        System.out.println("Book Title: "+title+" | Book Author: "+author+" | Year of Publication: "+yearPublished);
    }
}
class Library {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addBook() {
        System.out.println("Enter book title:");
        String title = sc.nextLine();
        System.out.println("Enter book author:");
        String author = sc.nextLine();
        System.out.println("Enter year of publishing:");
        int yearPublished = sc.nextInt();
        Book s = new Book(title, author, yearPublished);
        books.add(s);
    }

    static void displayAllBooks() {
        System.out.println("\n===== All Books =====");
        for (Book s : books) {
            s.displayInfo();
        }
    }
    static void searchByTitle(){
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        boolean found = false;
        for (Book s : books) {
            if (s.title.equals(title)) {
                s.displayInfo();
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Book not found!");
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library lib = new Library();
        int choice;
        do {
            System.out.println("\n========== Library Management System ==========");
            System.out.println("1. Add a new book");
            System.out.println("2. View book by title");
            System.out.println("3. View all books");
            System.out.println("0. Exit");
            System.out.println("===============================================");
            System.out.print("Enter your choice: ");
            choice = Library.sc.nextInt();
            Library.sc.nextLine();

            switch (choice) {
                case 1:
                    lib.addBook();
                    break;
                case 2:
                    lib.searchByTitle();
                    break;
                case 3:
                    lib.displayAllBooks();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}