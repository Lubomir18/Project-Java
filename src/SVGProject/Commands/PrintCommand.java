package SVGProject.Commands;

import SVGProject.CommandProcess.Command;
import SVGProject.FileControl.FileManager;
import SVGProject.Shape.ShapeRepository;

public class PrintCommand implements Command {

    private ShapeRepository repository;

    public PrintCommand(ShapeRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(String[] args) {
        return repository.print();
    }
}