/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.clock;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class ClockThread extends Thread{
    private JLabel time;

    public ClockThread(JLabel time) {
        this.time = time;
    }
    
    
    @Override
    public void run(){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
        while(true){
            Date now = new Date();
            String st = sdf.format(now);
            time.setText(st);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
