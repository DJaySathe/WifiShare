/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package master.model;


/**
 *
 * @author STAR
 */
public class MasterModel {
    private int id;
    private String domain;

    public MasterModel(int id, String domain) {
        this.id = id;
        this.domain = domain;
    }

    public MasterModel() {
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getDomain();
    }
    
}
