
import java.util.HashMap;

public class Typechart {

    // hashmap for element types
    private static final HashMap<String, HashMap<String, Double>> typeChart = new HashMap<>();

    static {

        // Normal
        HashMap<String, Double> normal = new HashMap<>();
        normal.put("Rock", 0.5);
        normal.put("Steel", 0.5);
        normal.put("Ghost", 0.0);

        // Fighting
        HashMap<String, Double> fighting = new HashMap<>();
        fighting.put("Normal", 2.0);
        fighting.put("Rock", 2.0);
        fighting.put("Steel", 2.0);
        fighting.put("Ice", 2.0);
        fighting.put("Dark", 2.0);
        fighting.put("Flying", 0.5);
        fighting.put("Poison", 0.5);
        fighting.put("Bug", 0.5);
        fighting.put("Psychic", 0.5);
        fighting.put("Fairy", 0.5);
        fighting.put("Ghost", 0.0);

        // Flying
        HashMap<String, Double> flying = new HashMap<>();
        flying.put("Fighting", 2.0);
        flying.put("Bug", 2.0);
        flying.put("Grass", 2.0);
        flying.put("Rock", 0.5);
        flying.put("Steel", 0.5);
        flying.put("Electric", 0.5);

        // Poison
        HashMap<String, Double> poison = new HashMap<>();
        poison.put("Grass", 2.0);
        poison.put("Fairy", 2.0);
        poison.put("Poison", 0.5);
        poison.put("Ground", 0.5);
        poison.put("Rock", 0.5);
        poison.put("Ghost", 0.5);
        poison.put("Steel", 0.0);

        // Ground
        HashMap<String, Double> ground = new HashMap<>();
        ground.put("Poison", 2.0);
        ground.put("Rock", 2.0);
        ground.put("Steel", 2.0);
        ground.put("Fire", 2.0);
        ground.put("Electric", 2.0);
        ground.put("Bug", 0.5);
        ground.put("Grass", 0.5);
        ground.put("Flying", 0.0);

        // Rock
        HashMap<String, Double> rock = new HashMap<>();
        rock.put("Flying", 2.0);
        rock.put("Bug", 2.0);
        rock.put("Fire", 2.0);
        rock.put("Ice", 2.0);
        rock.put("Fighting", 0.5);
        rock.put("Ground", 0.5);
        rock.put("Steel", 0.5);

        // Bug
        HashMap<String, Double> bug = new HashMap<>();
        bug.put("Grass", 2.0);
        bug.put("Psychic", 2.0);
        bug.put("Dark", 2.0);
        bug.put("Fighting", 0.5);
        bug.put("Flying", 0.5);
        bug.put("Poison", 0.5);
        bug.put("Ghost", 0.5);
        bug.put("Steel", 0.5);
        bug.put("Fire", 0.5);
        bug.put("Fairy", 0.5);

        // Ghost
        HashMap<String, Double> ghost = new HashMap<>();
        ghost.put("Ghost", 2.0);
        ghost.put("Psychic", 2.0);
        ghost.put("Dark", 0.5);
        ghost.put("Normal", 0.0);

        // Steel
        HashMap<String, Double> steel = new HashMap<>();
        steel.put("Rock", 2.0);
        steel.put("Ice", 2.0);
        steel.put("Fairy", 2.0);
        steel.put("Steel", 0.5);
        steel.put("Fire", 0.5);
        steel.put("Water", 0.5);
        steel.put("Electric", 0.5);

        // Fire
        HashMap<String, Double> fire = new HashMap<>();
        fire.put("Bug", 2.0);
        fire.put("Steel", 2.0);
        fire.put("Grass", 2.0);
        fire.put("Ice", 2.0);
        fire.put("Rock", 0.5);
        fire.put("Fire", 0.5);
        fire.put("Water", 0.5);
        fire.put("Dragon", 0.5);

        // Water
        HashMap<String, Double> water = new HashMap<>();
        water.put("Ground", 2.0);
        water.put("Rock", 2.0);
        water.put("Fire", 2.0);
        water.put("Water", 0.5);
        water.put("Grass", 0.5);
        water.put("Dragon", 0.5);

        // Grass
        HashMap<String, Double> grass = new HashMap<>();
        grass.put("Ground", 2.0);
        grass.put("Rock", 2.0);
        grass.put("Water", 2.0);
        grass.put("Flying", 0.5);
        grass.put("Poison", 0.5);
        grass.put("Bug", 0.5);
        grass.put("Steel", 0.5);
        grass.put("Fire", 0.5);
        grass.put("Grass", 0.5);
        grass.put("Dragon", 0.5);

        // Electric
        HashMap<String, Double> electric = new HashMap<>();
        electric.put("Flying", 2.0);
        electric.put("Water", 2.0);
        electric.put("Grass", 0.5);
        electric.put("Electric", 0.5);
        electric.put("Dragon", 0.5);
        electric.put("Ground", 0.0);

        // Psychic
        HashMap<String, Double> psychic = new HashMap<>();
        psychic.put("Fighting", 2.0);
        psychic.put("Poison", 2.0);
        psychic.put("Steel", 0.5);
        psychic.put("Psychic", 0.5);
        psychic.put("Dark", 0.0);

        // Ice
        HashMap<String, Double> ice = new HashMap<>();
        ice.put("Flying", 2.0);
        ice.put("Ground", 2.0);
        ice.put("Grass", 2.0);
        ice.put("Dragon", 2.0);
        ice.put("Steel", 0.5);
        ice.put("Fire", 0.5);
        ice.put("Water", 0.5);
        ice.put("Ice", 0.5);

        // Dragon
        HashMap<String, Double> dragon = new HashMap<>();
        dragon.put("Dragon", 2.0);
        dragon.put("Steel", 0.5);
        dragon.put("Fairy", 0.0);

        // Dark
        HashMap<String, Double> dark = new HashMap<>();
        dark.put("Ghost", 2.0);
        dark.put("Psychic", 2.0);
        dark.put("Fighting", 0.5);
        dark.put("Dark", 0.5);
        dark.put("Fairy", 0.5);

        // Fairy
        HashMap<String, Double> fairy = new HashMap<>();
        fairy.put("Fighting", 2.0);
        fairy.put("Dragon", 2.0);
        fairy.put("Dark", 2.0);
        fairy.put("Poison", 0.5);
        fairy.put("Steel", 0.5);
        fairy.put("Fire", 0.5);

        // All types into main chart (typeChart)
        typeChart.put("Normal", normal);
        typeChart.put("Fighting", fighting);
        typeChart.put("Flying", flying);
        typeChart.put("Poison", poison);
        typeChart.put("Ground", ground);
        typeChart.put("Rock", rock);
        typeChart.put("Bug", bug);
        typeChart.put("Ghost", ghost);
        typeChart.put("Steel", steel);
        typeChart.put("Fire", fire);
        typeChart.put("Water", water);
        typeChart.put("Grass", grass);
        typeChart.put("Electric", electric);
        typeChart.put("Psychic", psychic);
        typeChart.put("Ice", ice);
        typeChart.put("Dragon", dragon);
        typeChart.put("Dark", dark);
        typeChart.put("Fairy", fairy);
    }
}
