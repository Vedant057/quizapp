package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class playActivity extends AppCompatActivity {
    String[] question_list = {"Who scored the first century in the history of the Cricket World Cup?",
            "Which country has won the most Cricket World Cups?",
            "In which year was the first Cricket World Cup held?",
            "Who holds the record for the highest individual score in a single World Cup innings?",
            "Which team won the inaugural ICC Cricket World Cup in 1975?",
            "Which player has the most centuries in Cricket World Cup history?",
            "What is the highest team total in a Cricket World Cup match?",
            "Who captained India to victory in the 1983 Cricket World Cup?",
            "Which player has taken the most wickets in Cricket World Cup history?",
            "Who holds the record for the most dismissals by a wicketkeeper in Cricket World Cup history?",
            "Who is the highest run-scorer in the World Cup 2023?",
            "Which team has the highest scores in the history of the World Cup?",
            "Who is the top wicket-taking bowler in the two successive editions of the ODI World Cup?",
            "Which of the following cities has hosted the World Cup final on most occasions?",
            "Which of the following Indian players has taken the most wickets in World Cup history?",


    };
    String[] choose_list = {"Vivian Richards ","Clive Lloyd","Sunil Gavaskar","Dennis Amiss",
            "Australia","West Indies","England","India",
            "1967","1975","1983","1992",
            "Sachin Tendulkar","Ricky Ponting","Martin Guptill ","Chris Gayle",
            "Australia","West Indies","England","India",
            "Sachin Tendulkar","Virat Kohli","Rohit Sharma","Kamlesh Sirsat",
            "481/6","428/5","376/2","372/4",
            "Kapil Dev","Sunil Gavaskar","Ravi Shastri","Mohinder Amarnath",
            "Kapil Dev","Wasim Akram","Glenn McGrath","Muttiah Muralitharan",
            "Adam Gilchrist","Mark Boucher","Kumar Sangakkara","MS Dhoni",
            "Rachin Ravindra","Mohammad Rizwan","Rohit Sharma","Virat Kohli",
            "India","South Africa","Pakistan","England",
            "Glen McCarth","Mitchell Starc","Shane Warne","Wasim Akram",
            "London, England","Sydney, Australia","Mumbai, India","Lahore, Pakistan",
            "Anil Kumble","Javagal Srinath","Zaheer Khan","Harbhajan Singh",
    };
    String[] correct_list = {"Dennis Amiss","Australia","1975","Sachin Tendulkar","West Indies","Rohit Sharma","428/5","Kapil Dev","Glenn McGrath","Kumar Sangakkara","Virat Kohli","South Africa","Mitchell Starc","Sydney, Australia","Javagal Srinath"};


    TextView cpt_question , text_question;
    Button btn_choose1 , btn_choose2 , btn_choose3 , btn_choose4 , btn_next;


    int currentQuestion =  0  ;
    int scorePlayer =  0  ;
    boolean isclickBtn = false;
    String valueChoose = "";
    Button btn_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        cpt_question = findViewById(R.id.cpt_question);
        text_question = findViewById(R.id.text_question);

        btn_choose1 = findViewById(R.id.btn_choose1);
        btn_choose2 = findViewById(R.id.btn_choose2);
        btn_choose3 = findViewById(R.id.btn_choose3);
        btn_choose4 = findViewById(R.id.btn_choose4);
        btn_next = findViewById(R.id.btn_next);

        findViewById(R.id.image_back).setOnClickListener(
                a-> finish()
        );
        remplirData();
        btn_next.setOnClickListener(
                view -> {
                        if (isclickBtn){
                            isclickBtn = false;

                            if(!valueChoose.equals(correct_list[currentQuestion])){
                                Toast.makeText(playActivity.this , "Wrong",Toast.LENGTH_LONG).show();
                                btn_click.setBackgroundResource(R.drawable.background_btn_erreur);

                            }else {
                                Toast.makeText(playActivity.this , "correct",Toast.LENGTH_LONG).show();
                                btn_click.setBackgroundResource(R.drawable.background_btn_correct);

                                scorePlayer++;
                            }
                            new Handler().postDelayed(() -> {
                                if(currentQuestion!=question_list.length-1){
                                    currentQuestion = currentQuestion + 1;
                                    remplirData();
                                    valueChoose = "";
                                    btn_choose1.setBackgroundResource(R.drawable.background_btn_choose);
                                    btn_choose2.setBackgroundResource(R.drawable.background_btn_choose);
                                    btn_choose3.setBackgroundResource(R.drawable.background_btn_choose);
                                    btn_choose4.setBackgroundResource(R.drawable.background_btn_choose);

                                }else {
                                    Intent intent  = new Intent(playActivity.this , ResulteActivity.class);
                                    intent.putExtra("Resute" , scorePlayer);
                                    startActivity(intent);
                                    finish();
                                }

                            },2000);

                        }else {
                            Toast.makeText(playActivity.this ,  "You need to choose it",Toast.LENGTH_LONG).show();
                        }
                }
        );


    }

    void remplirData(){
        cpt_question.setText((currentQuestion+1) + "/" + question_list.length);
        text_question.setText(question_list[currentQuestion]);

        btn_choose1.setText(choose_list[4 * currentQuestion]);
        btn_choose2.setText(choose_list[4 * currentQuestion+1]);
        btn_choose3.setText(choose_list[4 * currentQuestion+2]);
        btn_choose4.setText(choose_list[4 * currentQuestion+3]);

    }

    public void ClickChoose(View view) {
        btn_click = (Button)view;

        if (isclickBtn) {
            btn_choose1.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose2.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose3.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose4.setBackgroundResource(R.drawable.background_btn_choose);
        }
        chooseBtn();


    }
    void chooseBtn(){

        btn_click.setBackgroundResource(R.drawable.background_btn_choose_color);
        isclickBtn = true;
        valueChoose = btn_click.getText().toString();
    }
}