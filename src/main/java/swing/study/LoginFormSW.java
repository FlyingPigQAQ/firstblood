package swing.study;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Tobby Quinn
 * @date 2019/04/30
 */
public class LoginFormSW {
    private static JFrame jFrame = new JFrame("用户登录");

    private static void createMainUI() {

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 600);

        loginFormUI();

        jFrame.setVisible(true);
    }

    private static void loginFormUI() {

        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(null);
        String imagePath = "/Users/tobbyquinn/Pictures/logo.png";
        BufferedImage resizeImage = null;
        try {
            BufferedImage sourceImage = ImageIO.read(new File(imagePath));
            // 高度设置-1,表示维持原有的宽高比
            Image thumbnail = sourceImage.getScaledInstance(300, -1, Image.SCALE_SMOOTH);

            resizeImage = new BufferedImage(thumbnail.getWidth(null), thumbnail.getHeight(null), BufferedImage.TYPE_INT_RGB);
            resizeImage.getGraphics().drawImage(thumbnail, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon imageIcon = new ImageIcon();
        imageIcon.setImage(resizeImage);

        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setBounds(10, 100, 300, 400);
        jPanel.add(jLabel);


        JLabel userNameLabel = new JLabel("用户名:");
        Font font = new Font(null, Font.PLAIN, 14);
        userNameLabel.setFont(font);
        userNameLabel.setBounds(10, 20, 56, 20);
        jPanel.add(userNameLabel);

        JTextField jTextField = new JTextField();
        jTextField.setBounds(70, 20, 200, 20);
        jPanel.add(jTextField);


        JLabel passwdLabel = new JLabel("密码:");
        passwdLabel.setBounds(10, 45, 56, 20);
        jPanel.add(passwdLabel);

        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setBounds(70, 45, 56, 20);
        jPanel.add(jPasswordField);

        JButton loginBtn = new JButton("登录");
        loginBtn.setBounds(10, 70, 30, 20);
        jPanel.add(loginBtn);

        loginBtn.addActionListener(loginActionListener(jTextField, jPasswordField));


    }


    static ActionListener loginActionListener(JTextField username, JPasswordField password) {
        ActionListener loginListener = e -> {
            if (username.getText().equals("1") && String.valueOf(password.getPassword()).equals("1")) {
                JOptionPane.showMessageDialog(jFrame, "登录成功", "Ok", JOptionPane.INFORMATION_MESSAGE);
                //删除整个视图，必须通过获取该父容器
                jFrame.getContentPane().removeAll();
                //删除组件完毕后，需要通过重新revalidate()使删除生效
                jFrame.getContentPane().revalidate();
                loginSuccess();
            } else {
                JOptionPane.showMessageDialog(jFrame, "登录失败", "Sorry", JOptionPane.ERROR_MESSAGE);

            }
        };
        return loginListener;
    }

    private static void loginSuccess() {
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(null);
        JTextArea jTextArea = new JTextArea();
        jTextArea.setBounds(10, 10, 100, 100);
        jTextArea.append("欢迎进入奥");
        jTextArea.setEnabled(false);

        jPanel.add(jTextArea);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginFormSW::createMainUI);
    }
}
