package com.example.myapplication;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Game implements Serializable {

    private static List<Questions> allQuestions;

    private Game() {

    }

    public static List<Questions> getAllQuestions(){
        if( allQuestions == null) {
            init();
        }

        return allQuestions;
    }

    private static void init(){

        List<String> choicesQ1 = Arrays.asList("SpiderMan 2", "Alan Wake 2", "Baldur's Gate 3", "Zelda TotK");
        Questions question1 = new Questions("Quel jeu a gagné le Game Award du G.O.T.Y (Game Of The Year) en 2023", choicesQ1, "Baldur's Gate 3");

        List<String> choicesQ2 = Arrays.asList("World of Warcraft", "Dofus", "Mass Effect", "Final Fantasy XIV");
        Questions question2 = new Questions("Lequel de ces jeux n'est pas un MMO", choicesQ2, "Mass Effect");

        List<String> choicesQ3 = Arrays.asList("Dragon Quest", "Final Fantasy", "Metal Gear", "Resident Evil");
        Questions question3 = new Questions("Dans quelle licence de jeu japonaise retouve t-on toujours un personnage appelé Cid et des Chokobos ?", choicesQ3, "Final Fantasy");

        List<String> choicesQ4 = Arrays.asList("God of War", "Red Dead Redemption", "Assassin's Creed", "The Last of Us");
        Questions question4 = new Questions("Dans quelle serie de jeu inspiré de l'histoire joue t-on un hero qui doit dejouer les Templiers ?", choicesQ4, "Assassin's Creed");

        List<String> choicesQ5 = Arrays.asList("2023", "2024", "2025", "2026");
        Questions question5 = new Questions("En quelle année sortira le prochain Grand Theft Auto ? (GTAVI)", choicesQ5, "2025");

        List<String> choicesQ6 = Arrays.asList("Apex Legends", "Valorant", "Counter Strike", "Overwatch");
        Questions question6 = new Questions("Comment s'appelle le FPS du studio américain BLIZZARD ?", choicesQ6, "Overwatch");

        List<String> choicesQ7 = Arrays.asList("Fortiche Studio", "Arkane", "Ubisoft", "CD Projekt RED");
        Questions question7 = new Questions("Comment s'appelle le studio qui a développé The Witcher et Cyberpunk 2077 ?", choicesQ7, "CD Projekt RED");

        List<String> choicesQ8 = Arrays.asList("Sekiro", "Bloodborne", "Elden Ring", "Demon's Soul");
        Questions question8 = new Questions("Lequel de ces jeux fromsoftware est sorti en dernier ?", choicesQ8, "Elden Ring");

        List<String> choicesQ9 = Arrays.asList("1953", "1958", "1963", "1968");
        Questions question9 = new Questions("En quelle année le tout premier jeu vidéo (Pong) a t'il été créer ?", choicesQ9, "1958");

        List<String> choiceQ10 = Arrays.asList("Die & Retry", "Roguelite", "FPS", "Plateformer");
        Questions question10 = new Questions("Quel est le type de jeu de Hades, développé par SuperGiant Games ?", choiceQ10, "Roguelite");

        allQuestions = new ArrayList<>();
        allQuestions.add(question1);
        allQuestions.add(question2);
        allQuestions.add(question3);
        allQuestions.add(question4);
        allQuestions.add(question5);
        allQuestions.add(question6);
        allQuestions.add(question7);
        allQuestions.add(question8);
        allQuestions.add(question9);
        allQuestions.add(question10);
    }

    public static List<Questions> getSelectedQuestions(int nbrQuestions) {
        List<Questions> selectedQuestions = new ArrayList<>();
        Random random = new Random();
        List<Questions> allQuestions = getAllQuestions();
        while (selectedQuestions.size() < nbrQuestions) {
            int randomIndex = random.nextInt(allQuestions.size());
            Questions randomQuestion = allQuestions.get(randomIndex);

            if (!selectedQuestions.contains(randomQuestion)) {
                selectedQuestions.add(randomQuestion);
            }
        }
        return selectedQuestions;
    }
}