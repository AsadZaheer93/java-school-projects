/*
   Name: Asad Zaheer
   Date: 10/11/2015
   Course/Section: IT 206-206
   Assignment: Assignment 4
   
   Description:
   This program is to help build a collection of paintings. The user can choos between
   showing the list of paintings in the collection, add a painting to the collection,
   delete a painting from the collection, sell a painting from the collection, and finally
   showing a final report of number of paintings sold, how many are still in the collection,
   and the amount of profit made. The user can add up to 58 paintings to the collections. 
   The user will needs to provide the the painting name, artist name, whether or not a 
   gmu student has painted it and the total area of the painting. A user can delete a
   painting by inputing the name of the painting and the program will delete it for them.
   The user can also sell a painting by inputing the name of the painting and then the
   program will ouput the information about the painting and then add the profit gained
   and then delete the painting from the program. At anytime during the program the user
   can type in a 1 and see what are the current paintings available. Once the user is 
   done they can type in 5 and show a report of the inventory, number of paintings sold,
   and the amount of profit made and then program will ext.
*/
import javax.swing.JOptionPane;

public class PaintingCollection {
   public static void main(String[] args) {
      //initializing variables
      final int MAX_PAINTINGS = 58;
      Painting[] collection = new Painting[MAX_PAINTINGS];
      double profit = 0;
      int sold = 0;
         
      int menuChoice = getMenuOption();
      //ask the user what they want to do
      while(menuChoice != 5) {
         switch(menuChoice) {
            case 1:
               printShowPaintings(collection);
               break;
            case 2:
               addPainting(collection);
               break;
            case 3:
               deletePainting(collection);
               break;
            case 4:
               profit += sellPainting(collection);
               sold++;
               break;
            default:
               // Program should never reach this condition if logic is correct
               JOptionPane.showMessageDialog(null, "Unknown Error");
               break;
         }
         menuChoice = getMenuOption();
      }
      printSummary(profit, sold, collection);
   }
   /**
      ask the user what they want to do
      @return menuChoice an int value to see what they have chosen
   */
   public static int getMenuOption() {
      int menuChoice;
      //ask the user what they want to do
      do {
         try {
            menuChoice = Integer.parseInt(JOptionPane.showInputDialog(
               "Enter your selection:"
               + "\n(1) Show All Paintings"
               + "\n(2) Add New Painting"
               + "\n(3) Delete Painting"
               + "\n(4) Sell Painting"
               + "\n(5) Quit Application"
            ));
         }
         catch(NumberFormatException e) {
            menuChoice = 0;
         }
         if(menuChoice < 1 || menuChoice > 5) {
            //error message
            JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid menu option.");
         }
      } while(menuChoice < 1 || menuChoice > 5);
      return menuChoice;
   }
   /**
      print out the current listing of painting in the collection
      @param collection all of the paintings in the collection
   */
   public static void printShowPaintings(Painting[] collection) {
      String output = "";
      
      if(collection == null) {
         //error message
         JOptionPane.showMessageDialog(null, "ERROR! No paintings in collection please add a painting.");
      }
      else {
         output = getOutput(collection);
         JOptionPane.showMessageDialog(null, output);
      }
   }
   /**
      Add a painting to the collection
      @param collection all of the paintings in the colleciton
   */
   public static void addPainting(Painting[] collection) {
      //get the nubmer of paintings
      int position = Painting.getNumOfPaintings();
      //check to see if there is enought room in the collection
      if(position < collection.length) {
         //add a painting
         collection[position] = new Painting();
         //get the painting information
         collection[position].setPaintingName(JOptionPane.showInputDialog("Enter the name of the painting."));
         collection[position].setArtistName(JOptionPane.showInputDialog("Enter the name of the artist for this painting."));
         String decision = "";
         double totalArea = 0.0;
         //validate input
         do { 
            collection[position].setPaintedGMU(decision = JOptionPane.showInputDialog("Was this painting painted by a GMU student? YES or NO"));
            if(!collection[position].setPaintedGMU(decision)) {
               //error message
               JOptionPane.showMessageDialog(null, "ERROR! Please enter a yes or a no.");
            }
         }while(  );
         //validate input
         do {
            try {
               collection[position].setTotalArea(totalArea = Double.parseDouble(JOptionPane.showInputDialog("What is the total area of the painting between 1 and 36?")));
               collection[position].setTotalCost(decision);
            }
            catch(NumberFormatException e) {
               totalArea = 0;
            }
            if(!collection[position].setTotalArea(totalArea)) {
               //error message
               JOptionPane.showMessageDialog(null, "ERROR! Please enter an integer value between 1 and 36.");
            }
         }while(!collection[position].setTotalArea(totalArea));
      }
      else {
         JOptionPane.showMessageDialog(null, "ERROR! There is no space left to add another painting.");
      }
   }
   /**
      delete a painting from the collection
      @param collection all of the paintings in the colleciton
   */
   public static void deletePainting(Painting[] collection) {
      String output = "";
      String delete = "";
      if(collection == null) {
         //error message
         JOptionPane.showMessageDialog(null, "ERROR! No paintings in collection please add a painting.");
      }
      else {
         output = getOutput(collection);
         do {
            delete = JOptionPane.showInputDialog("Which painting would you like to delete?\n\n" + output);
            //check if user input is the same as the list of paintings and then delete them
            for(int x = 0; x < Painting.getNumOfPaintings(); x++) {
               if(delete.equalsIgnoreCase(collection[x].getPaintingName())){
                  if(collection[Painting.getNumOfPaintings() - 1] != null) {
                     collection[x].setPaintingName(collection[Painting.getNumOfPaintings() - 1].getPaintingName());
                     collection[x].setArtistName(collection[Painting.getNumOfPaintings() - 1].getArtistName());
                     collection[x].setPaintedGMU(collection[Painting.getNumOfPaintings() - 1].getPaintedGMU());
                     collection[x].setTotalArea(collection[Painting.getNumOfPaintings() - 1].getTotalArea());
                     collection[Painting.getNumOfPaintings() - 1] = null;
                  }
               }
               else {
                  delete = "0";
               }
            }
            if(delete.equals("0")) {
               //error message
               JOptionPane.showMessageDialog(null, "ERROR! Please input a valid painting name from the list.");
            }
         }while(delete.equalsIgnoreCase("0"));
      }
   }
   /**
      sell a painting from the collection and delete it from the collection
      @param collection all of the paintings in the colleciton
      @return cost the cost of the painting sold
   */
   public static double sellPainting(Painting[] collection) {
      String output = "";
      String sell = "";
      double cost = 0.0;
      
      if(collection == null) {
         //error message
         JOptionPane.showMessageDialog(null, "ERROR! No paintings in collection please add a painting.");
      }
      else {
         output = getOutput(collection);
         do {
            sell = JOptionPane.showInputDialog("Which painting would you like to sell?\n\n" + output);
            //check if user input is the same as the list of paintings and then delete them and add the profit
            for(int x = 0; x < Painting.getNumOfPaintings(); x++) {
               if(sell.equalsIgnoreCase(collection[x].getPaintingName())){
                  cost = collection[x].getTotalCost();
                  //show the user information about the painting
                  JOptionPane.showMessageDialog(null, "Barcode: " + Painting.getBarcode() + "\nPainting Name: "
                  + collection[x].getPaintingName() + "\nArtist Name: " + collection[x].getArtistName() + "\nPainted by GMU Studen: "
                  + collection[x].getPaintedGMU() + "\nTotal Area: " + collection[x].getTotalArea() + "\nTotal Cost: " 
                  + collection[x].getTotalCost());
                  //delete painting
                  if(collection[Painting.getNumOfPaintings() - 1] != null) {
                     collection[x].setPaintingName(collection[Painting.getNumOfPaintings() - 1].getPaintingName());
                     collection[x].setArtistName(collection[Painting.getNumOfPaintings() - 1].getArtistName());
                     collection[x].setPaintedGMU(collection[Painting.getNumOfPaintings() - 1].getPaintedGMU());
                     collection[x].setTotalArea(collection[Painting.getNumOfPaintings() - 1].getTotalArea());
                     collection[Painting.getNumOfPaintings() - 1] = null;
                  }
                  return cost;
               }
               else {
                  sell = "0";
               }
            }
            if(sell.equals("0")) {
               //error message
               JOptionPane.showMessageDialog(null, "ERROR! Please input a valid painting name from the list.");
            }
         }while(sell.equalsIgnoreCase("0"));

      }
      return cost;
   }
   /**
      print a report of inventory, number of paintings sold and profit
      @param profit the amount of revenue made
      @param sold the number of painting sold
      @param collection all of the paintings in the colleciton
   */
   public static void printSummary(double profit, int sold, Painting[] collection) {
      String output = "";
      if(collection == null) {
         //error message
         JOptionPane.showMessageDialog(null, "ERROR! No paintings in collection please add a painting.");
      }
      else {
         //print out a report of inventory, number of paintings sold and profit
         JOptionPane.showMessageDialog(null, "Current Paintings in Inventory: " + Painting.getNumOfPaintings() + "\nNumber of Paintings sold: " 
         + sold + "\nTotal profit: " + String.format("$%.2f", profit));
      }
   }
   /**
      accumulate a big message for it to output all of the painting names and artist names from the collection
      @param collection all of the paintings in the colleciton
      @return output all of the painting names and artist names from the collection
   */
   public static String getOutput(Painting[] collection) {
      String output = "";
      //output all of the painting names and artist names
      if(Painting.getNumOfPaintings() > 0) {
         for(int x = 0; x < Painting.getNumOfPaintings(); x++) {
            output += "Painting Name: " + collection[x].getPaintingName() + "         Artist Name: " + collection[x].getArtistName() + "\n"; 
         }
      }
      else {
         output += "ERROR! No paintings.";
      }
      return output;
   }
}