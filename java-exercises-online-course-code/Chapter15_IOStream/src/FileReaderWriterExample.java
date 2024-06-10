import org.junit.Test;

import java.io.*;

public class FileReaderWriterExample {
    @Test
    public void fileTest1() {
        File file1 = new File("assets");
        File file2 = new File("assets/test.png");
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file2.getAbsoluteFile());
    }

    @Test
    public void fileTest2() {
        File file1 = new File("assets", "test.txt");
        File file2 = new File("assets", "test");
        File file3 = new File(file2, "test.txt");

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file2.getAbsoluteFile());
        System.out.println(file3.getAbsoluteFile());
    }

    @Test
    public void fileTest3() {
        FileReader fr = null;

        try {
            File file = new File("assets", "hello.txt");

            fr = new FileReader(file);

//            int data = 0;
//            while ((data = fr.read()) != -1) {
//                System.out.print((char) data);
//            }

            char[] cBuff = new char[20];
            int len = 0;
            while ((len = fr.read(cBuff)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(cBuff[i]);
                }
            }
            /*
            创建了一个长度为20的字符数组cBuff，用于存储从输入流中读取到的字符数据。
            然后，通过fr对象的read方法，将字符数据读取到cBuff数组中，并返回实际读取到的字符数量len。
            接下来，通过一个while循环，判断len的值是否为-1，如果不是-1，则表示还有字符可以读取。在循环内部，使用for循环遍历cBuff数组中的元素，
            并使用System.out.print方法将字符逐个输出。整体上，该段代码的作用是将字符流中的内容读取并逐个打印输出。
             */

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    @Test
    public void fileTest4() {
        FileWriter fw = null;
        try {
            File file = new File("assets", "info.txt");
            fw = new FileWriter(file, true); // 追加模式
            fw.write("sdagvsdfgbxdf\n");
            fw.write("sdgbxdf\n");
            fw.write("sdagvxdf\n");

            System.out.println("输出成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void fileTest5() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            File srcFile = new File("assets", "hello.txt");
            File destFile = new File("assets", "info.txt");

            fileReader = new FileReader(srcFile);
            fileWriter = new FileWriter(destFile, true);

            char[] cBuffer = new char[50];
            int len = 0;
            while ((len = fileReader.read(cBuffer)) != -1) {
                fileWriter.write(cBuffer, 0, len);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileReader != null && fileWriter != null) {
                    fileReader.close();
                    fileWriter.close();

                    // 在finally块中重命名目标文件
                    File destFile = new File("assets", "info.txt");
                    File newFile = new File("assets", "put.txt");
                    boolean success = destFile.renameTo(newFile);
                    if (!success) {
                        throw new RuntimeException("failed to rename file: " + destFile.getAbsolutePath());
                    }
                }
            } catch (IOException e) {
                e.getMessage();
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) {
        File file1 = new File("assets");
        File file2 = new File("assets/test.png");
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file2.getAbsoluteFile());
    }
}
