import java.util.Arrays;
import java.util.ArrayList;

public class Bubble{
  private ArrayList<Bookshelf> users;
  private ArrayList<Book> shared; //all shared books
  //private String[] authors; //to be added later

  public Bubble(Bookshelf user){
    this.users = new ArrayList<Bookshelf>();
    users.add(user);
    this.shared = user.booklist();
  }

  public void addUser(Bookshelf user){
    ArrayList<Book> sharedTemp = new ArrayList<Book>();
    users.add(user);
    for (Book i: shared){
      for (Book j: user.booklist()){
        if (j.isbn() == i.isbn()){
          sharedTemp.add(i);
        }
      }
    }
    shared = sharedTemp;
  }

  public String toString(){
    String s = "Bubble Members: ";
    for (Bookshelf i: users){
      s+= i.username()+", ";
    }
    s+="\n";
    for(Book i: shared){
      s+=i.toString()+"\n";
    }
    return s;
  }
}
