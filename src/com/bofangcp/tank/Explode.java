package com.bofangcp.tank;

import java.awt.*;

/**
 * @Author:GangleiSong
 * @Date:Create in 2021/7/17 14:55
 **/
public class Explode {
    public static int WINDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x,y;
    private Dir dir;

    private boolean living = true;

    TankFrame tf = null;
    private int step = 0;


    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

    }

    public void paint(Graphics g){
        if(step >= ResourceMgr.explodes.length){
            tf.liste.remove(this);
            return;
        }
        g.drawImage(ResourceMgr.explodes[step++],(x-WINDTH/2),(y-HEIGHT/2),null);
//        if(step >= ResourceMgr.explodes.length){
//            step = 0;
//        }
    }

}
