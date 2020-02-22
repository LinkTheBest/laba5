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
        System.out.println(space_deque.size());
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
        System.out.println("Введите координаты типа Х и Y: ");

        try {
            temp_coords.setX(temp_scn.nextDouble());
            temp_coords.setY(temp_scn.nextFloat());
        } catch (Exception e) {
            System.out.println("Вызовите команду снова и введите координаты в заданном формате!");
        }

        added_spc_mrn.setCoordinates(temp_coords);
        System.out.println("Введите количество ХП: ");
        try {
            added_spc_mrn.setHealth(temp_scn.nextInt());
        } catch (Exception ex) {
            System.out.println("Введите целочисленное значение!");
        }

        System.out.println("Введите имя главы");
        try {
            temp_chapter.setName(temp_scn.nextLine());
        } catch (Exception e) {
            System.out.println("Введите строку!");
        }
        added_spc_mrn.setChapter(temp_chapter);

        System.out.println("Введите номер нужного вам названия 'Weapon':");
        for (Weapon weapon : Weapon.values()) {
            counter++;
            System.out.println(counter + ". " + weapon.name());
        }
        try {
            counter = temp_scn.nextInt();
            switch (counter) {
                case 1:
                    temp_weapon = Weapon.MELTAGUN;
                    break;
                case 2:
                    temp_weapon = Weapon.BOLT_PISTOL;
                    break;
                case 3:
                    temp_weapon = Weapon.COMBI_FLAMER;
                    break;
                case 4:
                    temp_weapon = Weapon.COMBI_PLASMA_GUN;
                    break;
                case 5:
                    temp_weapon = Weapon.MISSILE_LAUNCHER;
                default:
                    System.out.println("Выберите хоть что-нибудь из списка(");

            }
        } catch (Exception e) {
        }
        added_spc_mrn.setWeaponType(temp_weapon);

        System.out.println("Введите номер нужного вам названия 'MeleeWeapon':");
        for (MeleeWeapon melee_weapon : MeleeWeapon.values()) {
            counter++;
            System.out.println(counter + ". " + melee_weapon.name());
        }
        try {
            counter = temp_scn.nextInt();
            switch (counter) {
                case 1:
                    temp_melee_weapon = MeleeWeapon.CHAIN_SWORD;
                    break;
                case 2:
                    temp_melee_weapon = MeleeWeapon.MANREAPER;
                    break;
                case 3:
                    temp_melee_weapon = MeleeWeapon.POWER_BLADE;
                    break;
                default:
                    System.out.println("Выберите хоть что-нибудь из списка(");

            }
        } catch (Exception e) {
        }
        added_spc_mrn.setMeleeWeapon(temp_melee_weapon);

        System.out.println("Введите номер нужного вам названия 'AstarsetsCategory':");
        for (AstartesCategory category : AstartesCategory.values()) {
            counter++;
            System.out.println(counter + ". " + category.name());
        }
        try {
            counter = temp_scn.nextInt();
            switch (counter) {
                case 1:
                    temp_category = AstartesCategory.AGGRESSOR;
                    break;
                case 2:
                    temp_category = AstartesCategory.INCEPTOR;
                    break;
                case 3:
                    temp_category = AstartesCategory.TACTICAL;
                    break;
                case 4:
                    temp_category = AstartesCategory.TERMINATOR;
                    break;
                default:
                    System.out.println("Выберите хоть что-нибудь из списка(");

            }
        } catch (Exception e) {
        }
        added_spc_mrn.setCategory(temp_category);
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
