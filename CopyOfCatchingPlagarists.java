import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * Write a description of class CopyOfCatchingPlagarists here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CopyOfCatchingPlagarists
{
    // instance variables - replace the example below with your own
    ArrayList<File> directories;
    List<String> files = new ArrayList<String>();
    HashSet phrases = new HashSet();
    String pathName;
    Scanner file;
    HashMap<String, HashSet > fileDir = new HashMap(files.size());
    List<String> pathnames = new ArrayList<String>();
    List<String> finalsName = new ArrayList<String>();
    HashMap<String, Integer> finals = new HashMap(finalsName.size());
    List<String> fin = new ArrayList<String>();
     String tempName = " ";

    public ArrayList<File> directories(){
        File dir = new File(".");
        directories = new ArrayList<File>();
        for(File folder : dir.listFiles())
            if(folder.isDirectory()) directories.add(folder);
        return directories;
    }

    public void continuous(int docList, int numWords) throws FileNotFoundException
    {
        String Iterate;
        String directory = directories.get(docList-1).getName();

        File fdir = new File(directory);
        String[] temp = fdir.list();
        for(int i = 0; i < temp.length; i++)
        {
            if(temp[i].endsWith(".txt")) files.add(temp[i]);
        }
        for(int k = 0; k < files.size(); k ++)
        {
            pathName = ("./"+ directory +"/"+ files.get(k)); 
             pathnames.add(pathName);
             
            if( tempName != pathName && !tempName.equals(" "))
              {
                fileDir.put(tempName, phrases);                
              }
             tempName = pathName;
           phrases.clear();
            file = new Scanner(new File(pathName));
            if (pathName != pathName) { // It's not there!
                throw new FileNotFoundException("Could not find file: " + pathName);
            }
            for(int p = 0; p < numWords; p++)
            {   
                if (p+1 == 1){ Iterate(numWords, file); file = new Scanner(new File(pathName));}
                if(p+1 == 2 && file.hasNext() ){Iterate = file.next();Iterate(numWords, file);file = new Scanner(new File(pathName));}
                if(p + 1 == 3 && file.hasNext()){ Iterate = file.next(); Iterate = file.next() ;Iterate(numWords, file);file = new Scanner(new File(pathName));}
                if(p+1 == numWords && file.hasNext()){Iterate = file.next(); Iterate = file.next(); Iterate = file.next() ;Iterate(numWords, file);file = new Scanner(new File(pathName));
                }
            }

        }            

        
    }

    public void Iterate(int numWords, Scanner file)
    {
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
                    phrase = null; 

                //j = count;
                // not enough words at end of file

            }
            if(phrase != null )
            {  

                phrases.add(phrase);
            }

           
        }
        
    }

    public void FindHits( int ConstituteHits)
    {
        for( int first = 0; first < fileDir.size(); first++) // iterates through hashmap
        {
          int count = first+1;
            if(count < pathnames.size() ){count = first+1;}
            for(int second = count; second < pathnames.size()-1; second++) // goes through pathnames 
          {
             if ( (intersection(fileDir.get(pathnames.get(first)), fileDir.get(pathnames.get(second))) >= ConstituteHits) )
             {  
              finals.put(pathnames.get(first)+ "  :  " + pathnames.get(second) + "  =  ", intersection(fileDir.get(pathnames.get(first)), fileDir.get(pathnames.get(second))));
              
           }
           finalsName.add(pathnames.get(first)+ ":" + pathnames.get(second) + " = ");
        }
        //nested for loop for files 
        // find intersection of hashsets 
        // find size of intersection 
        //size = hits
          //put file name 1 and file name 2 , hits        
         
         
    }
    
}
    public int intersection( Set<String> c1, Set<String> c2)
    {
        int count = 0;
            for (String phrase : c2)
            {
                if (c1.contains(phrase))
                {
                    count++;
                }
            }
        
        
      
        
        
        
        
        
             return count;
    }
   
    public void Sort( )
    {
      int temp = 10;
      String to = "";
        for(int k = 0; k < finalsName.size(); k++){
         int count = k+1;
        for ( int f = count; f < finalsName.size() ; f++)
       {
           if(temp >= 10  && finals.get(finalsName.get(f)) > temp)
           {
             temp = finals.get(finalsName.get(f));
             to = finalsName.get(f);
           }
           else if( temp >= 10 && finals.get(finalsName.get(k)) > temp)
           {
               temp = finals.get(finalsName.get(k));
              to = finalsName.get(k); 
           }
           
            finals.remove(to);
            
            }
       }
       fin.add(to + temp);
       
       
        //take hashmap of files itterate through with nest forloop
        // whichever value is greater save as temp
        // compare temp to rest of values
        // if temp is less than replace with other value
        //when finished with first part add to arrayList 
        //remove temp from Hashmap
    }
    
    public String toString()
    {
        //print arraylist of hit counts
        for (int g = 0; g < fin.size(); g++)
        {
         System.out.println(fin.get(g));
    }
    return "end of program.";
}
}
