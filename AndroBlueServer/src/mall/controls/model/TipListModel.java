/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mall.controls.model;

import mall.model.TipModel;
import java.util.ArrayList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author STAR
 */
public class TipListModel implements ListModel{

    ArrayList<TipModel> models;

    public TipListModel(ArrayList<TipModel> models) {
        this.models = models;
    }

    public int getSize() {
        return models.size();
    }

    public Object getElementAt(int index) {
        return models.get(index);
    }

    public void addListDataListener(ListDataListener l) {
    }

    public void removeListDataListener(ListDataListener l) {
    }

}
