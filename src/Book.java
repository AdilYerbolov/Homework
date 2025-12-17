public class Book {
    private int id;
    private static int idGen = 0;
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book(){
        id = idGen++;
        available = true;
    }
    public Book(String title, String author, int year){
        this();
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getYear(){
        return year;
    }
    public boolean getAvailability(){
        return available;
    }
    public void setTitle(String title){
        if (title != null) {
            this.title = title;
        }
        else{
            throw new IllegalArgumentException("title mustn't be null!");
        }
    }
    public void setAuthor(String author){
        if (author != null) {
            this.author = author;
        }
        else{
            throw new IllegalArgumentException("author mustn't be null!");
        }
    }
    public void setYear(int year){
        if (year >= 1500 && year <= 2025) {
            this.year = year;
        }
        else {
            throw new IllegalArgumentException("Enter appropriate Year!");
        }
    }
    public void markAsBorrowed(){
        available = false;
    }
    public void markAsReturned(){
        available = true;
    }

    @Override
    public String toString(){
        return "Book №" + id + ": title:" + title + ", author:" + author + ", year:" + year + ", available:" + available + "}\n";
    }
}
