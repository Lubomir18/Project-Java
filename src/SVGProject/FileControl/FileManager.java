package SVGProject.FileControl;

import java.io.*;

public class FileManager {
    private String currentFile;
    private String content;

    public boolean hasFile(){
        return currentFile != null;
    }

    public void open(String path){
        try {
            File file = new File(path);

            if (!file.exists()){
                file.createNewFile();
                content = "";
            } else {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder builder = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    builder.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error opening file");
        }
    }

    public void close(){
        if(!hasFile()){
            System.out.println("No file opened");
            return;
        }

        System.out.println("Successfully closed " + currentFile);
        currentFile = null;
        content = null;
    }

    public void save(){
        if(!hasFile()){
            System.out.println("No File opened");
            return;
        }

        writeToFile(currentFile);
    }

    public void saveAs(String path){
        if(!hasFile()){
            System.out.println("No File opened");
            return;
        }

        writeToFile(path);
    }

    private void writeToFile(String path){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(content);
            writer.close();

            System.out.println("Successfully saved to " + path);

        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }
}
