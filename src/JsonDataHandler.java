import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.math.BigDecimal;
import java.io.*;

public class JsonDataHandler {
    private String pathToJsonFile = System.getenv("JSON");
    private JSONParser jsonParser = new JSONParser();

    public Integer getJsonCollectionSize() {
        int counter = 0;
        try {
            System.out.println(pathToJsonFile);
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            for (Object obj : jsonArray) {
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
        String fromJsonName = null;
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            JSONObject jsonData = (JSONObject) jsonArray.get(index);
            fromJsonName = (String) jsonData.get("name");
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return fromJsonName;
    }

    public int getId(int index) {
        int tempId = 0;
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            JSONObject jsonData = (JSONObject) jsonArray.get(index);
            tempId = BigDecimal.valueOf((Long) jsonData.get("id")).intValue();
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return tempId;

    }

    public Coordinates getCoordinates(int index) {
        Coordinates coordinates = new Coordinates();
        Double jsonX = 0.0;
        Float jsonY = 0f;
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            JSONObject jsonData = (JSONObject) jsonArray.get(index);
            jsonX = (Double) jsonData.get("coordinate_x");
            jsonY = BigDecimal.valueOf((Double) jsonData.get("coordinate_y")).floatValue();
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        coordinates.setX(jsonX);
        coordinates.setY(jsonY);
        return coordinates;
    }


    public int getHealth(int index) {
        Integer jsonHealth = 0;
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            JSONObject jsonData = (JSONObject) jsonArray.get(index);
            jsonHealth = BigDecimal.valueOf((Long) jsonData.get("health")).intValue();
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return jsonHealth;
    }

    public AstartesCategory getAstartesCategory(int index) {
        AstartesCategory jsonCategory = null;
        String tempComparison;
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            JSONObject jsonData = (JSONObject) jsonArray.get(index);
            tempComparison = (String) jsonData.get("category");
            switch (tempComparison) {
                case "AGGRESSOR":
                    jsonCategory = AstartesCategory.AGGRESSOR;
                    break;
                case "INCEPTOR":
                    jsonCategory = AstartesCategory.INCEPTOR;
                    break;
                case "TACTICAL":
                    jsonCategory = AstartesCategory.TACTICAL;
                    break;
                case "TERMINATOR":
                    jsonCategory = AstartesCategory.TERMINATOR;
                    break;
            }
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return jsonCategory;
    }

    public Weapon getWeapon(int index) {
        Weapon jsonWeapon = null;
        String tempComparison;
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            JSONObject jsonData = (JSONObject) jsonArray.get(index);
            tempComparison = (String) jsonData.get("weapon");
            switch (tempComparison) {
                case "MELTAGUN":
                    jsonWeapon = Weapon.MELTAGUN;
                    break;
                case "BOLT_PISTOL":
                    jsonWeapon = Weapon.BOLT_PISTOL;
                    break;
                case "COMBI_FLAMER":
                    jsonWeapon = Weapon.COMBI_FLAMER;
                    break;
                case "COMBI_PLASMA_GUN":
                    jsonWeapon = Weapon.COMBI_PLASMA_GUN;
                    break;
                case "MISSILE_LAUNCHER":
                    jsonWeapon = Weapon.MISSILE_LAUNCHER;
                    break;
                default:
                    jsonWeapon = null;
                    break;
            }
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return jsonWeapon;

    }

    public MeleeWeapon getMeleeWeapon(int index) {
        MeleeWeapon jsonMeleeWeapon = null;
        String tempComparison;
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            JSONObject jsonData = (JSONObject) jsonArray.get(index);
            tempComparison = (String) jsonData.get("melee_weapon");
            switch (tempComparison) {
                case "CHAIN_SWORD":
                    jsonMeleeWeapon = MeleeWeapon.CHAIN_SWORD;
                    break;
                case "MANREAPER":
                    jsonMeleeWeapon = MeleeWeapon.MANREAPER;
                    break;
                case "POWER_BLADE":
                    jsonMeleeWeapon = MeleeWeapon.POWER_BLADE;
                    break;
                default:
                    jsonMeleeWeapon = null;
                    break;
            }
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return jsonMeleeWeapon;

    }

    public Chapter getChapter(int index) {
        Chapter chapter = new Chapter();
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            JSONObject jsonData = (JSONObject) jsonArray.get(index);
            chapter.setName((String) jsonData.get("chapter"));
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return chapter;
    }

}
