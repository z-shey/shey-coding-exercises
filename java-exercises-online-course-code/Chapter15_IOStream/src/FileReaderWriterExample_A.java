import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

public class FileReaderWriterExample_A {
    @Test
    public void Test() {
        File file = new File("assets/example.txt");

        // 使用 Reader 读取文件内容
        try (Reader reader = new FileReader(file)) {

            char[] buffer = new char[(int) file.length()];

            reader.read(buffer);
            System.out.println(new String(buffer));

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 使用 Writer 写入文件内容
        String content = "Hello, World!";

        try (Writer writer = new FileWriter(file)) {

            writer.write(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test2() {
        // 创建 File 对象，指定要读取的文件路径
        File file = new File("assets/example.txt");

        int length = (int) file.length(); // 获取文件长度

        Reader reader = null; // 声明一个 Reader 类型变量

        try {
            // 创建 FileReader 对象，用于读取文件内容
            reader = new FileReader(file);

            // 创建字符数组缓冲区，大小为文件长度
            char[] buffer = new char[length];

            int len = 0;

            // 不断读取字符到缓冲区，直到文件读完
            while ((len = reader.read(buffer)) != -1) {
                // 遍历缓冲区中的字符，将字符打印到控制台
                for (int i = 0; i < len; i++) {
                    System.out.print(buffer[i]);
                }
            }

        } catch (IOException e) {
            // 捕获可能抛出的 IO 异常
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 使用 Writer 写入文件内容
        String content = "Hello, World!";
        Writer writer = null;
        try {
            writer = new FileWriter(file);
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
