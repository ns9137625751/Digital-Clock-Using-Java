import java.awt.*;
// import java.awt.event.*;
import java.util.Date;
import javax.swing.*;


public class MyWindow extends JFrame {
    private JLabel headding;
    private JLabel clockLabel;

    private Font font=new Font("",Font.BOLD,35);
    MyWindow(){
        super.setTitle("My Clock");
        super.setSize(500,500);
        super.setLocation(300, 50);
        this.createGUI();
        this.startClock();
        super.setVisible(true);
    }
    public void createGUI(){
        headding= new JLabel("Nishant Clock");
        clockLabel=new JLabel("clock");

        headding.setFont(font);
        clockLabel.setFont(font);

        this.setLayout(new GridLayout(2,1));
        this.add(headding);
        this.add(clockLabel);
    }
    public void startClock(){

        // without Threading
        // Timer timer = new Timer(1000,new ActionListener(){
        //     @Override
        //     public void actionPerformed(ActionEvent e){
        //         // String DateTime=new Date().toString();
        //         String DateTime=new Date().toLocaleString();
        //         clockLabel.setText(DateTime);
        //     }
        // });
        // timer.start();


        // Using Threading
        Thread t= new Thread(){
            public void run(){
                try {
                    while(true){
                        String DateTime=new Date().toLocaleString();
                        clockLabel.setText(DateTime);
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}
