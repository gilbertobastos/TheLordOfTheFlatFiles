package br.com.gaob.ltff.rowParsers;

import br.com.gaob.ltff.rowFormats.AbstractRowFormat;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractRowParser {

    /**
     * Number formatter.
     */
    private DecimalFormatSymbols decimalFormatSymbols;
    private DecimalFormat decimalFormat;

    /**
     * The "specification" of the row format.
     */
    private AbstractRowFormat rowFormat;

    /**
     * Date formatter.
     */
    private SimpleDateFormat simpleDateFormat;

    /**
     *
     * @param rowFormat The "specification" of the row format.
     */
    public AbstractRowParser(AbstractRowFormat rowFormat) {
        this.rowFormat = rowFormat;

        decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator(rowFormat.getDecimalPointSymbol());

        decimalFormat = new DecimalFormat();
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        decimalFormat.setMaximumFractionDigits(rowFormat.getDecimalPlacesCount());

        simpleDateFormat = (rowFormat.getSimpleDateFormatPattern() != null) ?
                (new SimpleDateFormat(rowFormat.getSimpleDateFormatPattern())) :
                (new SimpleDateFormat());
    }

    /**
     * The method responsible for parsing the row and creating a array of "primitive-like"
     * objects that holds all the row values.
     *
     * @param inputRowString The row string.
     * @param outputRowDataArray A array with "primitive-like" objects that holds the values of row.
     * @throws ParseException If the parsing process fail.
     */
    public abstract void parseRow(String inputRowString, Object[] outputRowDataArray) throws ParseException;

    /**
     *
     * @param value Value to be parsed.
     * @return Parsed value wrapped in a object.
     * @throws ParseException If the parsing process fail.
     */
    private Double getParsedDouble(String value) throws ParseException {
        return decimalFormat.parse(value).doubleValue();
    }

    /**
     *
     * @param value Value to be parsed.
     * @return Parsed value wrapped in a object.
     * @throws ParseException If the parsing process fail.
     */
    private Integer getParsedInteger(String value) throws ParseException {
        return decimalFormat.parse(value).intValue();
    }

    /**
     *
     * @param value Value to be parsed.
     * @return Parsed value wrapped in a object.
     * @throws ParseException If the parsing process fail.
     */
    private String getParsedString(String value) throws ParseException {
        return value;
    }

    /**
     *
     * @param value Value to be parsed.
     * @return Parsed value wrapped in a object.
     * @throws ParseException If the parsing process fail.
     */
    private Date getParsedDate(String value) throws ParseException {
        return simpleDateFormat.parse(value);
    }

    /**
     *
     * @param value Value to be parsed.
     * @param columnType Parsed value wrapped in a object.
     * @return Parsed value wrapped in a object.
     * @throws ParseException If the parsing process fail.
     */
    public Object getParsedValue(String value, Class columnType) throws ParseException {

        switch (columnType.getSimpleName()) {
            case "Double":
                return getParsedDouble(value);
            case "Integer":
                return  getParsedInteger(value);
            case "String":
                return getParsedString(value);
            case "Date":
                return getParsedDate(value);
        }

        return null;
    }

    /**
     *
     * @return The row format class.
     */
    public AbstractRowFormat getRowFormat() { return this.rowFormat; }

    /**
     *
     * @return The decimal format class.
     */
    public DecimalFormat getDecimalFormat() { return decimalFormat; }
}
