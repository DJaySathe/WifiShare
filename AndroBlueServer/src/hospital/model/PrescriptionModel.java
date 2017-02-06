/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.model;

/**
 *
 * @author STAR
 */
public class PrescriptionModel {
    private int preid;
    private String medecine;
    private String dosage;
    private String freq;

    public PrescriptionModel(int preid, String medecine, String dosage, String freq) {
        this.preid = preid;
        this.medecine = medecine;
        this.dosage = dosage;
        this.freq = freq;
    }

    public PrescriptionModel() {
    }
    
    public int getPreid() {
        return preid;
    }

    public void setPreid(int preid) {
        this.preid = preid;
    }

    

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public String getMedecine() {
        return medecine;
    }

    public void setMedecine(String medecine) {
        this.medecine = medecine;
    }

    @Override
    public String toString() {
        return "Prescription-"+getPreid();
    }


}
