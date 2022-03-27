package DictionaryFeatures;

import HandleFile.FileHandler;

import java.io.*;
import java.util.*;

public class DictionaryFeature {
    public static void TimTheoSlangWord(HashMap<String, String> slangs, String pathLog) {
        try {
            System.out.println("Nhap tu slang-word ma ban muon tim?");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String slangWord = br.readLine();
            FileHandler.appendLogToFile(slangWord, pathLog);
            String definition = slangs.get(slangWord);
            if (definition != null) System.out.println("Y nghia cua " + slangWord + " la: " + definition);
            else System.out.println("Khong tim duoc y nghia thich hop cua " + slangWord);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void TimTheoDefinitions(HashMap<String, String> slangs) {
        try {
            ArrayList<String> results = new ArrayList<>(0);
            System.out.println("Nhap definition: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String definition = br.readLine();
            if (!definition.equals(" ")) {
                Set<String> keys = slangs.keySet();
                for (String key : keys) {
                    String defWithKey = slangs.get(key);
                    if (defWithKey.contains(definition)) results.add(key);
                }
            }
            if (results.size() == 0) System.out.println("Khong tim duoc slang thich hop");
            else {
                int i = 1;
                System.out.println("Slangs duoc tim thay:");
                for (String e : results) {
                    System.out.println(i + "/ " + e);
                    i++;
                }
            }

        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
    }

    public static void HienThiSlangsWordDaTim(String path) {
        try {
            ArrayList<String> slangsFound = FileHandler.importLogFormFile(path);
            if (!slangsFound.isEmpty()) {
                int i = 1;
                System.out.println("Danh sach cac slang word da tim kiem: ");
                for (String slang : slangsFound) {
                    System.out.println((i++) + "/ " + slang);
                }
            } else System.out.println("Chua co slang word nao duoc ghi lai.\n");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static HashMap<String, String> ThemSlangWord(String path, HashMap<String, String> slangs) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nhap slang: ");
            String slang = br.readLine();
            System.out.println("Nhap definition cho slang: ");
            String definition = br.readLine();
            slangs.put(slang, definition);
            FileHandler.exportDataToFile(path, slangs);
            slangs = FileHandler.importDataFromFile(path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return slangs;
    }

    public static HashMap<String, String> ChinhSuaSlangWord(String path, HashMap<String, String> slangs) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap slang word muon chinh sua: ");
            String slang = br.readLine();

            if (slangs.get(slang) != null) {
                System.out.print("Nhap definition ban muon chinh sua: ");
                String definition = new String("");
                definition = br.readLine();
                slangs.put(slang, definition);
                FileHandler.exportDataToFile(path, slangs);
                return slangs;
            }
            System.out.println("Khong tim thay slangword muon chinh sua.\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return slangs;
    }

    public static HashMap<String, String> XoaSlangWord(String path, HashMap<String, String> slangs) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap slang word muon xoa: ");
            String slang = br.readLine();
            if (slangs.containsKey(slang)) {
                System.out.print("Ban chac chan muon xoa tu nay? An 1 de tiep tuc xoa va bat ki nut nao de stop thao tac nay.");
                String _character = br.readLine();
                if ("1".equals(_character)) {
                    slangs.remove(slang);
                    FileHandler.exportDataToFile(path, slangs);
                    System.out.println("Xoa slang word thanh cong");
                } else System.out.println("Thao tac xoa da dung lai.\n");
                return slangs;
            } else System.out.println("Khong tim thay slang word muon xoa");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return slangs;
    }

    public static HashMap<String, String> KhoiPhucDanhSachGoc(String path, HashMap<String, String> slangs, String pathForWriting) {
        try {
            System.out.println("Ban co chac chan muon khoi phuc danh sach goc? ");
            System.out.println("An 1 de tiep tuc hoac bat ki nut nao khac de dung thao tac nay");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String _character = br.readLine();
            if ("1".equals(_character)) {
                slangs.clear();
                slangs = FileHandler.importDataFromFile(path);
                FileHandler.exportDataToFile(pathForWriting, slangs);
                System.out.println("Khoi phuc danh sach goc thanh cong.");
//                System.out.println("Size internal: "+slangs.size());
                return slangs;
            } else System.out.println("Thao tac khoi phuc da bi dung lai.");
        } catch (Exception e) {
            System.out.println("Khoi phuc danh sach goc khong thanh cong: " + e.toString());
        }
        return slangs;
    }

    public static boolean RandomSlangWord(HashMap<String, String> slangs) {
        try {
            Random rd = new Random();
            Object[] keys = slangs.keySet().toArray();
            String randomKey = (String) keys[rd.nextInt(keys.length)];
            System.out.println("Random slang word: " + randomKey + "`" + slangs.get(randomKey));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Khong co slangword nao duoc random ra.");
            return false;
        }
        return true;

    }

    public static boolean DoVuiRandomSlangWord(HashMap<String, String> slangs) {
        try {
            Random rd = new Random();
            Object[] keys = slangs.keySet().toArray();
            Object[] values = slangs.values().toArray();
            int randomIndexTrue = rd.nextInt(keys.length);
            //
            String val1 = (String) values[rd.nextInt(keys.length)];
            String val2 = (String) values[rd.nextInt(keys.length)];
            String val3 = (String) values[rd.nextInt(keys.length)];
            //
            String randomKey = (String) keys[randomIndexTrue];
            String trueDefinition = slangs.get(randomKey);
            List<Integer> indexs = new ArrayList<>(0);
            indexs.add(0);
            indexs.add(1);
            indexs.add(2);
            indexs.add(3);
            String[] results = new String[4];
            int rdNumberOfTrueVal = rd.nextInt(4);
            indexs.remove(rdNumberOfTrueVal);
            results[rdNumberOfTrueVal] = trueDefinition;
            //
            int rdNumberOfVal1 = -1;
            while (true) {
                rdNumberOfVal1 = rd.nextInt(4);
                if (rdNumberOfVal1 == rdNumberOfTrueVal) continue;
                else {
                    results[rdNumberOfVal1] = val1;
                    break;
                }
            }
            //
            int rdNumberOfVal2 = -1;
            while (true) {
                rdNumberOfVal2 = rd.nextInt(4);
                if (rdNumberOfVal2 == rdNumberOfTrueVal || rdNumberOfVal2 == rdNumberOfVal1) continue;
                else {
                    results[rdNumberOfVal2] = val2;
                    break;
                }
            }
            //
            int rdNumberOfVal3 = -1;
            while (true) {
                rdNumberOfVal3 = rd.nextInt(4);
                if (rdNumberOfVal3 == rdNumberOfTrueVal || rdNumberOfVal3 == rdNumberOfVal1 || rdNumberOfVal3 == rdNumberOfVal2)
                    continue;
                else {
                    results[rdNumberOfVal3] = val3;
                    break;
                }
            }
            System.out.println("Y nghia cua slangword:  " + randomKey + " la gi?");
            System.out.println("Chon 1 trong nhung dap an sau: ");
            for(int i=0;i<results.length;i++)
            {
                System.out.println(i+"/ "+results[i]);
            }
            System.out.print("Dap an cua ban la: ");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String str=br.readLine();
            String indexTrue=Integer.toString(rdNumberOfTrueVal);
            if(indexTrue.equals(str))
                System.out.println("Chuc mung ban da dung");
            else{
                System.out.println("Chuc ban may man lan sau. Dap an dung la: "+results[rdNumberOfTrueVal]);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
