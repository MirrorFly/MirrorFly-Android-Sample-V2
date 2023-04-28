/*
 * @category ContusFly
 * @copyright Copyright (C) 2018 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.location.googletranslation.pojo;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class LanguageDetection {

    private Detections[][] detections;

    public Detections[][] getDetections ()
    {
        return detections;
    }

    public void setDetections (Detections[][] detections)
    {
        this.detections = detections;
    }
}
