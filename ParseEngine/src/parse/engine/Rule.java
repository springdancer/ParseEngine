/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parse.engine;

import java.util.LinkedList;

/**
 *
 * @author Administrator
 */
public class Rule {

    VarTer lefSide;
    private LinkedList<VarTer> rightSide = new LinkedList<VarTer>();

    public Rule(VarTer left, VarTer... rightinput) {
        this.lefSide = left;
        for (int i = 0; i < rightinput.length; i++) {
            rightSide.add(rightinput[i]);
        }
    }

    /**
     * @return the rightSide
     */
    public LinkedList<VarTer> getRightSide() {
        return rightSide;
    }

    /**
     * @param rightSide the rightSide to set
     */
    public void setRightSide(LinkedList<VarTer> rightSide) {
        this.rightSide = rightSide;
    }
}
