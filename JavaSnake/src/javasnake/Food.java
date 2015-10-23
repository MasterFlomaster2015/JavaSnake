/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasnake;

import static java.lang.Math.random;
import java.util.ArrayList;

/**
 *
 * @author Larisa
 */
class Food extends Figure {
int maxX;
int maxY;
char c;
//public ArrayList<Point> line;    
    
    public Food(int maxX, int maxY, char c, ArrayList<Point> foodfield) { // конструктор
        this.maxX=maxX;
        this.maxY=maxY;
        this.c=c; 
        line = foodfield;
    }
     public ArrayList<Point> FoodCreation() {
    
       //  line = new ArrayList<Point>();
         
         //  плотность еды одинаковая 5% от всех точек поля (maxX*maxY)/20;
         // генерируем точки по экрану случайным образом
         for (int i=0; i< (int)((maxX*maxY)/50);i++) {
             
         int xrand = (int) Math.floor ( Math.random() * (maxX-1)+1 );
         int yrand= (int) Math.floor ( Math.random() * (maxY-2)+1 );
         
         Point p = new Point (xrand, yrand, c);
                 // если точка уже есть в списке - пропускаем, нет - вносим и выводим на экран
               
                if ( !line.contains(p) )
                
                     line.add (p);   
         } 
        return line; 
    } 
}


         
    
