/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.controls.model;

import hospital.model.PrescriptionModel;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author STAR
 */
public class PrescriptionTableModel implements TableModel{


    ArrayList<PrescriptionModel> list;
    String column[]={"Medicine","Dosage","Frequency"};
    public PrescriptionTableModel(ArrayList<PrescriptionModel> list) {
        this.list = list;
    }

    public ArrayList<PrescriptionModel> getList() {
        return list;
    }

    
    public int getRowCount() {
        return list.size();

    }

    public int getColumnCount() {
        return column.length;
    }

    public String getColumnName(int columnIndex) {
        return column[columnIndex];
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        PrescriptionModel model = list.get(rowIndex);
        String s=null;
        switch(columnIndex)
        {
            case 0:
                s= model.getMedecine();
                break;
            case 1:
                s= model.getDosage();
                break;
            case 2:
                s= model.getFreq();
                break;
        }
        return s;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        PrescriptionModel model = list.get(rowIndex);
        String s=null;
        switch(columnIndex)
        {
            case 0:
                model.setMedecine((String)aValue);
                break;
            case 1:
                model.setDosage((String)aValue);
                break;
            case 2:
                model.setFreq((String)aValue);
                break;
        }
    }
    public void insertRow(int index)
    {
        for (int i = 0; i < index; i++) {
            list.add(new PrescriptionModel(i,"","",""));
        }
    }
    public void insertRow(String index)
    {
            list.add(new PrescriptionModel(1,"","",""));
    }
    public void deleteAll()
    {
        list.clear();
    }
    public void addTableModelListener(TableModelListener l) {
    }

    public void removeTableModelListener(TableModelListener l) {
    }
}
