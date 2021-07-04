package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TikTacToe implements ActionListener {
    Random random = new Random(); //SETS A RANDOM USER
    JFrame frame = new JFrame(); // sets the frame of the project up
    JPanel title_panel = new JPanel();
    JPanel Button_panel = new JPanel();
    JLabel Text = new JLabel();
    JButton[] buttons = new JButton[9]; // an array of buttons for the grid
    boolean player1_turn; // if true player one go, if false players 2
    //constructor
    TikTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800); //frame size
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        //sets title at top of the screen
        Text.setBackground(new Color(25,25,25));
        Text.setForeground(new Color(25,255,0));
        Text.setFont(new Font("Int free", Font.BOLD,75));
        Text.setHorizontalAlignment(JLabel.CENTER);
        Text.setText("tiktactoe");
        Text.setOpaque(true);
        // buttons are in a grid of 3 by 3
        Button_panel.setLayout(new GridLayout(3,3));
        Button_panel.setBackground(new Color(25,25,25));

        for(int i =0; i<9; i++){
            buttons[i] = new JButton();
            Button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);
        firstTurn();



        title_panel.add(Text);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(Button_panel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0;i<9;i++){
            if(e.getSource() ==buttons[i]){
                if (player1_turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255));
                        buttons[i].setText(("X"));
                        player1_turn = false;
                        Text.setText("O's Turn");
                        checkWin();
                    }
                }
                else{
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText(("O"));
                        player1_turn = true;
                        Text.setText("X's Turn");
                        checkWin();
                    }
                }
            }

        }
    }

    public void firstTurn(){

        //try {
         //   Thread.sleep(2000); //adds a delay before the program states the turn
        //} catch (InterruptedException e) {
          //  e.printStackTrace();
        //}
        if(random.nextInt(2) == 0){
            player1_turn= true;
            Text.setText("X's Turn");

        }
        else{
            player1_turn= false;
            Text.setText("O's Turn");
        }
    }
    public void checkWin(){
        //X's wins
        if((buttons[0].getText()=="X") & (buttons[1].getText()=="X") & (buttons[2].getText()=="X")){
            Xwins(0,1,2); //top row combination
        }
        if((buttons[3].getText()=="X") & (buttons[4].getText()=="X") & (buttons[5].getText()=="X")){
            Xwins(3,4,5); //middle row combination
        }
        if((buttons[6].getText()=="X") & (buttons[7].getText()=="X") & (buttons[8].getText()=="X")){
            Xwins(6,7,8); //bottom row combination
        }
        if((buttons[0].getText()=="X") & (buttons[3].getText()=="X") & (buttons[6].getText()=="X")){
            Xwins(0,3,6); //first collum
        }
        if((buttons[1].getText()=="X") & (buttons[4].getText()=="X") & (buttons[7].getText()=="X")){
            Xwins(1,4,7); //Second collum
        }
        if((buttons[2].getText()=="X") & (buttons[5].getText()=="X") & (buttons[8].getText()=="X")){
            Xwins(2,5,8); //third row combination
        }
        if((buttons[0].getText()=="X") & (buttons[4].getText()=="X") & (buttons[8].getText()=="X")){
            Xwins(0,4,8); //top left diaginal
        }
        if((buttons[2].getText()=="X") & (buttons[4].getText()=="X") & (buttons[6].getText()=="X")){
            Xwins(2,4,6); //top right diaginal
        }

        //O's wins
        if((buttons[0].getText()=="O") & (buttons[1].getText()=="O") & (buttons[2].getText()=="O")){
            Owins(0,1,2); //top row combination
        }
        if((buttons[3].getText()=="O") & (buttons[4].getText()=="O") & (buttons[5].getText()=="O")){
            Owins(3,4,5); //middle row combination
        }
        if((buttons[6].getText()=="O") & (buttons[7].getText()=="O") & (buttons[8].getText()=="O")){
            Owins(6,7,8); //bottom row combination
        }
        if((buttons[0].getText()=="O") & (buttons[3].getText()=="O") & (buttons[6].getText()=="O")){
            Owins(0,3,6); //first collum
        }
        if((buttons[1].getText()=="O") & (buttons[4].getText()=="O") & (buttons[7].getText()=="O")){
            Owins(1,4,7); //Second collum
        }
        if((buttons[2].getText()=="O") & (buttons[5].getText()=="O") & (buttons[8].getText()=="O")){
            Owins(2,5,8); //third row combination
        }
        if((buttons[0].getText()=="O") & (buttons[4].getText()=="O") & (buttons[8].getText()=="O")){
            Owins(0,4,8); //top left diaginal
        }
        if((buttons[2].getText()=="O") & (buttons[4].getText()=="O") & (buttons[6].getText()=="O")){
            Owins(2,4,6); //top right diaginal
        }
    }
    public void Xwins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        Text.setText("X wins");

    }
    public void Owins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        Text.setText("O wins");
    }
}
