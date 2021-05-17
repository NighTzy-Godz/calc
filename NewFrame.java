import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;



public class NewFrame extends JFrame implements ActionListener{

    Container c;
    JLabel principal, interest, years,
    result, error, prinI, intI, yearI, monI, line;
    JTextField t1, t2, t3;
    JButton btn, btn0, btnR, del; 
    NewFrame(){
        ImageIcon image = new ImageIcon("mortgage.png");
        setIconImage(image.getImage());
        setTitle("Excess Dime");
        setSize(400, 600);
        setResizable(false); 
        setLayout(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        

        c = getContentPane();
        c.setLayout(null);

        principal = new JLabel("Principal");
        principal.setBounds(20, 20, 360, 30);
        principal.setFont(new Font("POPPINS", Font.BOLD, 22));
        c.add(principal);
    
        t1 = new JTextField();
        t1.setBounds(170, 20, 190, 28); 
        c.add(t1);

        


        interest = new JLabel("Interest");
        interest.setBounds(20, 60, 360, 28);
        interest.setFont(new Font("POPPINS", Font.BOLD, 22));
        c.add(interest);
    
        t2 = new JTextField();
        t2.setBounds(170, 60, 190, 30);
        // t2.setEditable(false);
        c.add(t2);

        years = new JLabel("Years");
        years.setBounds(20, 100, 360, 28);
        years.setFont(new Font("POPPINS", Font.BOLD, 22));
        c.add(years);
    
        t3 = new JTextField("");
        t3.setBounds(170, 100, 190, 30);
        // t3.setEditable(false);
        c.add(t3);

        

        // BTN SETTINGS
        // 70, 180, 80, 60

        prinI = new JLabel();
        prinI.setText("YOUR PRINCIPAL");
        prinI.setBounds(10, 20, 330, 20);
        prinI.setFont(new Font("POPPINS", Font.BOLD, 18));

        intI = new JLabel();
        intI.setText("YOUR INTEREST");
        intI.setBounds(10, 70, 300, 20);
        intI.setFont(new Font("POPPINS", Font.BOLD, 18));

        yearI = new JLabel();
        yearI.setText("YEARS OF PAYMENTS");
        yearI.setBounds(10, 120, 330, 20);
        yearI.setFont(new Font("POPPINS", Font.BOLD, 18));

        monI = new JLabel();
        monI.setText("DURATION");
        monI.setBounds(10, 170, 330, 20);
        monI.setFont(new Font("POPPINS", Font.BOLD, 18));

        line = new JLabel();
        line.setText("---------------------------------------------------------------------------");
        line.setBounds(10, 200, 310, 10);

        result = new JLabel("RESULT: ");
        result.setBounds(10, 220, 330, 20);
        result.setFont(new Font("POPPINS", Font.BOLD, 16));

        error = new JLabel("ERROR: ");
        error.setBounds(10, 270, 330, 20);
        error.setFont(new Font("POPPINS", Font.BOLD, 16));

        
        

        JPanel panel = new JPanel();
        panel.setBounds(30, 160, 320, 310);
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);
        panel.add(prinI);
        panel.add(intI);
        panel.add(yearI);
        panel.add(monI);
        panel.add(line);
        panel.add(result);
        panel.add(error);

        

        

        btnR = new JButton("Reset");
        btnR.setBounds(30, 480, 160, 60);
        btnR.setFocusable(false);
        btnR.addActionListener(this);

        btn = new JButton("Answer");
        btn.setBounds(190, 480, 160, 60);
        btn.setFocusable(false);
        btn.addActionListener(this);

        

        
        c.add(panel);
        c.add(btnR);
        c.add(btn);
        
       
        


            

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e){


         if(e.getSource()==btn){
            // FOR ERRORS

            // String errP = "Prinicpal Must  Higher Than 99k and Lower Than 50M";
            // String errI = " Higher Than 1 and Lower Than 10";
            // String errorP = " Higher Than 0 and Lower Than 26";
            String noerr = "NO ERRORS";
            String chars = "qwertyuiop[]asdfghjkl;'zxcvbnm,./`1234567890-=/*-+";

            // GETTING THE DATA IN THE BOX
            int principal = Integer.parseInt(t1.getText());
            float interest = Float.parseFloat(t2.getText());
            int years = Integer.parseInt(t3.getText());
            
            byte valid = 0;

            
            
          
            // PRINCIPAL
            int maxPrinicpal = 1000000;
            int limitPrinicpal = 100000;
            if(principal < limitPrinicpal || principal > maxPrinicpal ){
                // error.setText("PRINCIPAL: " + errP);
                JOptionPane.showMessageDialog(null, "Principal Must Be Higher Than $100K and Lower Than 5$0M ", "Principal Error", JOptionPane.ERROR_MESSAGE);
                result.setText("RESULT: NO ANSWERS"); 
                System.out.println("Jeez");
            }else{
                valid += 1;
                error.setText("ERROR: " + noerr);
                prinI.setText("YOUR PRINCIPAL: $" + principal);
            }
    
            // INTEREST
            int MONTHS = 12;
            double final_interest = 0;
            int limit = 1;
            int max = 10;

            if(interest < limit || interest > max){
                
                JOptionPane.showMessageDialog(null, "Interest Must Be Higher Than 0 and Lower Than 10 ", "Interest Error", JOptionPane.ERROR_MESSAGE);
                result.setText("RESULT: NO ANSWERS"); 
            
            }else{     
                valid += 1;      
                final_interest = interest / 100 / MONTHS;
                intI.setText("YOUR INTEREST: " + interest + "%");
                
            }
        

            // YEARS OF PAYMENT
            int years_pay = 0;;
            int limitY = 1;
            int maxY = 30;

            if(years < limitY || years > maxY){
                JOptionPane.showMessageDialog(null, "Years Of Payment Must Be Higher Than 1 and Lower Than  30", "Years of Payment Error", JOptionPane.ERROR_MESSAGE);
                result.setText("RESULT: NO ANSWERS"); 
            }else{
                valid += 1;
                years_pay = years * MONTHS;
                yearI.setText("YEARS OF PAYMENT: " + years + " YEARS");
                monI.setText("DURATION: " + years_pay + " MONTHS");
            }
        

    //     double payment =  principal * ((final_interest * Math.pow(1 + final_interest, years_pay)
    //    / (Math.pow(1 + final_interest, years_pay) -1 )));


            if(valid == 3){
                double payment =  principal * ((final_interest * Math.pow(1 + final_interest, years_pay)
                / (Math.pow(1 + final_interest, years_pay) -1 )));
            

                DecimalFormat places = new DecimalFormat("###.##");
                JOptionPane.showMessageDialog(null, "No Errors Detected!", "No Errors", JOptionPane.INFORMATION_MESSAGE);
            
                result.setText("RESULT: $" + places.format(payment) + " Every Month");
                System.out.println(places.format(payment));
            } 
        }
        if(e.getSource()==btnR){
            t1.setText("");
            
            t2.setText("");
            t3.setText("");
            yearI.setText("YEARS OF PAYMENT: ");
            intI.setText("YOUR INTEREST: ");
            prinI.setText("YOUR PRINCIPAL: ");
            monI.setText("DURATION: ");
            result.setText("RESULT: ");
            error.setText("ERROR: ");
        }
    }
}
