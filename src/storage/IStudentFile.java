package storage;

import model.Student;

import java.io.IOException;
import java.util.List;

public interface IStudentFile {
    public List<Student> readFile() throws IOException, ClassNotFoundException;
    public void writeFile(List<Student> students) throws IOException;
}
