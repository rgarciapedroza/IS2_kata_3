import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HistogramDisplay extends JFrame {

    private static final Paint COLOR_FONDO_1 = Color.pink;
    private static final Paint COLOR_FONDO_2 = Color.black;

    public HistogramDisplay(ArrayList<Double> parameter) throws HeadlessException{
        this.setTitle("HISTOGRAM");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(createHistogramDisplay(parameter));
    }

    private Component createHistogramDisplay(ArrayList<Double> parameter) {
        JFreeChart histogram = ChartFactory.createHistogram("Histogram", "values", "students",
                dataset(parameter),
                PlotOrientation.VERTICAL, false, false, false);

        histogram.getXYPlot().getRangeAxis().setRange(0, 25);
        histogram.getPlot().setBackgroundPaint(COLOR_FONDO_1);
        histogram.getXYPlot().setDomainGridlinePaint(COLOR_FONDO_2);
        histogram.getXYPlot().setRangeGridlinePaint(COLOR_FONDO_1);

        try{
            ChartUtilities.saveChartAsPNG(new File("C:/Users/rosma/OneDrive/IS2.histogram.png"), histogram, 800, 600);
        } catch (IOException e){
            System.out.println("Error al guardar la imagen" + e.getMessage());
        }
        return new ChartPanel(histogram);
    }

    private HistogramDataset dataset(ArrayList<Double> parameter) {
        HistogramDataset ds = new HistogramDataset();
        ds.addSeries("Series", values(parameter), 15);
        return ds;
    }

    private double[] values(ArrayList<Double> parameter) {
        double[] result = new double[parameter.size()];

        for (int i=0; i<parameter.size(); i++){
            result[i] = parameter.get(i);
        }
        return result;
    }
}
