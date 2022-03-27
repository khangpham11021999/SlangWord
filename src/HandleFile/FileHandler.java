package HandleFile;

import java.io.*;
import java.util.*;

public class FileHandler {
    public static HashMap<String, String> importDataFromFile(String path) {
        HashMap<String, String> slangs = new HashMap<>();
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            String line0 = bf.readLine();
            String line;
            ArrayList<String> errors = new ArrayList<>(0);//check errors
            while ((line = bf.readLine()) != null) {
                String[] obj = line.split("`");
                if (obj.length < 2)//line is failed to split
                    errors.add(line);
                else
                    slangs.put(obj[0], obj[1]);
            }
            if (errors.size() > 0) {
                System.out.println("Number of errors: " + errors.size());
                for (String e : errors)
                    System.out.println(e);
            }
            bf.close();
        } catch (IOException ioe) {
            System.out.println("Exception when import data from file: " + ioe.toString());
        }
        return slangs;
    }

    public static boolean exportDataToFile(String path, HashMap<String, String> slangs) throws Exception {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path));
            Set<String> keys = slangs.keySet();
            Iterator<String> i = keys.iterator();
            bw.write("Slag`Meaning");
            bw.write("\r\n");
            while (i.hasNext()) {
                String keyCur = i.next();
                bw.write(keyCur + "`" + slangs.get(keyCur));
                bw.write("\r\n");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            System.out.println("Ghi du lieu khong thanh cong.");
            return false;
        } finally {
            if (bw != null)
                bw.close();
        }
        return true;
    }

    public static ArrayList<String> importLogFormFile(String path) {
        ArrayList<String> slangsFound = new ArrayList<String>(0);
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = new String("");
            while ((line = br.readLine()) != null) {
                slangsFound.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return slangsFound;
    }

    public static boolean appendLogToFile(String slang, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
            bw.write(slang);
            bw.write("\r\n");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println("Khong co log duoc ghi lai");
            return false;
        }
        return true;
    }
}
