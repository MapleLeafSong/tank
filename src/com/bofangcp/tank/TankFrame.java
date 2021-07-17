package com.bofangcp.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author:GangleiSong
 * @Date:Create in 2021/7/14 23:17
 **/
public class TankFrame extends Frame {

    int x = 200,y =200;
    Dir dir = Dir.DOWN;
    final int SPEED = 10;
    Tank myTank = new Tank(400,500,Dir.UP,this);
    List<Tank> tanks = new ArrayList<>();
    List<Bullet> bullets = new ArrayList<Bullet>();
    Bullet b = new Bullet(300,300,Dir.DOWN,this);
    static final int GAME_WIDTH = 800,GAME_HEIGHT = 600;
    public TankFrame(){

        setSize(GAME_WIDTH,GAME_HEIGHT);
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

    /**
     * 双缓冲解决闪烁的问题。
     */
    Image offs = null;
    @Override
    public void update(Graphics g) {
        if(offs == null){
            offs = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics go = offs.getGraphics();
        Color c = go.getColor();
        go.setColor(Color.white);
        go.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        go.setColor(c);
        paint(go);
        g.drawImage(offs,0,0,null);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("子弹的数量："+bullets.size(),10,60);
        myTank.paint(g);
        ListIterator<Bullet> bulletListIterator = bullets.listIterator();

        while (bulletListIterator.hasNext()){
           Bullet b =  bulletListIterator.next();
            b.paint(g);
             if(!b.isAlive()){
                 bulletListIterator.remove();
             }
        }

        for (int i = 0;i<tanks.size();i++){
           tanks.get(i).paint(g);
       }

//        for (int i = 0;i<bullets.size();i++){
//           bullets.get(i).paint(g);
//       }
//迭代的时候不能进行删除操作。
//       for(Bullet b:bullets){
//           b.paint(g);
//       }

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
               case "j":
                   myTank.fire();
                   break;
               default:break;
           }
            setMainTankDir();
        }

        private void setMainTankDir(){
            if(!bl && !bu && !br && !bd){
                myTank.setMoving(false);
            }else{
                myTank.setMoving(true);
            }
            if(bl) {myTank.setDir(Dir.LEFT);}
            if(bu) {myTank.setDir(Dir.UP);}
            if(br) {myTank.setDir(Dir.RIGHT);}
            if(bd) {myTank.setDir(Dir.DOWN);}
        }

    }

}


