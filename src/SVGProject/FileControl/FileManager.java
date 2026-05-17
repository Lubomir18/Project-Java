package SVGProject.FileControl;

import java.awt.*;
import java.io.*;
import SVGProject.Commands.Console;
import SVGProject.SVG.SvgWriter;
import SVGProject.Shape.ShapeRepository;
import SVGProject.SVG.SvgParser;

public class FileManager {
    private String currentFile;
    private String content;
    private ShapeRepository repo;

    public FileManager(ShapeRepository repo) {
        this.repo = repo;
    }

    public boolean hasFile(){
        return currentFile != null;
    }

    public void open(String path) {

        File file = new File(path);

        if (!file.exists()) {
            Console.log("File does not exist");
            return;
        }

        if (!path.endsWith(".svg")) {
            Console.log("Only SVG files are supported");
            return;
        }

        try {

            repo.clear();
            SvgParser parser = new SvgParser();
            parser.parse(path, repo);
            currentFile = path;
            Console.log("Successfully opened " + path);

        } catch (Exception e) {
            Console.log("Error opening file");
        }
    }

    public void close(){
        if(!hasFile()){
            Console.log("No file opened");
            return;
        }

        Console.log("Successfully closed " + currentFile);
        currentFile = null;
        content = null;
    }

    public void save(){
        if(currentFile == null){
            Console.log("No file opened");
            return;
        }

        try {
            new SvgWriter().save(currentFile, repo);
            Console.log("Successfully saved " + currentFile);
        } catch (Exception e) {
            Console.log("Error saving file");
        }
    }

    public void saveAs(String path){
        try {
            new SvgWriter().save(path, repo);
            currentFile = path;
            Console.log("Successfully saved " + path);
        } catch (Exception e) {
            Console.log("Error saving file");
        }

    }

    public void erase(int index) {
        if (index < 1 || index > shapes.size()) {
            Console.log("There is no figure number " + index + "!");
            return;
        }

        ShapeBase removed = shapes.remove(index - 1);

        Console.log("Erased " + removed.getClass().getSimpleName() + " (" + index + ")");
    }

    private void writeToFile(String path){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(content);
            writer.close();

            Console.log("Successfully saved to " + path);

        } catch (IOException e) {
            throw new RuntimeException("Error saving file");
        }
    }
}
