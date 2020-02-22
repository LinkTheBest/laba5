import java.util.Scanner;

public class UserDataGetter {

    Scanner users_input = new Scanner(System.in);
    String command_string;
    UserInputHandler usr_input_hndlr = new UserInputHandler();

    public UserDataGetter() {
        getUserCommand();
    }

    public void getUserCommand() {
        String users_input_in_words[];
        String temp_value;
        int temp = 0;
        System.out.println("Введите команды или введите 'help' для просмотра списка команд...");
        loop_one:
        while (true) {

            command_string = users_input.nextLine();
            users_input_in_words = command_string.split("\\s");
            temp_value = users_input_in_words[0];
            switch (temp_value) {
                case "help":
                    usr_input_hndlr.commandList();
                    break;
                case "info":
                    usr_input_hndlr.infoCommand();
                    break;
                case "show":
                    usr_input_hndlr.showCommand();
                    break;
                case "add":
                    if (users_input_in_words[users_input_in_words.length - 1].equals("add")) {
                        System.out.println("Введите имя после команды!");
                        break;
                    }
                    usr_input_hndlr.addCommand(users_input_in_words[users_input_in_words.length - 1]);
                    break;
                case "remove_by_id":
                    try {
                        temp = Integer.parseInt(users_input_in_words[users_input_in_words.length - 1]);
                    } catch (Exception e) {
                        System.out.println("Введите число!");
                    }
                    usr_input_hndlr.removeByIdCommand(temp);
                    break;
                case "clear":
                    usr_input_hndlr.clearCommand();
                    break;
                case "save":
                    usr_input_hndlr.saveCommand();
                    break;
            }
//             System.out.println(command_string);
        }
    }
}
