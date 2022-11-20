package ca.bcit.comp2522.termproject.teamkoko;

/**
 * One of the character that player can choose.
 * @author Changwhi Oh
 * @version 1.0.0
 */
public class YoungHee extends Player {

    private final String name;
    private final String skill;

    /**
     * A default constructor.
     */
    public YoungHee() {
        super();
        this.name = "YoungHee";
        this.skill = "Jump";
    }

    /**
     * Returns character's name.
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns skill name.
     * @return String
     */
    public String getSkill() {
        return this.skill;
    }



}
