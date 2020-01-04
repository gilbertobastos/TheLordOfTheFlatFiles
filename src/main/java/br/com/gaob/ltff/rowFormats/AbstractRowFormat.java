package br.com.gaob.ltff.rowFormats;

import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class AbstractRowFormat {

    /**
     *  The "primitive" type of the columns in the order
     *  that they appear on the row.
     */
    private Class[] columnsType;

    /**
     *  The row-terminator symbol (character).
     *
     *  Example:
     *
     *  Unix-like systems: \n
     *  Windows: \r\n
     *
     *  and so on...local
     */
    private String rowTerminatorSymbol;

    /**
     * The decimal point symbol (use "null" if you don't want a decimal point in your numeric values).
     */
    private char decimalPointSymbol;

    /**
     * The count of decimal digits of a numeric value (use "0" if the row will not have floating-point values).
     */
    private int decimalPlacesCount;

    /**
     * The pattern that will be used by the class {@link SimpleDateFormat} to parse/assemble date values (use "null"
     * if you want to use the default patten for your locale).
     */
    private String simpleDateFormatPattern;

    /**
     * Constructor...
     *
     * @param columnsType A array with a collection of "primitive-like" types.
     * @param rowTerminatorSymbol Row terminator symbol.
     * @param decimalPointSymbol Decimal point symbol (use "null" if you don't want a decimal point in your numeric values).
     * @param decimalPlacesCount The count of decimal digits of a numeric value.
     * @param simpleDateFormatPattern The pattern that will be used by the class {@link SimpleDateFormat} to parse/assemble date
     *                                     values (use "null"  if you want to use the default patten for your locale).
     * @throws IllegalArgumentException If a class on the "columnsType" array doesn't be a "primitive-like" class.
     */
    public AbstractRowFormat(
            Class[] columnsType,
            String rowTerminatorSymbol,
            char decimalPointSymbol,
            String simpleDateFormatPattern,
            int decimalPlacesCount)
    {
        /* Verifying if the classes types of the array are "primitive-like" types. */
        for (Class c: columnsType) {
            if (
                    !(c.equals(Double.class)) &&
                    !(c.equals(Integer.class)) &&
                    !(c.equals(String.class)) &&
                    !(c.equals(Date.class))
            )
                throw new IllegalArgumentException();
        }

        this.columnsType = columnsType;
        this.rowTerminatorSymbol = rowTerminatorSymbol;
        this.decimalPointSymbol = decimalPointSymbol;
        this.decimalPlacesCount = decimalPlacesCount;
        this.simpleDateFormatPattern = simpleDateFormatPattern;
    }

    /**
     *
     * @return Column count.
     */
    public int getColumnCount() { return columnsType.length; }

    /**
     *
     * @param index The "number" (or position) of the column.
     * @return A class.
     */
    public Class getColumnType(int index) {
        return columnsType[index];
    }

    /**
     *
     * @return Row terminator symbol.
     */
    public String getRowTerminatorSymbol() { return rowTerminatorSymbol; }

    /**
     *
     * @return The decimal point symbol.
     */
    public char getDecimalPointSymbol() {
        return decimalPointSymbol;
    }

    /**
     *
     * @return The count of decimal digits of a numeric value.
     */
    public int getDecimalPlacesCount() {
        return decimalPlacesCount;
    }

    /**
     *
     * @return The pattern that will be used by the class {@link SimpleDateFormat} to parse/assemble date values.
     */
    public String getSimpleDateFormatPattern() {return simpleDateFormatPattern; }
}
