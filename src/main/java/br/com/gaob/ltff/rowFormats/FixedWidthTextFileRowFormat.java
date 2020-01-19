package br.com.gaob.ltff.rowFormats;

import java.util.LinkedList;

public class FixedWidthTextFileRowFormat extends AbstractRowFormat {

    /**
     *
     * @param columnsFormat Array with the information about the columns.
     * @param rowTerminatorSymbol Row terminator symbol.
     * @param decimalPointSymbol Decimal point symbol (use "null" if you don't want a decimal point in your numeric values).
     * @param decimalPlacesCount The count of decimal digits of a numeric value.
     * @param simpleDateFormatPattern The pattern that will be used by the class {@link java.text.SimpleDateFormat} (or other) to
     *                                parse/assemble date values (use "null"  if you want to use the default patten for your locale).
     * @throws IllegalArgumentException If a class on the "columnsType" array doesn't be a "primitive-like" class.
     */
    public FixedWidthTextFileRowFormat(
            FixedWidthTextColumnFormat[] columnsFormat, String rowTerminatorSymbol, char decimalPointSymbol,
            int decimalPlacesCount, String simpleDateFormatPattern
    )
    {
        super(columnsFormat, rowTerminatorSymbol, decimalPointSymbol, simpleDateFormatPattern, decimalPlacesCount);
    }
}
