package dk.kea.dat3js.hogwarts5.teachers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    @Test
    void getFullName() {
        //arrange
        Teacher teacher = new Teacher("Albus", "Dumbledore", null, null, null);

        //act
        var fullName = teacher.getFullName();

        //assert
        assertEquals("Albus Dumbledore", fullName);
    }

    @Test
    void getFullNameWithMiddleName() {
        //arrange
        Teacher teacher = new Teacher("Minerva", "McGonagall", "McGonagall", null, null, null);

        //act
        var fullName = teacher.getFullName();

        //assert
        assertEquals("Minerva McGonagall McGonagall", fullName);
    }

    @Test
    void getFullNameWithoutMiddleName() {
        //arrange
        Teacher teacher = new Teacher("Severus", null, "Snape", null, null, null);

        //act
        var fullName = teacher.getFullName();

        //assert
        assertEquals("Severus Snape", fullName);
    }

    @Test
    void setFullNameWithMiddleName() {
        //arrange
        Teacher teacher = new Teacher("First", "Middle", "Last", null, null, null);

        //act
        teacher.setFullName("Filius Party Flitwick");

        //assert
        assertEquals("Filius", teacher.getFirstName());
        assertEquals("Party", teacher.getMiddleName());
        assertEquals("Flitwick", teacher.getLastName());
    }

    @Test
    void setFullNameWithoutMiddleName() {
        //arrange
        Teacher teacher = new Teacher("First", "Last", null, null, null);

        //act
        teacher.setFullName("Pomona Sprout");

        //assert
        assertEquals("Pomona", teacher.getFirstName());
        assertNull(teacher.getMiddleName());
        assertEquals("Sprout", teacher.getLastName());
    }

    @Test
    void setFullNameWithoutLastName() {
        //arrange
        Teacher teacher = new Teacher("First", "Middle", "Last", null, null, null);

        //act
        assertThrows(IllegalArgumentException.class, () -> teacher.setFullName("Hagrid"));
    }

    @Test
    void setFullNameWithMultipleMiddleNames() {
        //arrange
        Teacher teacher = new Teacher("First", "Middle", "Last", null, null, null);

        //act
        teacher.setFullName("Albus Percival Wulfric Brian Dumbledore");

        //assert
        assertEquals("Albus", teacher.getFirstName());
        assertEquals("Percival Wulfric Brian", teacher.getMiddleName());
        assertEquals("Dumbledore", teacher.getLastName());
    }

    @Test
    void setFullNameWithEmptyString() {
        //arrange
        Teacher teacher = new Teacher("First", "Middle", "Last", null, null, null);

        //act
        assertThrows(IllegalArgumentException.class, () -> teacher.setFullName(""));
    }

    @Test
    void setFullNameWithNull() {
        //arrange
        Teacher teacher = new Teacher("First", "Middle", "Last", null, null, null);

        //act
        assertThrows(IllegalArgumentException.class, () -> teacher.setFullName(null));
    }

    @Test
    void CapitalizeIndividualNames() {
        //arrange
        Teacher teacher = new Teacher("albus", "dumbledore", "dumbledore", null, null, null);

        //act
        teacher.setFullName("albus dumbledore dumbledore");

        //assert
        assertEquals("Albus", teacher.getFirstName());
        assertEquals("Dumbledore", teacher.getMiddleName());
        assertEquals("Dumbledore", teacher.getLastName());
    }

    @Test
    void CapitalizeIndividualNamesWithCrazyCapitalization() {
        //arrange
        Teacher teacher = new Teacher("sEvErUs", "sNaPe", "sNaPe", null, null, null);

        //act
        teacher.setFirstName("sEvErUs");
        teacher.setMiddleName("sNaPe");
        teacher.setLastName("sNaPe");

        //assert
        assertEquals("Severus", teacher.getFirstName());
        assertEquals("Snape", teacher.getMiddleName());
        assertEquals("Snape", teacher.getLastName());
    }
}