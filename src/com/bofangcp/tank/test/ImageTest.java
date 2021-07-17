package com.bofangcp.tank.test;


import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * @Author:GangleiSong
 * @Date:Create in 2021/7/17 11:30
 **/
public class ImageTest {


    @Test
    public void test() {
//        fail("not yet imple");
//        assertNotNull("ddd");
        try {
            BufferedImage image = ImageIO.read(new File("D:\\写博客图片\\debug1.PNG"));
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
