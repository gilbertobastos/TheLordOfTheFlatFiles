package br.com.gaob.ltff;

import javax.print.DocFlavor;

public class DelimiterSeparatedRowAssembler extends AbstractRowAssembler {

    /**
     * Constructor...
     *
     * @param rowFormat The "specification" of the row format.
     */
    public DelimiterSeparatedRowAssembler(DelimiterSeparatedValuesRowFormat rowFormat) {
        super(rowFormat);
    }

    /**
     * The method responsible for "assembling" a row with the delimiter-separated value format (like a CSV file).
     *
     * @param inputRowDataArray A array with "primitive-like" objects that holds the values of row.
     * @return A "assembled" string with the delimiter-separated value format.
     */
    @Override
    public String mountRow(Object[] inputRowDataArray) {

        StringBuilder stringBuilder = new StringBuilder(4096);
        DelimiterSeparatedValuesRowFormat rowFormat = (DelimiterSeparatedValuesRowFormat) super.getRowFormat();

        /* Walking though the object collection to mount the row. */
        for (Object obj: inputRowDataArray) {

            String formattedValue;
            formattedValue = getFormatedValue(obj);

            boolean needEscapeChars;
            needEscapeChars = rowFormat.getEscapeSymbol() != null &&
                    formattedValue.indexOf(rowFormat.getDelimiterSymbol()) != -1;

            if (needEscapeChars) {
                stringBuilder.append(
                        rowFormat.getEscapeSymbol() +
                        formattedValue +
                        rowFormat.getEscapeSymbol() +
                        rowFormat.getDelimiterSymbol()
                );
            }
            else {
                stringBuilder.append(formattedValue + rowFormat.getDelimiterSymbol());
            }
        }

        return stringBuilder.toString();
    }
}
