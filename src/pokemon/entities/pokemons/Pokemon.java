/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.entities.pokemons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import pokemon.entities.creatures.Player;
import pokemon.gfx.Assets;
import pokemon.utils.Utils;

/**
 *
 * @author Administrador
 */
public class Pokemon{
    
    private int level, hit_Points, attack, defense;
    private int health_Stat, attack_Stat, defense_Stat, specialAttack_Stat,
            specialDefense_Stat, speed_Stat, rareness, base_Exp, happiness,
            steps_To_Hatch, battler_Player_Y, battler_Enemy_Y, battler_Altitude;
    private int[] base_Stats, effort_Points, compatibility;
    private float pokemon_height, pokemon_weight;
    private String name, internal_Name, kind, pokedex_Text, growth_Rate, 
            color, habitat, hidden_Ability, gender_Rate;
    private String[] abilities;
    private Type type1, type2;
    private Move moves, egg_Moves;
    private Pokemon evolutions;
    
    private final int id, image_X, image_Y, image_Width, image_Height;
    private final Image[] pokemonSprite;
    
    public static final int DEFAULT_POKEMON_WIDTH = 256, DEFAULT_POKEMON_HEIGHT = 256;
    
    private static String path;
    
    private static final String[] IGNORED_WORDS = {"Name=", "InternalName=", "Kind=", "Pokedex=",
        "Type1=", "Type2=", "BaseStats=", "Rareness=", "BaseEXP=", "Happiness=", "GrowthRate=",
        "StepsToHatch=", "Color=", "Habitat=", "EffortPoints=", "Abilities=",
        "HiddenAbility=", "Compatibility=", "Height=", "Weight=", "GenderRate=",
        "Moves=", "EggMoves=", "Evolutions=", "BattlerPlayerY=", "BattlerEnemyY=",
        "BattlerAltitude="};;
    
    public Pokemon(int id, int image_X, int image_Y, int image_Width, int image_Height, Image[] pokemonSprite) {
        this.id = id;
        this.image_X = image_X;
        this.image_Y = image_Y;
        this.image_Width = image_Width;
        this.image_Height = image_Height;
        this.pokemonSprite = pokemonSprite;
        path = Assets.pokemon_database;
        
        loadPokemon(id, path);
        
        level = 5;
        hit_Points = (((health_Stat * 2) * level) / 100) + level + 10;
        attack = (((attack_Stat * 2) * level) / 100) + 5;
        defense = (((defense_Stat * 2) * level) / 100) + 5;
    }

    public void tick() {
        
    }
    
    public void render(Graphics g) {
        g.drawImage(pokemonSprite[id], image_X, image_Y, image_Width, image_Height, null);
//        g.setColor(Color.red);
//        g.drawRect(imageX, image_Y, image_Width, image_Height);
    }
    
        private void loadPokemon(int id, String path){
        String file = Utils.loadPokemonInfoAsString(id, path, IGNORED_WORDS);
        String[] tokens = file.split("\n");
        
        name = tokens[0];
        internal_Name = tokens[1];
        kind = tokens[2];
        pokedex_Text = tokens[3];
//        type1 = Type.getType(tokens[4]);
//        type2 = Type.getType(tokens[5]);
        base_Stats = Pokemon.getBase_Stats(tokens[6]);
        health_Stat = base_Stats[0];
        attack_Stat = base_Stats[1];
        defense_Stat = base_Stats[2];
        specialAttack_Stat = base_Stats[3];
        specialDefense_Stat = base_Stats[4];
        speed_Stat = base_Stats[5];
        rareness = Utils.parseInt(tokens[7]);
        base_Exp = Utils.parseInt(tokens[8]);
        happiness = Utils.parseInt(tokens[9]);
        growth_Rate = tokens[10];
        steps_To_Hatch = Utils.parseInt(tokens[11]);
        color = tokens[12];
        habitat = tokens[13];
//        effort_Points = Pokemon.getEffort_Points(tokens[14]);
//        abilities = Ability.getAbility(tokens[15]);
//        hidden_Ability = Ability.getAbility(tokens[16]);
//        compatibility = Pokemon.getCompatibility(tokens[17]);
        pokemon_height = Utils.parseFloat(tokens[18]);
        pokemon_weight = Utils.parseFloat(tokens[19]);
        gender_Rate = tokens[20];
//        moves = Pokemon.getMoves(tokens[21]);
//        egg_Moves = Pokemon.getMoves(tokens[22]);
//        evolutions = Pokemon.getEvolution(tokens[23]);
        battler_Player_Y = Utils.parseInt(tokens[24]);
        battler_Enemy_Y = Utils.parseInt(tokens[25]);
        battler_Altitude = Utils.parseInt(tokens[26]);
    }

    private static int[] getBase_Stats(String token) {
        String[] baseStatsString = token.split(",");
        int[] baseStatsInt = new int[6];
        for (int i = 0; i < 6; i++) {
            baseStatsInt[i] = Utils.parseInt(baseStatsString[i]);
        }
        return baseStatsInt;
    }
    
    public int getHit_Points() {
        return hit_Points;
    }

    public void setHit_Points(int hit_Points) {
        this.hit_Points = hit_Points;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthStat() {
        return health_Stat;
    }

    public void setHealthStat(int health) {
        this.health_Stat = health;
    }

    public int getAttackStat() {
        return attack_Stat;
    }

    public void setAttackStat(int attack) {
        this.attack_Stat = attack;
    }

    public int getDefenseStat() {
        return defense_Stat;
    }

    public void setDefenseStat(int defense) {
        this.defense_Stat = defense;
    }

    public int getSpecial_AttackStat() {
        return specialAttack_Stat;
    }

    public void setSpecial_AttackStat(int special_Attack) {
        this.specialAttack_Stat = special_Attack;
    }

    public int getSpecial_DefenseStat() {
        return specialDefense_Stat;
    }

    public void setSpecial_DefenseStat(int special_Defense) {
        this.specialDefense_Stat = special_Defense;
    }

    public int getSpeedStat() {
        return speed_Stat;
    }

    public void setSpeedStat(int speed) {
        this.speed_Stat = speed;
    }

    public int getRareness() {
        return rareness;
    }

    public void setRareness(int rareness) {
        this.rareness = rareness;
    }

    public int getBase_Exp() {
        return base_Exp;
    }

    public void setBase_Exp(int base_Exp) {
        this.base_Exp = base_Exp;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getSteps_To_Hatch() {
        return steps_To_Hatch;
    }

    public void setSteps_To_Hatch(int steps_To_Hatch) {
        this.steps_To_Hatch = steps_To_Hatch;
    }

    public int getBattler_Player_Y() {
        return battler_Player_Y;
    }

    public void setBattler_Player_Y(int battler_Player_Y) {
        this.battler_Player_Y = battler_Player_Y;
    }

    public int getBattler_Enemy_Y() {
        return battler_Enemy_Y;
    }

    public void setBattler_Enemy_Y(int battler_Enemy_Y) {
        this.battler_Enemy_Y = battler_Enemy_Y;
    }

    public int getBattler_Altitude() {
        return battler_Altitude;
    }

    public void setBattler_Altitude(int battler_Altitude) {
        this.battler_Altitude = battler_Altitude;
    }

    public int[] getBase_Stats() {
        return base_Stats;
    }

    public void setBase_Stats(int[] base_Stats) {
        this.base_Stats = base_Stats;
    }

    public int[] getEffort_Points() {
        return effort_Points;
    }

    public void setEffort_Points(int[] effort_Points) {
        this.effort_Points = effort_Points;
    }

    public int[] getCompatibility() {
        return compatibility;
    }

    public void setCompatibility(int[] compatibility) {
        this.compatibility = compatibility;
    }

    public float getPokemon_height() {
        return pokemon_height;
    }

    public void setPokemon_height(float pokemon_height) {
        this.pokemon_height = pokemon_height;
    }

    public float getPokemon_weight() {
        return pokemon_weight;
    }

    public void setPokemon_weight(float pokemon_weight) {
        this.pokemon_weight = pokemon_weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInternal_Name() {
        return internal_Name;
    }

    public void setInternal_Name(String internal_Name) {
        this.internal_Name = internal_Name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getPokedex_Text() {
        return pokedex_Text;
    }

    public void setPokedex_Text(String pokedex_Text) {
        this.pokedex_Text = pokedex_Text;
    }

    public String getGrowth_Rate() {
        return growth_Rate;
    }

    public void setGrowth_Rate(String growth_Rate) {
        this.growth_Rate = growth_Rate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getHidden_Ability() {
        return hidden_Ability;
    }

    public void setHidden_Ability(String hidden_Ability) {
        this.hidden_Ability = hidden_Ability;
    }

    public String getGender_Rate() {
        return gender_Rate;
    }

    public void setGender_Rate(String gender_Rate) {
        this.gender_Rate = gender_Rate;
    }

    public String[] getAbilities() {
        return abilities;
    }

    public void setAbilities(String[] abilities) {
        this.abilities = abilities;
    }

    public Type getType1() {
        return type1;
    }

    public void setType1(Type type1) {
        this.type1 = type1;
    }

    public Type getType2() {
        return type2;
    }

    public void setType2(Type type2) {
        this.type2 = type2;
    }

    public Move getMoves() {
        return moves;
    }

    public void setMoves(Move moves) {
        this.moves = moves;
    }

    public Move getEgg_Moves() {
        return egg_Moves;
    }

    public void setEgg_Moves(Move egg_Moves) {
        this.egg_Moves = egg_Moves;
    }

    public Pokemon getEvolutions() {
        return evolutions;
    }

    public void setEvolutions(Pokemon evolutions) {
        this.evolutions = evolutions;
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        Pokemon.path = path;
    }

    public int getAttack() {
        return attack;
    }
    
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }
    
    public void setDefense(int defense) {
        this.defense = defense;
    }
}
