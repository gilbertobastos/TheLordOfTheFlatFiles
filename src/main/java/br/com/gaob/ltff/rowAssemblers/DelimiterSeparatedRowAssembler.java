package br.com.gaob.ltff.rowAssemblers;

import br.com.gaob.ltff.rowFormats.DelimiterSeparatedValuesRowFormat;

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
        for (int i = 0; i < inputRowDataArray.length; i++) {

            Object obj = inputRowDataArray[i];

            String formattedValue;
            formattedValue = getFormattedValue(obj);

            boolean needEscapeChars;
            needEscapeChars = rowFormat.getEscapeSymbol() != null &&
                    formattedValue.contains(rowFormat.getDelimiterSymbol());

            if (needEscapeChars) {
                stringBuilder.append(rowFormat.getEscapeSymbol()).append(formattedValue).append(rowFormat.getEscapeSymbol());
            }
            else {
                stringBuilder.append(formattedValue);
            }

            /* If the i-th column is the last column from the row,
               there will be no reason to put the delimiter symbol
               on the end of the same.
             */
            if (i != inputRowDataArray.length - 1) {
                stringBuilder.append(rowFormat.getDelimiterSymbol());
            }
        }

        return stringBuilder.toString();
    }
}
