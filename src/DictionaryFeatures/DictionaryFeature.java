package DictionaryFeatures;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class DictionaryFeature {
    public static void TimTheoSlangWord(HashMap<String,String> slangs){
        try {
            System.out.println("Nhap tu slang-word ma ban muon tim?");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String slangWord=br.readLine();
            String definition=slangs.get(slangWord);
            if(definition!=null)
                System.out.println("Y nghia cua "+slangWord+"la: "+definition );
            else
                System.out.println("Khong tim duoc y nghia thich hop cua "+slangWord);

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public static void TimTheoDefinitions(HashMap<String,String> slangs){
        try {
            ArrayList<String> results=new ArrayList<>(0);
            System.out.println("Nhap definition: ");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String definition=br.readLine();
            if(!definition.equals(" ")){
                Set<String> keys=slangs.keySet();
                for(String key:keys){
                    String defWithKey=slangs.get(key);
                    if(defWithKey.contains(definition))
                        results.add(key);
                }
            }
           if(results.size()==0)
               System.out.println("Khong tim duoc slang thich hop");
           else{
               int i=1;
               System.out.println("Slangs duoc tim thay:");
               for(String e:results){
                   System.out.println(i+"/ "+e);
                   i++;
               }
           }

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
