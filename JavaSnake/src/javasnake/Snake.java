/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasnake;

import java.util.ArrayList;
import com.googlecode.lanterna.terminal.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Larisa
 */
public class Snake extends Figure {
    
    public Direction SnakeDir;
     
    public Snake(Point tail, int leghth, Direction dir, int maxX, int maxY) {
        
        SnakeDir=dir;
        
        line = new ArrayList<Point>();
        
        for (int i=0;i<leghth; i++){
           
            //пустой список точек наполняем символами змейки
            Point p = new Point(tail); // новая точка с координатами хвоста
                        // меняем координаты на 1 шаг в направлении отрисовки змейки 
                        p.Move(i,dir,maxX,maxY);
                       
                        //и добавляем в список точек змейки
                        line.add(p);             

       
                     }
            
        }
        
 
    void Move(Terminal t,ArrayList<Point> food) {

         TerminalSize maxXY= t.getTerminalSize();
          int maxX = maxXY.getColumns();
          int maxY = maxXY.getRows();
   
        
        Point last = line.get(0);
        //line.remove(last);
        Point next = getNextPoint(maxX,maxY);
        line.add(next);
        next.Draw(t);
  
            if ( compareArray(food,next) !=null ) {
                
                food.remove(next);
                
            }
            else   {  
                line.remove(last);
                last.clear(t);
            }           
        }
        
       // if (!food.contains(next))
       // for (Point p:food) {

    private Point compareArray(ArrayList<Point> food, Point next) {
        
        for (int i=0;i<food.size()-1;i++) {
               Point p = food.get(i);
            if (p.x==next.x && p.y==next.y) 
                 { 
                     return p ;
                  }
        }
       return null;
    }
            
        

    private Point getNextPoint(int maxX, int maxY) {
        Point current = line.get(line.size()-1);
        Point next = new Point (current);            
        next.Move(1, SnakeDir, maxX, maxY);
        return next;   
    }
    
    
    public void handleSnake(char c, Terminal t, ArrayList<Point> food) {
         
        switch (c){
              
              case 'R':
                  
                  SnakeDir = Direction.RIGHT;
                    Move(t,food);
                  break;
                  
              case 'L':
                  
                  SnakeDir = Direction.LEFT;
                   Move(t,food);
                  break;
                  
              case 'U':
                  
                  SnakeDir= Direction.UP;
                   Move(t,food);
                  break;
                  
              case 'D':
                  
                 SnakeDir = Direction.DOWN;
                   Move(t,food);
                  break;
                  
              default:
                  
                  SnakeDir = Direction.LEFT;
                    Move(t,food);
                  break;
                  
                } 
              try {
                  Thread.sleep(100);  
              } catch (InterruptedException ex) {
                  Logger.getLogger(JavaSnake.class.getName()).log(Level.SEVERE, null, ex);
              }
    }
            
    }   

