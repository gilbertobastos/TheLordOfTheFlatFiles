package br.com.gaob.ltff.rowParsers;

import br.com.gaob.ltff.rowFormats.DelimiterSeparatedValuesRowFormat;

import java.text.ParseException;

public class DelimiterSeparatedRowParser extends AbstractRowParser {

    /**
     * Constructor...
     *
     * @param rowFormat The "specification" of the row format.
     */
    public DelimiterSeparatedRowParser(DelimiterSeparatedValuesRowFormat rowFormat) {
        super(rowFormat);
    }

    /**
     * Method responsible for parsing the row string and inserting the values in the array of objects.
     *
     * @param inputRowString The row string.
     * @param outputRowDataArray A array with "primitive-like" objects that will hold the values of row.
     * @throws ParseException If the parsing process fail.
     */
    @Override
    public void parseRow(String inputRowString, Object[] outputRowDataArray) throws ParseException {

        int inputRowStringPointer = 0;
        int outputRowDataArrayPointer = 0;
        DelimiterSeparatedValuesRowFormat rowFormat = (DelimiterSeparatedValuesRowFormat) this.getRowFormat();

        /* Parsing the row... */
        while (inputRowStringPointer < inputRowString.length())
        {
            /* Parsing the actual column (that is the contents of "inputRowStringPointer")
             * to the next delimiter (or EOL)...
             */
            String rawColumnData;
            boolean escapedColumn = false;

            if (rowFormat.getEscapeSymbol() != null)
            {
                /* Seeing if the start of the actual column has a escape symbol.. */
                escapedColumn =
                       inputRowString.substring(
                               inputRowStringPointer,
                               inputRowStringPointer + rowFormat.getEscapeSymbol().length()).equals(rowFormat.getEscapeSymbol());
            }

            /* Where the data of the actual column starts in the row string.... */
            int columnRawDataStartPos =
                    (escapedColumn) ?
                            (inputRowStringPointer + rowFormat.getEscapeSymbol().length()) :
                            (inputRowStringPointer);

            /* Where the data ends.... */
            int columnRawDataEndPos =
                    (escapedColumn) ?
                            (inputRowString.indexOf(rowFormat.getEscapeSymbol(), columnRawDataStartPos)) :
                            (inputRowString.indexOf(rowFormat.getDelimiterSymbol(), columnRawDataStartPos));

            /* If is the last column of the row (no delimiter on the end). */
            if (columnRawDataEndPos == - 1) {
                columnRawDataEndPos = inputRowString.length();
            }

            rawColumnData = inputRowString.substring(columnRawDataStartPos,columnRawDataEndPos);
            
            outputRowDataArray[outputRowDataArrayPointer] =
                    this.getParsedValue(rawColumnData, this.getRowFormat().getColumnType(outputRowDataArrayPointer));

            ++outputRowDataArrayPointer;

            inputRowStringPointer =
                    columnRawDataEndPos +
                            rowFormat.getDelimiterSymbol().length() +
                            ((escapedColumn) ? (rowFormat.getEscapeSymbol().length()) : (0));
        }
    }
}
