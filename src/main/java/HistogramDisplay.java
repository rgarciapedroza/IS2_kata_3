import org.jfree.chart.ChartFactory;
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
    private static final Paint COLOR_FONDO_GRAFICA_1 = Color.pink;
    private static final Paint COLOR_FONDO_GRAFICA_2 = Color.black;

    public HistogramDisplay(ArrayList<Double> parameter){
        JFreeChart histogram = ChartFactory.createHistogram("Histogram", "values", "students",
                dataset(parameter),
                PlotOrientation.VERTICAL, false, false, false);

        histogram.getXYPlot().getRangeAxis().setRange(0, 80);
        histogram.getPlot().setBackgroundPaint(COLOR_FONDO_GRAFICA_1);
        histogram.getXYPlot().setDomainGridlinePaint(COLOR_FONDO_GRAFICA_2);
        histogram.getXYPlot().setRangeGridlinePaint(COLOR_FONDO_GRAFICA_1);

        try{
            ChartUtilities.saveChartAsPNG(new File("C:/Users/rosma/OneDrive/Imágenes/histogram.png"));
        } catch (IOException e){
            System.out.println("Error al guardar la imagen del histograma: " + e.getMessage());
        }
    }

    private HistogramDataset dataset(ArrayList<Double> parameter) {
        HistogramDataset result = new HistogramDataset();
        result.addSeries("Serie", values(parameter), 25);
        return result;
    }

    private double[] values(ArrayList<Double> parameter) {
        double[] result = new double[parameter.size()];

        for (int i=0; i<parameter.size(); i++){
            result[i] = parameter.get(i);
        }
        return result;
    }
}
