package MainPack;

import DictionaryFeatures.DictionaryFeature;
import HandleFile.FileHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Menu{
    public static int PrintMenu(){
        String cat1="1.Tim kiem theo slang word\n";
        String cat2="2.Tim kiem theo definition, hien thi tat ca cac slang words trong definition co chu keyword go vao\n";
        String cat3="3.Hien thi history, danh sach cac slang-word da tim kiem\n";
        String cat4="4.Them 1 slang word\n";
        String cat5="5.Chinh sua 1 slang word\n";
        String cat6="6.Xoa 1 slang word\n";
        String cat7="7.Reset lai danh sach\n";
        String cat8="8.Random 1 slang word\n";
        String cat9="9.Do vui: Hien 1 slang word -> doan nghia cua slang word do\n";
        String cat10="10.Do vui: Hien 1 definition -> doan slang word cua no\n";
        String categories=cat1+cat2+cat3+cat4+cat5+cat6+cat7+cat8+cat9+cat10;
        System.out.println("------------------------------------------------");
        System.out.println("Danh sach cac lua chon:\n"+categories);
        System.out.print("Nhap lua chon cua ban: ");
        int choice=-1;
        while(true){
            try{
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                choice=Integer.parseInt(br.readLine().toString());
                break;
            }
            catch (Exception e){
                System.out.println("Lua chon khong hop le. Nhap lai!");
            }
        }
        return choice;
    }
    public static boolean isContinue(){
        try{
            String str="Ban co muon tiep tuc chuong trinh? An 1 de tiep tuc hoac bat ki nut nao de ket thuc.";
            System.out.println(str);
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            if("1".equals(br.readLine()))
                return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
public class Main {
    public static  void main(String[]args){
        String backupPath=".\\src\\Data\\backup.txt";
        String pathForReadingAndWriting=".\\src\\Data\\slang.txt";
        String pathTemp=".\\src\\Data\\temp.txt";
        try {
            HashMap<String, String> slangs = FileHandler.importDataFromFile(pathForReadingAndWriting);
//            System.out.println("Nums of data: "+slangs.size());
            boolean isContinue = true;
        while(isContinue){
            isContinue=false;
            int choice=Menu.PrintMenu();
            switch (choice){
                case 1:
                    DictionaryFeature.TimTheoSlangWord(slangs);
                    isContinue=Menu.isContinue();
                    break;
                case 2:
                    System.out.println("case 2");
                    isContinue=Menu.isContinue();
                    break;
                case 7://backup: confirm? and only root data is keeping
                    isContinue=Menu.isContinue();
                    break;
                default:
                    System.out.println("Case default");
                    break;
            }
        }

//            boolean checkWriting = FileHandler.exportDataToFile(pathTemp, slangs);
            System.out.println("Chuong trinh ket thuc. Xin cam on\n");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
