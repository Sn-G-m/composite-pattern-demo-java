package controller;

import filesystem.File;
import filesystem.IFileSystemComponent;

/**
 * Entry point for the file-system simulation.
 * */
public class Program {
    /**
     * Main function for the startup program.
     * @param args Empty command line arguments.
     */
    public static void main(final String[] args) {
        final IFileSystemComponent root = new File("composite-pattern-demo-java", "folder", "24 Aug 2025");
        final IFileSystemComponent javaDirectory = new File("java", "folder", "25 Aug 2025");
        final IFileSystemComponent readMe = new File("readMe", "markdown", "26 Aug 2025");
        final IFileSystemComponent programFile = new File("program", "java", "27 Aug 2025");

        root.addFile(javaDirectory);
        root.addFile(readMe);
        javaDirectory.addFile(programFile);
        root.showDetails();
    }

}
