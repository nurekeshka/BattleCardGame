package game.domain.repositories.impl;

import game.domain.enums.CardSuit;
import game.domain.enums.CardValue;
import game.domain.models.Card;
import game.domain.models.Deck;
import game.domain.repositories.CardsRepository;

import java.util.ArrayList;
import java.util.List;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.InputStream;

public class CardsRepositoryImpl implements CardsRepository {

    @Override
    public Card getCard(CardSuit suit, CardValue value) {
        return new Card(suit, value);
    }

    @Override
    public Deck getFullDeck() {
        List<Card> cards = new ArrayList<>();

        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                cards.add(new Card(suit, value));
            }
        }

        return new Deck(cards.toArray(new Card[0]));
    }

    private String getResourcePath(CardSuit suit, CardValue value) {
        return String.format("/images/%s_%s.png", suit.toString().toLowerCase(), value.toString().toLowerCase());
    }

    private Image loadImage(String imagePath) {
        try (InputStream is = getClass().getResourceAsStream(imagePath)) {
            if (is != null) {
                return ImageIO.read(is);
            } else {
                System.err.println("Image not found for path: " + imagePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
