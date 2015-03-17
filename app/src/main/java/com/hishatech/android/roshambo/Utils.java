package com.hishatech.android.roshambo;


import java.util.Random;

public class Utils {

    public static final String pref_name = "shambo_prefs";
    public static final String GamesPlayed_Key = "gamesPlayed";
    public static final String GamesLost_Key = "gamesLost";
    public static final String GamesTied_Key = "gamesTied";
    public static final String GamesWon_Key = "gamesWon";
    public static final Integer GamesDefault = 0;

    public static final Integer Paper_ID = 1;
    public static final int Paper_Image = R.drawable.aipaper;
    public static final Integer Rock_ID = 2;
    public static final int Rock_Image = R.drawable.airock;
    public static final Integer Scissor_ID = 3;
    public static final int Scissor_Image = R.drawable.aiscissor;

    public static Integer AIChoice() {

        int AIChoice = 1;
        Integer rosham;
        Random rng = new Random();
        rosham = rng.nextInt(3) + 1;

        switch (rosham) {
            case 1:

                AIChoice = Paper_ID;
                break;

            case 2:

                AIChoice = Rock_ID;
                break;

            case 3:

                AIChoice = Scissor_ID;
                break;
        }

        return AIChoice;
    }

}
