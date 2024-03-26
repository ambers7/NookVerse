import java.util.Arrays;
/*
  Title
  Authors
      Contributors
  ISBN/UID
      Format
  Read Status
      Date Added
      Last Date Read
      Dates Read
      Read Count
      Moods
      Pace
      Character- or Plot-Driven?
      Strong Character Development?
      Loveable Characters?
      Diverse Characters?
      Flawed Characters?
  Star Rating
      Review
      Content Warnings
      Content Warning Description
      Tags
      Owned?
*/

public class Book{
  private String title;
  private String[] authors;
  private long isbn;
  private int status; //1 if read, 0 if to read
  private double rating;

  //Constructor
  public Book(String title, String[] authors, long isbn, int status, double rating){
    this.title = title;
    this.authors = authors;
    this.isbn = isbn;
    this.status = status;
    this.rating = rating;
  }

  //Accessor Methods
  public String title(){
    return title;
  }

  public String[] authors(){
    return authors;
  }

  public long isbn(){
    return isbn;
  }

  public int status(){
    return status;
  }

  public double rating(){
    return rating;
  }


  public String toString(){
    String s = title + " by ";
    for (int i = 0; i < authors.length; i++){
      s+= authors[i]+", ";
    }
    s+="["+isbn+", ";
    if (status==0){
      s+="to read";
    } else if (status==1){
      s+="read";
    } else{
      s+="???";
    }
    s+=", "+ rating+"]";
    return s;
  }
  //+ if this book is second, - if this book is first, 0 if they are identical
  public int compare(Book book){
    if(authors[0].compareTo(book.authors[0])!=0){
      return authors()[0].compareTo(book.authors()[0]);
    } else{
      return title().compareTo(book.title());
    }
  }
}
