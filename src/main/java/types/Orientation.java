/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package types;

/**
 *
 * @author Rafael
 */
/**
     * Valid orientations for image transformations
     */
public enum Orientation {
    HORIZONTAL("Horizontal"),
    VERTICAL("Vertical");
    
    public final String label;
    
    private Orientation(String label) {
        this.label = label;
    }
    
    public static Orientation fromString(String label) {
        for (Orientation orientation: Orientation.values()) {
            if (orientation.label.equals(label)) {
                return orientation;
            }
        }
        return null;
    }
}
