package com.rnyathi.letitgo.Views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.rnyathi.letitgo.Main;
import com.rnyathi.letitgo.Scenes.Hud;

public class GameOverScreen implements Screen {
    private Viewport viewport;
    private Stage stage;

    private Main parent;
    private String time;
    private String score;
    private int level;
    public GameOverScreen(Main main, String score, String time, int level){

        parent = main;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        this.score = score;
        this.time = time;
        this.level = level;
    }

    @Override
    public void show() {


        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        Table table = new Table();
        table.center();
        table.setFillParent(true);

        Skin skin = new Skin(Gdx.files.internal("Skins/glassy-ui.json"));
        Label gameOverLabel = new Label("Game Over", font);
        Label scoreLabel = new Label(score, font);
        Label timeLabel = new Label(time, font);
        Label score = new Label("Score", font);
        Label time = new Label("Time", font);
        TextButton startAgain = new TextButton("Start Again", skin, "small");
        TextButton mainMenu = new TextButton("Main Menu", skin, "small");
        //changes level
        if(level == 1){
            startAgain.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    parent.changeScreen(Main.LEVELONE);
                }
            });
        } else if(level == 2){
            startAgain.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    parent.changeScreen(Main.LEVELTWO);
                }
            });
        } else if(level == 3){
            startAgain.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    parent.changeScreen(Main.LEVELTHREE);
                }
            });
        }

        mainMenu.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                parent.changeScreen(Main.MENU);
            }
        });
        //table
        table.add();
        table.add(gameOverLabel);
        table.add();
        table.row();

        table.add(time);
        table.add();
        table.add(score);
        table.row();


        table.add(scoreLabel);
        table.add();
        table.add(timeLabel);

        table.row();
        table.add(startAgain);
        table.add();
        table.add(mainMenu);
        stage.addActor(table);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height,true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
