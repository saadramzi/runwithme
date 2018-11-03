package miage.parisnanterre.fr.runwithme.workout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import miage.parisnanterre.fr.runwithme.R;
import miage.parisnanterre.fr.runwithme.workout.BeforeWorkoutFragment;

public class WorkoutActivity extends AppCompatActivity {

    Fragment currentFragment = null;
    FragmentTransaction ft;
    Button b;
    Boolean isBeforeWorkout;
    String WORKOUT_SESSION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        setWORKOUT_SESSION(getIntent().getStringExtra("WORKOUT_SESSION"));

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        b = (Button) findViewById(R.id.workoutButton);

        ft = getSupportFragmentManager().beginTransaction();
        currentFragment = new BeforeWorkoutFragment();
        ft.replace(R.id.containerWorkout, currentFragment);
        ft.commit();

        isBeforeWorkout = true;



    }

    public void setWORKOUT_SESSION(String session){
        this.WORKOUT_SESSION = session;
    }
    public String getWORKOUT_SESSION(){
        return this.WORKOUT_SESSION;
    }

    protected void changeWorkoutFragment(View v){
        /*
        if(isBeforeWorkout){
            b.setText("SKIP");
            /*currentFragment = new CurrentWorkoutFragment();
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, currentFragment);
            ft.commit();
            isBeforeWorkout = false;
        }else {
            b.setText("START");
            /*currentFragment = new BeforeWorkoutFragment();
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, currentFragment);
            ft.commit();
            isBeforeWorkout = true;
        }
        //isBeforeWorkout = isBeforeWorkout==true?false:true;
        */
        this.onBackPressed();
    }
}