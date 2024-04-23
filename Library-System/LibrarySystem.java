import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibrarySystem {
    private static Map<String, Book> library = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addBooks();
                    break;
                case 2:
                    borrowBooks();
                    break;
                case 3:
                    returnBooks();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        System.out.println("Exiting the program. Goodbye!");
        scanner.close();
    }

    private static void addBooks() {
        System.out.println("\nAdd Books:");
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();

        Book book = library.get(title);
        if (book != null) {
            // Book already exists, update quantity
            book.setQuantity(book.getQuantity() + quantity);
            System.out.println("Quantity updated for existing book: " + title);
        } else {
            // Add new book to the library
            library.put(title, new Book(title, author, quantity));
            System.out.println("New book added to the library: " + title);
        }
    }

    private static void borrowBooks() {
        System.out.println("\nBorrow Books:");
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        
        Book book = library.get(title);
        if (book == null) {
            System.out.println("Sorry, the book '" + title + "' is not available in the library.");
            return;
        }
        
        System.out.print("Enter the number of books to borrow: ");
        int quantityToBorrow = scanner.nextInt();
        
        if (quantityToBorrow > book.getQuantity()) {
            System.out.println("Sorry, only " + book.getQuantity() + " copies of '" + title + "' are available.");
        } else {
            book.setQuantity(book.getQuantity() - quantityToBorrow);
            System.out.println("You have successfully borrowed " + quantityToBorrow + " copies of '" + title + "'.");
        }
    }

    private static void returnBooks() {
        System.out.println("\nReturn Books:");
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        
        Book book = library.get(title);
        if (book == null) {
            System.out.println("Sorry, the book '" + title + "' does not belong to the library system.");
            return;
        }
        
        System.out.print("Enter the number of books to return: ");
        int quantityToReturn = scanner.nextInt();
        
        book.setQuantity(book.getQuantity() + quantityToReturn);
        System.out.println("You have successfully returned " + quantityToReturn + " copies of '" + title + "'.");
    }

    private static class Book {
        private String title;
        private String author;
        private int quantity;

        public Book(String title, String author, int quantity) {
            this.title = title;
            this.author = author;
            this.quantity = quantity;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
