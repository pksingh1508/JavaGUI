import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

class Book {
    String title;
    String author;
    String date;
    int quantity;

    public Book(String title, String author, String date, int quantity) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + date + ") - Quantity: " + quantity;
    }
}

class Librarian {
    String name;
    HashMap<Book, Integer> issuedBooks;

    public Librarian(String name) {
        this.name = name;
        this.issuedBooks = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void issueBook(Book book, int quantity) {
        int currentQuantity = issuedBooks.getOrDefault(book, 0);
        issuedBooks.put(book, currentQuantity + quantity);
    }

    public HashMap<Book, Integer> getIssuedBooks() {
        return issuedBooks;
    }
}

class Library {
    private ArrayList<Book> books;
    private ArrayList<Librarian> librarians;

    public Library() {
        this.books = new ArrayList<>();
        this.librarians = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Librarian> getLibrarians() {
        return librarians;
    }

    public Librarian findLibrarianByName(String name) {
        for (Librarian librarian : librarians) {
            if (librarian.getName().equals(name)) {
                return librarian;
            }
        }
        return null;
    }

    public ArrayList<Book> searchBooksByName(String name) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.title.toLowerCase().contains(name.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
}

class LibraryManagementSystem extends JFrame {
    private Library library;

    private JTextArea displayArea;
    private JTextField titleField, authorField, dateField, quantityField;
    private JTextField librarianNameField;

    public LibraryManagementSystem() {
        library = new Library();

        // GUI components
        displayArea = new JTextArea(15, 40);
        titleField = new JTextField(20);
        authorField = new JTextField(20);
        dateField = new JTextField(10);
        quantityField = new JTextField(5);
        librarianNameField = new JTextField(20);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                String date = dateField.getText();
                int quantity = Integer.parseInt(quantityField.getText());

                if (!title.isEmpty() && !author.isEmpty() && !date.isEmpty() && quantity > 0) {
                    Book newBook = new Book(title, author, date, quantity);
                    library.addBook(newBook);
                    displayBooks();
                } else {
                    JOptionPane.showMessageDialog(LibraryManagementSystem.this,
                            "Please fill in all fields with valid data.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton addLibrarianButton = new JButton("Add Librarian");
        addLibrarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String librarianName = librarianNameField.getText();

                if (!librarianName.isEmpty()) {
                    Librarian newLibrarian = new Librarian(librarianName);
                    library.addLibrarian(newLibrarian);
                    displayLibrarians();
                } else {
                    JOptionPane.showMessageDialog(LibraryManagementSystem.this,
                            "Please enter a librarian name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton searchButton = new JButton("Search Book");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchName = titleField.getText();

                if (!searchName.isEmpty()) {
                    ArrayList<Book> searchResult = library.searchBooksByName(searchName);
                    displayBooks(searchResult);
                } else {
                    JOptionPane.showMessageDialog(LibraryManagementSystem.this,
                            "Please enter a book name to search.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton viewIssuedBooksButton = new JButton("View Issued Books");
        viewIssuedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String librarianName = librarianNameField.getText();
                Librarian librarian = library.findLibrarianByName(librarianName);

                if (librarian != null) {
                    displayIssuedBooks(librarian);
                } else {
                    JOptionPane.showMessageDialog(LibraryManagementSystem.this,
                            "Librarian not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Layout
        JPanel panel = new JPanel();
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Author:"));
        panel.add(authorField);
        panel.add(new JLabel("Date:"));
        panel.add(dateField);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantityField);
        panel.add(addButton);

        JPanel librarianPanel = new JPanel();
        librarianPanel.add(new JLabel("Librarian Name:"));
        librarianPanel.add(librarianNameField);
        librarianPanel.add(addLibrarianButton);
        librarianPanel.add(searchButton);
        librarianPanel.add(viewIssuedBooksButton);

        JScrollPane scrollPane = new JScrollPane(displayArea);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(panel);
        add(librarianPanel);
        add(scrollPane);

        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void displayBooks() {
        displayBooks(library.getBooks());
    }

    private void displayBooks(ArrayList<Book> books) {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.toString()).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    public void displayLibrarians() {
        ArrayList<Librarian> librarians = library.getLibrarians();
        StringBuilder sb = new StringBuilder("Librarians:\n");
        for (Librarian librarian : librarians) {
            sb.append(librarian.getName()).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    private void displayIssuedBooks(Librarian librarian) {
        HashMap<Book, Integer> issuedBooks = librarian.getIssuedBooks();
        StringBuilder sb = new StringBuilder("Books Issued by " + librarian.getName() + ":\n");
        for (Book book : issuedBooks.keySet()) {
            sb.append(book.toString()).append(" - Quantity Issued: ").append(issuedBooks.get(book)).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LibraryManagementSystem();
            }
        });
    }
}
