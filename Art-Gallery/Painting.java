public class Painting {
   //instance variables of a painting object
   private String paintingName;
   private String artistName;
   private String paintedGMU;
   private double totalArea;
   private double totalCost;
   public static final double MAX_AREA = 36.0;
   public static final double MIN_AREA = 0;
   public static final double PAINTING_COST_NONGMU_STUDENT = 26.0;
   public static final double PAINTING_COST_GMU_STUDENT = 16.0;
   public static int numOfPaintings = 0;
   public static double lastBarcodeAssigned;
   /**
      default values if the user inputed in nothing
   */
   public Painting() {
      //need a default constructor
      lastBarcodeAssigned += 100;
      ++numOfPaintings;
   }
   /**
      get the name of the painting
      @return the name of the painting
   */
   public String getPaintingName() {
      return this.paintingName;
   }
   /**
      get the name of the artist
      @return the name of the artist
   */
   public String getArtistName() {
      return this.artistName;
   }
   /**
      get whether or not the painting was painted by a gmu student
      @return whether or not the painting was painted by a gmu student
   */
   public String getPaintedGMU() {
      return this.paintedGMU;
   }
   /**
      get the total area of the painting
      @return the total area of the painting
   */
   public double getTotalArea() {
      return this.totalArea;
   }
   /**
      get the total cost of the painting
      @return the total cost of the painting
   */
   public double getTotalCost() {
      return this.totalCost;
   }
   /**
      get barcode of the painting
      @return the barcode of the painting
   */
   public static double getBarcode() {
      return lastBarcodeAssigned;
   }
   /**
      get the number of paintings
      @return the number of paintings
   */
   public static int getNumOfPaintings() {
      return numOfPaintings;
   }
   /**
      set the naem of the painting
      @param paintingName the name of the painting
   */
   public void setPaintingName(String paintingName) {
      this.paintingName = paintingName;
   }
   /**
      set the naem of the artist
      @param artistName the name of the artist
   */
   public void setArtistName(String artistName) {
      this.artistName = artistName;
   }
   /**
      check to see whether or not a gmu student painted the painting can be set
      @param decision a yes or no anser
      @return true or false whether or not a gmu student painted the painting can be set
   */
   public boolean setPaintedGMU(String decision) {
      if(decision.equalsIgnoreCase("yes") || decision.equalsIgnoreCase("no")) {
         this.paintedGMU = decision;
         return true;
      }
      else {
         return false;
      }
   }
   /**
      check to see if the total area can be set
      @param totalArea the total area of the painting
      @return true or false to see if the total area can be set
   */
   public boolean setTotalArea(double totalArea) {
      if(totalArea > MIN_AREA && totalArea <= MAX_AREA) {
         this.totalArea = totalArea;
         return true;
      }
      else {
         return false;
      }
   }
   /**
      calculate the total cost of the painting
   */
   public void setTotalCost(String decision) {
      if(getPaintedGMU().equalsIgnoreCase("yes")) {
         this.totalCost += PAINTING_COST_GMU_STUDENT + getTotalArea();
      }
      else if(getPaintedGMU().equalsIgnoreCase("no")) {
         this.totalCost += PAINTING_COST_NONGMU_STUDENT + getTotalArea();
      }
   }
}