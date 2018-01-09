package com.extension;

import com.rIntegration.Correlation;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase2;
import org.apache.jena.sparql.function.FunctionRegistry;

import java.text.DecimalFormat;

/**
 * Created by Divya on 8/26/2017.
 */
public class PearsonCorrelation extends FunctionBase2{
    static {
        FunctionRegistry.get().put("http://example.org/function#pearsoncorr",PearsonCorrelation.class);
    }

    public static void init(){
        FunctionRegistry.get().put("http://example.org/function#pearsoncorr",PearsonCorrelation.class);
    }

    public double getPearsonCorrelation(String input1, String input2){
        Correlation correlation = new Correlation();
        return correlation.getPearsonCorrelation(input1,input2);
    }

    @Override
    public NodeValue exec(NodeValue v1, NodeValue v2) {
        double pearsonCorrelationVal =  getPearsonCorrelation(v1.asUnquotedString(),v2.asUnquotedString());
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        double result = Double.parseDouble(decimalFormat.format(pearsonCorrelationVal));
        return NodeValue.makeDecimal(result);
    }
}
