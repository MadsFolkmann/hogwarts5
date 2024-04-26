package dk.kea.dat3js.hogwarts5;

import java.util.Arrays;

public interface PersonWithNames {
    String getFirstName();
    String getMiddleName();
    String getLastName();
    void setFirstName(String firstName);
    void setMiddleName(String middleName);
    void setLastName(String lastName);

    default String getFullName() {
        return getFirstName() + " " + (getMiddleName() != null ? getMiddleName() + " " : "") + getLastName();    }

    default void setFullName(String fullName) {
        if (fullName == null) {
            throw new IllegalArgumentException("Full name cannot be null");
        }

        String[] names = fullName.split(" ");
        if (names.length >= 2) {
            setFirstName(names[0]);
            setLastName(names[names.length - 1]);

            if (names.length > 2) {
                String middleName = String.join(" ", Arrays.copyOfRange(names, 1, names.length - 1));
                setMiddleName(middleName);
            } else {
                setMiddleName(null);
            }
        } else {
            throw new IllegalArgumentException("Invalid full name");
        }
    }

    default String capitalize(String name) {
        if (name.contains(" ")) {
            int space = name.indexOf(" ");
            return capitalize(name.substring(0, space))+ " " + capitalize(name.substring(space+1));
        } else {
            return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }
    }
}
