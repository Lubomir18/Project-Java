package SVGProject.SVG;

import SVGProject.Commands.Console;
import SVGProject.Shape.ShapeBase;
import SVGProject.Shape.ShapeRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SvgWriter {

    public void save(String path, ShapeRepository repo){

        try (PrintWriter pw = new PrintWriter(new FileWriter(path))){

            pw.println("<svg xmlns=\"http://www.w3.org/2000/svg\">");

            for(ShapeBase s : repo.getAll()){
                pw.println(" " + s.toSVG());
            }

            pw.println("/svg");

        } catch (Exception e) {
            Console.log("Error writing SVG");;
        }

    }

}
