package util;

import exeptions.NotReadFileException;
import org.junit.Test;

public class ReaderFileTest {

    @Test(expected = NotReadFileException .class)
    public void readFileSuccess() throws NotReadFileException {
        String filePath = "Data1.txt"; //file Data1.txt doesn't exist
        ReaderFile.readFile(filePath);
    }
    @Test
    public void readFileNotSuccess() throws NotReadFileException {
        String filePath = "Data.txt";
        ReaderFile.readFile(filePath);
    }
}