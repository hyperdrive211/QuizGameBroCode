import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;


/**
 * Created By Jonathon on 11/11/2020
 * Update Comments About Program Here
 **/
public class Quiz implements ActionListener{

    //Constructor
    String [] questions = {
           "Which company created Java?",
            "Which year was Java created?",
            "What was Java originally called?",
            "Who is credited with creating Java?"
    };

    String[][] options = {
            {"Sun Microsystems", "Starbucks", "Microsoft", "Alphabet"},
            {"1989", "1996", "1972", "1492"},
            {"Apple", "Latte", "Oak", "Koffing"},
            {"Steve Jobs", "Bill Gates", "James Gosling", "Mark Zuckerberg"}
    };

    char [] answers = {
            'A', 'B', 'C', 'C'
    };

    char guess; char answer; int index; int correct_guesses = 0; int total_questions = questions.length;
    int result; int seconds = 10;

    JFrame frame = new JFrame(); JTextField textField = new JTextField(); JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton(); JButton buttonB = new JButton(); JButton buttonC = new JButton();
    JButton buttonD = new JButton();

    JLabel answer_labelA = new JLabel(); JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel(); JLabel answer_labelD = new JLabel();

    JLabel time_label = new JLabel(); JLabel seconds_left = new JLabel();

    JTextField number_right = new JTextField(); JTextField percentage = new JTextField();

    Color background = new Color(25,25,25);
    Color foreground = new Color(25,255,0);
    Font font = new Font("MV Boli", Font.BOLD, 25);
    Font buttonFont = new Font("MV Boli", Font.BOLD, 35);
    Font labelFont = new Font("MV Boli", Font.PLAIN, 35);

    Color wrong = new Color(255,0,0);

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if(seconds <=0 ){
                displayAnswer();
            }
        }
    });

    public Quiz() {
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(650, 650);
         frame.getContentPane().setBackground(new Color(50, 50, 50));
         frame.setLayout(null);
         frame.setResizable(false);

         textField.setBounds(0, 0, 650, 50);
         textField.setBackground(background);
         textField.setForeground(foreground);
         textField.setFont(new Font("Ink Free", Font.BOLD, 30));
         textField.setBorder(BorderFactory.createBevelBorder(1));
         textField.setHorizontalAlignment(JTextField.CENTER);
         textField.setEditable(false);
         textField.setText("Testing Text");

         textArea.setBounds(0, 50, 650, 50);
         textArea.setLineWrap(true);
         textArea.setWrapStyleWord(true);
         textArea.setBackground(background);
         textArea.setForeground(foreground);
         textArea.setFont(font);
         textArea.setBorder(BorderFactory.createBevelBorder(1));
         textArea.setEditable(false);
         textArea.setText("Sample Text");

         buttonA.setBounds(0, 150, 100, 100);
         buttonA.setFont(buttonFont);
         buttonA.setFocusable(false);
         buttonA.addActionListener(this);
         buttonA.setText("A");

        buttonB.setBounds(0, 250, 100, 100);
        buttonB.setFont(buttonFont);
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0, 350, 100, 100);
        buttonC.setFont(buttonFont);
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0, 450, 100, 100);
        buttonD.setFont(buttonFont);
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelA.setBounds(125, 150,500, 100 );
        answer_labelA.setBackground(background);
        answer_labelA.setForeground(foreground);
        answer_labelA.setFont(labelFont);
        answer_labelA.setText("I am working");

        answer_labelB.setBounds(125, 250, 500,100);
        answer_labelB.setBackground(background);
        answer_labelB.setForeground(foreground);
        answer_labelB.setFont(labelFont);
        answer_labelB.setText("I am working");


        answer_labelC.setBounds(125, 350, 500,100);
        answer_labelC.setBackground(background);
        answer_labelC.setForeground(foreground);
        answer_labelC.setFont(labelFont);
        answer_labelC.setText("I am working");


        answer_labelD.setBounds(125, 450, 500,100);
        answer_labelD.setBackground(background);
        answer_labelD.setForeground(foreground);
        answer_labelD.setFont(labelFont);
        answer_labelD.setText("I am working");

        seconds_left.setBounds(535, 510,100,100);
        seconds_left.setBackground(background);
        seconds_left.setForeground(new Color(255, 0,0));
        seconds_left.setFont(new Font("Ink Free", Font.BOLD, 60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

         time_label.setBounds(535, 475, 100, 25);
         time_label.setBackground(new Color(50,50,50));
         time_label.setForeground(new Color(255, 0, 0));
         time_label.setFont(new Font("MV Boli", Font.PLAIN, 16));
         time_label.setHorizontalAlignment(JTextField.CENTER);
         time_label.setText("Test!");

         number_right.setBounds(225, 225, 200, 100);
         number_right.setBackground(background);
         number_right.setBackground(foreground);

         number_right.setFont(new Font("Ink Free", Font.BOLD, 50));
         number_right.setBorder(BorderFactory.createBevelBorder(1));
         number_right.setHorizontalAlignment(JTextField.CENTER);
         number_right.setEditable(false);

         percentage.setBounds(225,325, 200,100);
         percentage.setBackground(background);
         percentage.setForeground(foreground);
         percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
         percentage.setBorder(BorderFactory.createBevelBorder(1));
         percentage.setHorizontalAlignment(JTextField.CENTER);
         percentage.setEditable(false);



         frame.add(time_label);
         frame.add(seconds_left);
         frame.add(buttonA);
         frame.add(buttonB);
         frame.add(buttonC);
         frame.add(buttonD);

         frame.add(answer_labelA);
         frame.add(answer_labelB);
         frame.add(answer_labelC);
         frame.add(answer_labelD);

         frame.add(textArea);
         frame.add(textField);
         frame.setVisible(true);

         nextQuestion();


    }

    public void nextQuestion(){
        if(index >= total_questions){
            results();
        }else{
            textField.setText("Question " + (index + 1));
            textArea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();
        }

    }

    public void displayAnswer(){

        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index] != 'A'){
            answer_labelA.setForeground(wrong);
        }
        if(answers[index] != 'B'){
            answer_labelB.setForeground(wrong);
        }
        if(answers[index] != 'C'){
            answer_labelC.setForeground(wrong);
        }
        if(answers[index] != 'D'){
            answer_labelD.setForeground(wrong);
        }

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer_labelA.setForeground(foreground);
                answer_labelB.setForeground(foreground);
                answer_labelC.setForeground(foreground);
                answer_labelD.setForeground(foreground);

                answer =' ';
                seconds = 10;
                seconds_left.setText(String.valueOf(seconds));

                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });

        pause.setRepeats(false);
        pause.start();
    }

    public void results(){
      buttonA.setEnabled(false);
      buttonB.setEnabled(false);
      buttonC.setEnabled(false);
      buttonD.setEnabled(false);

      result = (int)((correct_guesses / (double) total_questions) * 100);
      textField.setText("Results : ");
              textArea.setText(" ");

              answer_labelA.setText("");
              answer_labelB.setText("");
              answer_labelC.setText("");
              answer_labelD.setText("");

              number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
              percentage.setText(result+"%");

              frame.add(percentage);
              frame.add(number_right);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA){
            answer = 'A';
            if(answer == answers[index]){
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonB){
            answer = 'B';
            if(answer == answers[index]){
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonC){
            answer = 'C';
            if(answer == answers[index]){
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonD){
            answer = 'D';
            if(answer == answers[index]){
                correct_guesses++;
            }
        }

        displayAnswer();




    }
}
