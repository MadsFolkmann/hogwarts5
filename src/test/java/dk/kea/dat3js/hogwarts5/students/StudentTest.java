package dk.kea.dat3js.hogwarts5.students;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getFullName() {
        //arrange
        Student student = new Student("Harry", "Potter", null, 1);

        //act
        var fullName = student.getFullName();

        //assert
        assertEquals("Harry Potter", fullName);


    }

    @Test
    void getFullNameWithMiddleName() {
        //arrange
        Student student = new Student("Harry", "James", "Potter", null, 1);

        //act
        var fullName = student.getFullName();

        //assert
        assertEquals("Harry James Potter", fullName);
    }

    @Test
    void getFullNameWithoutMiddleName() {
        //arrange
        Student student = new Student("Harry", null, "Potter", null, 1);

        //act
        var fullName = student.getFullName();

        //assert
        assertEquals("Harry Potter", fullName);
    }

    @Test
    void setFullName() {
    }

    @Test
    void setFullNameWithMiddleName() {
        //arrange
        Student student = new Student("First", "Middle", "Last", null, 1);

        //act
        student.setFullName("Harry James Potter");

        //assert
        assertEquals("Harry", student.getFirstName());
        assertEquals("James", student.getMiddleName());
        assertEquals("Potter", student.getLastName());
    }

    @Test
    void setFullNameWithoutMiddleName() {
        //arrange
        Student student = new Student("First", "Middle", "Last", null, 1);

        //act
        student.setFullName("Harry Potter");

        //assert
        assertEquals("Harry", student.getFirstName());
        assertNull(student.getMiddleName());
        assertEquals("Potter", student.getLastName());
    }

    @Test
    void setFullNameWithoutLastName() {
        //arrange
        Student student = new Student("First", "Middle", "Last", null, 1);

        //act
        assertThrows(IllegalArgumentException.class, () -> student.setFullName("Harry"));
    }

    @Test
    void setFullNameWithMultipleMiddleNames() {
        //arrange
        Student student = new Student("First", "Middle", "Last", null, 1);

        //act
        student.setFullName("Harry James Sirius Potter");

        //assert
        assertEquals("Harry", student.getFirstName());
        assertEquals("James Sirius", student.getMiddleName());
        assertEquals("Potter", student.getLastName());
    }

    @Test
    void setFullNameWithEmptyString() {
        //arrange
        Student student = new Student("First", "Middle", "Last", null, 1);

        //act
        assertThrows(IllegalArgumentException.class, () -> student.setFullName(""));
    }

    @Test
    void setFullNameWithNull() {
        //arrange
        Student student = new Student("First", "Middle", "Last", null, 1);

        //act
        assertThrows(IllegalArgumentException.class, () -> student.setFullName(null));
    }

    @Test
    void CapitalizeIndividualNames() {
        //arrange
        Student student = new Student("harry", "james", "potter", null, 1);

        //act
        student.setFullName("harry james potter");

        //assert
        assertEquals("Harry", student.getFirstName());
        assertEquals("James", student.getMiddleName());
        assertEquals("Potter", student.getLastName());
    }

    @Test
    void CapitalizeIndividualNamesWithCrazyCapitalization() {
        //arrange
        Student student = new Student("hArRy", "JaMeS", "pOtTeR", null, 1);

        //act
        student.setFirstName("hArRy");
        student.setMiddleName("JaMeS");
        student.setLastName("pOtTeR");

        //assert
        assertEquals("Harry", student.getFirstName());
        assertEquals("James", student.getMiddleName());
        assertEquals("Potter", student.getLastName());
}
}