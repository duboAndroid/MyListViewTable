package com.example.tabcellview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     */
    ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("ListView自适应实现表格---hellogv");
        lv = (ListView) this.findViewById(R.id.ListView01);
        ArrayList<TableRow> table = new ArrayList<TableRow>();
        TableCell[] titles = new TableCell[5];// 每行5个单元
        int width = this.getWindowManager().getDefaultDisplay().getWidth() / titles.length;
        // 定义标题
        for (int i = 0; i < titles.length; i++) {
            titles[i] = new TableCell("标题" + String.valueOf(i),
                    width + 8 * i,
                    LinearLayout.LayoutParams.FILL_PARENT,
                    TableCell.STRING);
        }
        table.add(new TableRow(titles));
        // 每行的数据
        TableCell[] cells = new TableCell[5];// 每行5个单元
        for (int i = 0; i < cells.length - 1; i++) {
            cells[i] = new TableCell("No." + String.valueOf(i),
                    titles[i].width,
                    LinearLayout.LayoutParams.FILL_PARENT,
                    TableCell.STRING);
        }
        cells[cells.length - 1] = new TableCell(R.drawable.quality_tab_normal,
                titles[cells.length - 1].width,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                TableCell.IMAGE);
        // 把表格的行添加到表格
        for (int i = 0; i < 12; i++)
            table.add(new TableRow(cells));
        TableAdapter tableAdapter = new TableAdapter(this, table);
        lv.setAdapter(tableAdapter);
        lv.setOnItemClickListener(new ItemClickEvent());
    }

    class ItemClickEvent implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            Toast.makeText(MainActivity.this, "选中第" + String.valueOf(arg2) + "行", 500).show();
        }
    }
}
