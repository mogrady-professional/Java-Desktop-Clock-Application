import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

/**
 * Extends JFrame
 * @author Michael
 *
 */
public class clockFrame extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	Define Instance Variables
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	String time;
	String day;
	String date;

	/**
	 * Constructor for clockFrame
	 */
	clockFrame(){
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setTitle("Java Desktop Clock Application");
  this.setLayout(new FlowLayout()); //  centered alignment 
  this.setSize(400,150); // Sizing
  this.setResizable(false); // Fixed size
  
// Date Time Pattern Reference -> https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html#text
  timeFormat = new SimpleDateFormat("hh:mm:ss a");
  dayFormat = new SimpleDateFormat("EEEE"); // Display full day Name
  dateFormat = new SimpleDateFormat("dd MMMMM, yyyy"); // Format Day, Date, Month, Year
  
  timeLabel = new JLabel(); // Time
  timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
  timeLabel.setForeground(new Color(0x00FF00));
  timeLabel.setBackground(Color.black);
  timeLabel.setOpaque(true);
  
  dayLabel = new JLabel(); // Day
  dayLabel.setFont(new Font("Ink Free",Font.PLAIN,25));
  
  dateLabel = new JLabel(); // Date
  dateLabel.setFont(new Font("Ink Free",Font.PLAIN,25));
  
//  Add elements to JFrame
  this.add(timeLabel);
  this.add(dayLabel);
  this.add(dateLabel);
  this.setVisible(true);
  
  /**
   * Run Method each second
   */
  setTime();
 }
/**
 * While loop to update each second
 */
	public void setTime() {
		while (true) {
			/*
			 * Call Calendar class directly to get the time
			 */
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);

			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);

			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}