public class Driver{
  public static void main(String args[]){
    /*
    try{
      File file = new File("amber_storygraph.csv");
      Scanner input = new Scanner(file);
      input.close();
    } catch (FileNotFoundException ex){
      //file not found
    }
    */
    Bookshelf milk = new Bookshelf("milk");
    Book TheIdiot = new Book("The Idiot", new String[]{"Elif Batuman"}, 9780143111061L, 1, 4);
    Book pjo1 = new Book("The Lightning Thief", new String[]{"Rick Riordan"}, 1223212, 0, 0);
    Book pjo2 = new Book("The Sea of Monsters", new String[]{"Rick Riordan"}, 1134324, 0, 0);
    Book pjo3 = new Book("The Titan's Curse", new String[]{"Rick Riordan"}, 11143241, 1, 3);
    Book pjo4 = new Book("The Battle of the Labyrinth", new String[]{"Rick Riordan"}, 542134, 1, 4.5);
    Book pjo5 = new Book("The Last Olympian", new String[]{"Rick Riordan"}, 13542543, 1, 5);

    milk.addBook(TheIdiot);
    milk.addBook(pjo1);
    milk.addBook(pjo2);
    milk.removeBook(1223212); //removes lightning thief
    milk.addBook(pjo3);
    milk.addBook(pjo4);
    milk.removeBook(13542543); //does nothing
    milk.addBook(pjo5);
    milk.addBook(pjo5);
    milk.addBook(pjo5);
    milk.addBook(pjo5);
    milk.addBook(pjo5); 
    System.out.println(milk.booklist().get(0));
    System.out.println(milk.booklist().get(1));
    System.out.println(milk.booklist().get(2));
    System.out.println(milk.booklist().get(3));
    System.out.println(milk.booklist().get(4));
    //System.out.println(milk.booklist().get(5));
  }
}
