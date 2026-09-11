package com.gamebasic.game.dto;

import com.gamebasic.game.entity.GamePhase;
import com.gamebasic.game.entity.GameStatus;

public class GameSummaryResponse {
    private final Long id;
    private final String playerName;
    private final int currentFloor;
    private final int currentHp;
    private final GamePhase phase;
    private final GameStatus status;

    public GameSummaryResponse(
            Long id,
            String playerName,
            int currentFloor,
            int currentHp,
            GamePhase phase,
            GameStatus status
    ) {
        this.id = id;
        this.playerName = playerName;
        this.currentFloor = currentFloor;
        this.currentHp =currentHp;
        this.phase = phase;
        this.status = status;
    }

    public Long getId() {return  id;}
    public String getPlayerName() { return playerName; }
    public int getCurrentFloor() { return  currentFloor; }
    public int getCurrentHp() { return currentHp; }
    public GamePhase getPhase() { return phase; }
    public GameStatus getStatus() { return status; }
}
