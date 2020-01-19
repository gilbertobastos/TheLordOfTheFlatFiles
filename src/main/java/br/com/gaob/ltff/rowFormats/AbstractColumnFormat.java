package br.com.gaob.ltff.rowFormats;

import java.util.Date;

public abstract  class AbstractColumnFormat {

    /**
     * The name of the column.
     */
    private String name;

    /**
     * The "primitive" type of the column.
     */
    private Class type;

    /**
     *
     * @param name The name of the column.
     * @param type The "primitive" type of the column.
     * @throws IllegalArgumentException If the type doesn't be a "primitive-like" class.
     */
    public AbstractColumnFormat(String name, Class type) throws IllegalArgumentException {

        /* Verifying if the class types is a "primitive-like" type. */
        if (
                !(type.equals(Double.class)) &&
                !(type.equals(Integer.class)) &&
                !(type.equals(String.class)) &&
                !(type.equals(Date.class))
        ) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.type = type;
    }

    /**
     * The name of the column.
     */
    public String getName() {
        return name;
    }

    /**
     *  The "primitive" type of the column
     */
    public Class getType() {
        return type;
    }
}
