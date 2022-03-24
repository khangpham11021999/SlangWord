package DictionaryFeatures;
import java.io.*;
import java.util.HashMap;

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
}
