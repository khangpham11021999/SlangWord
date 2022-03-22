package HandleFile;
import Dictionary.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileHandler {
    public static HashMap<String,String> importDataFromFile(String path){
        HashMap<String,String> slangs=new HashMap<>();
        List<String> lines=new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            String line0=bf.readLine();
            String line;
            ArrayList<String> errors=new ArrayList<>(0);//check errors
            while((line=bf.readLine())!=null) {
                String[] obj=line.split("`");
                if(obj.length<2)//line is failed to split
                    errors.add(line);
                else
                    slangs.put(obj[0],obj[1]);
            }
            if(errors.size()>0) {
                System.out.println("Number of errors: " + errors.size());
                for(String e:errors)
                    System.out.println(e);
            }
            bf.close();
        }catch (IOException ioe){
            System.out.println("Exception when import data from file: "+ioe.toString());
        }
        return slangs;
    }
    public static void exportDatatoFile(String path,ArrayList<String> slangs){
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter(path,true));

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
