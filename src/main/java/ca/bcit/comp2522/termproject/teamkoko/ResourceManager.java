package ca.bcit.comp2522.termproject.teamkoko;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * ResourceManager class
 * @author Jesper
 * @version 1
 */

public class ResourceManager {

    /**
     * Saves the game
     * @param data datafile
     * @param fileName filename of this save_file
     * @throws Exception
     */
    public static void save(Serializable data, String fileName) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            oos.writeObject(data);
        }
    }


}
