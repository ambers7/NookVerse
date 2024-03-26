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
    Bookshelf amber = new Bookshelf("amber");
    Book TheIdiot = new Book("The Idiot", new String[]{"Elif Batuman"}, 9780143111061L, 1, 4);
    Book pjo1 = new Book("The Lightning Thief", new String[]{"Rick Riordan"}, 1223212, 0, 0);
    Book pjo2 = new Book("The Sea of Monsters", new String[]{"Rick Riordan"}, 1134324, 0, 0);
    Book pjo3 = new Book("The Titan's Curse", new String[]{"Rick Riordan"}, 11143241, 1, 3);
    Book pjo4 = new Book("The Battle of the Labyrinth", new String[]{"Rick Riordan"}, 542134, 1, 4.5);
    Book pjo5 = new Book("The Last Olympian", new String[]{"Rick Riordan"}, 13542543, 1, 5);
    Book NookVerse = new Book("NookVerse", new String[]{"Amber Shen", "Mikayla Lin", "Mary Lee"}, 132432435, 1, 1);

    milk.addBook(TheIdiot);
    milk.addBook(pjo1);
    milk.addBook(pjo2);
    milk.removeBook(1223212); //removes lightning thief
    milk.removeBook(13542543); //does nothing
    milk.addBook(pjo5);
    milk.addBook(pjo5);
    milk.addBook(NookVerse);
    milk.addBook(pjo5);
    milk.addBook(pjo5);
    System.out.println(milk.toString());

    amber.addBook(pjo5);
    amber.addBook(pjo3);
    amber.addBook(pjo4);
    amber.addBook(NookVerse);
    System.out.println(amber.toString());

    Bubble am = new Bubble(milk);
    am.addUser(amber);
    System.out.println(am.toString());
  }
}
