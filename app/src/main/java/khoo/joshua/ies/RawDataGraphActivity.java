package khoo.joshua.ies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.Series;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RawDataGraphActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series;
    private Filter filter;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raw_data_graph);

        backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(RawDataGraphActivity.this, MainActivity.class);
                startActivity(main);
            }
        });

//        InputStream inputStream = getResources().openRawResource(R.raw.eeg);
//        CSVFile csvFile = new CSVFile(inputStream);
//        List eeg_list = csvFile.read();

//        double x = 0.0, y = 0.0;
//        GraphView graph = (GraphView) findViewById(R.id.raw_data_graph);
//        series = new LineGraphSeries<DataPoint>();
//        for (int i = 0; i < eeg_list.size(); i++) {
//            x = x + 0.1;
//            // y = eeg_list.get(i)
//            series.appendData(new DataPoint(x, Math.sin(x)), true, eeg_list.size());
//        }
//        graph.addSeries(series);

    }

}
