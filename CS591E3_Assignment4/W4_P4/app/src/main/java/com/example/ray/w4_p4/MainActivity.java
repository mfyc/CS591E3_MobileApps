package com.example.ray.w4_p4;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    Button btnA;
    Button btnB;
    Button btnC;
    Button btnD;
    Button btnE;
    Button btnF;
    Button btnG;
    Button btnH;
    Button btnI;
    Button btnJ;
    Button btnK;
    Button btnL;
    Button btnM;
    Button btnN;
    Button btnO;
    Button btnP;
    Button btnQ;
    Button btnR;
    Button btnS;
    Button btnT;
    Button btnU;
    Button btnV;
    Button btnW;
    Button btnX;
    Button btnY;
    Button btnZ;
    Button btnNewGame;
    TextView ltr1;
    TextView ltr2;
    TextView hintbox1;
    TextView hintbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA = (Button) findViewById(R.id.btnA);
        btnB = (Button) findViewById(R.id.btnB);
        btnC = (Button) findViewById(R.id.btnC);
        btnD = (Button) findViewById(R.id.btnD);
        btnE = (Button) findViewById(R.id.btnE);
        btnF = (Button) findViewById(R.id.btnF);
        btnG = (Button) findViewById(R.id.btnG);
        btnH = (Button) findViewById(R.id.btnH);
        btnI = (Button) findViewById(R.id.btnI);
        btnJ = (Button) findViewById(R.id.btnJ);
        btnK = (Button) findViewById(R.id.btnK);
        btnL = (Button) findViewById(R.id.btnL);
        btnM = (Button) findViewById(R.id.btnM);
        btnN = (Button) findViewById(R.id.btnN);
        btnO = (Button) findViewById(R.id.btnO);
        btnP = (Button) findViewById(R.id.btnP);
        btnQ = (Button) findViewById(R.id.btnQ);
        btnR = (Button) findViewById(R.id.btnR);
        btnS = (Button) findViewById(R.id.btnS);
        btnT = (Button) findViewById(R.id.btnT);
        btnU = (Button) findViewById(R.id.btnU);
        btnV = (Button) findViewById(R.id.btnV);
        btnW = (Button) findViewById(R.id.btnW);
        btnX = (Button) findViewById(R.id.btnX);
        btnY = (Button) findViewById(R.id.btnY);
        btnZ = (Button) findViewById(R.id.btnY);
        btnNewGame = (Button) findViewById(R.id.btnNewGame);
        ltr1 = (TextView) findViewById(R.id.ltr1);
        hintbox1 = (TextView) findViewById(R.id.hintbox1);
        hintbox = (TextView) findViewById(R.id.hintbox);
        ArrayList<String> words = new ArrayList<>();
        words.add("hollo");
        words.add("hollp");
        words.add("hollo");
        words.add("holqo");
        Random ran = new Random();
        int x = ran.nextInt(5);
        final String word = words.get(x);
        //    String hintletter= String.valueOf(word.charAt(0));
        //    hintbox.setText(hintletter);
        //  ltr1.setText("_____");
        //  ltr1.setTextColor(-1);
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(i);
            }
        });
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('a');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('b');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('c');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('d');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('e');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('f');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('g');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('h');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('i');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('j');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('k');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('l');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('m');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('n');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('o');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('p');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('q');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('r');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('s');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('t');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('u');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('v');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('w');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('x');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('y');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
        btnZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterIndex = word.indexOf('z');
                if (letterIndex == -1) {
                    wrong();
                } else {
                    ltr1.setText(word);
                }
            }
        });
    }






    private int getLives() {
        int maxtries = 6;
        int currentry = 0;
        currentry += 1;
        int lives = maxtries - currentry;
        return lives;
    }

    private void insertletter(char a, int num) {
        StringBuilder myName = new StringBuilder(ltr2.getText());
        myName.setCharAt(num, a);

        ltr1.setText(a);

    }

    private void wrong() {
        int maxtries = 6;
        int currentry = 0;
        currentry += 1;
        int lives = maxtries - currentry;
        if (lives == 6) {
            rl.setBackgroundResource(R.drawable.hangman6);
        }
        if (lives == 5) {
            rl.setBackgroundResource(R.drawable.hangman5);
        }
        if (lives == 4) {
            rl.setBackgroundResource(R.drawable.hangman4);
        }
        if (lives == 3) {
            rl.setBackgroundResource(R.drawable.hangman3);
        }
        if (lives == 2) {
            rl.setBackgroundResource(R.drawable.hangman2);
        }
        if (lives == 1) {
            rl.setBackgroundResource(R.drawable.hangman1);
        }
        if (lives == 0) {
            rl.setBackgroundResource(R.drawable.hangman0);
            Toast toast = Toast.makeText(getApplicationContext(), "You have lost :(", Toast.LENGTH_LONG);
            toast.show();

        }
    }
}
