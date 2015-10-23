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
public class VerticalLine extends Figure {
    
  
    public VerticalLine(int upY, int downY, int x, char c) {
        
        line = new ArrayList<Point>();
        
        for (int i=upY; i<downY;i++){

        Point p = new Point(x,i,c);
            this.line.add(p);
        }
    }
    
}
