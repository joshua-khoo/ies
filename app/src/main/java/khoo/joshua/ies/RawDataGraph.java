package khoo.joshua.ies;

import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.InputStream;
import java.util.List;

public class RawDataGraph {

    private LineGraphSeries<DataPoint> series;
    private Filter filter;

    InputStream inputStream = getResources().openRawResource(R.raw.eeg);
    CSVFile csvFile = new CSVFile(inputStream);
    List eeg_list = csvFile.read();

    double x = 0.0, y = 0.0;
    GraphView graph = (GraphView) findViewById(R.id.graph);
    series = new LineGraphSeries<DataPoint>();
    for(int i = 0; i < eeg_list.size(); i++) {
        x = x + 0.1;
        // y = eeg_list.get(i)
        series.appendData(new DataPoint(x, Math.sin(x)), true, eeg_list.size());
    }
    graph.addSeries(series);

}
