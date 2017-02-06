/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package college.controls.model;

import college.model.MapModel;
import java.util.ArrayList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author STAR
 */
public class MapListModel implements ListModel {

    ArrayList<MapModel> list;

    public MapListModel(ArrayList<MapModel> list) {
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
