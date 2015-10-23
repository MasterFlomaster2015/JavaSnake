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
public class Figure {
 
    protected ArrayList<Point> line;
    protected Terminal t;
    
     
    public void Draw (Terminal t){
                for (Point p:line) {
                    p.Draw(t);
                }
        }
    
}
