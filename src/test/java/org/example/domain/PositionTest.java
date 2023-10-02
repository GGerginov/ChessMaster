package org.example.domain;


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    public void testPositionStateWhenCreatedThenGetXAndY() {
        Position position = new Position.Builder().x(5).y(10).build();

        int x = position.getX();
        int y = position.getY();

        assertEquals(5,x);
        assertEquals(10,y);
    }

    @Test
    public void testEqualsMethodWhenSameXAndYThenTrue() {
        Position position1 = new Position.Builder().x(5).y(10).build();
        Position position2 = new Position.Builder().x(5).y(10).build();


        boolean isEqual = position1.equals(position2);

        assertTrue(isEqual);
    }

    @Test
    public void testEqualsMethodWhenDifferentXAndYThenFalse() {
        Position position1 = new Position.Builder().x(5).y(10).build();
        Position position2 = new Position.Builder().x(10).y(5).build();

        boolean isEqual = position1.equals(position2);

        assertFalse(isEqual);
    }

    @Test
    public void testHashCodeMethodWhenSameXAndYThenEqual() {
        // Arrange
        Position position1 = new Position.Builder().x(5).y(10).build();
        Position position2 = new Position.Builder().x(5).y(10).build();

        int hashCode1 = position1.hashCode();
        int hashCode2 = position2.hashCode();

        boolean isEqual = hashCode1 == hashCode2;

        assertTrue(isEqual);
    }

    @Test
    public void testHashCodeMethodWhenDifferentXAndYThenNotEqual() {

        Position position1 = new Position.Builder().x(5).y(10).build();
        Position position2 = new Position.Builder().x(10).y(5).build();

        int hashCode1 = position1.hashCode();
        int hashCode2 = position2.hashCode();
        boolean isEqual = hashCode1 == hashCode2;

        assertFalse(isEqual);
    }




}