package com.bofangcp.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author:GangleiSong
 * @Date:Create in 2021/7/14 21:52
 **/
public class Main {

    public static void main(String[] args) throws InterruptedException {
//        //代表的就是一个窗口
//        Frame f = new Frame();
//        //设置可将
//        f.setSize(800,600);
//        f.setResizable(false);
//        f.setTitle("tank war");
//        f.setVisible(true);
//
//
//
//        f.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });


        TankFrame tf = new TankFrame();

        for(int i = 0;i<5;i++){
            tf.tanks.add(new Tank((int)(Math.random()*400),(int)(Math.random()*400),Dir.DOWN,tf,Group.BAD));

        }
        while (true){
            if(tf.tanks.size()<6){
                tf.tanks.add(new Tank((int)(Math.random()*400),(int)(Math.random()*400),Dir.DOWN,tf,Group.BAD));
            }
            Thread.sleep(50);
            tf.repaint();
        }

    }





}
