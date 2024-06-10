import org.junit.Test;

import java.io.*;

public class EncodingConversionExample {
    @Test
    public void Test() throws IOException {
        File file = new File("assets/GBK.txt");
//        File file = new File("assets/UTF8.txt");

        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "gbk");

        char[] cBuffer = new char[1024];
        int len = 0;
        while ((len = isr.read(cBuffer)) != -1) {
            String str = new String(cBuffer, 0, len);
            System.out.println(str);
        }

        isr.close();
    }

    @Test
    public void Test1() throws IOException {
        File GBKfile = new File("assets/GBK.txt");
        File UTF8file = new File("assets/GBK_TO_UTF8.txt");

        FileInputStream fis = new FileInputStream(GBKfile);
        InputStreamReader isr = new InputStreamReader(fis, "gbk");

        FileOutputStream fos = new FileOutputStream(UTF8file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
        
        char[] cBuffer = new char[1024];
        int len = 0;
        while ((len = isr.read(cBuffer)) != -1) {
            osw.write(cBuffer, 0, len);
        }

        osw.close();
        isr.close();
    }
}
