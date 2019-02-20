package khoo.joshua.ies;

import java.util.Vector;

public class Filter {

    public Filter() {

    }

    public Vector<Double> removeDC(Vector<Double> data) {
        // get mean of data
        double mean = 0;
        for(double d : data) {
            mean += d;
        }
        mean /= data.size();

        // remove mean from each element in data
        for(int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) - mean);
        }

        return data;
    }

}
