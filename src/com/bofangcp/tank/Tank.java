package com.bofangcp.tank;

import java.awt.*;

/**
 * @Author:GangleiSong
 * @Date:Create in 2021/7/15 21:53
 **/
public class Tank {
    int x,y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    private boolean moving = false;

    public Tank(int x,int y,Dir dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }


    public void paint(Graphics g){
        g.fillRect(x,y,50,50);
        move();
    }

    private void move() {
        if(!moving)return;

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
            default:break;
        }

    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
