package SVGProject.FileControl;

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

    public String open(String path) {

        File file = new File(path);

        if (!file.exists()) {
            return "File does not exist";
        }

        if (!path.endsWith(".svg")) {
            return "Only SVG files are supported";
        }

        try {

            repo.clear();
            SvgParser parser = new SvgParser();
            parser.parse(path, repo);
            currentFile = path;
            return "Successfully opened " + path;

        } catch (Exception e) {
            return "Error opening file";
        }
    }

    public String close(){
        if(!hasFile()){
            return"No file opened";
        }

        String result = "Successfully closed " + currentFile;
        currentFile = null;
        content = null;
        repo.clear();
        return result;
    }

    public String save(){
        if(currentFile == null){
            return "No file opened";
        }

        try {
            new SvgWriter().save(currentFile, repo);
            return "Successfully saved " + currentFile;
        } catch (Exception e) {
            return "Error saving file";
        }
    }

    public String saveAs(String path){
        try {
            new SvgWriter().save(path, repo);
            currentFile = path;
            return "Successfully saved " + path;
        } catch (Exception e) {
            return "Error saving file";
        }

    }
}
