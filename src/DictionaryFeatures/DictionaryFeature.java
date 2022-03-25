package DictionaryFeatures;
import HandleFile.FileHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class DictionaryFeature {
    public static void TimTheoSlangWord(HashMap<String,String> slangs,String pathLog){
        try {
            System.out.println("Nhap tu slang-word ma ban muon tim?");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String slangWord=br.readLine();
            FileHandler.appendLogToFile(slangWord,pathLog);
            String definition=slangs.get(slangWord);
            if(definition!=null)
                System.out.println("Y nghia cua "+slangWord+" la: "+definition );
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
            System.out.println(ioe.toString());
        }
    }
    public static void HienThiSlangsWordDaTim(String path){
        try{
            ArrayList<String> slangsFound=FileHandler.importLogFormFile(path);
            if(!slangsFound.isEmpty())
            {
                int i=1;
                System.out.println("Danh sach cac slang word da tim kiem: ");
                for(String slang: slangsFound){
                    System.out.println((i++)+"/ "+slang);
                }
            }
            else
                System.out.println("Chua co slang word nao duoc ghi lai.\n");
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public static HashMap<String,String> ThemSlangWord(String path,HashMap<String,String> slangs){
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nhap slang: ");
            String slang=br.readLine();
            System.out.println("Nhap definition cho slang: ");
            String definition=br.readLine();
            slangs.put(slang,definition);
            FileHandler.exportDataToFile(path,slangs);
            slangs=FileHandler.importDataFromFile(path);
        }catch (IOException ioe){
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return slangs;
    }
    public static HashMap<String,String> ChinhSuaSlangWord(String path,HashMap<String,String> slangs){
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap slang word muon chinh sua: ");
            String slang=br.readLine();

            if(slangs.get(slang)!=null)
            {
                System.out.print("Nhap definition ban muon chinh sua: ");
                String definition=new String("");
                definition=br.readLine();
                slangs.put(slang,definition);
                FileHandler.exportDataToFile(path,slangs);
                return slangs;
            }
            System.out.println("Khong tim thay slangword muon chinh sua.\n");
        } catch (Exception e){
            e.printStackTrace();
        }
        return slangs;
    }
}
