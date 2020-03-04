import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.*;

public class UserInputHandler {
    JsonDataHandler jsonDataHandler = new JsonDataHandler();
    Deque<SpaceMarine> spaceDeque;
    private int arraySize = 0;

    public UserInputHandler() {
        arraySize = jsonDataHandler.getJsonCollectionSize();
        spaceDeque = addStartElement();
    }

    public Deque<SpaceMarine> addStartElement() {
        spaceDeque = new ArrayDeque<>(createAStartObject());
        return spaceDeque;
    }

    public void addElement(SpaceMarine spc_mrn) {
        spaceDeque.add(spc_mrn);
    }

    public void infoCommand() {
        System.out.println("Size: " + spaceDeque.size());
        System.out.println("isEmpty: " + spaceDeque.isEmpty());
        System.out.println("Type: " + spaceDeque.getClass());
    }

    public void showCommand() {
        for (SpaceMarine s : spaceDeque) {
            System.out.println("-----------------");
            System.out.println("name: " + s.getName());
            System.out.println("id:" + s.getId());
            System.out.println("Astartes Category: " + s.getCategory());
            System.out.print("Coordinate X: " + s.getCoordinates().getX() + " ");
            System.out.println("Coordinate Y: " + s.getCoordinates().getY());
            System.out.println("Health: " + s.getHealth());
            System.out.println("Weapon Type: " + s.getWeaponType());
            System.out.println("MeleeWeapon Type: " + s.getMeleeWeapon());
            System.out.println("Chapter: " + s.getChapter().getName());
            System.out.println("-----------------");

        }
    }

    public void addCommand(String name) {
        List<SpaceMarine> tempList = new ArrayList<>(spaceDeque);
        int counter = 0;
        Scanner tempScn = new Scanner(System.in);
        Coordinates tempCoords = new Coordinates();
        Chapter tempChapter = new Chapter();
        Weapon tempWeapon = null;
        MeleeWeapon tempMeleeWeapon = null;
        AstartesCategory tempCategory = null;
        SpaceMarine addedSpcMrn = new SpaceMarine();
        addedSpcMrn.setName(name);
// ---------------------------------------------------------------------------------------------------------------------
        System.out.println("Введите координаты, сначала Х, затем Y: ");
        while (true) {
            try {
                if (!tempScn.hasNextDouble()) {
                    System.out.println("Введите два числа!");
                    tempScn.next();
                    continue;
                }
                tempCoords.setX(tempScn.nextDouble());
                if (!tempScn.hasNextFloat()) {
                    System.out.println("Введите число!");
                    tempScn.next();
                    continue;
                }
                tempCoords.setY(tempScn.nextFloat());
            } catch (Exception e) {
                System.out.println("Вызовите команду снова и введите координаты в заданном формате!");
            }
            break;
        }
        addedSpcMrn.setCoordinates(tempCoords);
// ---------------------------------------------------------------------------------------------------------------------
        System.out.println("Введите количество ХП: ");
        while (true) {

            try {
                if (!tempScn.hasNextInt()) {
                    System.out.println("Введите число!");
                    tempScn.next();
                    continue;
                }
                addedSpcMrn.setHealth(tempScn.nextInt());
            } catch (Exception ex) {
                System.out.println("Введите целочисленное значение!");
            }
            break;
        }
// ---------------------------------------------------------------------------------------------------------------------
        System.out.println("Введите имя главы:");
        while (true) {
            try {
                if (!tempScn.hasNext()) {
                    System.out.println("Введите имя!");
                    tempScn.next();
                    continue;
                }
                tempChapter.setName(tempScn.next());
            } catch (Exception e) {
                System.out.println("Введите строку!");
            }
            break;
        }
        addedSpcMrn.setChapter(tempChapter);

// ---------------------------------------------------------------------------------------------------------------------
        System.out.println("Введите номер нужного вам названия 'Weapon':");
        for (Weapon weapon : Weapon.values()) {
            counter++;
            System.out.println(counter + ". " + weapon.name());
        }
        while (true) {
            try {
                if (!tempScn.hasNextInt()) {
                    System.out.println("Число слишком большое или же не соответсвует данному типу!");
                    tempScn.next();
                    continue;
                }
                counter = tempScn.nextInt();
                switch (counter) {
                    case 1:
                        tempWeapon = Weapon.MELTAGUN;
                        counter = 0;
                        break;
                    case 2:
                        tempWeapon = Weapon.BOLT_PISTOL;
                        counter = 0;
                        break;
                    case 3:
                        tempWeapon = Weapon.COMBI_FLAMER;
                        counter = 0;
                        break;
                    case 4:
                        tempWeapon = Weapon.COMBI_PLASMA_GUN;
                        counter = 0;
                        break;
                    case 5:
                        tempWeapon = Weapon.MISSILE_LAUNCHER;
                        counter = 0;
                        break;
                    default:
                        if (counter >= 2147483647) {
                            System.out.println("Выбрать все-таки стоит из списка)");
                        }
                        tempWeapon = Weapon.MELTAGUN;
                        counter = 0;
                        break;

                }
            } catch (Exception e) {
            }
            break;
        }
        addedSpcMrn.setWeaponType(tempWeapon);
// ---------------------------------------------------------------------------------------------------------------------
        System.out.println("Введите номер нужного вам названия 'MeleeWeapon':");
        for (MeleeWeapon melee_weapon : MeleeWeapon.values()) {
            counter++;
            System.out.println(counter + ". " + melee_weapon.name());
        }
        while (true) {
            try {
                if (!tempScn.hasNextInt()) {
                    System.out.println("Число слишком большое или же не соответсвует данному типу!");
                    tempScn.next();
                    continue;
                }
                counter = tempScn.nextInt();
                switch (counter) {
                    case 1:
                        tempMeleeWeapon = MeleeWeapon.CHAIN_SWORD;
                        counter = 0;
                        break;
                    case 2:
                        tempMeleeWeapon = MeleeWeapon.MANREAPER;
                        counter = 0;
                        break;
                    case 3:
                        tempMeleeWeapon = MeleeWeapon.POWER_BLADE;
                        counter = 0;
                        break;
                    default:
                        if (counter >= 2147483647) {
                            System.out.println("Выбрать все-таки стоит из списка)");
                        }
                        tempMeleeWeapon = MeleeWeapon.CHAIN_SWORD;
                        break;

                }
            } catch (Exception e) {
            }
            break;
        }
        addedSpcMrn.setMeleeWeapon(tempMeleeWeapon);
// ---------------------------------------------------------------------------------------------------------------------
        System.out.println("Введите номер нужного вам названия 'AstarsetsCategory':");
        for (AstartesCategory category : AstartesCategory.values()) {
            counter++;
            System.out.println(counter + ". " + category.name());
        }
        while (true) {
            try {
                if (!tempScn.hasNextInt()) {
                    System.out.println("Число слишком большое или же не соответсвует данному типу!");
                    tempScn.next();
                    continue;
                }
                counter = tempScn.nextInt();
                switch (counter) {
                    case 1:
                        tempCategory = AstartesCategory.AGGRESSOR;
                        counter = 0;
                        break;
                    case 2:
                        tempCategory = AstartesCategory.INCEPTOR;
                        counter = 0;
                        break;
                    case 3:
                        tempCategory = AstartesCategory.TACTICAL;
                        counter = 0;
                        break;
                    case 4:
                        tempCategory = AstartesCategory.TERMINATOR;
                        counter = 0;
                        break;
                    default:
                        if (counter >= 2147483647) {
                            System.out.println("Выбрать все-таки стоит из списка)");
                        }
                        tempCategory = AstartesCategory.AGGRESSOR;
                        counter = 0;
                        break;

                }
            } catch (Exception e) {
            }
            break;
        }
        addedSpcMrn.setCategory(tempCategory);
// ---------------------------------------------------------------------------------------------------------------------
        tempList.add(addedSpcMrn);
        spaceDeque = new ArrayDeque<>(tempList);
    }

    public void removeByIdCommand(int index) {
        List<SpaceMarine> tempList = new ArrayList<>(spaceDeque);
        try {
            tempList.remove(index);
        } catch (Exception e) {
            System.out.println("Такого элемента не существует!");
        }
        spaceDeque = new ArrayDeque<>(tempList);
    }

    public void clearCommand() {
        spaceDeque.clear();
    }

    public void saveCommand() {
        RandomFilePathCreator rnd_file_path_creator = new RandomFilePathCreator();
        JSONArray to_file_array = new JSONArray();
        for (SpaceMarine spc_mrn : spaceDeque) {
            JSONObject to_json_array_obj = new JSONObject();
            try {
                to_json_array_obj.put("name", spc_mrn.getName());
                to_json_array_obj.put("coordinate_x", spc_mrn.getCoordinates().getX());
                to_json_array_obj.put("coordinate_y", spc_mrn.getCoordinates().getY());
                to_json_array_obj.put("health", spc_mrn.getHealth());
                to_json_array_obj.put("category", spc_mrn.getCategory().name());
                to_json_array_obj.put("weapon", spc_mrn.getWeaponType().name());
                to_json_array_obj.put("melee_weapon", spc_mrn.getMeleeWeapon().name());
                to_json_array_obj.put("chapter", spc_mrn.getChapter().getName());
                to_file_array.add(to_json_array_obj);
            } catch (Exception e) {
                System.out.println("Какое-то из полей не заполнено!");
            }
        }
        try {
            File finalFile = new File(System.getenv("JSON"));
            PrintWriter writer = new PrintWriter(finalFile);
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(finalFile));
            writer.print("");
            writer.close();
            outputStream.write(to_file_array.toJSONString().getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (java.io.FileNotFoundException err) {
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void executeSctiptCommand(String user_input) {
        try {
            Scanner tempScn = new Scanner(new File(user_input));
            while (tempScn.hasNext()) {
                int i = 0;
                String temp = tempScn.nextLine();
                String[] tempSec = temp.split("\\s");
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
                        if (tempSec[tempSec.length - 1].equals("add")) {
                            System.out.println("Введите имя после команды!");
                            break;
                        }
                        addCommand(tempSec[tempSec.length - 1]);
                        break;
                    case "remove_by_id":
                        try {
                            i = Integer.parseInt(tempSec[tempSec.length - 1]);
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
                        executeSctiptCommand(tempSec[tempSec.length - 1]);
                        break;
                    case "exit":
                        System.exit(0);
                        break;
                    case "add_if_max":
                        addIfMaxCommand(tempSec[tempSec.length - 1]);
                        break;
                    case "add_if_min":
                        addIfMinCommand(tempSec[tempSec.length - 1]);
                        break;
                }

            }
        } catch (Exception e) {
            System.out.println("Файл не найден!");
        }
    }

    public void addIfMaxCommand(String name) {
        FindMaxElement findMax = new FindMaxElement();
        addCommand(name);
        List<SpaceMarine> temp_list = new ArrayList<>(spaceDeque);
        spaceDeque = findMax.makeDecision(temp_list);
    }

    public void addIfMinCommand(String name) {
        FindMinElement findMin = new FindMinElement();
        addCommand(name);
        List<SpaceMarine> temp_list = new ArrayList<>(spaceDeque);
        spaceDeque = findMin.makeDecision(temp_list);
    }

    public void removeLowerCommand(String name) {
        LowerRemover lowerRemover = new LowerRemover();
        addCommand(name);
        List<SpaceMarine> tempList = new ArrayList<>(spaceDeque);
        spaceDeque = lowerRemover.removeLowerElement(tempList);

    }

    public void sumOfHealthCommand() {
        int sum = 0;
        for (SpaceMarine spc : spaceDeque) {
            sum = sum + spc.getHealth();
        }
        System.out.println("Сумма полей health:" + sum);
    }

    public void printDescendingCommand() {
        List<SpaceMarine> temp = new ArrayList<>(spaceDeque);
        Collections.sort(temp);
        spaceDeque = new ArrayDeque<>(temp);
        showCommand();
    }

    public void printFieldDescendingHealthCommmand() {
        List<SpaceMarine> temp = new ArrayList<>(spaceDeque);
        Collections.sort(temp);
        spaceDeque = new ArrayDeque<>(temp);
        for (SpaceMarine spc : spaceDeque) {
            System.out.println(spc.getHealth());
        }

    }


    public List<SpaceMarine> createAStartObject() {
        List<SpaceMarine> startObjList = new LinkedList<SpaceMarine>();
        for (int counter = 0; counter < arraySize; counter++) {
            SpaceMarine tempSpc = new SpaceMarine();
            tempSpc.setName(jsonDataHandler.getName(counter));
            if (jsonDataHandler.getId(counter) != 0) {
                tempSpc.setId(jsonDataHandler.getId(counter));
            }
            tempSpc.setHealth(jsonDataHandler.getHealth(counter));
            tempSpc.setCoordinates(jsonDataHandler.getCoordinates(counter));
            tempSpc.setCategory(jsonDataHandler.getAstartesCategory(counter));
            tempSpc.setWeaponType(jsonDataHandler.getWeapon(counter));
            tempSpc.setMeleeWeapon(jsonDataHandler.getMeleeWeapon(counter));
            tempSpc.setChapter(jsonDataHandler.getChapter(counter));
            startObjList.add(tempSpc);
        }
        return startObjList;
    }

    public void commandList() {
        Map<String, String> commandList = new HashMap<>();
        commandList.put("help", "вывести справку по доступным командам");
        commandList.put("info", "вывести в стандартный поток вывода информацию о коллекции");
        commandList.put("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        commandList.put("add {element}", "добавить новый элемент в коллекцию");
        commandList.put("update_id {element}", "обновить значение элемента коллекции, id которого равен заданному");
        commandList.put("remove_by_id id", "удалить элемент из коллекции по его id");
        commandList.put("clear", "очистить коллекцию");
        commandList.put("save", "сохранить коллекцию в файл");
        commandList.put("execute_script file_name", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        commandList.put("exit", "завершить программу (без сохранения в файл)");
        commandList.put("add_if_max {element}", "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        commandList.put("add_if_min {element}", "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
        commandList.put("remove_lower {element}", "удалить из коллекции все элементы, меньшие, чем заданный");
        commandList.put("sum_of_health", "вывести сумму значений поля health для всех элементов коллекции");
        commandList.put("print_descending", "вывести элементы коллекции в порядке убывания");
        commandList.put("print_field_descending_health {health}", "вывести значения поля health в порядке убывания");

        Iterator<Map.Entry<String, String>> iterator = commandList.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());

        }
    }
}
