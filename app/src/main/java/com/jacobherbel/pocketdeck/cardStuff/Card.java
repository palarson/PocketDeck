package com.jacobherbel.pocketdeck.cardStuff;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.IOException;

/**
 * Created by jacobherbel on 6/20/17.
 */
public class Card {

    private final Suit suit;
    private final CardValue cardValue;
    private final int imageID;

    public Card(Context context, CardValue cardValue, Suit suit) throws IOException {
        this.cardValue = cardValue;
        this.suit = suit;
        String name = "" + getSuit().getSuitName() + "_" + getCardValue().getValueName();
        imageID = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
    }

    public Suit getSuit() {
        return suit;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public int getImage() {
        return imageID;
    }


}

