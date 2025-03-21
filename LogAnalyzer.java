/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 * 
 * 1. day 18 is the busiest by 237
 * 2. private String[] people;
 *      people = new Person[];
 * 3. private int[] variant;
 *      variant = new boolean[];
 * 4. theres hourCounts in ever method except the printData at the end
 * 5. int[] counts; 
 *    boolean[] occupied;
 * 6. double[] readings;
 *      readings = new double[60];
 *    Sring[] urls;
 *      urls = new string[90];
 *    TicketMachine[] machines;
 *      machines = new TicketMachine[5];
 * 7. 20
 * 8. double[] prices = new double[50]; its [] not ()
 * 9. it opens the editior but it still prints with the correct information
 * 
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    private String[] logFile;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    
    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        //reader = new LogfileReader();
        reader = new LogfileReader(filename);
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        /**for(int hour = 0; hour < hourCounts.length; hour++) {
        *    System.out.println(hour + ": " + hourCounts[hour]);
        }*/
        
        int hour = 0;
        while(hour < hourCounts.length)
        {
            System.out.println(hour + ": " + hourCounts[hour]);
            hour++;
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    /**
     * Question 11
     * Print all the values in the marks array that are greater than mean.
     * @param marks An array of mark values.
     * @param mean The mean (average) mark. */ 
    public void printGreater(double mean) {
        double[] marks = {1.1, 5.7, 6.6, 9.2, 10.4};
        for(int index = 0; index < marks.length; index++) {
           if(marks[index] > mean){ 
               System.out.println(marks[index]);
          }
       }    
     }
     
    /** 
     * Question 13
     * Return the number of accesses recorded in the log file. */
    public int numberOfAccesses() {
        int total = 0;
        for(int counts : hourCounts){
            total +=counts;
        }
        // Add the value in each element of hourCounts to // total. ...
        return total;
    }
}
