package com.bofangcp.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author:GangleiSong
 * @Date:Create in 2021/7/17 12:12
 **/
public class ResourceMgr {

    public static BufferedImage tankL,tankU,tankR,tankD;
    public static BufferedImage bulletL,bulletU,bulletR,bulletD;
    static{
        try {
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com\\bofangcp\\tank\\resource\\tank\\m24-1-1.png"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com\\bofangcp\\tank\\resource\\tank\\m24-2-1.png"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/bofangcp/tank/resource/tank/m24-3-1.png"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com\\bofangcp\\tank\\resource\\tank\\m24-4-1.png"));

            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com\\bofangcp\\tank\\resource\\tank\\bL.png"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com\\bofangcp\\tank\\resource\\tank\\bU.png"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com\\bofangcp\\tank\\resource\\tank\\bR.png"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com\\bofangcp\\tank\\resource\\tank\\bD.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
