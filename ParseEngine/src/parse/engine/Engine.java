/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parse.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Administrator
 */
public class Engine {

    LinkedList<VarTer> input = new LinkedList<>();
    Rule[][] parsTable;
    ArrayList<VarTer> variables = new ArrayList<>();
    ArrayList<VarTer> terminals = new ArrayList<>();
    ArrayList<Rule> rules = new ArrayList<>();

    /**
     * This function makes engine data ready but remember that without setting
     * up parsTable you have nothing
     *
     * @param firstRule
     * @param all all Variable and Terminals in your code;
     */
    @SuppressWarnings("empty-statement")
    public Engine(VarTer... all) {
        for (VarTer item : all) {
            addVarTer(item);

        }
        parsTable = new Rule[variables.size()][terminals.size()];
    }

    /**
     *
     * @param item
     */
    private void addVarTer(VarTer item) {
        if (item.gettType() == VarTer.Tokentypes.terminal) {
            terminals.add(item);
        } else {
            variables.add(item);
        }
    }

    /**
     * just for Extention
     */
    public Engine() {
        //Enter your code here if you want chage it manually

        //Sample
        VarTer[] my = new VarTer[13];
        Rule[] myRule = new Rule[11];
        my[0] = new VarTer("E", VarTer.Tokentypes.variable);
        my[1] = new VarTer("T", VarTer.Tokentypes.variable);
        my[2] = new VarTer("X", VarTer.Tokentypes.variable);
        my[3] = new VarTer("F", VarTer.Tokentypes.variable);
        my[4] = new VarTer("Y", VarTer.Tokentypes.variable);
        my[5] = new VarTer("+", VarTer.Tokentypes.terminal);
        my[6] = new VarTer("-", VarTer.Tokentypes.terminal);
        my[7] = new VarTer("*", VarTer.Tokentypes.terminal);
        my[8] = new VarTer("/", VarTer.Tokentypes.terminal);
        my[9] = new VarTer("(", VarTer.Tokentypes.terminal);
        my[10] = new VarTer(")", VarTer.Tokentypes.terminal);
        my[11] = new VarTer("id", VarTer.Tokentypes.terminal);
        my[12] = new VarTer("num", VarTer.Tokentypes.terminal);
        myRule[0] = new Rule(my[0], my[1], my[2]);//E->TX
        myRule[1] = new Rule(my[0]);//E->landa
        myRule[2] = new Rule(my[0], my[6], my[0]);//E->-E
        myRule[3] = new Rule(my[0], my[5], my[0]);//E->+E
        myRule[4] = new Rule(my[1], my[3], my[4]);//T->fy
        myRule[5] = new Rule(my[4]);//y->Landa
        myRule[6] = new Rule(my[4], my[7], my[1]);//Y->*T
        myRule[7] = new Rule(my[4], my[8], my[1]);//Y->/T
        myRule[8] = new Rule(my[3], my[11]);//F->id
        myRule[9] = new Rule(my[3], my[12]);//F->num
        myRule[10] = new Rule(my[3], my[9], my[0], my[10]);//F->(E)
        for (VarTer item : my) {
            addVarTer(item);
        }

        //endSample
    }

    public void addRule(VarTer tableVar, VarTer tableTer, Rule myRule) {
        int varInex = -1, terIndex = -1;
        for (int i = 0; i < variables.size(); i++) {
            if (tableVar == variables.get(i)) {
                varInex = i;
            }
        }
        if (varInex == -1) {
            return;
        }
        for (int i = 0; i < terminals.size(); i++) {
            if (tableTer == terminals.get(i)) {
                terIndex = i;
            }
        }
        if (terIndex == -1) {
            return;
        }
        parsTable[varInex][terIndex] = myRule;
    }

}
