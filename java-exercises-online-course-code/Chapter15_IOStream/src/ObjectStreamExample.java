import org.junit.Test;

import java.io.*;

public class ObjectStreamExample {
    @Test
    public void Test1() throws IOException {
        File file = new File("assets/object.data");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        oos.writeUTF("hello world");
        oos.flush();

        oos.writeObject("assasfhaisfbhiabsf");
        oos.flush();

        oos.close();
    }

    @Test
    public void Test2() throws IOException, ClassNotFoundException {
        File file = new File("assets/object.data");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        System.out.println(ois.readUTF());

        while (true) {
            try {
                String str = (String) ois.readObject();
                System.out.println(str);
            } catch (EOFException e) {
                break;
            }
        }

        ois.close();
    }

    @Test
    public void Test3() throws IOException {
        File file = new File("assets/object_person.data");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        Person person = new Person("john", 12);
        oos.writeObject(person);
        oos.flush();

        oos.close();
    }

    @Test
    public void Test4() throws IOException, ClassNotFoundException {
        File file = new File("assets/object_person.data");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        Person person = (Person) ois.readObject();
        System.out.println(person);

        ois.close();
    }

}
