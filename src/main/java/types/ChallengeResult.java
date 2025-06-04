/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package types;

import java.awt.image.BufferedImage;

/**
 *
 * @author Rafael
 */
public class ChallengeResult {
    public BufferedImage image;
    public int totalPills;
    public int brokenPills;
    public int totalRoundPills;
    public int totalCapsulePills;

    public ChallengeResult(BufferedImage image, int totalPills, int brokenPills, int totalRoundPills, int totalCapsulePills) {
        this.image = image;
        this.totalPills = totalPills;
        this.brokenPills = brokenPills;
        this.totalRoundPills = totalRoundPills;
        this.totalCapsulePills = totalCapsulePills;
    }    
}
