import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;

class Calculator extends JFrame implements ActionListener{
    //Leftside Number, Operator, and RightSide Number
    String s0, s1, s2;
    //Buttons for numbers and math operations that appear
    JButton button0, button1, button2, button3, button4, button5, 
    button6, button7, button8, button9, buttonAdd, buttonSub, buttonDiv, 
    buttonMulti, buttonEquals, buttonDeci, buttonClear, buttonPow, buttonSqrt, buttonNlog;
    static JFrame f;
    static JTextField l;

    private Calculator(){
        this.s0 = "";
        this.s1 = "";
        this.s2 = "";
        //create number buttons
        this.button0 = new JButton("0");
        this.button1 = new JButton("1");
        this.button2 = new JButton("2");
        this.button3 = new JButton("3");
        this.button4 = new JButton("4");
        this.button5 = new JButton("5");
        this.button6 = new JButton("6");
        this.button7 = new JButton("7");
        this.button8 = new JButton("8");
        this.button9 = new JButton("9");
        
        //equals button
        this.buttonEquals = new JButton("=");
        
        //create operator buttons
        this.buttonAdd = new JButton("+");
        this.buttonSub = new JButton("-");
        this.buttonDiv = new JButton("/");
        this.buttonMulti = new JButton("*");
        this.buttonClear = new JButton("C");
        this.buttonPow = new JButton("^");
        this.buttonSqrt = new JButton("Sqrt");
        this.buttonNlog = new JButton("Nlog");
 
        // create . button
        this.buttonDeci = new JButton(".");
        
        //build calculator
        f = new JFrame("Shrubulator");
        f.add(createButtons());
        f.setSize(250, 300);
        f.setVisible(true);
    }

    private JPanel createButtons(){
        //Intialize JPanel
        l = new JTextField(16);
        l.setEditable(false);
        JPanel p = new JPanel();
        p.add(l);
        p.add(buttonClear);
        p.add(button0);
        p.add(button1);
        p.add(button2);
        p.add(button3);
        p.add(button4);
        p.add(button5);
        p.add(button6);
        p.add(button7);
        p.add(button8);
        p.add(button9);
        p.add(buttonAdd);
        p.add(buttonMulti);
        p.add(buttonSub);
        p.add(buttonDiv);
        p.add(buttonEquals);
        p.add(buttonDeci);
        p.add(buttonPow);
        p.add(buttonSqrt);
        p.add(buttonNlog);
        return p;
    }

    private void addActionListener(Calculator c){
        //Function for declaring the actionlistener for all the buttons
        buttonAdd.addActionListener(c);
        buttonDiv.addActionListener(c);
        buttonSub.addActionListener(c);
        buttonMulti.addActionListener(c);
        button9.addActionListener(c);
        button8.addActionListener(c);
        button7.addActionListener(c);
        button6.addActionListener(c);
        button5.addActionListener(c);
        button4.addActionListener(c);
        button3.addActionListener(c);
        button2.addActionListener(c);
        button1.addActionListener(c);
        button0.addActionListener(c);
        buttonDeci.addActionListener(c);
        buttonEquals.addActionListener(c);
        buttonClear.addActionListener(c);
        buttonPow.addActionListener(c);
        buttonSqrt.addActionListener(c);
        buttonNlog.addActionListener(c);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        //Check if inputted button is a numberor decimal
        if(s.charAt(0) >= '0' && s.charAt(0) <= '9' || s.charAt(0) == '.'){
            //if s1(left number) is already filled
            if(!s1.equals("")){
                //set right number to input
                s2 = s2 + s;
            }else{
                //set leftside to input
                s0 = s0 + s;
            }
            l.setText(s0 + s1 + s2);    
        }else if(s.charAt(0) == 'C'){
            //Clear the calculator
            s0 = s1 = s2 = "";
            l.setText(s0 + s1 + s2);
        }else if(s.equals("Sqrt")){
            //Take then Square Root of an inputted number 
            double toEquals;
            toEquals = Math.sqrt(Double.parseDouble(s0));
            l.setText("Sqrt " + s0 + "=" + toEquals);
            s0 = Double.toString(toEquals);
            s1 = s2 = "";
        }else if(s.equals("Nlog")){
            //Find the Natural Log of the Number
            double toEquals;
            toEquals = Math.log(Double.parseDouble(s0));
            l.setText("Nlog " + s0 + "=" + toEquals);
            s0 = Double.toString(toEquals);
            s1 = s2 = "";
        }else if(s.charAt(0) == '='){
            //Outputs results if there is both a leftside and rightside number and an operator and equalsis pressed
            double toEquals = 0.0;
                switch(s1){
                case("+"): 
                    toEquals = (Double.parseDouble(s0) + Double.parseDouble(s2));
                    break;
                case("-"):
                    toEquals = (Double.parseDouble(s0) - Double.parseDouble(s2));
                    break;
                case("/"):
                    toEquals = (Double.parseDouble(s0) / Double.parseDouble(s2));
                    break;
                case("*"):
                    toEquals = (Double.parseDouble(s0) * Double.parseDouble(s2));
                    break;
                case("^"):
                    toEquals = (Math.pow(Double.parseDouble(s0), Double.parseDouble(s2)));
                    break;
                default:
                    System.out.println("Error");
                }
                l.setText(s0 + s1 + s2 + "=" + toEquals);
                // convert it to string
                s0 = Double.toString(toEquals);
                s1 = s2 = "";
        }else{
            //If leftside or rightside is empty
            if(s1.equals("") || s2.equals("")){
                s1 = s;
           }else{
            //If all three slots are filled and other operator is pressed(results will be caclulated as if equals was pressed then placed to the left and the new operand)
            double toEquals = 0.0;
            switch(s1){
                case("+"): 
                    toEquals = (Double.parseDouble(s0) + Double.parseDouble(s2));
                    break;
                case("-"):
                    toEquals = (Double.parseDouble(s0) - Double.parseDouble(s2));
                    break;
                case("/"):
                    toEquals = (Double.parseDouble(s0) / Double.parseDouble(s2));
                    break;
                case("*"):
                    toEquals = (Double.parseDouble(s0) * Double.parseDouble(s2));
                    break;
                case("^"):
                    toEquals = (Math.pow(Double.parseDouble(s0), Double.parseDouble(s2)));
                    break;
                default:
                    System.out.println("Error");
                }
                s0 = Double.toString(toEquals);
                // place the operator
                s1 = s;
                // make the operand blank
                s2 = "";
           }
           l.setText(s0 + s1 + s2);
        }
        
    }
    public static void main(String[] args){
        Calculator c = new Calculator();
        c.addActionListener(c);
    }
}
