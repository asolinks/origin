package CardGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class InitialisationTest {
	
	private JFrame frame;
	private JPanel cardPanel;
	private JLabel userCardStockLabel;
	private JLabel userCardStock;
	private JLabel computerCardStockLabel;
	private JLabel computerCardStock;
	private JLabel userPlayHand;
	private JLabel computerPlayHand;
	private JLabel resultLabel;
	private JLabel meme;
	private ImageIcon imageIconStock;
	private ImageIcon imageIconSmiley;
	private ImageIcon imageIconFrown;
	private ImageIcon imageIconCat;
	
    private List<String> cardDeck;
    private List<String> computerHand;
    private List<String> userHand;
	
	
    //Constructor to initialize the deck of cards
    public InitialisationTest() {
    	
       //cardDeck with 52 variable names
       cardDeck = generateCardDeck1(); 
        
       //cardDeck is shuffled
       Collections.shuffle(cardDeck); 
        
       //computer assigned own cards
       computerHand = new ArrayList<>(cardDeck.subList(0, 26)); 
        
       //User assigned own cards
       userHand = new ArrayList<>(cardDeck.subList(26, 52)); 
       
      //This assigns the user card variables to the GUI variable to match the card names
      assignToGUI(); 
    }

	
	
	
    //Generates 52 cards
    private List<String> generateCardDeck1() {
        List<String> cardDeck = new ArrayList<>();
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cardDeck.add(rank + " " + suit);
            }
        }
        return cardDeck;
    }
    
    private void assignToGUI() {
        frame = new JFrame("Card Game");
        frame.setSize(500, 570);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardPanel = new JPanel();
		cardPanel.setLayout(null);
		frame.add(cardPanel);
		
		imageIconStock = new ImageIcon("C:\\Users\\user\\git\\repositoryHello\\TestGitProject\\src\\CardGame\\images\\back.png");
		
        int targetWidthStock = 150;
        int targetHeightStock = 200;
        Image resizedCardImageStock = imageIconStock.getImage().getScaledInstance(targetWidthStock, targetHeightStock, Image.SCALE_SMOOTH);
        ImageIcon resizedIconStock = new ImageIcon(resizedCardImageStock);
 
        
		userCardStockLabel = new JLabel("User Card", JLabel.CENTER);
		userCardStock = new JLabel();
		computerCardStockLabel = new JLabel("Computer Card", JLabel.CENTER);
		computerCardStock = new JLabel();
		userPlayHand = new JLabel();
		computerPlayHand = new JLabel();
		resultLabel = new JLabel("Welcome to a Classic War Card Game, Click Play to Start", JLabel.CENTER);
		meme = new JLabel();
		
		userCardStock.setIcon(resizedIconStock);
		computerCardStock.setIcon(resizedIconStock);
		
        //Memes
		imageIconSmiley = new ImageIcon("C:\\Users\\user\\git\\repositoryHello\\TestGitProject\\src\\CardGame\\images\\smiley.png");
		imageIconFrown = new ImageIcon("C:\\Users\\user\\git\\repositoryHello\\TestGitProject\\src\\CardGame\\images\\frowny.png");
		imageIconCat = new ImageIcon("C:\\Users\\user\\git\\repositoryHello\\TestGitProject\\src\\CardGame\\images\\catGraduate.jpg");
        
		int targetWidthMeme = 80;
        int targetHeightMeme = 80;
        Image resizedCardImageSmiley = imageIconSmiley.getImage().getScaledInstance(targetWidthMeme, targetHeightMeme, Image.SCALE_SMOOTH);
        ImageIcon resizedIconSmiley = new ImageIcon(resizedCardImageSmiley);
        
        Image resizedCardImageFrown = imageIconFrown.getImage().getScaledInstance(targetWidthMeme, targetHeightMeme, Image.SCALE_SMOOTH);
        ImageIcon resizedIconFrown = new ImageIcon(resizedCardImageFrown);
        
        Image resizedCardImageCat = imageIconCat.getImage().getScaledInstance(targetWidthMeme, targetHeightMeme, Image.SCALE_SMOOTH);
        ImageIcon resizedIconCat = new ImageIcon(resizedCardImageCat);
        meme.setIcon(resizedIconCat);
        
		
        //Play button
		JButton play = new JButton("Play");
		play.setBorder(null);
		play.setBounds(50, 500, 150, 20);
		play.setFont(new Font("Arial", Font.BOLD, 15));
		play.setBackground(cardPanel.getBackground());
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
		JLabel userPlayHand = new JLabel();
		JLabel computerPlayHand = new JLabel();
				
				playNextCard();
				
				String resultLabelText = resultLabel.getText().toLowerCase().trim();
				if (resultLabelText.contains("user wins this round!") || resultLabelText.contains("game over! user wins!")) {
					meme.setIcon(resizedIconSmiley);
				} else {
					meme.setIcon(resizedIconFrown);
				}
			}
		});
		
		Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
		
		userCardStockLabel.setBounds(50, 10, 150, 20);
		userCardStock.setBounds(50, 35, 150, 200);
		userPlayHand.setBounds(50, 245, 150, 200);
		computerCardStockLabel.setBounds(300, 10, 150, 20);
		computerCardStock.setBounds(300, 35, 150, 200);
		computerPlayHand.setBounds(300, 245, 150, 200);
		meme.setBounds(210, 200, 80, 80);
		resultLabel.setBounds(50, 455, 400, 40);
		
		
		userCardStockLabel.setFont(new Font("Arial", Font.BOLD, 14));
		computerCardStockLabel.setFont(new Font("Arial", Font.BOLD, 14));
				
		userCardStockLabel.setBorder(border);
		userCardStock.setBorder(border);
		userPlayHand.setBorder(border);
		computerCardStockLabel.setBorder(border);
		computerCardStock.setBorder(border);
		computerPlayHand.setBorder(border);
		resultLabel.setBorder(border);
		meme.setBorder(border);
		
		
		cardPanel.add(userCardStockLabel);
		cardPanel.add(userCardStock);
		cardPanel.add(userPlayHand);
		cardPanel.add(computerCardStockLabel);
		cardPanel.add(computerCardStock);
		cardPanel.add(computerPlayHand);
		cardPanel.add(resultLabel);
		cardPanel.add(meme);
		cardPanel.add(play);

		frame.setVisible(true);

    }
    
    void playNextCard() {
        if (!userHand.isEmpty() && !computerHand.isEmpty()) {
            String userCard = userHand.remove(0);
            String computerCard = computerHand.remove(0);

            ImageIcon userCardImage = new ImageIcon("C:/Users/user/git/repositoryHello/TestGitProject/src/CardGame/images/" + userCard + ".png");
            ImageIcon computerCardImage = new ImageIcon("C:/Users/user/git/repositoryHello/TestGitProject/src/CardGame/images/" + computerCard + ".png");

            Image resizedUserCardImage = userCardImage.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
            Image resizedComputerCardImage = computerCardImage.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);

            // Update the card labels with the new card images...
            userPlayHand.setIcon(new ImageIcon(resizedUserCardImage));
            computerPlayHand.setIcon(new ImageIcon(resizedComputerCardImage));
            

            int userCardValue = getCardValue(userCard);
            int computerCardValue = getCardValue(computerCard);

            //resultLabel.setText("User Play Hand: " + userCard + "Computer Play Hand: " + computerCard);
           
            String roundResult;
            if (userCardValue > computerCardValue) {
            	userHand.add(userCard);
            	userHand.add(computerCard);
                roundResult = "User wins this round!";
                
            } else if (userCardValue < computerCardValue) {
            	computerHand.add(computerCard);
            	computerHand.add(userCard);
                roundResult = "Computer wins this round!";
                
            } else {
                roundResult = "It's a tie!";
                
            }
            resultLabel.setText(roundResult);

            if (userHand.isEmpty() || computerHand.isEmpty()) {
                String winner = userHand.isEmpty() ? "Computer" : "User";
                resultLabel.setText("Game over! " + winner + " wins!");
                                
            }
            
            if(userHand.isEmpty()) {
            	userPlayHand.setIcon(null);
            	userCardStock.setIcon(null);
            } else if (computerHand.isEmpty()){
            	computerPlayHand.setIcon(null);
            	computerCardStock.setIcon(null);
            }		
    		

            cardPanel.repaint();
        }
    }

    int getCardValue(String card) {
        String[] parts = card.split(" ");
        
        if (parts.length != 2) {
            return 0; // Invalid card format
        }
        
        String rank = parts[0];
        String suit = parts[1];
        
        int rankValue;
        switch (rank) {
            case "2": rankValue = 2; break;
            case "3": rankValue = 3; break;
            case "4": rankValue = 4; break;
            case "5": rankValue = 5; break;
            case "6": rankValue = 6; break;
            case "7": rankValue = 7; break;
            case "8": rankValue = 8; break;
            case "9": rankValue = 9; break;
            case "10": rankValue = 10; break;
            case "Jack": rankValue = 11; break;
            case "Queen": rankValue = 12; break;
            case "King": rankValue = 13; break;
            case "Ace": rankValue = 14; break;
            default: rankValue = 0; break; // Invalid rank
        }
        
        int suitValue;
        switch (suit) {
            case "Hearts": suitValue = 1; break;
            case "Diamonds": suitValue = 2; break;
            case "Clubs": suitValue = 3; break;
            case "Spades": suitValue = 4; break;
            default: suitValue = 0; break; // Invalid suit
        }
        
        if (rankValue == 0 || suitValue == 0) {
            return 0; // Invalid rank or suit
        }
        
        return rankValue + suitValue;
    }


 
}
