/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzylogic;
import net.sourceforge.jFuzzyLogic.*;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 *
 * @author dric0
 */
public class Fuzzylogic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // Load from 'FCL' file
        String fileName = "/home/dric0/NetBeansProjects/trabWiga/FuzzyLogic/Fuzzylogic/tipper.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) { 
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        // Show 
        FunctionBlock functionBlock = fis.getFunctionBlock(null);
        JFuzzyChart.get().chart(functionBlock);

        // Set inputs
        fis.setVariable("behavior", 9.5);
        fis.setVariable("age", 30);
        fis.setVariable("education", 18);
        fis.setVariable("publicity", 51);
        //fis.setVariable("service", 3);
        //fis.setVariable("food", 7);

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        Variable score = functionBlock.getVariable("score");
        JFuzzyChart.get().chart(score, score.getDefuzzifier(), true);

        // Print ruleSet
        System.out.println(fis);
    }
}
