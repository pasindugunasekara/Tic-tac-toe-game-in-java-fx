package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    JFrame jFrame = new JFrame();
    JPanel buttonpanel = new JPanel();
    JPanel titlepanal = new JPanel();
    JLabel text = new JLabel();
    JButton[] buttonset = new JButton[9];
    Random random = new Random();
    boolean player1_opportunity;


    TicTacToe(){
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(700,700);
        jFrame.getContentPane().setBackground(new Color(0,0,0));
        jFrame.setLayout(new BorderLayout());
        jFrame.setVisible(true);

        text.setBackground(new Color(160,160,160));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("WELOCOME TO XOX GAME");
        text.setForeground(new Color(0,153,153));
        text.setFont(new Font("Ink Free", Font.BOLD,40));
        text.setOpaque(true);

        titlepanal.setLayout(new BorderLayout());
        titlepanal.setBounds(0,0,700,100);

        buttonpanel.setLayout(new GridLayout(3,3));
        buttonpanel.setBackground(new Color(102,255,255));

        for (int i=0; i<9; i++){
            buttonset[i] =new JButton();
            buttonpanel.add(buttonset[i]);
            buttonset[i].setFocusable(false);
            buttonset[i].addActionListener(this);
            buttonset[i].setFont(new Font( "MV Boli",Font.BOLD, 120));
        }

        titlepanal.add(text);
        jFrame.add(titlepanal,BorderLayout.NORTH);
        jFrame.add(buttonpanel);

        opportunity();

    }

    public void opportunity(){
        if (random.nextInt(2)==0){
            player1_opportunity=true;
            text.setText("X opportunity");
        }else {
            player1_opportunity=false;
            text.setText("O opportunity");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<9; i++){
            if (e.getSource()==buttonset[i]){
                if (player1_opportunity){
                    if (buttonset[i].getText()==""){
                        buttonset[i].setForeground(new Color(255,0,0));
                        buttonset[i].setText("X");
                        player1_opportunity=false;
                        text.setText("O opportunity");
                        search();
                    }
                }
                else {
                    if (buttonset[i].getText()==""){
                        buttonset[i].setForeground(new Color(0,0,204));
                        buttonset[i].setText("O");
                        player1_opportunity=true;
                        text.setText("X opportunity");
                        search();
                    }
                }
            }
        }
    }
    public void search(){
        if (
                (buttonset[0].getText()=="X") &&
                (buttonset[1].getText()=="X") &&
                (buttonset[2].getText()=="X")
        ){
            XWon(0,1,2);
        }
        if (
                (buttonset[3].getText()=="X") &&
                (buttonset[4].getText()=="X") &&
                (buttonset[5].getText()=="X")
        ){
            XWon(3,4,5);
        }
        if (
                (buttonset[6].getText()=="X") &&
                (buttonset[7].getText()=="X") &&
                (buttonset[8].getText()=="X")
        ){
            XWon(6,7,8);
        }
        if (
                (buttonset[0].getText()=="X") &&
                (buttonset[3].getText()=="X") &&
                (buttonset[6].getText()=="X")
        ){
            XWon(0,3,6);
        }
        if (
                (buttonset[1].getText()=="X") &&
                (buttonset[4].getText()=="X") &&
                (buttonset[7].getText()=="X")
        ){
            XWon(1,4,7);
        }
        if (
                (buttonset[2].getText()=="X") &&
                (buttonset[5].getText()=="X") &&
                (buttonset[8].getText()=="X")
        ){
            XWon(2,5,8);
        }
        if (
                (buttonset[0].getText()=="X") &&
                (buttonset[4].getText()=="X") &&
                (buttonset[8].getText()=="X")
        ){
            XWon(0,4,8);
        }
        if (
                (buttonset[2].getText()=="X") &&
                (buttonset[4].getText()=="X") &&
                (buttonset[6].getText()=="X")
        ){
            XWon(2,4,6);
        }


        //o win
        if (
                (buttonset[0].getText()=="O") &&
                        (buttonset[1].getText()=="O") &&
                        (buttonset[2].getText()=="O")
        ){
            OWon(0,1,2);
        }
        if (
                (buttonset[3].getText()=="O") &&
                        (buttonset[4].getText()=="O") &&
                        (buttonset[5].getText()=="O")
        ){
            OWon(3,4,5);
        }
        if (
                (buttonset[6].getText()=="O") &&
                        (buttonset[7].getText()=="O") &&
                        (buttonset[8].getText()=="O")
        ){
            OWon(6,7,8);
        }
        if (
                (buttonset[0].getText()=="O") &&
                        (buttonset[3].getText()=="O") &&
                        (buttonset[6].getText()=="O")
        ){
            OWon(0,3,6);
        }
        if (
                (buttonset[1].getText()=="O") &&
                        (buttonset[4].getText()=="O") &&
                        (buttonset[7].getText()=="O")
        ){
            OWon(1,4,7);
        }
        if (
                (buttonset[2].getText()=="O") &&
                        (buttonset[5].getText()=="O") &&
                        (buttonset[8].getText()=="O")
        ){
            OWon(2,5,8);
        }
        if (
                (buttonset[0].getText()=="O") &&
                        (buttonset[4].getText()=="O") &&
                        (buttonset[8].getText()=="O")
        ){
            OWon(0,4,8);
        }
        if (
                (buttonset[2].getText()=="O") &&
                        (buttonset[4].getText()=="O") &&
                        (buttonset[6].getText()=="O")
        ){
            OWon(2,4,6);
        }


    }



    public void XWon(int x,  int y , int z){

        buttonset[x].setBackground(Color.YELLOW);
        buttonset[y].setBackground(Color.YELLOW);
        buttonset[z].setBackground(Color.YELLOW);

        for (int i=0;i<9; i++){
            buttonset[i].setEnabled(false);
        }
        text.setText("X WON");

    }
    public void OWon(int x,  int y , int z){
        buttonset[x].setBackground(Color.YELLOW);
        buttonset[y].setBackground(Color.YELLOW);
        buttonset[z].setBackground(Color.YELLOW);

        for (int i=0;i<9; i++){
            buttonset[i].setEnabled(false);
        }
        text.setText("O WON");

    }
}
