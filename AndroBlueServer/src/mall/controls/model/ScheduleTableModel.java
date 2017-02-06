/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mall.controls.model;

import mall.model.ScheduleModel;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author STAR
 */
public class ScheduleTableModel implements TableModel{

    ArrayList<ScheduleModel> list;
    String columnList[]={"Shop","Opening Time","Closeing Time","Days"};

    public ScheduleTableModel(ArrayList<ScheduleModel> list) {
        this.list = list;
    }

    public ArrayList<ScheduleModel> getList() {
        return list;
    }
    

    public int getRowCount() {
        return list.size();
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
                value=model.getServices();
                break;
            case 1:
                value=model.getOpTime();
                break;
            case 2:
                value=model.getClsTime();
                break;
            case 3:
                value=model.getDays();
                break;
        }
        return value;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ScheduleModel model=list.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                model.setServices((String)aValue);
                break;
            case 1:
                model.setOpTime((String)aValue);
                break;
            case 2:
                model.setClsTime((String)aValue);
                break;
            case 3:
                model.setDays((String)aValue);
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
