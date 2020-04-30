/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmi.cbse.playersystemtest;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.playersystem.Player;
import dk.sdu.mmmi.cbse.playersystem.PlayerPlugin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author John
 */
public class PlayerPluginTest {
    
        GameData gameData;
        World world;
        PlayerPlugin playerPlugin;
    
    public PlayerPluginTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        gameData = new GameData();
        world = new World();
        playerPlugin = new PlayerPlugin();
    }
    
    @AfterEach
    public void tearDown() {
        gameData = null;
        world = null;
        playerPlugin = null;
    }

        @Test
    public void start_AddingPlayer_True() {
                
        assert(world.getEntities(Player.class).isEmpty()); // Asserts that there are no players
        
        playerPlugin.start(gameData, world); // Creates and adds a player
             
        assert(world.getEntities(Player.class) != null); // Asserts that worlds entity player collection is not null
        assert(!world.getEntities(Player.class).isEmpty()); // asserts that the player entity collection is not empty
    }
    
    @Test
    public void stop_RemovingPlayer_True() {
        
        playerPlugin.start(gameData, world); // Creates and adds a player - This is done so there is a player to remove
        
        assert(world.getEntities(Player.class) != null); // Asserts that worlds entity player collection is not null
        assert(!world.getEntities(Player.class).isEmpty()); // Asserts that the player entity collection is not empty
        
        playerPlugin.stop(gameData, world); // Removes the player 
        
        assert(world.getEntities(Player.class).isEmpty()); //Asserts that the added player has been removed
    }
}
