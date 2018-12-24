package servise.util.fileRead;

import exeption.NotReadFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderFile {
    private static final Logger logger = LogManager.getLogger(ReaderFile.class);
    public static List<String> readFile(String filePath) throws NotReadFileException {
        List<String> lines = new ArrayList<String>();
        Path path = Paths.get(filePath);
        try (Stream<String> lineStream = Files.lines(path, StandardCharsets.UTF_8)){
        lines = lineStream.collect(Collectors.toList());
            logger.info("file has been read");
        }
        catch (IOException e){
            logger.error("unsuccessful read of file");
            throw new NotReadFileException("unsuccessful read of file",e);
        }
        return lines;
    }

}
