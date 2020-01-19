package br.com.gaob.ltff.rowFormats;

public class FixedWidthTextColumnFormat extends AbstractColumnFormat {

    /**
     * The position of the column in the row.
     */
    private int columnPos;

    /**
     * The size of the column in the row.
     */
    private int size;

    /**
     *
     * @param name The name of the column.
     * @param type The "primitive" type of the column.
     * @param columnPos The position of the column in the row.
     * @param size The size of the column in the row.
     * @throws IllegalArgumentException If the type doesn't be a "primitive-like" class.
     */
    public FixedWidthTextColumnFormat(String name, Class type, int columnPos, int size) {

        super(name, type);
        this.columnPos = columnPos;
        this.size = size;
    }

    /**
     * The position of the column in the row.
     */
    public int getColumnPos() {
        return columnPos;
    }

    /**
     * The size of the column in the row.
     */
    public int getSize() {
        return size;
    }
}
