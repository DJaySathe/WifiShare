/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.controls.model;

import hospital.model.PrescriptionModel;
import java.util.ArrayList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author STAR
 */
public class PrescriptionListModel implements ListModel{

    private ArrayList<PrescriptionModel> prescriptionList;

    public PrescriptionListModel(ArrayList<PrescriptionModel> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }

    public int getSize() {
        return prescriptionList.size();
    }

    public Object getElementAt(int index) {
        return prescriptionList.get(index);
    }

    public void addListDataListener(ListDataListener l) {
    }

    public void removeListDataListener(ListDataListener l) {
    }

}
