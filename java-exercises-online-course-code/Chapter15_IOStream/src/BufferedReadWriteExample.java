import org.junit.Test;

import java.io.*;

public class BufferedReadWriteExample {
    //    缓存流 加个 buffer
    @Test
    public void Test() {
        File sourceFile = new File("path/to/source.txt");
        File targetFile = new File("path/to/target.txt");

        // Java7中出现了一个新特性叫做“自动资源管理”（Automatic Resource Management，ARM）
        // “try-with-resources”语句，它是一种更加简洁的处理流关闭的方式。
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(targetFile);
             BufferedInputStream bis = new BufferedInputStream(fis);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            int data;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test2() throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            fileInputStream = new FileInputStream("assets/file.txt");
            fileOutputStream = new FileOutputStream("assets/output.txt");

            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            int len = 0;

            while ((len = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            }
        }
    }


    @Test
    public void Test3() throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileReader = new FileReader("assets/file.txt");
            fileWriter = new FileWriter("assets/output.txt");

            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.flush();
                bufferedWriter.close();
            }
        }
    }



}
