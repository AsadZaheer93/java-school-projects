public class Person {
   //instance variables of a person object
   private String name;
   private String speech;
   private double totalCost;
   private double budget;
   private double remaining;
   /**
      default values if the user inputed in nothing
   */
   public Person() {
      this("", "", 1000);
   }
   /**
      default values if the user inputed in values
   */
   public Person(String name, String speech, double budget) {
      this.name = name;
      this.speech = speech;
      this.budget = budget;
   }
   /**
      get the name of the person
      @return the name of the person
   */
   public String getName() {
      return name;
   }
   /**
      get if the user wants to give a speech
      @return if the user wants to give a speech
   */
   public String getSpeech() {
      return speech;
   }
   /**
      get the total cost of the items purchased
      @return the total cost of the items purchased
   */
   public double getTotalCost() {
      return totalCost;
   }
   /**
      get the budget amount
      @return the budget amount
   */
   public double getBudget() {
      return budget;
   }
   /**
      get the remaining budget left
      @return the remaining budget left
   */
   public double getRemaining() {
      return remaining;
   }
   /**
      check to see if the name can be set
      @param name the name of the person
      @return true or false if the name can be set
   */
   public boolean setName(String name) {
      if (!(name.equals(""))) {
         this.name = name;
         return true;
      }
      else {
         return false;
      }
   }
   /**
      check to see if the speech option can be set
      @param speech a yes or no answer
      @return true or false if the speech option can be set
   */
   public boolean setSpeech(String speech) {
      if (speech.equalsIgnoreCase("yes") || speech.equalsIgnoreCase("no") ) {
         this.speech = speech;
         return true;
      }
      else {
         return false;
      }
   }
   /**
      check to see if the budget can be set
      @param budget the amount that the user has inputed for their budget
      @return true or false if the budget can be set
   */
   public boolean setBudget(double budget) {
      if (budget >= 0 && budget < 2000) {
         this.budget = budget;
         return true;
      }
      else {
         return false;
      }
   }
   /**
      check to see if the total cost of all items purchased can be set
      @param itemCost the cost of a single item purhcased
      @return true or false if the total cost can be setted and calculated
   */
   public boolean setTotalCost(double itemCost) {
      if (getTotalCost() < getBudget()){
         this.totalCost += itemCost;
         return true;
      }
      else {
         return false;
      }
   }
   /**
      check to see if the remaining budget can be set
      @return true or false if the remaining budget can be setted and calculated
   */
   public boolean calculateBudgetRemaining() {
      if (getBudget() > getTotalCost()) {
         this.remaining = getBudget() - getTotalCost();
         return true;
      }
      else {
         return false;
      }
   }
}