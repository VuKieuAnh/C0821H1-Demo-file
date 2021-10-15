package storage;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentReadWriteFile implements IStudentFile {
    private static StudentReadWriteFile studentReadWriteFile;
    private StudentReadWriteFile() {
    }
    public static StudentReadWriteFile getInstance(){
        if (studentReadWriteFile == null){
            studentReadWriteFile = new StudentReadWriteFile();
        }
        return studentReadWriteFile;
    }

    public List<Student> readFile() throws IOException, ClassNotFoundException {
        File file = new File("list.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            List<Student> list = (List<Student>) object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public void writeFile(List<Student> students) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("list.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(students);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}