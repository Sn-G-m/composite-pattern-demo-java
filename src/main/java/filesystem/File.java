package filesystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Returns a file object with name, type, date created and subfiles
 * as attributes.
 * */
public class File implements IFileSystemComponent {
    /** Specifies the name for the file object. */
    private final String fileName;
    /** Specifies the type for the file object. */
    private final String fileType;
    /** Specifies the date of creation for the file object. */
    private final String dateCreated;
    /** List for holding all the subfolders and files within.  */
    private List<IFileSystemComponent> subFiles;

    public File(final String fileNameParam, final String fileTypeParam, final String dateCreatedParam) {
        this.fileName = fileNameParam;
        this.fileType = fileTypeParam;
        this.dateCreated = dateCreatedParam;
        if ("folder".equals(fileTypeParam)) {
            this.subFiles = new ArrayList<>();
        }
    }

    @Override
    public void showDetails() {
        final int lineLen = 50;
        System.out.printf("=====Displaying details for %s=====\n", this.fileName);
        System.out.printf("File Name: %s\n", this.fileName);
        System.out.printf("File Type: %s\n", this.fileType);
        System.out.printf("Date of creation: %s\n", this.dateCreated);
        if ("folder".equals(this.fileType)) {
            System.out.printf("Number of items within(immediately inside): %s\n\n", this.subFiles.size());
            System.out.printf("-----Details for files inside %s-----\n", this.fileName);
            for (IFileSystemComponent subFile : this.subFiles) {
                subFile.showDetails();
            }
            System.out.printf("%s\n", "-".repeat(lineLen));
        }
        System.out.printf("%s\n", "=".repeat(lineLen));
    }

    @Override
    public void addFile(final IFileSystemComponent file) {
        if ("folder".equals(this.fileType)) {
            this.subFiles.add(file);
            System.out.printf("%s added to %s folder successfully...\n", file, this.fileName);
        } else {
            System.out.printf("Operation failed with exit code 2, %s is not a directory\n", this.fileName);
        }
    }
}
