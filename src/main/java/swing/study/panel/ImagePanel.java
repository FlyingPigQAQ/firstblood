package swing.study.panel;

import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Tobby Quinn
 * @date 2019/04/30
 */
public class ImagePanel extends JPanel {

    private BufferedImage image;

    public ImagePanel(String path) throws IOException {
        this.image = ImageIO.read(new File(path));
    }

    public ImagePanel(InputStream ins) throws IOException {
        this.image = ImageIO.read(ins);
    }

//    public ImagePanel(byte[] data) throws IOException {
//        IOUtils.
//    }


    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.drawImage(image,0,0,this);
    }
}
