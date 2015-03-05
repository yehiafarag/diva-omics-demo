/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.diva.client.rank.view;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;

/**
 *
 * @author Yehia Farag
 */
public class SparkLineRecord extends HLayout implements Comparable{

    private final double value;
    
    public SparkLineRecord(String imgUrl, double value,double maxValue) {
        super((""+((int)maxValue+4)).length()*6);
        this.setMembersMargin((""+((int)maxValue+4)).length()*6);
        this.value = value;
        setHeight(22);
        setWidth100();
        setAlign(Alignment.RIGHT);
//        setMargin(5);

        Label valueLabel = new Label("   ");
        valueLabel.setShowDown(false);
        valueLabel.setShowRollOver(false);
        valueLabel.setLayoutAlign(Alignment.LEFT);

        valueLabel.setHeight(16);
        valueLabel.setWidth((""+((int)maxValue+4)).length()*6);
        Img chartImg = new Img(imgUrl);

        chartImg.setShowDown(false);
        chartImg.setShowRollOver(false);
        chartImg.setAlign(Alignment.RIGHT);
        chartImg.setHeight(16);
        chartImg.setWidth("80%");
        
        this.setMembers(valueLabel,chartImg);
        chartImg.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                event.cancel();
                
            }
        });
    }

    @Override
    public int compareTo(Object t) {
        if (this.value == ((SparkLineRecord) t).value) {
            return 0;
        } else if ((this.value) > ((SparkLineRecord) t).value) {
            return 1;
        } else {
            return -1;
        }
    }

}
