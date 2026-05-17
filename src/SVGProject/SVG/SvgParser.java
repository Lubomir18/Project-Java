package SVGProject.SVG;

import SVGProject.Shape.Circle;
import SVGProject.Shape.Rectangle;
import SVGProject.Shape.ShapeRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SvgParser {

    public void parse(String path, ShapeRepository repo){

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;
            while((line = br.readLine()) != null){

                if (line.contains("<circle")){
                    double cx = extract(line, "cx");
                    double cy = extract(line, "cy");
                    double r = extract(line, "r");

                    repo.add(new Circle(cx,cy,r));
                }

                if(line.contains("<rect")){
                    double x = extract(line, "x");
                    double y = extract(line, "y");
                    double w = extract(line, "width");
                    double h = extract(line, "height");

                    repo.add(new Rectangle(x, y, w, h));
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Error reading SVG");
        }

    }

    private double extract(String line, String attr){
        Pattern p = Pattern.compile(attr +  "=\"([^\"]+)\"");
        Matcher m = p.matcher(line);
        if(m.find()){
            return Double.parseDouble(m.group(1));
        }
        return 0;
    }

}
