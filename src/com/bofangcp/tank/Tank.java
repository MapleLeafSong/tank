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
    private TankFrame tf ;
    public static final int TANK_WIDTH = ResourceMgr.tankD.getWidth();
    public static int TANK_HEIGHT = ResourceMgr.tankD.getHeight();
    public Tank(int x,int y,Dir dir,TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }


    public void paint(Graphics g){

        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
        }

//        g.drawImage(ResourceMgr.tankL,x,y,null);
       // g.fillRect(x,y,50,50);
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

    public void fire() {
        int bx = this.x + Tank.TANK_WIDTH/2-Bullet.B_WIDTH/2;
        int by = this.y + Tank.TANK_HEIGHT/2-Bullet.B_HEIGHT/2;
       tf.bullets.add(new Bullet(bx,by,this.dir,this.tf));
    }
}
