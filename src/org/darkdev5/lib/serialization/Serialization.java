package org.darkdev5.lib.serialization;

import lombok.Getter;
import lombok.Setter;

import java.io.*;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 * @param <T>
 */
public @Getter
@Setter class Serialization<T> {
    private String path;
    T object;

    public Serialization(String path, T object) {
        this.path = path;
        this.object = object;
    }

    /**
     * Check the object to see if it implements Serializable interface or not.
     *
     * @return Returns true if it implements Serializable interface and false if not.
     */
    public boolean isSerializable() {
        return object instanceof Serializable;
    }

    /**
     * Serializable an object and save it to a file.
     *
     * @return Returns true if Serialize was successful and false if not.
     */
    public boolean serialize() {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Reads a file and deSerialize an object and save it to an object.
     *
     * @return Returns true if deSerialize was successful and false if not.
     */
    @SuppressWarnings("unchecked")
    public T deSerialize() {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
