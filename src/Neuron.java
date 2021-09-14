import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Neuron {
    protected List<Double> weights;
    protected double value;
    protected double error;
    public Neuron(int numberOfWeights) {
        weights = new ArrayList<>();
        for(int i = 0; i < numberOfWeights; i++){
            weights.add(Math.random());
            value = 0;
            error = 0;
        }
    }

    @Override
    public String toString() {
        return "Neuron{" +
                "weights=" + weights +
                ", value=" + value +
                ", error=" + error +
                '}';
    }
}
