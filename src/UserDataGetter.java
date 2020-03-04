import java.util.Scanner;

public class UserDataGetter {

    Scanner usersInput = new Scanner(System.in);
    String commandString;
    UserInputHandler usrInputHndlr = new UserInputHandler();

    public UserDataGetter() {
        getUserCommand();
    }

    public void getUserCommand() {
        String usersInputInWords[];
        String tempValue;
        int temp = 0;
        System.out.println("Введите команды или введите 'help' для просмотра списка команд...");
        while (true) {
            if (!usersInput.hasNext()) {
                System.out.println("Вы нашли фичу и завершили программу!");
                System.exit(0);
            }
            commandString = usersInput.nextLine();
            usersInputInWords = commandString.split("\\s");
            tempValue = usersInputInWords[0];
            switch (tempValue) {
                case "help":
                    usrInputHndlr.commandList();
                    break;
                case "info":
                    usrInputHndlr.infoCommand();
                    break;
                case "show":
                    usrInputHndlr.showCommand();
                    break;
                case "add":
                    if (usersInputInWords[usersInputInWords.length - 1].equals("add")) {
                        System.out.println("Введите имя после команды!");
                        break;
                    }
                    usrInputHndlr.addCommand(usersInputInWords[usersInputInWords.length - 1]);
                    break;
                case "remove_by_id":
                    try {
                        temp = Integer.parseInt(usersInputInWords[usersInputInWords.length - 1]);
                    } catch (Exception e) {
                        System.out.println("Введите число!");
                    }
                    usrInputHndlr.removeByIdCommand(temp);
                    break;
                case "clear":
                    usrInputHndlr.clearCommand();
                    break;
                case "save":
                    usrInputHndlr.saveCommand();
                    break;
                case "execute_script":
                    usrInputHndlr.executeSctiptCommand(usersInputInWords[usersInputInWords.length - 1]);
                    break;
                case "exit":
                    System.exit(0);
                    break;
                case "add_if_max":
                    if (usersInputInWords[usersInputInWords.length - 1].equals("add_if_max")) {
                        System.out.println("Введите имя после команды!");
                        break;
                    }
                    usrInputHndlr.addIfMaxCommand(usersInputInWords[usersInputInWords.length - 1]);
                    break;
                case "add_if_min":
                    if (usersInputInWords[usersInputInWords.length - 1].equals("add_if_min")) {
                        System.out.println("Введите имя после команды!");
                        break;
                    }
                    usrInputHndlr.addIfMinCommand(usersInputInWords[usersInputInWords.length - 1]);
                    break;
                case "remove_lower":
                    if (usersInputInWords[usersInputInWords.length - 1].equals("remove_lower")) {
                        System.out.println("Введите имя после команды!");
                        break;
                    }
                    usrInputHndlr.removeLowerCommand(usersInputInWords[usersInputInWords.length - 1]);
                    break;
                case "sum_of_health":
                    usrInputHndlr.sumOfHealthCommand();
                    break;
                case "print_descending":
                    usrInputHndlr.printDescendingCommand();
                    break;
                case "print_field_descending_health":
                    usrInputHndlr.printFieldDescendingHealthCommmand();
                    break;
            }
        }
    }
}
