// import java.util.*;
import java.io.*;
// import java.io.File;
public class FilesFolderExample {
    static int filesCount = 0;
    static int folderCount = 0;

    public static void getNumberOfFilesandFolder(File path){
        File[] files = path.listFiles();

        if(files != null){
            for(File f : files){
                if(f.isFile()){
                    filesCount++;
                }
                else{
                    folderCount++;
                    getNumberOfFilesandFolder(f);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        // String path = "C:\Users\gaura\OneDrive\Desktop\coding\Java\xyz.txt";
        File file = new File("C:\\Users\\gaura\\OneDrive\\Desktop\\coding\\Java");
        // file.createNewFile();
        System.out.println(file.getAbsolutePath());
        if(file.exists()){
            getNumberOfFilesandFolder(file);
            System.out.println("Total number of files in given path are = " + filesCount);
            System.out.println("Total number of folders in given path are = " + folderCount);
        } else {
            System.out.println("Path does not exists");
        }
    }
}
    