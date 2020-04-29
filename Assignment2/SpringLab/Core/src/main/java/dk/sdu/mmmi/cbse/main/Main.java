package dk.sdu.mmmi.cbse.main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Main {

    public static void main(String[] args) {
        
        ApplicationContext gamecontext = new ClassPathXmlApplicationContext("CoreBean.xml");
        Game game = gamecontext.getBean("game", Game.class );

        LwjglApplicationConfiguration cfg
                = new LwjglApplicationConfiguration();
        cfg.title = "Asteroids";
        cfg.width = 500;
        cfg.height = 400;
        cfg.useGL30 = false;
        cfg.resizable = false;

        new LwjglApplication(game, cfg);

    }

}
