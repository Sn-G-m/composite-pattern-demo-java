package filesystem;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    IFileSystemComponent testRoot = new File("root", "folder", "24 Jun 2025");
    IFileSystemComponent testFile = new File ("sample", "text", "25 Jul 2025");
    IFileSystemComponent testSrc = new File ("src", "folder", "26 Jul 2025");

    @Test
    void testShowDetailsSingle() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        testSrc.showDetails();
        String expectation = """
                File Name: src, File Type: folder, Date of creation: 26 Jul 2025
                0 items found \
                within src, displaying sub-file details
                src contents printed successfully...
                """;
        assertEquals(expectation, os.toString());
    }

    @Test
    void testShowDetailsRecursive() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        testSrc.addFile(testFile);
        testSrc.showDetails();
        String prologue = "New file added to src folder successfully...\n";
        String srcString = "File Name: src, File Type: folder, Date of creation: 26 Jul 2025\n1 items found within src, displaying sub-file details\n";
        String fileString = "File Name: sample, File Type: text, Date of creation: 25 Jul 2025\n";
        String epilogue = "src contents printed successfully...\n";
        String expectation = prologue + srcString + fileString + epilogue;
        assertEquals(expectation, os.toString());
    }

    @Test
    void testAddFileToFolder() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        testSrc.addFile(testFile);
        assertEquals("New file added to src folder successfully...\n", os.toString());
    }

    @Test
    void testAddFileToFile() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        testFile.addFile(testRoot);
        assertEquals("Operation failed with exit code 2, sample is not a directory\n", os.toString());
    }
}