import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.List;
import java.io.FileNotFoundException;

/**
 * Write a description of class CatchingPlagarists here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */








public class CatchingPlagaristsTest
{
  
 //public void Directory()
    //{
     
     
   
     
     public static void main( String[] args) 
        throws FileNotFoundException
        {
        CopyOfCatchingPlagarists CP = new CopyOfCatchingPlagarists();
            
            Scanner scan = new Scanner(System.in);  // Create a Scanner object
       System.out.println("Enter which document set you would like to use.");
       
         System.out.println("1.) " + CP.directories().get(0).getName());
         System.out.println("2.) " + CP.directories().get(1).getName());
         System.out.println("3.) " + CP.directories().get(2).getName());
         
           
       
        int docList = scan.nextInt(); 
       
       while(docList > 3)
       {
           System.out.println("please input a valid document list");
           docList = scan.nextInt();
       }
       
       
       System.out.println ("please input how many words your plagarized phrases will be. ");
       
      int numWords = scan.nextInt();
        
       System.out.println ( "How many matches constitute plagarism? ");
       
       int hits = scan.nextInt();
      
    CP.continuous( docList, numWords);
    
         CP.FindHits(hits);
         for (int i = 0; i < CP.finalsName.size(); i++)
         {
            System.out.println(CP.finals.get(CP.finalsName));
            }
         
          //for(int i = 0; i < CP.pathnames.size(); i++){ System.out.println(CP.fileDir.get(CP.pathnames.get(i)));}
           // CP.Sort();
            // CP.toString();
            // System.out.println(CP.finalsName);
       // System.out.println(directories);
          
          // Create a File object.
            /* String directory = CP.directories.get(docList-1).getName();
             
             File fdir = new File(directory);
            String[] temp = fdir.list();
         for(int i = 0; i < temp.length; i++)
             {
                if(temp[i].endsWith(".txt")) CP.files.add(temp[i]);
        }
           
        String pathName = ("./"+directory +"/"+ files.get(0));
           
         
        Scanner file = new Scanner(new File(pathName));
        if (pathName != pathName) { // It's not there!
              throw new FileNotFoundException("Could not find file: " + pathName);
            }
            
   
      
     
   
 
List<String> phrases = new ArrayList<String>();
        
         while(file.hasNext())
         {
              String phrase = "";
              
           // read 'numWords' words from file 
           for(int j = 0; j < numWords; j++) {
               if(file.hasNext()){
              // strip away all punctuation, and set to lowercase
                phrase += file.next().replaceAll("[^A-z]","").toLowerCase(); 
             }
              else
             phrase = null; // not enough words at end of file
              }
              if(phrase != null )
                 {  phrases.add(phrase);
                   System.out.println(phrase);
                }
                 
           
           
        
              }
            //  System.out.println(phrases);      
}       
//public ArrayList<File> directories()
     //{
         
            
         
    //     return directories;
    // }
//public List<String> fileList()
// {
                
       
   //  }
//public String pathName() throws FileNotFoundException
   //  {
           
            
    
          
  //            return pathName;
  //   }
//public List<String> contiguous() throws FileNotFoundException
   //  {
         
         
        //      return phrases;
   //  }
       */

}
}