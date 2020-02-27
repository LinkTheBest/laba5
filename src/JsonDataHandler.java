import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.math.BigDecimal;
import java.io.*;

public class JsonDataHandler {
        private String path_to_json_file = "/Users/nickyking/IdeaProjects/laba5/src/test.json";
//  private String path_to_json_file = "C:\\Users\\Nikitka\\IdeaProjects\\laba5\\src\\test.json";
   // private String path_to_json_file = System.getenv("JSON");
    private JSONParser json_parser = new JSONParser();

    public Integer getJsonCollectionSize() {
        int counter = 0;
        try {
            JSONArray json_array = (JSONArray) json_parser.parse(new FileReader(path_to_json_file));
            for (Object obj : json_array) {
                counter++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (ParseException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return counter;
    }

    public String getName(int index) {
        String from_json_name = null;
        try {
            JSONArray json_array = (JSONArray) json_parser.parse(new FileReader(path_to_json_file));
            JSONObject json_data = (JSONObject) json_array.get(index);
            from_json_name = (String) json_data.get("name");
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return from_json_name;
    }

    public Coordinates getCoordinates(int index) {
        Coordinates coordinates = new Coordinates();
        Double json_x = 0.0;
        Float json_y = 0f;
        try {
            JSONArray json_array = (JSONArray) json_parser.parse(new FileReader(path_to_json_file));
            JSONObject json_data = (JSONObject) json_array.get(index);
            json_x = (Double) json_data.get("coordinate_x");
            json_y = BigDecimal.valueOf((Double) json_data.get("coordinate_y")).floatValue();
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        coordinates.setX(json_x);
        coordinates.setY(json_y);
        return coordinates;
    }


    public int getHealth(int index) {
        Integer json_health = 0;
        try {
            JSONArray json_array = (JSONArray) json_parser.parse(new FileReader(path_to_json_file));
            JSONObject json_data = (JSONObject) json_array.get(index);
            json_health = BigDecimal.valueOf((Double) json_data.get("health")).intValue();
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return json_health;
    }

    public AstartesCategory getAstartesCategory(int index) {
        AstartesCategory json_category = null;
        String temp_comparison;
        try {
            JSONArray json_array = (JSONArray) json_parser.parse(new FileReader(path_to_json_file));
            JSONObject json_data = (JSONObject) json_array.get(index);
            temp_comparison = (String) json_data.get("category");
            switch (temp_comparison) {
                case "AGGRESSOR":
                    json_category = AstartesCategory.AGGRESSOR;
                    break;
                case "INCEPTOR":
                    json_category = AstartesCategory.INCEPTOR;
                    break;
                case "TACTICAL":
                    json_category = AstartesCategory.TACTICAL;
                    break;
                case "TERMINATOR":
                    json_category = AstartesCategory.TERMINATOR;
                    break;
            }
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return json_category;
    }

    public Weapon getWeapon(int index) {
        Weapon json_weapon = null;
        String temp_comparison;
        try {
            JSONArray json_array = (JSONArray) json_parser.parse(new FileReader(path_to_json_file));
            JSONObject json_data = (JSONObject) json_array.get(index);
            temp_comparison = (String) json_data.get("weapon");
            switch (temp_comparison) {
                case "MELTAGUN":
                    json_weapon = Weapon.MELTAGUN;
                    break;
                case "BOLT_PISTOL":
                    json_weapon = Weapon.BOLT_PISTOL;
                    break;
                case "COMBI_FLAMER":
                    json_weapon = Weapon.COMBI_FLAMER;
                    break;
                case "COMBI_PLASMA_GUN":
                    json_weapon = Weapon.COMBI_PLASMA_GUN;
                    break;
                case "MISSILE_LAUNCHER":
                    json_weapon = Weapon.MISSILE_LAUNCHER;
                    break;
                default:
                    json_weapon = null;
                    break;
            }
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return json_weapon;

    }

    public MeleeWeapon getMeleeWeapon(int index) {
        MeleeWeapon json_melee_weapon = null;
        String temp_comparison;
        try {
            JSONArray json_array = (JSONArray) json_parser.parse(new FileReader(path_to_json_file));
            JSONObject json_data = (JSONObject) json_array.get(index);
            temp_comparison = (String) json_data.get("melee_weapon");
            switch (temp_comparison) {
                case "CHAIN_SWORD":
                    json_melee_weapon = MeleeWeapon.CHAIN_SWORD;
                    break;
                case "MANREAPER":
                    json_melee_weapon = MeleeWeapon.MANREAPER;
                    break;
                case "POWER_BLADE":
                    json_melee_weapon = MeleeWeapon.POWER_BLADE;
                    break;
                default:
                    json_melee_weapon = null;
                    break;
            }
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return json_melee_weapon;

    }

    public Chapter getChapter(int index) {
        Chapter chapter = new Chapter();
        try {
            JSONArray json_array = (JSONArray) json_parser.parse(new FileReader(path_to_json_file));
            JSONObject json_data = (JSONObject) json_array.get(index);
            chapter.setName((String) json_data.get("chapter"));
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return chapter;
    }

}
