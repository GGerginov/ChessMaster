package org.example.domain;

/**
 * The `Position` class represents a position on a two-dimensional chess board.
 * It contains the x and y coordinates of the position.
 */
public class Position {
    private final int x;
    private final int y;

    private Position(Builder builder) {
        this.x = builder.x;
        this.y = builder.y;
    }

    /**
     * Returns the x coordinate of the position.
     *
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y coordinate of the position.
     *
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * The `Builder` class is used to construct a `Position` object.
     * It provides methods to set the x and y coordinates.
     */
    public static class Builder {
        private int x;
        private int y;

        public Builder() {
        }

        /**
         * Sets the x coordinate of the position.
         *
         * @param x the x coordinate
         * @return the builder object
         */
        public Builder x(int x) {
            this.x = x;
            return this;
        }

        /**
         * Sets the y coordinate of the position.
         *
         * @param y the y coordinate
         * @return the builder object
         */
        public Builder y(int y) {
            this.y = y;
            return this;
        }

        /**
         * Builds a new `Position` object with the specified coordinates.
         *
         * @return the new `Position` object
         */
        public Position build() {
            return new Position(this);
        }
    }

    /**
     * Checks if this `Position` object is equal to another object.
     * Two `Position` objects are considered equal if they have the same x and y coordinates.
     *
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;

        if (getX() != position.getX()) return false;
        return getY() == position.getY();
    }

    /**
     * Returns the hash code value for this `Position` object.
     *
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        int result = getX();
        result = 31 * result + getY();
        return result;
    }
}