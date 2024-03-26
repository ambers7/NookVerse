import java.util.Arrays;
import java.util.ArrayList;

public class Bookshelf{
  private ArrayList<Book> booklist;
  private String username;

  public Bookshelf(String username){
    this.username = username;
    this.booklist = new ArrayList<Book>();
  }

  public String username(){
    return username;
  }

  public ArrayList<Book> booklist(){
    return booklist;
  }

  //adds book to arraylist (alphabetically by author first, then title)
  public boolean addBook(Book book){
    //+ if this book is second, - if this book is first, 0 if they are identical
    // if book.compare(next book) is +, continue, and if its -, add it in right before
    for (int i = 0; i < booklist.size(); i++){
      if (book.compare(booklist.get(i))<0){
        booklist.add(i, book);
        return true;
      }
    }
    return false;
  }

/*
  public Book removeBook(long isbn){
    return NULL;
  }
  */
}
