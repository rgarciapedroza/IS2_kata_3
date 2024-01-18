import java.io.*;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;

public class FileStudentLoader implements StudentLoader{
    private final File file;

    public FileStudentLoader(File file) {
        this.file = file;
    }

    @Override
    public List<Student> load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            return reader.lines().skip(1).map(this::toStudent).collect(toList());
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private Student toStudent(String line) {
        String[] student = line.split(",");
        return new Student(
                parseInt(student[0]),
                student[1],
                Double.parseDouble(student[2]),
                Double.parseDouble(student[3])
        )
    }
}
