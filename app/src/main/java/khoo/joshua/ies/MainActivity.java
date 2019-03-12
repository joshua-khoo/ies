package khoo.joshua.ies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvGraphs;
    private ArrayAdapter adapter;
    private static List<String> graphs;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        graphs = Arrays.asList("Graph raw data", "Graph filtered data");
        lvGraphs = (ListView) findViewById(R.id.lvGraphs);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, graphs);
        lvGraphs.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lvGraphs.setAdapter(adapter);

        lvGraphs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent newActivity;
                switch(position) {
                    case 0: // raw data graph
                        newActivity = new Intent(MainActivity.this, RawDataGraphActivity.class);
                        startActivity(newActivity);
                        break;
                    case 1: // filtered data graph
                        newActivity = new Intent(MainActivity.this, FilterDataGraphActivity.class);
                        startActivity(newActivity);
                        break;
                }
            }
        });
    }

}
