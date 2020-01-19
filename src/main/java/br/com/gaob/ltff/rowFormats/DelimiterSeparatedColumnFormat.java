package br.com.gaob.ltff.rowFormats;

public class DelimiterSeparatedColumnFormat extends AbstractColumnFormat {

    /**
     *
     * @param name The name of the column.
     * @param type The "primitive" type of the column.
     * @throws IllegalArgumentException If the type doesn't be a "primitive-like" class.
     */
    public DelimiterSeparatedColumnFormat(String name, Class type) {
        super(name, type);
    }

}
