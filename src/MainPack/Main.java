package MainPack;
class Menu{
    public static void PrintMenu(){
        String cat1="1.Tim kiem theo slang word\n";
        String cat2="2.Tim kiem theo definition, hien thi tat ca cac slang words trong definition co chu keyword go vao\n";
        String cat3="3.Hien thi history, danh sach cac slang-word da tim kiem\n";
        String cat4="4.Them 1 slang word\n";
        String cat5="5.Chinh sua 1 slang word\n";
        String cat6="6.Xoa 1 slang word\n";
        String cat7="7.Reset lai danh sach\n";
        String cat8="8.Random 1 slang word\n";
        String cat9="9.Do vui: Hien 1 slang word -> doan nghia cua slang word do\n";
        String cat10="10.Do vui: Hien 1 definition -> doan slang word cuar no\n";
        String categories=cat1+cat2+cat3+cat4+cat5+cat6+cat7+cat8+cat9+cat10;
        System.out.println("Chon 1 chuc nang:\n"+categories);
    }
}
public class Main {
    public static  void main(String[]args){
        Menu.PrintMenu();
    }
}
