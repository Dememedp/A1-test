package Supplies;

import java.io.*;
import java.util.HashMap;

public class SupMain {
    public static void main(String[] args) {
        System.out.println(readLogin());
        System.out.println(readPost());
        addPost();
    }

    public static String readLogin(){
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File("resources/logins.csv");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                sb.append(line + '\n');
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static HashMap findAuth(String text){
        HashMap<String, String> authMap = new HashMap<>();
        String[] arr = text.split(",\\t");
        for (int i = 1; i < arr.length; i+=4){
            authMap.put(arr[i], arr[i+1]);
        }
        return authMap;
    }

    public static String readPost(){
        StringBuilder sb = new StringBuilder();
        String[] numArray;
        try {
            File file = new File("resources/postings.csv");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                numArray = line.split(";");
                sb.append(numArray[0]).append("\n");
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void addPost(){
        StringBuilder sb = new StringBuilder();
        HashMap authMap = findAuth(readLogin());
        String name;
        try {
            File file = new File("resources/postings.csv");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            sb.append(line);
            sb.append(";\tAuth.Post\n");
            line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                sb.append(line);
                name = line.split(";")[9].trim();
                if (authMap.containsKey(name)){
                    if (authMap.containsValue("true")){
                        sb.append(";\ttrue");
                    }
                } else{
                    sb.append(";\tfalse\n");
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
    }
}
