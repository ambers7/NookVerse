import java.util.Arrays;
import java.util.ArrayList;

public class Bubble{
  private ArrayList<Bookshelf> users;
  private ArrayList<Book> shared; //all shared books
  private ArrayList<Book> sharedToRead;
  private ArrayList<Book> sharedRead;
  //private String[] authors; //to be added later

  public Bubble(Bookshelf user){
    this.users = new ArrayList<Bookshelf>();
    users.add(user);
    this.shared = user.booklist();
    this.sharedToRead = new ArrayList<Book>();
    this.sharedRead = new ArrayList<Book>();
    for (Book i: user.booklist()){
      if (i.status()==0){
        sharedToRead.add(i);
      } else if (i.status()==1){
        sharedRead.add(i);
      }
    }
  }

  public void addUser(Bookshelf user){
    ArrayList<Book> sharedTemp = new ArrayList<Book>();
    ArrayList<Book> sharedToReadTemp = new ArrayList<Book>();
    ArrayList<Book> sharedReadTemp = new ArrayList<Book>();
    users.add(user);
    for (Book j: user.booklist()){
      for (Book i: shared){
        if (j.isbn() == i.isbn()){
          sharedTemp.add(i);
        }
      }
      for (Book i: sharedToRead){
        if (j.isbn() == i.isbn()){
          sharedToReadTemp.add(i);
        }
      }
      for (Book i: sharedRead){
        if (j.isbn() == i.isbn()){
          sharedReadTemp.add(i);
        }
      }

    }

    shared = sharedTemp;
    sharedToRead = sharedToReadTemp;
    sharedRead = sharedReadTemp;
  }

  public String toString(){
    String s = "BUBBLE MEMBERS: ";
    for (Bookshelf i: users){
      s+= i.username()+", ";
    }
    s = s.substring(0, s.length()-2);
    s+="\n";

    s+="\nALL SHARED BOOKS: \n";
    for(Book i: shared){
      s+=i.toStringBasic()+"\n";
    }

    s+="\nSHARED TO READ: \n";
    for(Book i: sharedToRead){
      s+=i.toStringBasic()+"\n";
    }

    s+="\nBOTH READ: \n";
    for(Book i: sharedRead){
      s+=i.toStringBasic()+"\n";
    }
    s = s.substring(0, s.length()-1);
    return s;
  }
}
