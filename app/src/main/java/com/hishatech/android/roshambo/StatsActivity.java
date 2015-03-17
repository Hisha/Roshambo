package com.hishatech.android.roshambo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class StatsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        // Access various widgets in Application.
        TextView txtTotalGames = (TextView) findViewById(R.id.txtTotalGames);
        TextView txtTotalLosses = (TextView) findViewById(R.id.txtTotalLosses);
        TextView txtTotalTies = (TextView) findViewById(R.id.txtTotalTies);
        TextView txtTotalWins = (TextView) findViewById(R.id.txtTotalWins);

        SharedPreferences prefs = getSharedPreferences(Utils.pref_name, 0);

        txtTotalGames.setText(getResources().getString(R.string
                .totalGames) + prefs.getInt(Utils.GamesPlayed_Key,
                Utils.GamesDefault));

        txtTotalLosses.setText(getResources().getString(R.string
                .totalLosses) + prefs.getInt(Utils.GamesLost_Key,
                Utils.GamesDefault));

        txtTotalTies.setText(getResources().getString(R.string
                .totalTies) + prefs.getInt(Utils.GamesTied_Key,
                Utils.GamesDefault));

        txtTotalWins.setText(getResources().getString(R.string
                .totalWins) + prefs.getInt(Utils.GamesWon_Key,
                Utils.GamesDefault));

    }

}
