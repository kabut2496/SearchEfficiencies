/*
 *Karl Butler
 * 5/31/2020
 * search efficiencies
 * This program tests the efficiency of different serching algorithms
 */
package searchefficiencies;
import javax.swing.JOptionPane;
import java.util.Arrays;
/**
 *
 * @author Karl Butler
 */
public class SearchEfficiencies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//the varables gX,x and serch are used to retrive the users inputs.

        String gX;
        int x,randNum,serch;
        
       gX = JOptionPane.showInputDialog("Enter the number of randome numbers that you want");
       x=Integer.parseInt(gX);

//the array numbers is used to make the array.

       int [] numbers = new int[x];

//this for loop puts the randome numbers in the array
       
       for(int i =0; i <= x-1;i++){
           numbers[i]=(int) (Math.random()*1000);
       }
        gX = JOptionPane.showInputDialog("Enter the number you want to serch for");
        serch=Integer.parseInt(gX);
 
//calling the diffrent serch algorithms
       
         linnerSerch(numbers, serch);
         binarySearch(numbers, serch);
         sortedLinnerSerch(numbers, serch);
       
    }
/**
 * this is the binary search algorithm  
 * loop is used to count the loops in the algorithm
 * comparisons is used to count the comparisons
 * low is used to be the lowest number in the array
 * and high is the highest number in the array
 * found is used to set weather the number has been found yet
 * starTtime and endTime are used to track the time of the algorithm
 * time is the actual time
*/    
    public static void binarySearch(int[] array, int key)
    {
        Arrays.sort(array);
        int loop = 0;
        int comparisons =0;
        int low = 0;
        int high = array.length - 1;
        boolean found= false;
        long startTime = System.nanoTime();
        
        while(low <= high)
        {
            loop++;
            
            int mid = (low + high) / 2;
            
            int cur = array[mid];
            
            if(cur == key)
            {
                comparisons++;
                
                 found = true;
                break;
                
                
            }
            else if(cur < key)
            {
                comparisons=comparisons+2;
                low = mid + 1;
            }
            else
            {
                comparisons=comparisons+3;
                high = mid - 1;
            }
        }
        
        long endTime= System.nanoTime();
        long time = endTime-startTime;
        
        System.out.println("--------------------------------");
        System.out.println("preforming Binary Search");
        System.out.println("there were "+ loop + " loops");
        System.out.println("there were "+comparisons + "comparisons");
        System.out.println("search returned:"+ found);
        System.out.println("it took " +(time /1000000) + "ms to complet");
        System.out.println("--------------------------------");
        
    }
/**
 * loop is used to count the loops in the algorithm
 * comparisons is used to count the comparisons
 * boolean is weather or not the number has been found or not
 * starTtime and endTime are used to track the time of the algorithm
 * time is the actual time
 */
    public static void linnerSerch (int[] array, int key){
       int loop = 0;
       int comparisons =0;
       boolean found= false;
       long startTime = System.nanoTime();
       
        for(int i = 0; i < array.length; i++)
        {
            loop++;
            comparisons++;
            int element = array[i];
            if(element == key)   
            {
               
                found= true;
                break;
            }
    }
        long endTime= System.nanoTime();
        long time = endTime-startTime;
        
        System.out.println("preforming non sorted liner serch");
        System.out.println("there were "+ loop + " loops");
        System.out.println("there were "+comparisons + "comparisons");
        System.out.println("search returned:"+ found);
        System.out.println("it took " +(time /1000000) + "ms to complet");

    }
 /** loop is used to count the loops in the algorithm
 * comparisons is used to count the comparisons
 * boolean is weather or not the number has been found or not
 * starTtime and endTime are used to track the time of the algorithm
 * time is the actual time
 */
       public static void sortedLinnerSerch (int[] array, int key){
           
       int loop = 0;
       int comparisons =0;
       boolean found= false;
       long startTime = System.nanoTime();
       
       Arrays.sort(array);
       
        for(int i = 0; i < array.length; i++)
        {
            loop++;
            comparisons++;
            int element = array[i];
            if(element == key)   
            {
                
                found= true;
                break;
            }
    }
        long endTime= System.nanoTime();
        long time = endTime-startTime;
        
        System.out.println("preforming sorted liner serch");
        System.out.println("there were "+ loop + " loops");
        System.out.println("there were "+comparisons + "comparisons");
        System.out.println("search returned:"+ found);
        System.out.println("it took " +(time /1000000) + "ms to complet");
    }
}
    
    
