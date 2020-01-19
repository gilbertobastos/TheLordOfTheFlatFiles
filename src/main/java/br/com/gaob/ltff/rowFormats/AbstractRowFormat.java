package br.com.gaob.ltff.rowFormats;

import java.util.Date;

public abstract class AbstractRowFormat {

    /**
     * Array with the information about the columns.
     */
    private AbstractColumnFormat[] columnsFormat;

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
     * The pattern that will be used to parse/assemble the date values.
     */
     private String datePattern;

    /**
     * Constructor...
     *
     * @param columnsFormat Array with the information about the columns.
     * @param rowTerminatorSymbol Row terminator symbol.
     * @param decimalPointSymbol Decimal point symbol (use "null" if you don't want a decimal point in your numeric values).
     * @param decimalPlacesCount The count of decimal digits of a numeric value.
     * @param datePattern The pattern that will be used to parse/assemble the date values.
     */
    public AbstractRowFormat(
            AbstractColumnFormat[] columnsFormat,
            String rowTerminatorSymbol,
            char decimalPointSymbol,
            String datePattern,
            int decimalPlacesCount)
    {
        this.columnsFormat = columnsFormat;
        this.rowTerminatorSymbol = rowTerminatorSymbol;
        this.decimalPointSymbol = decimalPointSymbol;
        this.decimalPlacesCount = decimalPlacesCount;
        this.datePattern = datePattern;
    }

    /**
     *
     * @return Column count.
     */
    public int getColumnCount() { return columnsFormat.length; }

    /**
     *
     * @param index The "number" (or position) of the column.
     * @return Column Format.
     */
    public AbstractColumnFormat getColumnFormat(int index) {
        return columnsFormat[index];
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
     * @return The pattern that will be used to parse/assemble the date values.
     */
    public String getDatePattern() {return datePattern; }
}
