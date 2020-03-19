/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.LEFT;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.RIGHT;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.UP;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import java.util.Random;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

/**
 *
 * @author John
 */
@ServiceProviders(value = {
    @ServiceProvider(service = IEntityProcessingService.class),})
public class EnemyControlSystem implements IEntityProcessingService{
    
    Random rnd = new Random(10);

    @Override
    public void process(GameData gameData, World world) {
        for (Entity enemy : world.getEntities(Enemy.class)) {
            PositionPart positionPart = enemy.getPart(PositionPart.class);
            MovingPart movingPart = enemy.getPart(MovingPart.class);
            
            /* Directional Keys
            movingPart.setLeft(gameData.getKeys().isDown(LEFT));
            movingPart.setRight(gameData.getKeys().isDown(RIGHT));
            movingPart.setUp(gameData.getKeys().isDown(UP));
            */
            
            float speed = (float) Math.random() * 10f + 40f;
            if (rnd.nextInt() < 8) {
                movingPart.setMaxSpeed(speed);
                movingPart.setUp(true);
            }
            else {
                movingPart.setRight(true);
            }
            
            movingPart.process(gameData, enemy);
            positionPart.process(gameData, enemy);
            
            updateShape(enemy);
            
            movingPart.setUp(false);
            movingPart.setRight(false);
        }
    }

    private void updateShape(Entity enemy) {
        PositionPart positionPart = enemy.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();
       /*
        //Tie Fighter Shape
        float[] shapex = new float[16];
        float[] shapey = new float[16];
        shapex[0] = (float) (x + Math.cos(radians) * 10);
        shapey[0] = (float) (y + Math.sin(radians) * 10);
        */
        
       
        //Regular Shape
        float[] shapex = enemy.getShapeX();
        float[] shapey = enemy.getShapeY();
        shapex[0] = (float) (x + Math.cos(radians) * 8);
        shapey[0] = (float) (y + Math.sin(radians) * 8);

        shapex[1] = (float) (x + Math.cos(radians - 4 * Math.PI / 5) * 8);
        shapey[1] = (float) (y + Math.sin(radians - 4 * Math.PI / 5) * 8);

        shapex[2] = (float) (x + Math.cos(radians + Math.PI) * 5);
        shapey[2] = (float) (y + Math.sin(radians + Math.PI) * 5);

        shapex[3] = (float) (x + Math.cos(radians + 4 * Math.PI / 5) * 8);
        shapey[3] = (float) (y + Math.sin(radians + 4 * Math.PI / 5) * 8);
        
    }
    
}
