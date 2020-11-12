package co.daniel16.pokedex.model;

import java.io.Serializable;

public class Pokemon implements Serializable {

    private String id;
    private String name;
    private String type;
    private String sprite;
    private int defense;
    private int attack;
    private int speed;
    private int life;

    public Pokemon() {
    }

    public Pokemon(String id, String name, String type, String sprite, int defense, int attack, int speed, int life) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.sprite = sprite;
        this.defense = defense;
        this.attack = attack;
        this.speed = speed;
        this.life = life;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
