package br.com.gaob.ltff.rowFormats;

public class DelimiterSeparatedValuesRowFormat extends AbstractRowFormat {

    /**
     *  A delimiter symbol like ";" or "|" or "\t" (a tabulation) and etc...
     */
    private static String delimiterSymbol;

    /*  *
     *  A escape symbol to do the delimiter symbol be "ignored" and interpreted like a normal
     *  character.
     *
     *  Use "null" if you will not make/parse a row with no escape symbol.
     */
    private static String escapeSymbol;

    /**
     *
     * @param columnsFormat Array with the information about the columns.
     * @param rowTerminatorSymbol Row terminator symbol.
     * @param decimalPointSymbol Decimal point symbol (use "null" if you don't want a decimal point in your numeric values).
     * @param decimalPlacesCount The count of decimal digits of a numeric value.
     * @param datePattern The pattern that will be used to parse/assemble the date values.
     * @param delimiterSymbol A delimiter symbol (like a ";").
     * @param escapeSymbol A escape symbol do the delimiter symbol br "ignored".
     * @throws IllegalArgumentException If a class on the "columnsType" array doesn't be a "primitive-like" class.
     */
    public DelimiterSeparatedValuesRowFormat(
            DelimiterSeparatedColumnFormat[] columnsFormat, String rowTerminatorSymbol, char decimalPointSymbol,
            int decimalPlacesCount, String datePattern, String delimiterSymbol, String escapeSymbol
    )
    {
        super(columnsFormat, rowTerminatorSymbol, decimalPointSymbol, datePattern, decimalPlacesCount);

        this.delimiterSymbol = delimiterSymbol;
        this.escapeSymbol = escapeSymbol;
    }

    /**
     *
     * @return Delimiter symbol.
     */
    public String getDelimiterSymbol() { return delimiterSymbol; }

    /**
     *
     * @return Escape symbol.
     */
    public String getEscapeSymbol() { return escapeSymbol; }
}
