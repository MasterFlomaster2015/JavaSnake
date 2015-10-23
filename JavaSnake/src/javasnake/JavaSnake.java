/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasnake;

//import java.io.IOException;

import java.util.ArrayList;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.input.*;



public class JavaSnake {


      public static void main(String args[]){

          
          Terminal t = TerminalFacade.createTerminal();
          
          
          t.enterPrivateMode();
          t.moveCursor(0, 0);
          
          TerminalSize maxXY= t.getTerminalSize();
          int maxX = maxXY.getColumns();
          int maxY = maxXY.getRows();
          
      
          // инициализируем хвост змейки
        char dir ='R';
        Direction init = Direction.LEFT;
        Point p1= new Point(76,10,'*');
          //создаем змейку длинной 7 знаков '?' - она идет налево
        Snake sn= new Snake (p1,7,init,maxX,maxY);
       
      // создаем и потом рисуем внешние границы "поля"
       HorizontalLine hl= new HorizontalLine (0,maxX-1,0,'*');
       HorizontalLine h2= new HorizontalLine (0,maxX-1,maxY,'*');
       VerticalLine v1= new VerticalLine (0,maxY-1,0,'*');
       VerticalLine v2= new VerticalLine (0,maxY,maxX,'*');
        
       // создаем массив с едой
       ArrayList<Point> foodfield = new ArrayList<Point>();
       
       Food fd = new Food ( maxX, maxY, '*', foodfield ); //просто создаем экземпляр класса
      
        foodfield = fd.FoodCreation(); //получаем список координаты еды
       //нужен метод получения массива еды для сравнения со змейкой
      
       
       hl.Draw(t); 
       v1.Draw(t);
       h2.Draw(t);
       v2.Draw(t);
       //рисуем еду
       fd.Draw(t);
       // начинаем рисовать змейку
       sn.Draw(t);
      
     
       
       Key key;
       
       while (true) {
           
        //Key key;
           
         
         if ( (key = t.readInput())!= null){
       
              dir =  key.getCharacter();
         }
          // dir изначально едет направо R;
         
         
         sn.handleSnake(dir, t,foodfield);
         
           }            
  
      }
}
