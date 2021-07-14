package com.bofangcp.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author:GangleiSong
 * @Date:Create in 2021/7/14 23:17
 **/
public class TankFrame extends Frame {

    public TankFrame(){

        setSize(800,600);
        setResizable(false);
        setTitle("坦克大战");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
    }
}
