package br.com.gaob.ltff;

public class DelimiterSeparatedRowParser extends AbstractRowParser {

    /**
     * Constructor...
     *
     * @param rowFormat The "specification" of the row format.
     */
    public DelimiterSeparatedRowParser(DelimiterSeparatedValuesRowFormat rowFormat) {
        super(rowFormat);
    }

    @Override
    public void parseRow(String inputRowString, Object[] outputRowDataArray) {

    }
}
