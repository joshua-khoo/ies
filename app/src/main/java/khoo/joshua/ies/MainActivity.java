package khoo.joshua.ies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.Series;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    @BindView (R.id.button_filter) Button button_filter;

    LineGraphSeries<DataPoint> series;

    Filter filter;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        InputStream inputStream = getResources().openRawResource(R.raw.stats);
        CSVFile csvFile = new CSVFile(inputStream);
        List eeg_list = csvFile.read();

        double x = 0.0, y = 0.0;
        GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        for(int i = 0; i < 500; i++) {
            x = x + 0.1;
            y = Math.sin(x);
            series.appendData(new DataPoint(x, y), true, 500);
        }
        graph.addSeries(series);
    }

    @OnClick(R.id.button_filter) public void onClick() {
        filter = new Filter();
        double x = 0.0, y = 0.0;
        Vector<Double> data = new Vector<Double>();
        GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        for(int i = 0; i < 500; i++) {
            y = Math.sin(x);
            data.add(y);

        }
        filter.removeDC(data);
        for(int i = 0; i < 500; i++) {
            x = x + 0.1;
            series.appendData(new DataPoint(x, data.get(i)), true, 500);
        }
        graph.addSeries(series);
    }
}
