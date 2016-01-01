/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parse.engine;

/**
 *
 * @author Administrator
 */

public class VarTer {

    /**
     * @return the str
     */
    public String getStr() {
        return str;
    }

    /**
     * @param str the str to set
     */
    public void setStr(String str) {
        this.str = str;
    }

    /**
     * @return the tType
     */
    public Tokentypes gettType() {
        return tType;
    }

    /**
     * @param tType the tType to set
     */
    public void settType(Tokentypes tType) {
        this.tType = tType;
    }
   public  enum Tokentypes{
    variable,terminal
}
    private String str;
    private Tokentypes tType;
    public  VarTer(String str,Tokentypes tokenType){
        this.str=str;
        this.tType=tokenType;
       }
    }

