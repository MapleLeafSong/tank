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
        g.fillRect(x,y,50,50);
//        System.out.println("paint");
//        x+=10;
//        y+=10;
    }


    class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            String key = String.valueOf(e.getKeyChar());
            if("a".equals(key) && x >= 0){
                x -=10;
            }
            if("d".equals(key)){
                x +=10;
            }
            if("w".equals(key)&& y>=20){
                y -=10;
            }
            if("s".equals(key)){
                y +=10;
            }

            repaint();
            System.out.println(e.getKeyChar());
            System.out.println("pre");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key rel");
        }
    }

}


