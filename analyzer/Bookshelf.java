import java.util.Arrays;
import java.util.ArrayList;

public class Bookshelf{
  private ArrayList<Book> booklist;
  private String username;

  public Bookshelf(String username){
    this.username = username;
    this.booklist = new ArrayList<Book>();
  }
}
