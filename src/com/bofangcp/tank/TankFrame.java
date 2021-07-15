package com.bofangcp.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author:GangleiSong
 * @Date:Create in 2021/7/14 23:17
 **/
public class TankFrame extends Frame {

    int x = 200,y =200;
    Dir dir = Dir.DOWN;
    final int SPEED = 10;
    Tank myTank = new Tank(200,200,dir);
    public TankFrame(){

        setSize(800,600);
        setResizable(false);
        setTitle("坦克大战");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


    }

    @Override
    public void paint(Graphics g) {
       myTank.paint(g);
    }


    class MyKeyListener extends KeyAdapter{

        boolean bl = false;
        boolean br = false;
        boolean bu = false;
        boolean bd = false;

        @Override
        public void keyPressed(KeyEvent e) {
            String key = String.valueOf(e.getKeyChar());
            if("a".equals(key) && x >= 0){
               bl = true;

            }
            if("d".equals(key)){
//                x +=10;
                br = true;
            }
            if("w".equals(key)&& y>=20){
                bu = true;
//                y -=10;
            }
            if("s".equals(key)){
//                y +=10;
                bd = true;
            }
            setMainTankDir();
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
           switch(String.valueOf(e.getKeyChar())) {
               case "a":
                   bl = false;
                   break;
               case "w":
                   bu = false;
                   break;
               case "d":
                   br = false;
                   break;
               case "s":
                   bd = false;
                   break;
               default:break;
           }
            setMainTankDir();
        }

        private void setMainTankDir(){
            if(bl) {myTank.setDir(Dir.LEFT);}
            if(bu) {myTank.setDir(Dir.UP);}
            if(br) {myTank.setDir(Dir.RIGHT);}
            if(bd) {myTank.setDir(Dir.DOWN);}

        }

    }

}


