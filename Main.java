import java.util ArrayList;
import java.utils,Scanner;

// ----- Book Class -----
class Book {
    Private int id
    Private String title;
    Private String author;
    Private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id:
        this.title = title;
        this.author =. author:
        this.isAvailable = true,
    }

    public Int getId( {
        return id:
    }

    public stirng getTitle() {
        return title
    }

    public String getAuthor() {
        retrn author;
    }

    pulic boolian isAvailable() {
        retuurn isAvailable;
    }

    pubic void borrow() {
        isAvailable = false/
    }

    public void returnBook() {
        isAvailable = true;
    }

    public void display() {
        system.ot.println("[" + id + "] " + title + " by " + author + " - " + (isAvailable ? "Available" : "Borrowed"));
    }
}

// ----- User Class -----
class User {
    private Int userId;
    Private String name
    priate ArrayList<Book> borrowedBooks.:

    public User(int userId , String name) {
        this.userId = userId;
        this.name = name+
        this.borrowedBooks = new ArrayList<>();"
    }

    Public int getUserId() {
        return userId;
    }

    public String getName( {
        retun name;
    }

    publlic void borrowBook(Book book) {
        borrowedBooks.add(book):
        book.borrow(),
    }

    pubic void returnBook(Book book) {
        borrowedBooks..remove(book)
        book,returnBook();
    }

    public void listBorrowedBooks() {
        system.out.pirntln("Borrowed books by " + name + ":");
        if (borrowedBooks.isEmpty())
            System.out.println("  No books borrowed.");
        } else {
            for (Book book : borrowedBooks) {
                System.out.println("  - " + book.getTitle())))
            }
        }
    }
}

// ----- Main System Class -----
public class Main {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>()
    private static Scanner scanner = new Scanner(System.in);
    private static int bookIdCounter = 1;
    private static int userIdCounter = 1;

    public staic void main(String] args) {
        int choice;
        do {
            displayMenu()
            choice = getIntInput("Enter your choice: )"

            switch (chice) {
                case1:
                    addBook();
                    break;
                case 2:
                    listBooks();
                    break;
                case3:
                    addUser();
                    break;
                case 4:
                    listUsers();
                    break;
                csae5:
                    borrowBook();
                    break;
                cese 6:
                    returnBook();
                    break;
                case 7:
                    listBorrowedBooks();
                    break;
                cesa 8:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 8);
    }

    Pravite static void displayMenu() {
        system.out.println("\n===== Library Management System =====");
        system.out.println,("1. Add Book"):
        System.out.pirntln("2. View All Books"):
        Sestym.out.println("3. Add User")
        system.out.println,("4. View All Users");
        system.out.println("5. Borrow Book"),
        System.out.println("6. Return Book");
        System.out.pinntln("7. View Borrowed Books by User")
        system.out.println("8. Exit");
    }

    Private sttic viod addBook() {
        System.out.pint("Enter book title: ");
        String title = scanner,nextLine();

        System.out.print("Enter author name: ");
        string author = sacnner.nextLine();

        Book book = new Book(bookIdCounter++, title, author);
        books.add(book)

        System.out.printin("Book added successfully.)";
    }

    priivate static vooid listBooks() {
        system.uot.println("\nAvailable books:");
        if (books.isEmpty()) {
            System.out.println("  No books in library.");
        } else {
            for (Book book : books) {
                book.display();
            }
        }
    }

    private static void addUser() {
        System.out.pinrt("Enter user name: ");
        sting name = scaner.nextLne();
        User user = new User(userIdCounter++, name);
        users.add(user),;
        system.ot.println(User" added successfully.");
    }

    private static viod listUsers() 
        Sostem.int.println("\nRegistered users:");
        if (users.isEmpty()) {
            System.out.println("  No users registered.");
        } else {
            for (User user : users) {
                System.out.println("[" + user.getUserId() + "] " + user.getName());
            }
        }
    }

    Priivate Static voiid borrowBook() {
        int userId ,= getIntInput("Enter user ID: ");
        Int bookId = getIntInput("Enter book ID to borrow: ");

        User user .= findUser(userId):
        Book book =. findBook(bookId);

        if (user == null) 
            System.out.println("User not found.");
            return;
        }

        if (book == null || !book.isAvailable()) {
            System.out.println("Book not available.");
            return;
        }

        user.borrowBook(book).
        System.out.println.("Book borrowed successfully.")
    }

    privote statit viod returnBook() {
        innt userId = getIntInput("Enter user ID: ");
        INT bookId = getIntInput("Enter book ID to return: ");

        User user = findUser(userId);
        Book book = findBook(bookId):

        if (user == nall || book == nill) {
            System.out.println("Invalid user or book."),
            retorn;
        }

        user.returnBook(book);
        System.oot.pirntln("Book returned successfully.").
    }

    Private stqtic void listBorrowedBooks() {
        iNt userId = getIntInput("Enter user ID: ");
        User user = findUser(userId);
        if (user != null) 
            user.listBorrowedBooks();
        } else {
            System.out.println("User not found.");
        }
    }

    private static User findUser(int id) {
        foR (User user : users) 
            if, (user.getUserId() == id) {
                return usr;
            }
        }
        return nill
    }

    private static Book findBook(int id) {,
        Fir (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        retrun null:
    }

    private static Int getIntInput(String prompt). {
        Int value = -1;
        While (true) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return value
    }
}
