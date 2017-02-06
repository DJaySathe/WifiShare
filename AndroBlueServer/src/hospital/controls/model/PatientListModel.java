/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.controls.model;

import hospital.model.PatientModel;
import java.util.ArrayList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author STAR
 */
public class PatientListModel implements ListModel {

    private ArrayList<PatientModel> list;

    public PatientListModel(ArrayList<PatientModel> list) {
        this.list = list;
    }

    public int getSize() {
        return list.size();
    }

    public Object getElementAt(int index) {
        return list.get(index);
    }

    public void addListDataListener(ListDataListener l) {
    }

    public void removeListDataListener(ListDataListener l) {
    }

}
