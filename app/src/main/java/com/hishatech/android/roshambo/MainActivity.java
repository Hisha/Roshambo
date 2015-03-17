package com.hishatech.android.roshambo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    Button btnPaper, btnPlayAgain, btnRock, btnScissor;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    TextView txtGameStatus, txtPlayAgain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences(Utils.pref_name, 0);
        editor = prefs.edit();

        //region * * UI setup * *

        btnPaper = (Button) findViewById(R.id.btnPaper);
        btnPlayAgain = (Button) findViewById(R.id.btnPlayAgain);
        btnRock = (Button) findViewById(R.id.btnRock);
        btnScissor = (Button) findViewById(R.id.btnScissor);
        txtGameStatus = (TextView) findViewById(R.id.txtGameStatus);
        txtPlayAgain = (TextView) findViewById(R.id.txtPlayAgain);

        //endregion

        //region * * Button ClickListeners * *

        btnPaper.setOnClickListener(mClickListener);
        btnPlayAgain.setOnClickListener(mClickListener);
        btnRock.setOnClickListener(mClickListener);
        btnScissor.setOnClickListener(mClickListener);

        //endregion

        hideAll();

        showStartup();

    }

    //region ** Button Click Listener Code **
    private View.OnClickListener mClickListener = new View.OnClickListener() {

        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.btnPaper:
                    compareChoice(Utils.Paper_ID);
                    break;

                case R.id.btnRock:
                    compareChoice(Utils.Rock_ID);
                    break;

                case R.id.btnScissor:
                    compareChoice(Utils.Scissor_ID);
                    break;

                case R.id.btnPlayAgain:
                    finish();
                    startActivity(getIntent());
                    break;

            }

        }

    };
    //endregion

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.About:

                Intent Aboutintent = new Intent(this, AboutActivity.class);
                this.startActivity(Aboutintent);
                break;

            case R.id.Stats:

                Intent Statsintent = new Intent(this, StatsActivity.class);
                this.startActivity(Statsintent);
                break;

        }

        return false; // should never happen

    }

    private void hideAll() {

        btnPaper.setVisibility(View.GONE);
        btnPlayAgain.setVisibility(View.GONE);
        btnRock.setVisibility(View.GONE);
        btnScissor.setVisibility(View.GONE);
        txtGameStatus.setVisibility(View.GONE);
        txtPlayAgain.setVisibility(View.GONE);

    }

    private void showStartup() {

        btnPaper.setVisibility(View.VISIBLE);
        btnRock.setVisibility(View.VISIBLE);
        btnScissor.setVisibility(View.VISIBLE);

    }

    private void showPlayAgain() {

        btnPlayAgain.setVisibility(View.VISIBLE);
        txtGameStatus.setVisibility(View.VISIBLE);
        txtPlayAgain.setVisibility(View.VISIBLE);

    }

    private void gamePlayed() {

        Integer GamesPlayed = prefs.getInt(Utils.GamesPlayed_Key,
                Utils.GamesDefault);

        editor.putInt(Utils.GamesPlayed_Key, GamesPlayed + 1);
        editor.commit();

    }

    private void gameLost(Integer aiChoice, Integer userChoice) {

        String gameStatus = "";
        Integer GamesLost = prefs.getInt(Utils.GamesLost_Key,
                Utils.GamesDefault);

        editor.putInt(Utils.GamesLost_Key, GamesLost + 1);
        editor.commit();

        if (aiChoice.equals(1)) {
            gameStatus = getResources().getString(R.string
                    .paper) + getResources().getString(R.string
                    .beats);
        } else if (aiChoice.equals(2)) {
            gameStatus = getResources().getString(R.string
                    .rock) + getResources().getString(R.string
                    .beats);
        } else if (aiChoice.equals(3)) {
            gameStatus = getResources().getString(R.string
                    .scissor) + getResources().getString(R.string
                    .beats);
        }

        if (userChoice.equals(1)) {
            gameStatus = gameStatus + getResources().getString(R.string
                    .paper);
        }
        if (userChoice.equals(2)) {
            gameStatus = gameStatus + getResources().getString(R.string
                    .rock);
        }
        if (userChoice.equals(3)) {
            gameStatus = gameStatus + getResources().getString(R.string
                    .scissor);
        }

        txtGameStatus.setText(gameStatus);

        txtPlayAgain.setText(getResources().getString(R.string
                .txtPlayAgain_Lose));

    }

    private void gameTied(Integer aiChoice, Integer userChoice) {

        String gameStatus = "";
        Integer GamesTied = prefs.getInt(Utils.GamesTied_Key,
                Utils.GamesDefault);

        editor.putInt(Utils.GamesTied_Key, GamesTied + 1);
        editor.commit();

        if (aiChoice.equals(1)) {
            gameStatus = getResources().getString(R.string
                    .paper) + getResources().getString(R.string
                    .ties);
        } else if (aiChoice.equals(2)) {
            gameStatus = getResources().getString(R.string
                    .rock) + getResources().getString(R.string
                    .ties);
        } else if (aiChoice.equals(3)) {
            gameStatus = getResources().getString(R.string
                    .scissor) + getResources().getString(R.string
                    .ties);
        }

        if (userChoice.equals(1)) {
            gameStatus = gameStatus + getResources().getString(R.string
                    .paper);
        }
        if (userChoice.equals(2)) {
            gameStatus = gameStatus + getResources().getString(R.string
                    .rock);
        }
        if (userChoice.equals(3)) {
            gameStatus = gameStatus + getResources().getString(R.string
                    .scissor);
        }

        txtGameStatus.setText(gameStatus);

        txtPlayAgain.setText(getResources().getString(R.string
                .txtPlayAgain_Tie));

    }

    private void gameWon(Integer aiChoice, Integer userChoice) {

        String gameStatus = "";
        Integer GamesWon = prefs.getInt(Utils.GamesWon_Key,
                Utils.GamesDefault);

        editor.putInt(Utils.GamesWon_Key, GamesWon + 1);
        editor.commit();

        if (aiChoice.equals(1)) {
            gameStatus = getResources().getString(R.string
                    .paper) + getResources().getString(R.string
                    .losesTo);
        } else if (aiChoice.equals(2)) {
            gameStatus = getResources().getString(R.string
                    .rock) + getResources().getString(R.string
                    .losesTo);
        } else if (aiChoice.equals(3)) {
            gameStatus = getResources().getString(R.string
                    .scissor) + getResources().getString(R.string
                    .losesTo);
        }

        if (userChoice.equals(1)) {
            gameStatus = gameStatus + getResources().getString(R.string
                    .paper);
        }
        if (userChoice.equals(2)) {
            gameStatus = gameStatus + getResources().getString(R.string
                    .rock);
        }
        if (userChoice.equals(3)) {
            gameStatus = gameStatus + getResources().getString(R.string
                    .scissor);
        }

        txtGameStatus.setText(gameStatus);

        txtPlayAgain.setText(getResources().getString(R.string
                .txtPlayAgain_Win));

    }

    private void compareChoice(Integer UserChoice) {

        Integer aiChoice = Utils.AIChoice();

        gamePlayed();

        if (aiChoice.equals(UserChoice)) {

            //Tie

            gameTied(aiChoice, UserChoice);

            showPlayAgain();

        } else if (aiChoice.equals(Utils.Paper_ID) && UserChoice.equals(Utils
                .Rock_ID) || aiChoice.equals(Utils.Rock_ID) && UserChoice.equals
                (Utils
                        .Scissor_ID) || aiChoice.equals(Utils.Scissor_ID) &&
                UserChoice
                        .equals(Utils
                                .Paper_ID)) {

            //AI Wins

            gameLost(aiChoice, UserChoice);

            showPlayAgain();

        } else if (aiChoice.equals(Utils.Rock_ID) && UserChoice.equals(Utils
                .Paper_ID) || aiChoice.equals(Utils.Scissor_ID) && UserChoice
                .equals
                        (Utils
                                .Rock_ID) || aiChoice.equals(Utils.Paper_ID) &&
                UserChoice
                        .equals(Utils
                                .Scissor_ID)) {

            //User Wins

            gameWon(aiChoice, UserChoice);

            showPlayAgain();

        }

    }

}
