package com.map.suba.dontgiveup;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class ExampleInstrumentedTest {

    private static final String BASIC_SAMPLE_PACKAGE
            = "com.map.suba.dontgiveup";
    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String STRING_TO_BE_TYPED = "UiAutomator";
    private static final String STRING_TO_BE_TYPED1 = "subesan";
    private UiDevice mDevice;

    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = mDevice.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                LAUNCH_TIMEOUT);

        // Launch the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        // Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
                LAUNCH_TIMEOUT);
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.map.suba.dontgiveup", appContext.getPackageName());
    }

   /* @Test
    public void swipeToDelete() {
        mDevice.findObject(By.clazz("android.widget.LinearLayout")).swipe(LEFT,1.0f);

    }*/

    @Test
    public void IndexSpecificInput() throws UiObjectNotFoundException {
       /* String [] myInput=new String[]{"one", "two","three", "four", "five"};
        for(int i=0;i<5;i++){
            mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "editText")).setText(myInput[i]);
            mDevice.findObject(By.clazz("android.widget.Button")).click();
        }*/

        UiCollection number=new UiCollection(new UiSelector().className("android.widget.ListView"));
        UiObject myList=number.getChild(new UiSelector().index(1));
        myList.swipeLeft(5);
        int totalView=number.getChildCount();
        assertEquals(4,totalView);






        //UiObject2 addText=mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "txt_data")),500);
        //assertThat(listviewItem.getText(), is(equalTo(myInput[3])));

    }



   /* @Test
    public void listToAdd(){
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "editText")).setText(STRING_TO_BE_TYPED1);
        mDevice.findObject(By.clazz("android.widget.Button")).click();
        //mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "btn_list_view")).click();

        UiObject2 addText=mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE,"txt_data")),500);
        assertThat(addText.getText(), is(equalTo(STRING_TO_BE_TYPED)));

    }


   /* @Test
    public void listToAddNegative(){
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "editText")).setText(STRING_TO_BE_TYPED);
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "btn_list_view")).click();

        UiObject2 addText=mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE,"txt_data")),500);
        assertThat(addText.getText(), is(not(STRING_TO_BE_TYPED1)));

    }*/

}
