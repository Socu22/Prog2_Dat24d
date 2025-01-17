package RefreshKnowledge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class JFrameExample extends JFrame {
    JFrame frame;
    JPanel ActionComponentsPanel;
    JPanel textPanel;
    JTextField textField;
    JTextArea textArea;
    int counter=0;

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

        //weird Cursor and KeyBoard Stuff
        menuItem1.addActionListener(e-> {
            Robot robot = null;
            try {
                robot = new Robot();

                robot.mouseMove(400, 0);  // Move to (400, 0)
                Thread.sleep(500);        // Pause for 500 ms

                robot.mouseMove(400, 350);  // Move to (400, 350)
                Thread.sleep(500);

                robot.mouseMove(200, 350);  // Move to (200, 350)
                Thread.sleep(500);

                robot.mouseMove(200, 250);  // Move to (200, 250)
                Thread.sleep(500);
            } catch (AWTException ex) {
                throw new RuntimeException(ex);
            }catch (InterruptedException ex2){
                throw new RuntimeException();
            }

            // Move mouse in a square pattern with delays

        });
        menuItem2.addActionListener(e-> {
            Robot robot = null;
            try {
                robot = new Robot();

                robot.keyPress(KeyEvent.VK_H);
                robot.keyRelease(KeyEvent.VK_H);

                Thread.sleep(500);


                robot.keyPress(KeyEvent.VK_E);
                robot.keyRelease(KeyEvent.VK_E);

                Thread.sleep(500);

                robot.keyPress(KeyEvent.VK_Y);
                robot.keyRelease(KeyEvent.VK_Y);

                Thread.sleep(500);
                System.out.println(robot.getPixelColor(400,400).toString());


            } catch (AWTException ex) {
                throw new RuntimeException(ex);
            }catch (InterruptedException ex2){
                throw new RuntimeException();
            }

        });


        menuItem3.addActionListener(e-> {

        });


        //adds item to a menubar
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.add(menuItem3);
        menuBar.add(menu1);

    //adds buttons to a panel
        ActionComponentsPanel = new JPanel();
        JButton heyButton = new JButton("Click Hey!");
        JButton byeButton = new JButton("Click Bye");
        ActionComponentsPanel.add(heyButton);
        ActionComponentsPanel.add(byeButton);

        //ActionL's to buttons
        heyButton.addActionListener((e)->{
            //JOptionPane.showMessageDialog(frame,"Hey->");
            counter= Integer.parseInt(JOptionPane.showInputDialog(frame,"x is: ",counter));
            counter++;
            textField.setText(String.valueOf(counter));

        });
        byeButton.addActionListener((e)->{
            //JOptionPane.showMessageDialog(frame,"Bye->");
            JOptionPane.showMessageDialog(frame, textArea.getLineCount());
            textArea.append("\n "+counter);


        });

    //Makes a panel for adding labels as text.
        textPanel= new JPanel();
        JLabel infoLabel = new JLabel("This is label1");
        JLabel testLabel = new JLabel("This is label2");
        textField= new JTextField(20);
        textArea= new JTextArea(10,10);
        textPanel.add(infoLabel);
        textPanel.add(testLabel);
        textPanel.add(textField);
        textPanel.add(textArea);

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
