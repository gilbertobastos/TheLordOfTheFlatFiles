package br.com.gaob.ltff;

import br.com.gaob.ltff.rowAssemblers.DelimiterSeparatedRowAssembler;
import br.com.gaob.ltff.rowFormats.DelimiterSeparatedColumnFormat;
import br.com.gaob.ltff.rowFormats.DelimiterSeparatedValuesRowFormat;
import br.com.gaob.ltff.rowParsers.DelimiterSeparatedRowParser;

import java.text.ParseException;
import java.util.Date;

public class TheLordOfTheFlatFiles {

    public static void main(String[] args) {

        DelimiterSeparatedColumnFormat[] dsvColumnsFormats = new DelimiterSeparatedColumnFormat[3];
        dsvColumnsFormats[0] = new DelimiterSeparatedColumnFormat("Coluna 1", String.class);
        dsvColumnsFormats[1] = new DelimiterSeparatedColumnFormat("Coluna 2", String.class);
        dsvColumnsFormats[2] = new DelimiterSeparatedColumnFormat("Coluna 3", Double.class);

        DelimiterSeparatedValuesRowFormat dsvRowFormat = new DelimiterSeparatedValuesRowFormat(
                dsvColumnsFormats,
                "\n",
                'X',
                1,
                "YYYY",
                ";",
                null
        );

        Object dataArray[] = new Object[3];
        dataArray[0] = "Ok :D";
        dataArray[1] = "Batata :D";
        dataArray[2] = 123.45;

        DelimiterSeparatedRowAssembler dsvRowAssembler = new DelimiterSeparatedRowAssembler(dsvRowFormat);
        System.out.println(dsvRowAssembler.mountRow(dataArray));
    }
}
