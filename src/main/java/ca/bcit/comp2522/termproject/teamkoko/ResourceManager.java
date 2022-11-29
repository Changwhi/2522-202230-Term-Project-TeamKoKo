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

    /**
     * Loads the game
     * @param fileName fileName
     * @return savefile as Object
     * @throws Exception
     */
    public static Object load(String fileName) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return ois.readObject();
        }
    }
}
