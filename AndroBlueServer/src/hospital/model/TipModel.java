/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.model;

/**
 *
 * @author STAR
 */
public class TipModel {
    String tip;

    public TipModel(String tip) {
        this.tip = tip;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return getTip();
    }
    
}
