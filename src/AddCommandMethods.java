import java.util.Scanner;

public class AddCommandMethods {
    private int counter = 0;
    private int health = 0;
    private int id = 0;
    private Scanner tempScn = new Scanner(System.in);
    private Coordinates tempCoords = new Coordinates();
    private Chapter tempChapter = new Chapter();
    private Weapon tempWeapon = null;
    private MeleeWeapon tempMeleeWeapon = null;
    private AstartesCategory tempCategory = null;

    public int readId() {
        System.out.println("Введите положительное ID до 99999:");
        while (true) {
            try {
                if (!tempScn.hasNextInt()) {
                    System.out.println("Число неверное или слишком большое!");
                    tempScn.next();
                    continue;
                }
                id = tempScn.nextInt();
                if (id < 0 || id > 99999) {
                    id = 0;
                }
            } catch (Exception ex) {
                System.out.println("Введите целочисленное значение!");
            }
            break;
        }
        return id;
    }

    public Coordinates readCoordinates() {
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
                    System.out.println("Число неверное или слишком большое!");
                    tempScn.next();
                    continue;
                }
                tempCoords.setY(tempScn.nextFloat());
            } catch (Exception e) {
                System.out.println("Вызовите команду снова и введите координаты в заданном формате!");
            }
            break;
        }
        return tempCoords;
    }

    public int readHealth() {
        System.out.println("Введите количество ХП: ");
        while (true) {

            try {
                if (!tempScn.hasNextInt()) {
                    System.out.println("Число неверное или слишком большое!");
                    tempScn.next();
                    continue;
                }
                health = tempScn.nextInt();
            } catch (Exception ex) {
                System.out.println("Введите целочисленное значение!");
            }
            break;
        }
        return health;
    }

    public Chapter readChapterName() {
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
        return tempChapter;
    }

    public Weapon readWeaponType() {
        System.out.println("Введите номер нужного вам названия 'Weapon':");
        for (Weapon weapon : Weapon.values()) {
            counter++;
            if (counter == 1) {
                System.out.println("[" + counter + "]" + ". " + weapon.name());
            } else
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
                        System.out.println("Выбрать все-таки стоит из списка)");
                        tempWeapon = Weapon.MELTAGUN;
                        counter = 0;
                        break;

                }
            } catch (Exception e) {
            }
            break;
        }
        return tempWeapon;
    }

    public MeleeWeapon readMeleeWeaponCategory() {
        System.out.println("Введите номер нужного вам названия 'MeleeWeapon':");
        for (MeleeWeapon meleeWeapon : MeleeWeapon.values()) {
            counter++;
            if (counter == 1) {
                System.out.println("[" + counter + "]" + ". " + meleeWeapon.name());
            } else
                System.out.println(counter + ". " + meleeWeapon.name());
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
                        System.out.println("Выбрать все-таки стоит из списка)");
                        tempMeleeWeapon = MeleeWeapon.CHAIN_SWORD;
                        break;

                }
            } catch (Exception e) {
            }
            break;
        }
        return tempMeleeWeapon;
    }

    public AstartesCategory readAstartesCategory() {
        System.out.println("Введите номер нужного вам названия 'AstarsetsCategory':");
        for (AstartesCategory category : AstartesCategory.values()) {
            counter++;
            if (counter == 1) {
                System.out.println("[" + counter + "]" + ". " + category.name());
            } else
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
                        System.out.println("Выбрать все-таки стоит из списка)");
                        tempCategory = AstartesCategory.AGGRESSOR;
                        counter = 0;
                        break;

                }
            } catch (Exception e) {
            }
            break;
        }
        return tempCategory;
    }
}
