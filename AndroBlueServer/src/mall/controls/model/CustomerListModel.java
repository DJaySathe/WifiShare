/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mall.controls.model;
import java.util.ArrayList;
import javax.swing.ListModel;
import mall.model.CustomerModel;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author STAR
 */
public class CustomerListModel implements ListModel{

    ArrayList<CustomerModel> list;

    public CustomerListModel(ArrayList<CustomerModel> list) {
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
