/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasnake;

import java.util.ArrayList;
import com.googlecode.lanterna.terminal.*;

/**
 *
 * @author Larisa
 */
public class HorizontalLine extends Figure {

  
    public HorizontalLine(int leftX, int wrightX, int y, char c) {
        
         line = new ArrayList<Point>();
        
        for (int i=leftX; i<wrightX;i++){

        Point p = new Point(i,y,c);
            this.line.add(p);
        }
    }
    
}
