import java.util.List;

public class InObject {
    protected List<Integer> inputs;
    protected List<Integer> expected_outputs;

    public InObject(List<Integer> inputs, List<Integer> expected_outputs) {
        this.inputs = inputs;
        this.expected_outputs = expected_outputs;
    }

    @Override
    public String toString() {
        return "InObject{" +
                "inputs=" + inputs +
                ", expectedOutputs=" + expected_outputs +
                '}';
    }
}
