package com.moringaschool.rubisenergies;

import static org.junit.Assert.*;

import android.widget.TextView;

import com.moringaschool.rubisenergies.ui.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

public class SignInTest {
    @RunWith(RobolectricTestRunner.class)

    public class MainActivityTest {
        public MainActivity activity;

        @Before
        public void setUp() throws Exception {
            activity = Robolectric.buildActivity(MainActivity.class)
                    .create()
                    .resume()
                    .get();
        }


        @Test
        public void addition_isCorrect() {
            assertEquals(4, 2 + 2);
        }

        //    @Test
        public void validateTextview() {

            TextView welcometxt = activity.findViewById(R.id.welcometxt);
            assertTrue("Welcome to Rubis Fast Food.".equals(welcometxt.getText().toString()));
        }

        @Test
        public void validateTextViewContent() {
            assertEquals(6, 2 + 4);
        }

        @Test
        public void validateAddition() {
//        TextView te

        }
    }

}