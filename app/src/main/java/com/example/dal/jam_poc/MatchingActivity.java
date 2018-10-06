package com.example.dal.jam_poc;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class MatchingActivity extends AppCompatActivity {

    ImageView iv_11, iv_12, iv_21, iv_22,iv_31, iv_32, iv_41,iv_42;

    //array for the images
    Integer[] cardsArray = {101, 102, 103, 104, 201, 202, 203, 204,};

    //actual images
    int image101, image102, image103, image104,
            image201, image202, image203, image204;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    int turn = 1;
    int playerPoints = 0, cpuPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iv_11 = (ImageView) findViewById(R.id.iv_11);
        iv_12 = (ImageView) findViewById(R.id.iv_12);
        iv_21 = (ImageView) findViewById(R.id.iv_21);
        iv_22 = (ImageView) findViewById(R.id.iv_22);
        iv_31 = (ImageView) findViewById(R.id.iv_31);
        iv_32 = (ImageView) findViewById(R.id.iv_32);
        iv_41 =(ImageView) findViewById(R.id.iv_41);
        iv_42 = (ImageView) findViewById(R.id.iv_42);

        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_21.setTag("2");
        iv_22.setTag("3");
        iv_31.setTag("4");
        iv_32.setTag("5");
        iv_41.setTag("6");
        iv_42.setTag("7");

        //load the card images
        frontOfCardsResources();

        //shuffle the images
        Collections.shuffle(Arrays.asList(cardsArray));

        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_11, theCard);

            }
        });
        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_12, theCard);

            }
        });

        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_21, theCard);

            }
        });
        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_22, theCard);

            }
        });

        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_31, theCard);


            }
        });
        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_32, theCard);

            }
        });
        iv_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_41, theCard);

            }
        });
        iv_42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_42, theCard);

            }
        });

    }

    private void doStuff(ImageView iv, int card) {
        //set the correct image to the imageView
        if (cardsArray[card] == 101) {
            iv.setImageResource(image101);
        } else if (cardsArray[card] == 102) {
            iv.setImageResource(image102);
        } else if (cardsArray[card] == 103) {
            iv.setImageResource(image103);
        } else if (cardsArray[card] == 104) {
            iv.setImageResource(image104);

        } else if (cardsArray[card] == 201) {
            iv.setImageResource(image201);
        } else if (cardsArray[card] == 202) {
            iv.setImageResource(image202);
        } else if (cardsArray[card] == 203) {
            iv.setImageResource(image203);
        } else if (cardsArray[card] == 204) {
            iv.setImageResource(image204);

        }

        //check which image is selected and save it to temporary variable
        if (cardNumber == 1) {
            firstCard = cardsArray[card];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = cardsArray[card];
            if (secondCard > 200) {
                secondCard = firstCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_41.setEnabled(false);
            iv_42.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //check if the selected images are equal
                    calculate();
                }
            },1000);
        }
    }
    private void calculate() {
        //if images are equal remove then add points
        if (firstCard == secondCard) {
            if (clickedFirst == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                iv_42.setVisibility(View.INVISIBLE);
            }
            if (clickedSecond == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                iv_42.setVisibility(View.INVISIBLE);
            }

        } else {
            iv_11.setImageResource(R.drawable.ic_back);
            iv_12.setImageResource(R.drawable.ic_back);
            iv_21.setImageResource(R.drawable.ic_back);
            iv_22.setImageResource(R.drawable.ic_back);
            iv_31.setImageResource(R.drawable.ic_back);
            iv_32.setImageResource(R.drawable.ic_back);
            iv_41.setImageResource(R.drawable.ic_back);
            iv_42.setImageResource(R.drawable.ic_back);

        }

        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_41.setEnabled(true);
        iv_42.setEnabled(true);
        // check if the game is over
        checkEnd();
    }


    private void checkEnd(){


        if (iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&
                iv_31.getVisibility() == View.INVISIBLE &&
                iv_32.getVisibility() == View.INVISIBLE &&
                iv_41.getVisibility() == View.INVISIBLE &&
                iv_42.getVisibility() == View.INVISIBLE) {


            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MatchingActivity.this);
            alertDialogBuilder
                    .setMessage("You Win!\nP1: " + playerPoints + "\nP2: " + cpuPoints)
                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), MatchingActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }


    private void frontOfCardsResources () {
        image101 = R.drawable.ic_image101;
        image102 = R.drawable.ic_image102;
        image103 = R.drawable.ic_image103;
        image104 = R.drawable.ic_image104;
        image201 = R.drawable.ic_image201;
        image202 = R.drawable.ic_image202;
        image203 = R.drawable.ic_image203;
        image204 = R.drawable.ic_image204;

    }
}