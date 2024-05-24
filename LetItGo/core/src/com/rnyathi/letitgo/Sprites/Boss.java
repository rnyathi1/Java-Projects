package com.rnyathi.letitgo.Sprites;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.rnyathi.letitgo.Main;
import com.rnyathi.letitgo.Scenes.Hud;
import com.rnyathi.letitgo.Views.LevelOneScreen;
import com.rnyathi.letitgo.Views.LevelThreeScreen;
import com.rnyathi.letitgo.Views.LevelTwoScreen;

import static jdk.javadoc.internal.doclets.toolkit.util.DocPath.parent;

public class  Boss extends Enemy{
    private float stateTime;
    private float previousTime;
    private float fireballCount;
    private Animation walkAnimation;
    private Array<TextureRegion> frames;
    private boolean setToDestroy;
    private boolean destroyed;
    Array<Fireball> balls;
    boolean secondPhase;
    boolean beginSecondPhase;

    Main parent = new Main();
    Hud hud;
    Vector2 vector;
    LevelThreeScreen screenThree;
    int lives;
    TextureRegion batImage;
    public Boss(LevelThreeScreen screenThree, float x, float y ) {
        super(screenThree, x, y);
        hud = new Hud(parent.batch);
        this.screenThree = screenThree;

        batImage = new TextureRegion(screenThree.getAtlas().findRegion("bat") , 55,1,42,19);
        setRegion(batImage);
        setBounds(getX(),getY(),70 /Main.PPM,70/Main.PPM);
        defineEnemy();
        this.lives = 3;
        setToDestroy = false;
        destroyed = false;
        previousTime = 0;
        fireballCount = 0;
        secondPhase = false;
        beginSecondPhase = false;
        balls = new Array<Fireball>();





    }
    @Override
    protected void defineEnemy() {

        BodyDef bdef = new BodyDef();
        bdef.position.set(getX(),getY());
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(20 / Main.PPM);
        fdef.filter.categoryBits = Main.BOSS_BIT;
        fdef.filter.maskBits = Main.GROUND_BIT | Main.ENEMY_BOUNDARY_BIT | Main.ENEMY_BIT|Main.COMPLETION_BIT | Main.PLAYER_BIT ;

        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData(this);
        b2body.setGravityScale(1/100);
        b2body.setLinearDamping(3);


        PolygonShape head = new PolygonShape();
        Vector2[] vertice = new Vector2[4];
        vertice[3] = new Vector2(-22, 14).scl(1 / Main.PPM);
        vertice[2] = new Vector2(22, 14).scl(1 / Main.PPM);
        vertice[1] = new Vector2(-16, 25).scl(1 / Main.PPM);
        vertice[0] = new Vector2(16, 25).scl(1 / Main.PPM);
        head.set(vertice);

        fdef.shape = head;
        fdef.restitution = 2f;
        fdef.filter.categoryBits = Main.ENEMY_HEAD_BIT;
        b2body.createFixture(fdef).setUserData(this);
        b2body.setGravityScale(1/100);
        b2body.setLinearDamping(3);
    }

    @Override
    public void hitOnHead() {
        hud.addScore(500 * Main.difficulty);
        if (screenThree.getX() < b2body.getPosition().x) {
            b2body.applyLinearImpulse(new Vector2(90,-10),new Vector2((float)screenThree.getX(), (float)screenThree.getY()),true);
        } else{
            b2body.applyLinearImpulse(new Vector2(-90,-10),new Vector2((float)screenThree.getX(), (float)screenThree.getY()),true);
        }
        lives -= 1;

        if(lives == 0){
            setToDestroy = true;
        }


    }

    @Override
    public void update(float dt) {
        stateTime += dt;
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);

        if(setToDestroy && !destroyed){
            world.destroyBody(b2body);
            destroyed = true;
        } else if( !destroyed) {
            vector = new Vector2();
            // Switches phases
            if(stateTime - previousTime > 6 / Main.difficulty  && !beginSecondPhase){
                beginSecondPhase = true;
                previousTime = stateTime;
            }

            if(beginSecondPhase){
                abovePlayer();

                if(stateTime - previousTime > 3){
                    beginSecondPhase = false;
                    previousTime = stateTime;
                }
            } else {
                if(setToDestroy && !destroyed){
                    world.destroyBody(b2body);
                    destroyed = true;
                    stateTime = 0;
                } else if(!destroyed){
                    if (b2body.getPosition().x > screenThree.getX()) {
                        vector.x = -1f;
                    } else if (b2body.getPosition().x < screenThree.getX()) {
                        vector.x = 1f;

                    }
                    if (b2body.getPosition().y < screenThree.getY()) {
                        vector.y = 0.45f;
                    } else if (b2body.getPosition().y > screenThree.getY()) {
                        vector.y = -0.45f;
                    }
                    b2body.setLinearVelocity(vector);

                }

            }
            if(beginSecondPhase && stateTime - fireballCount > 2 ){
                shoot();
                fireballCount = stateTime;
            }


        }
        for(Fireball fireball : balls){
            fireball.update(dt);
            if(fireball.destroyed){
                balls.removeValue(fireball, true);
            }
        }


    }
    public void destroy(){
        screenThree.setDone();
    }
    public void shoot(){

                balls.add(new Fireball(screenThree, b2body.getPosition().x, b2body.getPosition().y));
        }

    public void abovePlayer(){
        secondPhase = true;
        // Tracks players
        if (b2body.getPosition().x > screenThree.getX()) {
            vector.x = -0.5f;
        } else if (b2body.getPosition().x < screenThree.getX()) {
            vector.x = 0.5f;
        }

        if(b2body.getPosition().y - screenThree.getY() > 1){
            vector.y = -1;
        } else {
            vector.y = 1;
        }
        b2body.setLinearVelocity(vector);
    }

    public void draw(Batch batch) {
        if (!destroyed || stateTime < 1) {
            super.draw(batch);

        }
        for(Fireball fireball : balls){
            fireball.draw(batch);
        }
    }
}
