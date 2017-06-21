package com.jacobherbel.pocketdeck;

import android.content.res.Resources;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.jacobherbel.pocketdeck.cardStuff.Card;
import com.jacobherbel.pocketdeck.cardStuff.CardDeck;

import java.util.Random;

public class SingleDeviceActivity extends AppCompatActivity {

    private CardDeck cardDeck = new CardDeck();
    private Card[] hand = new Card[5];
    private int cardsInHand = 0;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_device);
    }

    public void getRandomCard(View view) {
        //Random rn = new Random();
        //String pulledCard = cardDeck.cardAt(rn.nextInt(52)).fileName();
        String pulledCard = cardDeck.cardAt(index++).fileName();
        Resources res = getResources();
        int resID = res.getIdentifier(pulledCard, "drawable", getPackageName());
        ImageView card = (ImageView) findViewById(R.id.card1);
        card.setImageResource(resID);

        ImageView topCard = (ImageView) findViewById(R.id.topOfDeck);
        TranslateAnimation moveLefttoRight = new TranslateAnimation(0, 300, 0, 0); // This stuff just slides the card to the right
        moveLefttoRight.setDuration(1000);
        moveLefttoRight.setFillAfter(true);
        card.startAnimation(moveLefttoRight);

    }

    public void addToHand(View view, Card card) {
        if (cardsInHand <= 5) {
            hand[cardsInHand - 1] = card;
        }
        else {
            //TODO add "replace a current card" or "toss" buttons when user hand is full
        }
    }


}