import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Perceptron {

    protected List<List<Neuron>> matrix;  /* матрица*/

    public Perceptron(int inputSignalsNumber,int hiddenLayerSize, int outputLayerSize) { 
        matrix = new ArrayList<>(Arrays.asList(new ArrayList<Neuron>(), new ArrayList<Neuron>()));
        for(int i = 0; i < hiddenLayerSize;i++){  
            matrix.get(0).add(new Neuron(inputSignalsNumber));
        }
        for(int i = 0; i < outputLayerSize;i++){  
            matrix.get(1).add(new Neuron(hiddenLayerSize));
        }

    }

    public void study(List<InObject> testing_array,Long epochs,double learning_rate){ 
        for(long epoch = 0; epoch < epochs; epoch++){  
            Collections.shuffle(testing_array);        
            for(InObject object : testing_array){     
                this.calculate(object);              
                this.backpropagation(object);       
                this.change_weights(object,learning_rate);
            }
        }

    }

    public void calculate(InObject object){
        for(Neuron neuron : matrix.get(0)){
            double summ = 0.0;
            for(int i = 0; i < neuron.weights.size();i++){
                summ += neuron.weights.get(i) * object.inputs.get(i);
                neuron.value = this.sigmoid(summ);
            }
        }
        for(Neuron neuron : matrix.get(1)){
            double summ = 0.0;
            for(int i = 0; i < neuron.weights.size();i++){
                summ += neuron.weights.get(i) * matrix.get(0).get(i).value;
                neuron.value = this.sigmoid(summ);
            }
        }
    }

    public void backpropagation(InObject object){
        for(Neuron neuron : matrix.get(1)){
            int neuron_position = matrix.get(1).indexOf(neuron);
            double difference = object.expected_outputs.get(neuron_position) - neuron.value;
            neuron.error = difference * sigmoid_derivative(neuron.value);
        }
        for(Neuron neuron : matrix.get(0)){
            int neuron_position = matrix.get(0).indexOf(neuron);
            double difference = 0.0;
            for(Neuron next_layer_neuron : matrix.get(1)){
                difference += next_layer_neuron.error * next_layer_neuron.weights.get(neuron_position);
            }
            neuron.error = difference * sigmoid_derivative(neuron.value);
        }
    }

    public void change_weights(InObject object,double learning_rate){
        for(Neuron neuron : matrix.get(0)){
            for(int i = 0; i < neuron.weights.size(); i++){
                double current_weight = neuron.weights.get(i);
                double delta = learning_rate * neuron.error * object.inputs.get(i);
                neuron.weights.set(i,current_weight+delta);
            }
        }
        for(Neuron neuron : matrix.get(1)){
            for(int i = 0; i < neuron.weights.size(); i++){
                double current_weight = neuron.weights.get(i);
                double delta = learning_rate * neuron.error * matrix.get(0).get(i).value;
                neuron.weights.set(i,current_weight+delta);
            }
        }
    }

    public void check_perceptron(InObject object){
        this.calculate(object);
        for(int i = 0; i < matrix.get(1).size(); i++){
            int show = i+1;
            System.out.println("neuron number:  " + show + "  result:  " + matrix.get(1).get(i).value + "  expected:  "  +object.expected_outputs.get(i));
        }
        System.out.println("/////////////");
    }


    public double sigmoid(double value){
        return 1 / (1 + Math.exp(-value));
    }

    public double sigmoid_derivative(double value){
        return value * (1 - value);
    }

}
