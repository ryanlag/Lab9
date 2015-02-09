 import java.util.List; 
 import java.util.ArrayList; 
 
 
 /** 
  * The ElevensBoard class represents the board in a game of Elevens. 
  */ 
 public class ElevensBoard extends Board { 
 
 
 	/** 
 	 * The size (number of cards) on the board. 
 	 */ 
 	private static final int BOARD_SIZE = 9; 
 
 
 	/** 
 	 * The ranks of the cards for this game to be sent to the deck. 
 	 */ 
 	private static final String[] RANKS = 
 		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"}; 
 
 
 	/** 
 	 * The suits of the cards for this game to be sent to the deck. 
 	 */ 
 	private static final String[] SUITS = 
 		{"spades", "hearts", "diamonds", "clubs"}; 
 
 
 	/** 
 	 * The values of the cards for this game to be sent to the deck. 
 	 */ 
 	private static final int[] POINT_VALUES = 
 		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 1000, 10000}; 
 
 
 	/** 
 	 * Flag used to control debugging print statements. 
 	 */ 
 	private static final boolean I_AM_DEBUGGING = false; 
 
 
 
 
 	/** 
 	 * Creates a new <code>ElevensBoard</code> instance. 
 	 */ 
 	 public ElevensBoard() { 
 	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES); 
 	 } 
 
 	/** 
 	 * Determines if the selected cards form a valid group for removal. 
 	 * In Elevens, the legal groups are (1) a pair of non-face cards 
 	 * whose values add to 11, and (2) a group of three cards consisting of 
 	 * a jack, a queen, and a king in some order. 
 	 * @param selectedCards the list of the indices of the selected cards. 
 	 * @return true if the selected cards form a valid group for removal; 
 	 *         false otherwise. 
 	 */ 
 	@Override 
 	public boolean isLegal(List<Integer> selectedCards) { 
 		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */ 
 		if (containsPairSum11(selectedCards) == true) 
 			return true; 
 		if (containsJQK(selectedCards) == true) 
 			return true; 
 		return false; 
 	} 
 	 
 
 
 	/** 
 	 * Determine if there are any legal plays left on the board. 
 	 * In Elevens, there is a legal play if the board contains 
 	 * (1) a pair of non-face cards whose values add to 11, or (2) a group 
 	 * of three cards consisting of a jack, a queen, and a king in some order. 
 	 * @return true if there is a legal play left on the board; 
 	 *         false otherwise. 
 	 */ 
 	@Override 
 	public boolean anotherPlayIsPossible() { 
 		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */ 
 		//The cards on the board are in the front of the cards Array list, taking up spaces 0 - 8 
 		if((containsJQKBoard(getCards())) || (containsSum11Board(getCards()))) { 
 			return true; 
 		} 
 		return false; 
 	} 
 
 
 	/** 
 	 * Check for an 11-pair in the selected cards. 
 	 * @param selectedCards selects a subset of this board.  It is list 
 	 *                      of indexes into this board that are searched 
 	 *                      to find an 11-pair. 
 	 * @return true if the board entries in selectedCards 
 	 *              contain an 11-pair; false otherwise. 
 	 */ 
 	 
 	private boolean containsPairSum11(List<Integer> selectedCards) { 
 		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */ 
 		 
 		if (selectedCards.size() == 2) { 
 			if (cardAt(selectedCards.get(0)).pointValue() + cardAt(selectedCards.get(1)).pointValue() == 11) { 
 				return true; 
 			} 
 		} 
 		return false; 
 	} 
 
 
 	/** 
 	 * Check for a JQK in the selected cards. 
 	 * @param selectedCards selects a subset of this board.  It is list 
 	 *                      of indexes into this board that are searched 
 	 *                      to find a JQK group. 
 	 * @return true if the board entries in selectedCards 
 	 *              include a jack, a queen, and a king; false otherwise. 
 	 */ 
 	private boolean containsJQK(List<Integer> selectedCards) { 
 		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */ 
 		 
 		int temp1 = selectedCards.get(0); 
 		int temp2 = selectedCards.get(1); 
 		int temp3 = selectedCards.get(2); 
 		 
 		if (selectedCards.size() == 3) { 
 				if ( cardAt(temp1).pointValue() + cardAt(temp2).pointValue() + cardAt(temp3).pointValue() == 11100) { 
 					return true; 
 				} 
 			} 
 		return false; 
 	} 
 	private	boolean containsJQKBoard(ArrayList<Card> arrayList) { 
 		 
 		for(int k = 0; k < 9; k++) { 
 			for (int m = 0; m < 7; m++) 
 				if (cardAt(k).pointValue() + cardAt(m).pointValue() + cardAt(m + 1).pointValue() == 11100) { 
 					return true; 
 				} else { 
 			return false; 
 			/*if (cardAt(k).pointValue() + cardAt(0).pointValue() + cardAt(1).pointValue() == 11100) { 
 				return true; 
 			}if (cardAt(k).pointValue() + cardAt(1).pointValue() + cardAt(2).pointValue() == 11100) { 
 				return true; 
 			}if (cardAt(k).pointValue() + cardAt(2).pointValue() + cardAt(3).pointValue() == 11100) { 
 				return true; 
 			}if (cardAt(k).pointValue() + cardAt(3).pointValue() + cardAt(4).pointValue() == 11100) { 
 				return true; 
 			}if (cardAt(k).pointValue() + cardAt(4).pointValue() + cardAt(5).pointValue() == 11100) { 
 				return true; 
 			}if (cardAt(k).pointValue() + cardAt(5).pointValue() + cardAt(6).pointValue() == 11100) { 
 				return true; 
 			}if (cardAt(k).pointValue() + cardAt(6).pointValue() + cardAt(7).pointValue() == 11100) { 
 				return true; 
 			}if (cardAt(k).pointValue() + cardAt(7).pointValue() + cardAt(8).pointValue() == 11100) { 
 				return true; 
 				 
 			}else { 
 				return false; 
 			}*/ 
 				}	 
 		} 
 		return false; 
 	} 
 	private	boolean containsSum11Board(ArrayList<Card> arrayList) { 
 		 
 		for(int k = 0; k < 9; k++) { 
 			for(int m = 0; m < 9; m++){  
 				if (cardAt(k).pointValue() + cardAt(m).pointValue() == 11) { 
 					return true; 
				} 
 			} 
 			 
 		} 
 		return false; 
 	} 
 }  
