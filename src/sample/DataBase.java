package sample;

import java.io.*;
import java.util.*;

public class DataBase {
    FileWriter fw;
    FileReader fr;
    File file = new File("C:\\Games\\text.txt");
    TreeMap<String, String > administrator = new TreeMap<String, String>();

    public void write(String key){
        try {
            File file = new File("C:\\Games\\text.txt");
            fw = new FileWriter(file, true);
            fw.write(" "+ key + " ");

            fw.close();
        } catch (IOException e) {
        }
    }
    public void adminwrite(String login, String password){
        administrator.put(login, password);
    }
    public boolean check(String key) throws IOException {
        FileInputStream fstream;
        BufferedReader  br = null;
        String keyss = null;
        try {
           fstream = new FileInputStream("C:\\Games\\text.txt");
           br = new BufferedReader(new InputStreamReader(fstream));
           keyss = br.readLine();
           br.close();
        } catch (FileNotFoundException e) {
            File file = new File("C:\\Games\\text.txt");
            try {
                file.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } fr = new FileReader("C:\\Games\\text.txt");
        String keus = null;
        boolean result;
        Scanner sc =new Scanner(fr);
        try {
            keus = sc.nextLine();
            result = (keyss.contains(" " +key + " "));
            fw = new FileWriter(file, false);
            fw.write(keus.replaceFirst(" " +  key + " ", "" ));
            fw.flush();
        }catch (NoSuchElementException e){
            result = false;
        }
        System.out.println(keus);
        return result;

    }

    public  DataBase(){
        adminwrite("rprescott", "1");
    }
}
