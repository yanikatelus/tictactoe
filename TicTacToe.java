import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToe extends JPanel{

    JButton buttons[] = new JButton[9]; 
    int num = 0;//if num is a even, then put a X. If it's odd, then put an O
    
    /* constructor */
    public TicTacToe(){
      setLayout(new GridLayout(3,3));
      initializeButtons(); 
    }
    /* method: intialize
         creates 8 buttons on jpanel
    */
    public void initializeButtons(){
        for(int i = 0; i <= 8; i++){
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(new buttonListener());
            add(buttons[i]); //adds this button to JPanel (note: no need for JPanel.add(...)     
        }
    }
    /* method: intialize
         clears buttons on jpanel
    */
    public void resetButtons(){
        for(int i = 0; i <= 8; i++){
            buttons[i].setText("");
        }
    //action listener for buttons    
    private class buttonListener implements ActionListener{
       
        public void actionPerformed(ActionEvent e) {
            
            JButton clicked = (JButton)e.getSource(); //get the particular button that was clicked
            if(num%2 == 0)
                clicked.setText("X");
            else
                clicked.setText("O");
            
            if(win() == true){
                JOptionPane.showConfirmDialog(null, "Game Over.");
                resetButtons();
            }   
            num++;
        }
        
        public boolean win(){
            /**   Reference: the button array is arranged like this as the board
             *      0 | 1 | 2
             *      3 | 4 | 5
             *      6 | 7 | 8
             */
            //horizontal winner
            if( checkAdjacent(0,1) && checkAdjacent(1,2) )
                return true;
            else if( checkAdjacent(3,4) && checkAdjacent(4,5) )
                return true;
            else if ( checkAdjacent(6,7) && checkAdjacent(7,8))
                return true;
            
            //vertical winner
            else if ( checkAdjacent(0,3) && checkAdjacent(3,6))
                return true;  
            else if ( checkAdjacent(1,4) && checkAdjacent(4,7))
                return true;
            else if ( checkAdjacent(2,5) && checkAdjacent(5,8))
                return true;
            
            //diagonal winner
            else if ( checkAdjacent(0,4) && checkAdjacent(4,8))
                return true;  
            else if ( checkAdjacent(2,4) && checkAdjacent(4,6))
                return true;
            else 
                return false;
        }
        
        public boolean checkAdjacent(int a, int b){
            if ( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("") )
                return true;
            else
                return false;
        }
        
    }
    //main method
    public static void main(String[] args) {
        JFrame window = new JFrame("Tic Tac Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new TicTacToe());
        window.setBounds(300,200,300,300);
        window.setVisible(true);
    }
}