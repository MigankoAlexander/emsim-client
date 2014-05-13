/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emsimclient;

/**
 *
 * @author Miganko
 */
public class ObjectInstance {
    
    private String title;
    private double incidentProbability;
    private double damageRadius;
    private double propagationSpeed;

    public ObjectInstance(String title, double incidentProbability, double damageRadius, double propagationSpeed) {
        this.title = title;
        this.incidentProbability = incidentProbability;
        this.damageRadius = damageRadius;
        this.propagationSpeed = propagationSpeed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getIncidentProbability() {
        return incidentProbability;
    }

    public void setIncidentProbability(double incidentProbability) {
        this.incidentProbability = incidentProbability;
    }

    public double getDamageRadius() {
        return damageRadius;
    }

    public void setDamageRadius(double damageRadius) {
        this.damageRadius = damageRadius;
    }

    public double getPropagationSpeed() {
        return propagationSpeed;
    }

    public void setPropagationSpeed(double propagationSpeed) {
        this.propagationSpeed = propagationSpeed;
    }
    
}
