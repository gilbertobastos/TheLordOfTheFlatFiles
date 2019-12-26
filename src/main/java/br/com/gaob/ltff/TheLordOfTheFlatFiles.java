package br.com.gaob.ltff;

public class TheLordOfTheFlatFiles {

    public static void main(String[] args) {

        Class[] columnsType = new Class[2];
        columnsType[0] = String.class;
        columnsType[1] = String.class;

        DelimiterSeparatedValuesRowFormat delimiterSeparatedValuesRowFormat =
                 new DelimiterSeparatedValuesRowFormat(
                         columnsType, "\n", '.',
                         4, ";", null);

        DelimiterSeparatedRowAssembler delimiterSeparatedRowAssembler =
                new DelimiterSeparatedRowAssembler(delimiterSeparatedValuesRowFormat);

        Object[] rowValues = new Object[2];
        rowValues[0] = "Goal1";
        rowValues[1] = "Goal2";

        String outputRow = delimiterSeparatedRowAssembler.mountRow(rowValues);
        System.out.println(outputRow);
    }
}
