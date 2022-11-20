package ca.bcit.comp2522.termproject.teamkoko;

/**
 * one of the characters that player can choose.
 * @author Changwhi Oh
 * @version 1.0.0
 */
public class ChulSoo extends Player {
    private final String name;
    private final String skill;

    /**
     * A default constructor.
     */
    public ChulSoo() {
        super();
        this.name = "ChulSoo";
        this.skill = "Teleport";
    }

    /**
     * Returns Character's name.
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns Skill name.
     * @return String
     */
    public String getSkill() {
        return this.skill;
    }

}
