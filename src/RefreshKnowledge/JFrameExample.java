package RefreshKnowledge;

import javax.swing.*;
import java.awt.*;

public class JFrameExample extends JFrame {
    JFrame frame;
    JPanel ActionComponentsPanel;
    JPanel textPanel;

    private static final JFrameExample instance = new JFrameExample("test");

    static JFrameExample getInstance() {
        return instance;
    }

    public JFrameExample(String title) throws HeadlessException {
//sets up the basic framework
    //basic frame
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(422,422);

    // basic Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1= new JMenu("Menu1");
       JMenuItem menuItem1=new JMenuItem("MenuItem1");
       JMenuItem menuItem2=new JMenuItem("MenuItem2");
       JMenuItem menuItem3=new JMenuItem("MenuItem3");

        //AddsActionListners to MenuItems

        menuItem1.addActionListener(e-> System.out.println("It works 1"));
        menuItem2.addActionListener(e-> System.out.println("It works 2"));
        menuItem3.addActionListener(e-> System.out.println("It works 3"));


        //adds item to a menubar
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.add(menuItem3);
        menuBar.add(menu1);

    //adds buttons to a panel
        ActionComponentsPanel = new JPanel();
        JButton heyButton = new JButton("Click Here!");
        JButton byeButton = new JButton("Click Here!2");
        ActionComponentsPanel.add(heyButton);
        ActionComponentsPanel.add(byeButton);

        //ActionL's to buttons
        heyButton.addActionListener((e)->{
            JOptionPane.showMessageDialog(frame,"You did it...:->");
        });
        byeButton.addActionListener((e)->{
            JOptionPane.showMessageDialog(frame,"You did it.Again..:->");
        });

    //Makes a panel for adding labels as text.
        textPanel= new JPanel();
        JLabel infoLabel = new JLabel("This is label1");
        JLabel testLabel = new JLabel("This is label2");
        textPanel.add(infoLabel);
        textPanel.add(testLabel);

    //sets everything to the frame;
        frame.setLayout(new BorderLayout());
        frame.setJMenuBar(menuBar);
        frame.add(ActionComponentsPanel,BorderLayout.AFTER_LINE_ENDS);
        frame.add(textPanel,BorderLayout.CENTER);

    //sets it all visible!!
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrameExample.getInstance();
    }
}
