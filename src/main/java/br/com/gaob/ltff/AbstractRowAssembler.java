package br.com.gaob.ltff;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public abstract class AbstractRowAssembler {

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
     * Constructor...
     *
     * @param rowFormat The "specification" of the row format.
     */
    public AbstractRowAssembler(AbstractRowFormat rowFormat) {
        this.rowFormat = rowFormat;

        decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator(rowFormat.getDecimalPointSymbol());

        decimalFormat = new DecimalFormat();
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        decimalFormat.setMaximumFractionDigits(rowFormat.getDecimalPlacesCount());
    }

    /**
     * The method responsible for "assembling" a row with the "stipulated" row format.
     *
     * @param inputRowDataArray A array with "primitive-like" objects that holds the values of row.
     * @return A "assembled" string with the "stipulated" row format.
     */
    public abstract String mountRow(Object[] inputRowDataArray);

    /**
     *
     * @param object The object.
     * @return A string representation of the value of the object.
     */
    private String getFormattedString(String object) { return object; }

    /**
     *
     * @param object The object.
     * @return A string representation of the value of the object.
     */
    private String getFormattedInteger(Integer object) { return object.toString(); }

    /**
     *
     * @param object The object.
     * @return A string representation of the value of the object.
     */
    private String getFormattedDouble(Double object) {
        return decimalFormat.format(object);
    }

    /**
     *
     * @param object The object.
     * @return A string representation of the value of the object.
     */
    public String getFormattedValue(Object object) {
        switch (object.getClass().getSimpleName()) {
            case "Double":
                return getFormattedDouble((Double) object);
            case "Integer":
                return  getFormattedInteger((Integer) object);
            case "String":
                return getFormattedString((String) object);
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
