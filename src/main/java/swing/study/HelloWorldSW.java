package swing.study;


import javax.swing.*;

/**
 * @author Tobby Quinn
 * @date 2019/04/30
 */
public class HelloWorldSW {
    /**
     * Using setSize() you can give the size of frame you want but if you use pack(), it will automatically change the size of the frames according to the size of components in it. It will not consider the size you have mentioned earlier.
     */
    private static void helloWordGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        //创建并设置窗口
        JFrame frame = new JFrame("Hello World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //添加Hello World标签
        JLabel jLabel = new JLabel("Hello World");
        frame.getContentPane().add(jLabel);


        //显示窗口
       // frame.pack();  pack（）
        frame.setSize(500,600);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HelloWorldSW::helloWordGUI);
    }
}
