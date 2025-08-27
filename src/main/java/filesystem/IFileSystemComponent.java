package filesystem;

/**
 * Interface for the file-system.
 */
public interface IFileSystemComponent {
    void addFile(IFileSystemComponent file);

    void showDetails();
}
