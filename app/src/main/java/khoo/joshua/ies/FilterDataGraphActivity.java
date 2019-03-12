package khoo.joshua.ies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.InputStream;
import java.util.List;

public class FilterDataGraphActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series;
    private Filter filter;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_data_graph);

        backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(FilterDataGraphActivity.this, MainActivity.class);
                startActivity(main);
            }
        });

//        filter = new Filter();
//        double x = 0.0, y = 0.0;
//        // Vector<Double> data = new Vector<Double>();
//        GraphView graph = (GraphView) findViewById(R.id.filter_data_graph);
//        InputStream inputStream = getResources().openRawResource(R.raw.eeg);
//        CSVFile csvFile = new CSVFile(inputStream);
//        List eeg_list = csvFile.read();
//        series = new LineGraphSeries<DataPoint>();
////        for(int i = 0; i < eeg_list.size(); i++) {
////            data.add(eeg_list.get(i));
////        }
////        filter.removeDC(data);
//        for (int i = 0; i < 500; i++) {
//            x = x + 0.1;
//            series.appendData(new DataPoint(x, Math.sin(x / 2)), true, eeg_list.size());
//        }
//        graph.addSeries(series);
    }
}
