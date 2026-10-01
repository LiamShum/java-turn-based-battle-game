
import java.util.HashMap;

public class MoveLibrary {

    private static final HashMap<String, HashMap<String, Double>> movesByType
            = new HashMap<>();

    static {

        // Normal
        HashMap<String, Double> normal = new HashMap<>();
        normal.put("Tackle", 40.0);
        normal.put("Quick Attack", 40.0);
        normal.put("Slash", 70.0);
        normal.put("Body Slam", 85.0);
        movesByType.put("Normal", normal);

        // Fire
        HashMap<String, Double> fire = new HashMap<>();
        fire.put("Ember", 40.0);
        fire.put("Flame Charge", 50.0);
        fire.put("Fire Punch", 75.0);
        fire.put("Flamethrower", 90.0);
        movesByType.put("Fire", fire);

        // Water
        HashMap<String, Double> water = new HashMap<>();
        water.put("Water Gun", 40.0);
        water.put("Water Pulse", 60.0);
        water.put("Aqua Tail", 90.0);
        water.put("Surf", 90.0);
        movesByType.put("Water", water);

        // Electric
        HashMap<String, Double> electric = new HashMap<>();
        electric.put("Thunder Shock", 40.0);
        electric.put("Spark", 65.0);
        electric.put("Thunder Punch", 75.0);
        electric.put("Thunderbolt", 90.0);
        movesByType.put("Electric", electric);

        // Grass
        HashMap<String, Double> grass = new HashMap<>();
        grass.put("Vine Whip", 45.0);
        grass.put("Razor Leaf", 55.0);
        grass.put("Seed Bomb", 80.0);
        grass.put("Energy Ball", 90.0);
        movesByType.put("Grass", grass);

        // Ice
        HashMap<String, Double> ice = new HashMap<>();
        ice.put("Ice Shard", 40.0);
        ice.put("Icy Wind", 55.0);
        ice.put("Ice Punch", 75.0);
        ice.put("Ice Beam", 90.0);
        movesByType.put("Ice", ice);

        // Fighting
        HashMap<String, Double> fighting = new HashMap<>();
        fighting.put("Mach Punch", 40.0);
        fighting.put("Low Sweep", 65.0);
        fighting.put("Brick Break", 75.0);
        fighting.put("Aura Sphere", 80.0);
        movesByType.put("Fighting", fighting);

        // Poison
        HashMap<String, Double> poison = new HashMap<>();
        poison.put("Poison Sting", 15.0);
        poison.put("Acid", 40.0);
        poison.put("Poison Jab", 80.0);
        poison.put("Sludge Bomb", 90.0);
        movesByType.put("Poison", poison);

        // Ground
        HashMap<String, Double> ground = new HashMap<>();
        ground.put("Mud Slap", 20.0);
        ground.put("Bulldoze", 60.0);
        ground.put("Dig", 80.0);
        ground.put("Earthquake", 100.0);
        movesByType.put("Ground", ground);

        // Flying
        HashMap<String, Double> flying = new HashMap<>();
        flying.put("Peck", 35.0);
        flying.put("Wing Attack", 60.0);
        flying.put("Air Slash", 75.0);
        flying.put("Fly", 90.0);
        movesByType.put("Flying", flying);

        // Psychic
        HashMap<String, Double> psychic = new HashMap<>();
        psychic.put("Confusion", 50.0);
        psychic.put("Psybeam", 65.0);
        psychic.put("Zen Headbutt", 80.0);
        psychic.put("Psychic", 90.0);
        movesByType.put("Psychic", psychic);

        // Bug
        HashMap<String, Double> bug = new HashMap<>();
        bug.put("Struggle Bug", 50.0);
        bug.put("Bug Bite", 60.0);
        bug.put("X-Scissor", 80.0);
        bug.put("Bug Buzz", 90.0);
        movesByType.put("Bug", bug);

        // Rock
        HashMap<String, Double> rock = new HashMap<>();
        rock.put("Rock Throw", 50.0);
        rock.put("Rock Tomb", 60.0);
        rock.put("Rock Slide", 75.0);
        rock.put("Stone Edge", 100.0);
        movesByType.put("Rock", rock);

        // Ghost
        HashMap<String, Double> ghost = new HashMap<>();
        ghost.put("Lick", 30.0);
        ghost.put("Shadow Sneak", 40.0);
        ghost.put("Hex", 65.0);
        ghost.put("Shadow Ball", 80.0);
        movesByType.put("Ghost", ghost);

        // Dragon
        HashMap<String, Double> dragon = new HashMap<>();
        dragon.put("Twister", 40.0);
        dragon.put("Dragon Breath", 60.0);
        dragon.put("Dragon Claw", 80.0);
        dragon.put("Dragon Pulse", 85.0);
        movesByType.put("Dragon", dragon);

        // Dark
        HashMap<String, Double> dark = new HashMap<>();
        dark.put("Bite", 60.0);
        dark.put("Payback", 50.0);
        dark.put("Night Slash", 70.0);
        dark.put("Dark Pulse", 80.0);
        movesByType.put("Dark", dark);

        // Steel
        HashMap<String, Double> steel = new HashMap<>();
        steel.put("Metal Claw", 50.0);
        steel.put("Bullet Punch", 40.0);
        steel.put("Iron Head", 80.0);
        steel.put("Flash Cannon", 80.0);
        movesByType.put("Steel", steel);

        // Fairy
        HashMap<String, Double> fairy = new HashMap<>();
        fairy.put("Fairy Wind", 40.0);
        fairy.put("Draining Kiss", 50.0);
        fairy.put("Dazzling Gleam", 80.0);
        fairy.put("Play Rough", 90.0);
        movesByType.put("Fairy", fairy);
    }


    // get available moves for two types 
    public static HashMap<String, Double> getAvailableMoves(String type1, String type2) {
        HashMap<String, Double> availablemoves = new HashMap<>();

        availablemoves.putAll(movesByType.get(type1));
        availablemoves.putAll(movesByType.get(type2));

        return availablemoves;

    }
}
