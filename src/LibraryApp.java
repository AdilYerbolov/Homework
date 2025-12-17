import java.util.Scanner;
import java.util.ArrayList;

public class LibraryApp {
    private ArrayList<Book> books = new ArrayList<Book>();
    Scanner scanner = new Scanner(System.in);


    private boolean isActive = true;

    public void run() {
        while (isActive == true) {
            int choice;
            System.out.println("Welcome to Library App!\n" +
                    "1. Print all books\n" +
                    "2. Add new book\n" +
                    "3. Search books by title\n" +
                    "4. Borrow a book\n" +
                    "5. Return a book\n" +
                    "6. Delete a book by id\n" +
                    "7. Quit");
            if(!scanner.hasNextInt()){
                System.out.println("Please enter a number");
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: printAllBooks(); break;
                case 2: addNewBook(); break;
                case 3: searchBook(); break;
                case 4: borrowBook(); break;
                case 5: returnBook(); break;
                case 6: deleteBook(); break;
                case 7: quit(); break;
                }

        }
    }

    public void printAllBooks() {
        if (books != null) {
            if (books.isEmpty()) {
                System.out.println("No books in the library");
            } else {
                System.out.println(books);
            }
        }
        else {
            System.out.println("No books in the library");
        }
    }
    public void addNewBook() {
        Book newBook = new Book();
        System.out.println("Title of the book: ");
        newBook.setTitle(scanner.nextLine());
        System.out.println("Author of the book: ");
        newBook.setAuthor(scanner.nextLine());
        while (newBook.getYear() < 1500 || newBook.getYear() > 2025) {
            System.out.println("Year of publishment: ");
            if (scanner.hasNextInt()) {
                newBook.setYear(scanner.nextInt());
            } else {
                System.out.println("Please enter a number!");
            }
        }
        books.add(newBook);
    }
        public void searchBook () {
            System.out.println("Enter the name of the book: ");
            String search = scanner.nextLine().toLowerCase();
            boolean found = false;
            for (Book book : books) {
                if (book.getTitle().toLowerCase().contains(search)) {
                    System.out.println(book);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No books found");
            }
        }
        public void borrowBook () {
            boolean chosen = false;
            boolean found = false;
            int ID = -1;
            while (!chosen) {
                System.out.println("Enter the book id: ");
                if (scanner.hasNextInt()) {
                    ID = scanner.nextInt();
                    chosen = true;
                } else {
                    System.out.println("Please enter a number!");
                }
            }
            for (Book book : books) {
                if (book.getId() == ID) {
                    if (book.getAvailability()) {
                        book.markAsBorrowed();
                    } else {
                        System.out.println("Book is already borrowed");
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("There is no book with such ID");
            }
        }
        public void returnBook () {
            boolean chosen = false;
            boolean found = false;
            int ID = -1;
            while (!chosen) {
                System.out.println("Enter the book id: ");
                if (scanner.hasNextInt()) {
                    ID = scanner.nextInt();
                    chosen = true;
                } else {
                    System.out.println("Please enter a number!");
                }
            }
            for (Book book : books) {
                if (book.getId() == ID) {
                    if (!book.getAvailability()) {
                        book.markAsReturned();
                    } else {
                        System.out.println("Book was not borrowed");
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("There is no book with such ID");
            }
        }
        public void deleteBook () {
            boolean chosen = false;
            boolean found = false;
            int ID = -1;
            while (!chosen) {
                System.out.println("Enter the book id: ");
                if (scanner.hasNextInt()) {
                    ID = scanner.nextInt();
                    chosen = true;
                } else {
                    System.out.println("Please enter a number!");
                }
            }
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getId() == ID) {
                    books.remove(i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("There is no book with such ID");
            }
        }
        public void quit () {
            isActive = false;
            scanner.close();
        }
    }
