package Index;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Search {
    public static String txtString(File file) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static int search(String pat, String txt) {
        int local = 1;
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= (N - M); i++) {
            if (txt.charAt(i) == ' ')
                local++;
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            }
            if (j == M)
                return local + 1;
        }
        return N;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File file = new File("txt.txt");
        String txt = txtString(file);
        int n = 0;
        try {
            FileReader fr = new FileReader("pat.txt");
            BufferedReader br = new BufferedReader(fr);
            String pat;
            while ((pat = br.readLine()) != null) {
                int local = search(pat, txt);
                if (local == txt.length()) {
                    System.out.println("--" + pat);
                } else
                    System.out.println(local + "  " + pat);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
