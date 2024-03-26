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
    Book TheIdiot = new Book("The Idiot", new String[]{"Elif Batuman"}, new String[]{}, 9780143111061L, 1, 4);
    System.out.println(TheIdiot);
  }
}
