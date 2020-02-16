package file.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileUtilsTest {
    private final int NUMBER_OF_LINES = 3;
    final String pathToFile = getClass().getResource("/files.utils/file.txt").getPath();
    private final String firstLine = "Ala ma kota kot ma Ale";

    @Test
    protected void testIfNumberOfLineAreEquals() {
        String fileContent = FileTool.getFileContent(pathToFile);
        String[] split = fileContent.split("\n");
        System.out.println(split.length);
        Assertions.assertEquals(NUMBER_OF_LINES, split.length);
    }

    @Test
    protected void howDoesSplitWorks() {
        String textToSplit = pathToFile;
        System.out.println(pathToFile);
        String[] split = textToSplit.split("/");

    }

    @Test
    protected void sameLine() {
        String fileContent = FileTool.getFileContent(pathToFile);
        String[] split = fileContent.split("\n");
        Assertions.assertEquals(firstLine, split[0]);
    }


}
