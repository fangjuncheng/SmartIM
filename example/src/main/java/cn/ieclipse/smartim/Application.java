package cn.ieclipse.smartim;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import cn.ieclipse.smartqq.SmartQQPanel;
import cn.ieclipse.wechat.WechatPanel;
import icons.SmartIcons;
import io.github.biezhi.wechat.api.WechatClient;

public class Application {
    
    private JFrame window;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        WechatClient.initSSL();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Application window = new Application();
                    window.window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the application.
     */
    public Application() {
        initialize();
    }
    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        window = new JFrame() {
            @Override
            public void dispose() {
                IMHistoryManager.getInstance().flush();
                super.dispose();
            }
        };
        window.setTitle("SmartIM-SmartQQ/微信网页版");
        window.setBounds(100, 100, 700, 450);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        window.getContentPane().add(tabbedPane, BorderLayout.CENTER);
        
        SmartQQPanel panel1 = new SmartQQPanel();
        tabbedPane.addTab("SmartQQ", SmartIcons.qq, panel1, null);
        
        WechatPanel panel2 = new WechatPanel();
        tabbedPane.addTab("Wechat", SmartIcons.wechat, panel2, null);
        
        // JMenuBar menuBar = new JMenuBar();
        // frmSmartim.setJMenuBar(menuBar);
        //
        // JMenu mnNewMenu = new JMenu("文件");
        // mnNewMenu.setMnemonic('F');
        // menuBar.add(mnNewMenu);
        //
        // JMenuItem mntmNewMenuItem = new JMenuItem("SmartQQ");
        // mnNewMenu.add(mntmNewMenuItem);
        //
        // JMenuItem mntmNewMenuItem_1 = new JMenuItem("微信");
        // mnNewMenu.add(mntmNewMenuItem_1);
    }
    
}
