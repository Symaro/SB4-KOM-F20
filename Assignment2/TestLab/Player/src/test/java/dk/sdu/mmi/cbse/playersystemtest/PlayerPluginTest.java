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

import org.hamcrest.collection.IsEmptyCollection;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

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
                
        assertThat(world.getEntities(Player.class), IsEmptyCollection.empty()); // Asserts that there are no players
        
        playerPlugin.start(gameData, world);
             
        assertNotNull(world.getEntities(Player.class)); // Asserts that worlds entity player collection is not null
        assertThat(world.getEntities(Player.class), not(IsEmptyCollection.empty())); // asserts that the player entity collection is not empty
    }
    
    @Test
    public Entity createPlayerShip_createPlayer_True() {
        
        //TODO: make test
        
        return new Entity();
    }
    
    @Test
    public void stop_RemovingPlayer_True() {
        
        playerPlugin.start(gameData, world);
        
        assertNotNull(world.getEntities(Player.class)); // Asserts that worlds entity player collection is not null
        assertThat(world.getEntities(Player.class), not(IsEmptyCollection.empty())); // asserts that the player entity collection is not empty
        
        playerPlugin.stop(gameData, world);
        
        assertThat(world.getEntities(Player.class), IsEmptyCollection.empty()); //Asserts that the added player has been removed
    }
}
