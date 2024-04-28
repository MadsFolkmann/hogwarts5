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

    default String capitalize(String name){
        if (name == null || name.isEmpty()){
            return name;
        }
        String[] parts = name.split(" ");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].startsWith("Mc") && parts[i].length() > 2) {
                parts[i] = parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1, 2).toLowerCase() + parts[i].substring(2, 3).toUpperCase() + parts[i].substring(3).toLowerCase();
            } else {
                parts[i] = parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1).toLowerCase();
            }
        }
        return String.join(" ", parts);
    }
}
