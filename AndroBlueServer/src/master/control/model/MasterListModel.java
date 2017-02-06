/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.control.model;

import master.model.*;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Ritesh
 */
public class MasterListModel implements ComboBoxModel {
    
    private ArrayList<MasterModel> list ;
    private MasterModel selected=null;

    public MasterListModel(ArrayList<MasterModel> list) {
        this.list = list;
    }

    public void setSelectedItem(Object o) {
        selected=(MasterModel) o;
    }

    public Object getSelectedItem() {
        return selected;
    }

    public int getSize() {
        return list.size();
    }

    public Object getElementAt(int i) {
        return list.get(i);
    }

    public void addListDataListener(ListDataListener ll) {
    }

    public void removeListDataListener(ListDataListener ll) {
    }

  
}
