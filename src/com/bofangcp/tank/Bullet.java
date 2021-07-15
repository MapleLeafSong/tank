package com.bofangcp.tank;

import java.awt.*;

/**
 * @Author:GangleiSong
 * @Date:Create in 2021/7/15 22:24
 **/
public class Bullet {

    private static final int SPEED = 10;
    private static int WIDTH = 20,HEIGHT = 30;
    private int x,y;
    private Dir dir;
    private boolean alive = true;
    private TankFrame tf;
    public Bullet(int x,int y,Dir dir,TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }
    public void paint(Graphics g){
        if(!alive){
            tf.bullets.remove(this);
        }

        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(c);
        move();

    }

    private void move() {
        switch (dir){
            case LEFT:
                x-= SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case DOWN:
                y+= SPEED;
                break;
            case RIGHT:
                x+= SPEED;
                break;
        }

        if(x<0||y<0||x>TankFrame.GAME_WIDTH|| y> TankFrame.GAME_HEIGHT){
            alive = false;
        }


    }


}
