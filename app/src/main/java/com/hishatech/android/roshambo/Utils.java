package com.hishatech.android.roshambo;


import java.util.Random;

public class Utils {

    public static final int Paper_ID = R.drawable.AIPaper;
    public static final int Rock_ID = R.drawable.AIRock;
    public static final int Scissor_ID = R.drawable.AIScissor;

    public static int AIChoice() {

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
