/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.controls.model;

import hospital.model.ScheduleModel;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author STAR
 */
public class ScheduleTableModel implements TableModel{

    ArrayList<ScheduleModel> list;
    String columnList[]={"Doctor Name / Lab","Days","Arrival Timing","Departure Time"};
    int rowcount;

    public ScheduleTableModel(ArrayList<ScheduleModel> list) {
        this.list = list;
        rowcount=list.size();
    }

    public void addRow(int count)
    {
        rowcount=rowcount+count;
//        int size = list.size();
        for (int i = 0; i < count; i++) {

            list.add(new ScheduleModel("", "", "",""));

        }
    }
    public ArrayList<ScheduleModel> getList() {
        return list;
    }
    

    public int getRowCount() {
        return rowcount;
    }

    public int getColumnCount() {
        return columnList.length;
    }

    public String getColumnName(int columnIndex) {
        return columnList[columnIndex];
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        ScheduleModel model=list.get(rowIndex);
        String value="";
        switch(columnIndex)
        {
            case 0:
                value=model.getDoctorName();
                break;
            case 1:
                value=model.getDays();
                break;
            case 2:
                value=model.getTimeArr();
                break;
            case 3:
                value=model.getTimeDpr();
                break;
        }
        return value;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ScheduleModel model=list.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                model.setDoctorName((String)aValue);
                break;
            case 1:
                model.setDays((String)aValue);
                break;
            case 2:
                model.setTimeArr((String)aValue);
                break;
            case 3:
                model.setTimeDpr((String)aValue);
                break;
        }

    }

    public void addTableModelListener(TableModelListener l) {
    }

    public void removeTableModelListener(TableModelListener l) {
    }
    public void insertRow(int index)
    {
        for (int i = 0; i < index; i++) {
            list.add(new ScheduleModel("","","",""));
        }
    }
    public void insertRow(String index)
    {
            list.add(new ScheduleModel("","","",""));
    }
    public void deleteAll()
    {
        list.clear();
    }
}
