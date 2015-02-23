/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.diva.client.somclust.view;

import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;

/**
 *
 * @author Yehia Farag
 */
public class HeatmapImg extends Image implements MouseMoveHandler, MouseOutHandler {

    private final int squareL;
    private final int squareW;
    private double scale =1;

    public void setScale(double scale) {
        this.scale = scale;
    }
    @Override
    public void onMouseMove(MouseMoveEvent event) {
        int y = (int) (event.getY());
        int x = ((int) (event.getX()));
         y = (int)((double)y/scale);         
        x = this.getHeight()-((int)((double) x/scale));
        int corX = 0;
        int corY = 0;
        if (type == 1) {
            corX = event.getX() / squareW;
            corY = event.getY() / squareL;
        }else{
         corY =x / squareL;
         corX = y / squareW;
        }
        
        if (rowNames[corY] != null && colNames[corX] != null) {
            toolTip.setHTML("<textarea cols=\"50\" rows=\"1\">"+ colNames[corX] + " - " + rowNames[corY] + " - Value:" + values[corY][corX]+"</textarea>");
            toolTip.setVisible(true);
        } else {
            toolTip.setVisible(false);
        }

    }

    @Override
    public void onMouseOut(MouseOutEvent event) {
        toolTip.setVisible(false);
    }
    
    private  String[] colNames;
    private  String[] rowNames;
    private  double[][] values;
    private final HTML toolTip;
    private final int type;
   
    
    public HeatmapImg(String url, String[] rowNames, String[] colNames,double[][] values,HTML toolTip,int type,int squareL,int squareW) {
        super(url);
        this.squareL = squareL;
        this.squareW = squareW;
        this.addMouseMoveHandler(HeatmapImg.this);
        this.addMouseOutHandler(HeatmapImg.this);
        this.colNames = colNames;
        this.rowNames = rowNames;
        this.values = values;
        this.toolTip = toolTip;
        toolTip.setVisible(false);
        this.type= type;
        
    }
    public void updateTooltips(String[] rowNames, String[] colNames,double[][] values){
     this.colNames = colNames;
        this.rowNames = rowNames;
        this.values = values;
    
    }
}
