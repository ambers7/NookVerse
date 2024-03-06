import java.util.array;
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
  private String[] authors, contributors;
  private long isbn;
  private int status; //true if read, false if to read
  private float rating;

  //Constructor
  public Book(String title, String[] authors, String[] contributors, long isbn, int status, float rating){
    this.title = title;
    this.authors = authors;
    this.contributors = contributors;
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

  public String[] contributors(){
    return contributors;
  }

  public long isbn(){
    return isbn;
  }

  public int status(){
    return status;
  }

  public float rating(){
    return rating;
  }

  public toString(){

  }
}
