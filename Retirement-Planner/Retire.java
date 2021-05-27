/*
   Name: Asad Zaheer
   Date: 09/27/2015
   Course/Section: IT 206-206
   Assignment: Assignment 2
   
   Description:
   This program is built to help the user budget their money to have a retirement party. The 
   program will take in a name for which can be any name but cannot be blank. We will then ask 
   the user if they are going to give a speech or not and to verify if they are or not. Then 
   the program will ask what the item's cost is and to also check if the item is within the 
   budget limit. The progmram will keep on asking until the budget has reached its maximum or 
   the user inputs 0 to exit out the program. While all of this is happenening the program is 
   verifying if the cost of the items is enough for the budget and if it is it will calculate 
   the remaining budget and continue on with the inputs until the user inputs a 0 to end. Also 
   for every successful item cost input the program set a counter to count all of the items 
   purchased. Once everything has been inputed the program will print out the name of the person
   retiring, if the person retiring is giving a speech, the amount of items purhcased, the 
   total cost of all items purchased and the remaining amoun of the budget.
*/
import javax.swing.JOptionPane;

public class Retire {
   public static void main(String[] args) {
      //Creating an object for one person
      Person p1 = new Person();
      //initialization values for one person
      String name = "";
      String speech = "";
      double budget = 0.0;
      double itemCost = 0.0;
      int count = 0;
      double remaining = 0.0;
      //ask the user what their name is
      do {
         name = JOptionPane.showInputDialog("What is the name of the retiree?");
      }while(!p1.setName(name));
      //ask the user if they are going to give a speech or not
      do {
         speech = JOptionPane.showInputDialog("Will this person be giving a speech? yes or no");
      }while(!p1.setSpeech(speech));
      //ask the user what is their budget
      do {
         try {
            budget = Double.parseDouble(JOptionPane.showInputDialog("What is this person's budget?"));
         }
         catch(NumberFormatException e) {
            //error message
            JOptionPane.showMessageDialog(null, "ERROR! Please input a positive value greater than 0.");
         }     
      }while(!p1.setBudget(budget));
      
      do {
         //ask the user what is the price of the item purchased
         do {
            try {
               itemCost = Double.parseDouble(JOptionPane.showInputDialog("What is the cost of the item or imput 0 to quit?"));
               p1.setTotalCost(itemCost);
               count += 1;
            }
            catch(NumberFormatException e) {
               //error message
               JOptionPane.showMessageDialog(null, "ERROR! Please input a positive value greater than 0.");
            }
         }while((itemCost >= 0 && itemCost < 2000) && (itemCost < p1.getRemaining()) && !(itemCost == 0));
         p1.calculateBudgetRemaining();
      }while(p1.calculateBudgetRemaining()  && !(itemCost == 0));
      //print out all data for the user the see what has been inputed and calculated
      JOptionPane.showMessageDialog(null, "Name: " + p1.getName() + "\nWill this person give a speech: " + p1.getSpeech() + 
         "\nTotal number of items purchased: " + count + "\nTotal amount spent on all items: " + String.format("$%.2f", p1.getTotalCost()) + 
         "\nBudget remaining: " + String.format("$%.2f", p1.getRemaining()));
   }
}