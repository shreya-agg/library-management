import java.util.Scanner;

public class LibrarySystem {
    private static Library library = new Library();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        library.loadFromFile();
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Save and Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    borrowBook(scanner);
                    break;
                case 4:
                    returnBook(scanner);
                    break;
                case 5:
                    library.saveToFile();
                    System.out.println("Data saved. Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        library.addBook(new Book(title, author));
        System.out.println("Book added.");
    }

    private static void viewBooks() {
        System.out.println("Library Books:");
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }
    }

    private static void borrowBook(Scanner scanner) {
        System.out.print("Enter the title of the book to borrow: ");
        String title = scanner.nextLine();
        library.borrowBook(title);
    }

    private static void returnBook(Scanner scanner) {
        System.out.print("Enter the title of the book to return: ");
        String title = scanner.nextLine();
        library.returnBook(title);
    }
}
