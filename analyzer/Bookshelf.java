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
    if (booklist.size()==0){
      booklist.add(book);
      return true;
    }
    //+ if this book is second, - if this book is first, 0 if they are identical
    // if book.compare(next book) is +, continue, and if its -, add it in right before
    for (int i = 0; i < booklist.size(); i++){
      if (book.compare(booklist.get(i))<0){
        booklist.add(i, book);
        return true;
      } else if (book.compare(booklist.get(i))==0){
        return false;
      }
    }
    booklist.add(book);
    return false;
  }


  public Book removeBook(long isbn){
    for (int i = 0; i < booklist.size(); i++){
      if (booklist.get(i).isbn()==isbn){
        Book b = booklist.get(i);
        booklist.remove(i);
        return b;
      }
    }
    return null;
  }

}
