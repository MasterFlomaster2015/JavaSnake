/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasnake;


import com.googlecode.lanterna.terminal.*;

/**
 *
 * @author Larisa
 */
public class Point {
    public int x;
    public int y;
    public char sym;
    public Terminal t;

    
    public Point(int x, int y, char sym) { //конструктор класса
                this.x = x;
                this.y = y;
                this.sym = sym;
               // this.t= t;
            }
    public Point (Point p){
    
        this.x = p.x;
        
        this.y = p.y;
    
        this.sym = p.sym;
        
      //  this.t= t;
        
    }
     // если коордитаты точки выходят за пределы игрового поля
     // новая координата = модуль (старой - размер поля (в нашем случае макс.минус 2(границы)) )
     // нужен метод, который учтет это
    public void Move (int offset, Direction direction, int maxX, int maxY){
        
           
        
                    if(direction == Direction.RIGHT)
 			{
 				if (x == maxX - 2) {
                                    x = 1;
                                }
                            x = x + offset;
 			}
 			else if(direction == Direction.LEFT)
 			{
                                if ( x==1) {
                                 x = maxX - 2;   
                                }                               
                            x = x - offset;
 			}
 			else if(direction == Direction.UP)
 			{
                                if ( y == 1) {
                                    y = maxY - 1;
                                }
 				y = y - offset;
 			}
 			else if(direction == Direction.DOWN)
 			{
                                if (y == maxY - 2) {
                                    y = 1;
                                }
 				y = y + offset;
 			}
        
    }
    
    public void Draw (Terminal t){
        //этот метод должен уметь ставить курсор на точку с координатами x,y и печатать символ 
         
           t.moveCursor(x,y);
           t.putCharacter(sym);
            
    }

    public void clear(Terminal t) {
       sym=' ';
       Draw(t);
    }
}
