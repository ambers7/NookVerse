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
  private String[] authors, contributors;
  private long isbn;
  private int status; //1 if read, 0 if to read
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

}
