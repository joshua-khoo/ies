package khoo.joshua.ies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.Series;

import java.util.Vector;
import java.util.List;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private ListView graphs;


    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void addGraphs() {

    }

    @OnClick(R.id.button_filter) public void onClick() {
        filter = new Filter();
        double x = 0.0, y = 0.0;
        // Vector<Double> data = new Vector<Double>();
        GraphView graph = (GraphView) findViewById(R.id.graph);
        InputStream inputStream = getResources().openRawResource(R.raw.eeg);
        CSVFile csvFile = new CSVFile(inputStream);
        List eeg_list = csvFile.read();
        series = new LineGraphSeries<DataPoint>();
//        for(int i = 0; i < eeg_list.size(); i++) {
//            data.add(eeg_list.get(i));
//        }
//        filter.removeDC(data);
        for(int i = 0; i < 500; i++) {
            x = x + 0.1;
            series.appendData(new DataPoint(x, Math.sin(x/2)), true, eeg_list.size());
        }
        graph.addSeries(series);
    }
}
