import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.*;

public class UserInputHandler {
    JsonDataHandler json_data_handler = new JsonDataHandler();
    Deque<SpaceMarine> space_deque;
    private int array_size = 0;

    public UserInputHandler() {
        array_size = json_data_handler.getJsonCollectionSize();
        space_deque = addStartElement();
    }

    public Deque<SpaceMarine> addStartElement() {
        space_deque = new ArrayDeque<>(createAStartObject());
        return space_deque;
    }

    public void addElement(SpaceMarine spc_mrn) {
        space_deque.add(spc_mrn);
    }

    public void infoCommand() {
        System.out.println("Size: " + space_deque.size());
        System.out.println("isEmpty: " + space_deque.isEmpty());
        System.out.println("Type: " + space_deque.getClass());
    }

    public void showCommand() {
        for (SpaceMarine s : space_deque) {
            System.out.println("-----------------");
            System.out.println(s.getName());
            System.out.println(s.getCategory());
            System.out.print(s.getCoordinates().getX() + " ");
            System.out.println(s.getCoordinates().getY());
            System.out.println(s.getHealth());
            System.out.println(s.getWeaponType());
            System.out.println(s.getMeleeWeapon());
            System.out.println(s.getChapter().getName());
            System.out.println("-----------------");

        }
    }

    public void addCommand(String name) {
        List<SpaceMarine> temp_list = new ArrayList<>(space_deque);
        int attempt_counter = 3;
        int counter = 0;
        Scanner temp_scn = new Scanner(System.in);
        Coordinates temp_coords = new Coordinates();
        Chapter temp_chapter = new Chapter();
        Weapon temp_weapon = null;
        MeleeWeapon temp_melee_weapon = null;
        AstartesCategory temp_category = null;
        SpaceMarine added_spc_mrn = new SpaceMarine();
        added_spc_mrn.setName(name);
// ---------------------------------------------------------------------------------------------------------------------
        System.out.println("Введите координаты, сначала Х, затем Y: ");
        while (true) {
            try {
                if (!temp_scn.hasNextDouble()) {
                    System.out.println("Введите два числа!");
                    temp_scn.next();
                    continue;
                }
                temp_coords.setX(temp_scn.nextDouble());
                if (!temp_scn.hasNextFloat()) {
                    System.out.println("Введите число!");
                    temp_scn.next();
                    continue;
                }
                temp_coords.setY(temp_scn.nextFloat());
            } catch (Exception e) {
                System.out.println("Вызовите команду снова и введите координаты в заданном формате!");
            }
            break;
        }
        added_spc_mrn.setCoordinates(temp_coords);
// ---------------------------------------------------------------------------------------------------------------------
        System.out.println("Введите количество ХП: ");
        while (true) {

            try {
                if (!temp_scn.hasNextInt()) {
                    System.out.println("Введите число!");
                    temp_scn.next();
                    continue;
                }
                added_spc_mrn.setHealth(temp_scn.nextInt());
            } catch (Exception ex) {
                System.out.println("Введите целочисленное значение!");
            }
            break;
        }
// ---------------------------------------------------------------------------------------------------------------------
        System.out.println("Введите имя главы:");
        try {
            temp_chapter.setName(temp_scn.nextLine());
        } catch (Exception e) {
            System.out.println("Введите строку!");
        }
        added_spc_mrn.setChapter(temp_chapter);
// ---------------------------------------------------------------------------------------------------------------------
        System.out.println("Введите номер нужного вам названия 'Weapon':");
        for (Weapon weapon : Weapon.values()) {
            counter++;
            System.out.println(counter + ". " + weapon.name());
        }
        while (true) {
            try {
                if (!temp_scn.hasNextInt()) {
                    System.out.println("Введите число!");
                    temp_scn.next();
                    continue;
                }
                counter = temp_scn.nextInt();
                switch (counter) {
                    case 1:
                        temp_weapon = Weapon.MELTAGUN;
                        counter = 0;
                        break;
                    case 2:
                        temp_weapon = Weapon.BOLT_PISTOL;
                        counter = 0;
                        break;
                    case 3:
                        temp_weapon = Weapon.COMBI_FLAMER;
                        counter = 0;
                        break;
                    case 4:
                        temp_weapon = Weapon.COMBI_PLASMA_GUN;
                        counter = 0;
                        break;
                    case 5:
                        temp_weapon = Weapon.MISSILE_LAUNCHER;
                        counter = 0;
                        break;
                    default:
                        temp_weapon = Weapon.MELTAGUN;
                        counter = 0;
                        break;

                }
            } catch (Exception e) {
            }
            break;
        }
        added_spc_mrn.setWeaponType(temp_weapon);
// ---------------------------------------------------------------------------------------------------------------------
        System.out.println("Введите номер нужного вам названия 'MeleeWeapon':");
        for (MeleeWeapon melee_weapon : MeleeWeapon.values()) {
            counter++;
            System.out.println(counter + ". " + melee_weapon.name());
        }
        while (true) {
            try {
                if (!temp_scn.hasNextInt()) {
                    System.out.println("Введите число!");
                    temp_scn.next();
                    continue;
                }
                counter = temp_scn.nextInt();
                switch (counter) {
                    case 1:
                        temp_melee_weapon = MeleeWeapon.CHAIN_SWORD;
                        counter = 0;
                        break;
                    case 2:
                        temp_melee_weapon = MeleeWeapon.MANREAPER;
                        counter = 0;
                        break;
                    case 3:
                        temp_melee_weapon = MeleeWeapon.POWER_BLADE;
                        counter = 0;
                        break;
                    default:
                        temp_melee_weapon = MeleeWeapon.CHAIN_SWORD;
                        break;

                }
            } catch (Exception e) {
            }
            break;
        }
        added_spc_mrn.setMeleeWeapon(temp_melee_weapon);
// ---------------------------------------------------------------------------------------------------------------------
        System.out.println("Введите номер нужного вам названия 'AstarsetsCategory':");
        for (AstartesCategory category : AstartesCategory.values()) {
            counter++;
            System.out.println(counter + ". " + category.name());
        }
        while (true) {
            try {
                if (!temp_scn.hasNextInt()) {
                    System.out.println("Введите число!");
                    temp_scn.next();
                    continue;
                }
                counter = temp_scn.nextInt();
                switch (counter) {
                    case 1:
                        temp_category = AstartesCategory.AGGRESSOR;
                        counter = 0;
                        break;
                    case 2:
                        temp_category = AstartesCategory.INCEPTOR;
                        counter = 0;
                        break;
                    case 3:
                        temp_category = AstartesCategory.TACTICAL;
                        counter = 0;
                        break;
                    case 4:
                        temp_category = AstartesCategory.TERMINATOR;
                        counter = 0;
                        break;
                    default:
                        temp_category = AstartesCategory.AGGRESSOR;
                        counter = 0;
                        break;

                }
            } catch (Exception e) {
            }
            break;
        }
        added_spc_mrn.setCategory(temp_category);
// ---------------------------------------------------------------------------------------------------------------------
        temp_list.add(added_spc_mrn);
        space_deque = new ArrayDeque<>(temp_list);
    }

    public void removeByIdCommand(int index) {
        List<SpaceMarine> temp_list = new ArrayList<>(space_deque);
        try {
            temp_list.remove(index);
        } catch (Exception e) {
            System.out.println("Такого элемента не существует!");
        }
        space_deque = new ArrayDeque<>(temp_list);
    }

    public void clearCommand() {
        space_deque.clear();
    }

    public void saveCommand() {
        RandomFilePathCreator rnd_file_path_creator = new RandomFilePathCreator();
        JSONArray to_file_array = new JSONArray();

        for (SpaceMarine spc_mrn : space_deque) {
            JSONObject to_json_array_obj = new JSONObject();
            to_json_array_obj.put("name", spc_mrn.getName());
            to_json_array_obj.put("coordinate_x", spc_mrn.getCoordinates().getX());
            to_json_array_obj.put("coordinate_y", spc_mrn.getCoordinates().getY());
            to_json_array_obj.put("health", spc_mrn.getHealth());
            to_json_array_obj.put("category", spc_mrn.getCategory().name());
            to_json_array_obj.put("weapon", spc_mrn.getWeaponType().name());
            to_json_array_obj.put("melee_weapon", spc_mrn.getMeleeWeapon().name());
            to_json_array_obj.put("chapter", spc_mrn.getChapter().getName());
            to_file_array.add(to_json_array_obj);
        }
        try {
            BufferedOutputStream output_stream = new BufferedOutputStream(new FileOutputStream(rnd_file_path_creator.pathCreator()));
            output_stream.write(to_file_array.toJSONString().getBytes());
            output_stream.flush();
            output_stream.close();
        } catch (java.io.FileNotFoundException err) {
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void executeSctiptCommand(String user_input) {
        try {
            Scanner temp_scn = new Scanner(new File(user_input));
            while (temp_scn.hasNext()) {
                int i = 0;
                String temp = temp_scn.nextLine();
                String[] temp_sec = temp.split("\\s");
                switch (temp) {
                    case "help":
                        commandList();
                        break;
                    case "info":
                        infoCommand();
                        break;
                    case "show":
                        showCommand();
                        break;
                    case "add":
                        if (temp_sec[temp_sec.length - 1].equals("add")) {
                            System.out.println("Введите имя после команды!");
                            break;
                        }
                        addCommand(temp_sec[temp_sec.length - 1]);
                        break;
                    case "remove_by_id":
                        try {
                            i = Integer.parseInt(temp_sec[temp_sec.length - 1]);
                        } catch (Exception e) {
                            System.out.println("Введите число!");
                        }
                        removeByIdCommand(i);
                        break;
                    case "clear":
                        clearCommand();
                        break;
                    case "save":
                        saveCommand();
                        break;
                    case "execute_script":
                        executeSctiptCommand(temp_sec[temp_sec.length - 1]);
                        break;
                    case "exit":
                        System.exit(0);
                        break;
                    case "add_if_max":
                        addIfMaxCommand(temp_sec[temp_sec.length - 1]);
                        break;
                    case "add_if_min":
                        addIfMinCommand(temp_sec[temp_sec.length - 1]);
                        break;
                }

            }
        } catch (Exception e) {
            System.out.println("Файл не найден!");
        }
    }

    public void addIfMaxCommand(String name) {
        FindMaxElement find_max = new FindMaxElement();
        addCommand(name);
        List<SpaceMarine> temp_list = new ArrayList<>(space_deque);
        space_deque = find_max.makeDecision(temp_list);
    }

    public void addIfMinCommand(String name) {
        FindMinElement find_min = new FindMinElement();
        addCommand(name);
        List<SpaceMarine> temp_list = new ArrayList<>(space_deque);
        space_deque = find_min.makeDecision(temp_list);
    }


    public List<SpaceMarine> createAStartObject() {
        List<SpaceMarine> start_obj_list = new LinkedList<SpaceMarine>();
        for (int counter = 0; counter < array_size; counter++) {
            SpaceMarine temp_spc = new SpaceMarine();
            temp_spc.setName(json_data_handler.getName(counter));
            temp_spc.setHealth(json_data_handler.getHealth(counter));
            temp_spc.setCoordinates(json_data_handler.getCoordinates(counter));
            temp_spc.setCategory(json_data_handler.getAstartesCategory(counter));
            temp_spc.setWeaponType(json_data_handler.getWeapon(counter));
            temp_spc.setMeleeWeapon(json_data_handler.getMeleeWeapon(counter));
            temp_spc.setChapter(json_data_handler.getChapter(counter));
            start_obj_list.add(temp_spc);
        }
        return start_obj_list;
    }

    public void commandList() {
        Map<String, String> command_list = new HashMap<>();
        command_list.put("help", "вывести справку по доступным командам");
        command_list.put("info", "вывести в стандартный поток вывода информацию о коллекции");
        command_list.put("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        command_list.put("add {element}", "добавить новый элемент в коллекцию");
        command_list.put("update_id {element}", "обновить значение элемента коллекции, id которого равен заданному");
        command_list.put("remove_by_id id", "удалить элемент из коллекции по его id");
        command_list.put("clear", "очистить коллекцию");
        command_list.put("save", "сохранить коллекцию в файл");
        command_list.put("execute_script file_name", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        command_list.put("exit", "завершить программу (без сохранения в файл)");
        command_list.put("add_if_max {element}", "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        command_list.put("add_if_min {element}", "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
        command_list.put("remove_lower {element}", "удалить из коллекции все элементы, меньшие, чем заданный");
        command_list.put("sum_of_health", "вывести сумму значений поля health для всех элементов коллекции");
        command_list.put("print_descending", "вывести элементы коллекции в порядке убывания");
        command_list.put("print_field_descending_health {health}", "вывести значения поля health в порядке убывания");

        Iterator<Map.Entry<String, String>> iterator = command_list.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());

        }
    }
}
