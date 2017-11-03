package com.example.tabcellview;

/**
 * TableCell 实现表格的格单元
 *
 * @author hellogv
 */
public class TableCell {
    static public final int STRING = 0;
    static public final int IMAGE = 1;
    public Object value;
    public int width;
    public int height;
    int type;

    public TableCell(Object value, int width, int height, int type) {
        this.value = value;
        this.width = width;
        this.height = height;
        this.type = type;
    }
}