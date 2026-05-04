package SVGProject;

import SVGProject.Commands.HelpCommand;
import java.util.Scanner;

public class Application {

    public void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+");
            String command = parts[0];


            if(command.equalsIgnoreCase("help")){
                if(parts.length == 1){
                    HelpCommand.CommandHelp();
                }
                else{
                    for(int i=0;i< parts.length;i++){
                        //String parts =
                    }
                }
            }

            if(command.equalsIgnoreCase("exit")){
                break;
            }
        }

    }

}
