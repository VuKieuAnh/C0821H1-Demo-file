package storage;

import model.Student;

import java.io.IOException;
import java.util.List;

public class StudentFileExcel implements IStudentFile {
    @Override
    public List<Student> readFile() throws IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public void writeFile(List<Student> students) throws IOException {

    }
}
