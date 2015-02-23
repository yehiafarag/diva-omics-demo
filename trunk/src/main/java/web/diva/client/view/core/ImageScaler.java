/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.diva.client.view.core;

import com.google.gwt.user.client.ui.Image;
import com.smartgwt.client.util.SC;

/**
 *
 * @author Yehia Farag
 */
public class ImageScaler {
    
    public Image reScaleOnWidth(Image image,int newWidth){
        int orWidth = image.getWidth();
        int orHeight = image.getHeight();
        int newHeight = (orHeight*newWidth)/orWidth;
        image.setSize(newWidth+"px", newHeight+"px");
    return image;
    }
    
    public Image reScaleOnHeight(Image image,int newHeight){
         int orWidth = image.getWidth();
        int orHeight = image.getHeight();
        int scale = orHeight/newHeight;
        int newWidth = orWidth/scale;
        image.setSize(newWidth+"px", newHeight+"px");
    
    return image;
    }
     public Image reScaleOnHeightPercentage(int orWidth ,int orHeight,Image image){
        
       int  newHeight= image.getHeight();
        int scale = orHeight/newHeight;
        int newWidth = orWidth/scale;
        image.setSize(newWidth+"px", newHeight+"px");
        
    
    return image;
    }
    
}
