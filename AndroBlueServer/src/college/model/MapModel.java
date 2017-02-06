/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package college.model;

/**
 *
 * @author STAR
 */
public class MapModel {

    private String floorName;

    public MapModel(String floorName) {
        this.floorName = floorName;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    @Override
    public String toString() {
        return getFloorName();
    }
    
}
