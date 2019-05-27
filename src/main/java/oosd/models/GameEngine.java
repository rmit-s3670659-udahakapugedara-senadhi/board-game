package oosd.models;
import oosd.helpers.HistoryManager;
import oosd.helpers.Movement;
import oosd.helpers.UndoContainer;
import oosd.models.board.Board;
import oosd.models.board.Piece;
import oosd.models.player.Player;
import oosd.models.units.Unit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static oosd.helpers.ListHelper.isNotEmpty;

/**
 * 
 * The Originator of Momento Command Design Pattern
 */

// TODO: Convert this to C4J
public class GameEngine {
    private Board board;
    private Piece selectedPiece;
    private Player turn;
    private List<Player> players;
    private Iterator<Player> playersIterator;
    private HistoryManager historyManager;

    public GameEngine(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        this.historyManager = new HistoryManager();

        // Whoever we add to the players list, the first one takes the turn
        if (isNotEmpty(players)) {
            this.playersIterator = players.listIterator();
            this.turn = playersIterator.next();
        }
    }

    /**
     * Get the game board.
     *
     * @return board that contains the game
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * Get the selected piece user clicks.
     *
     * @return selected piece
     */
    public Piece getSelectedPiece() {
        return selectedPiece;
    }

    /**
     * Set the selected piece on in the game.
     *
     * @param selectedPiece selected piece
     */
    public void setSelectedPiece(Piece selectedPiece) {
        this.selectedPiece = selectedPiece;
    }

    /**
     * Get the players in the game.
     *
     * @return list of players in the game
     */
    public List<Player> getPlayers() {
        return this.players;
    }

    /**
     * Get the turn of the game.
     *
     * @return a player in the turn
     */
    public Player getTurn() {
        return this.turn;
    }

    /**
     * Get the next turn by going through the list sequentially.
     *
     * @return player in the turn
     */
    public Player getNextTurn() {
        if (!playersIterator.hasNext()) {
            playersIterator = players.listIterator();
        }

        turn = playersIterator.next();

        return turn;
    }

    public void updateDefendPieces() {
        board.apply((column, row) -> {
            Unit unit = board.getPiece(column, row).getUnit();

            if (unit != null && unit.getDefendStatus()) {
                unit.decrementDefendCount();
            }
        });
    }
    
    /**
     * Fetch data from 
     * Set both players to previous positions
     * @return 
     */
    public UndoContainer undoLastMove() {        
        return this.historyManager.undoLast();
        
    }
    
    public void storeMove(Player player, Unit unit,Piece piece) {  	
        this.historyManager.store(new Movement(player,unit,piece));
    }
     
}
