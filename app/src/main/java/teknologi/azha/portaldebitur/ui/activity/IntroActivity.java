package teknologi.azha.portaldebitur.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.model.SliderPage;

import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.ui.fragment.SampleSlide;

/**
 * Created by user on 10/30/2017.
 */

public class IntroActivity extends AppIntro  {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SliderPage sliderPage1 = new SliderPage();
        addSlide(SampleSlide.newInstance(R.layout.item_onboarding_1));

        SliderPage sliderPage2 = new SliderPage();
        addSlide(SampleSlide.newInstance(R.layout.item_onboarding_2));

        SliderPage sliderPage3 = new SliderPage();
        addSlide(SampleSlide.newInstance(R.layout.item_onboarding_3));
        /*sliderPage1.setTitle("Welcome!");
        sliderPage1.setDescription("This is a demo of the AppIntro library, with a custom background on each slide!");
        sliderPage1.setImageDrawable(R.drawable.icon_uang);
        sliderPage1.setBgColor(Color.TRANSPARENT);
        addSlide(AppIntroFragment.newInstance(sliderPage1));


        SliderPage sliderPage2 = new SliderPage();
        sliderPage2.setTitle("Clean App Intros");
        sliderPage2.setDescription("This library offers developers the ability to add clean app intros at the start of their apps.");
        sliderPage2.setImageDrawable(R.drawable.ic_slide2);
        sliderPage2.setBgColor(Color.TRANSPARENT);
        addSlide(AppIntroFragment.newInstance(sliderPage2));

        SliderPage sliderPage3 = new SliderPage();
        sliderPage3.setTitle("Simple, yet Customizable");
        sliderPage3.setDescription("The library offers a lot of customization, while keeping it simple for those that like simple.");
        sliderPage3.setImageDrawable(R.drawable.ic_slide3);
        sliderPage3.setBgColor(Color.TRANSPARENT);
        addSlide(AppIntroFragment.newInstance(sliderPage3));

        SliderPage sliderPage4 = new SliderPage();
        sliderPage4.setTitle("Explore");
        sliderPage4.setDescription("Feel free to explore the rest of the library demo!");
        sliderPage4.setImageDrawable(R.drawable.ic_slide4);
        sliderPage4.setBgColor(Color.TRANSPARENT);
        addSlide(AppIntroFragment.newInstance(sliderPage4));
        showSkipButton(false);
        setProgressButtonEnabled(false);
        // Declare a new image view
        ImageView imageView = new ImageView(this);

        // Bind a drawable to the imageview
        imageView.setImageResource(R.drawable.bg_pnm);

        // Set background color
        imageView.setBackgroundColor(Color.BLACK);

        // Set layout params
        imageView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        // Bind the background to the intro
        setBackgroundView(imageView);
        //setCustomTransformer(new ZoomOutPageTransformer());
        setFlowAnimation();*/
        // Override bar/separator color
        //setBarColor(Color.parseColor("#1251a4"));
        setSeparatorColor(Color.parseColor("#FFFFFF"));

        // SHOW or HIDE the statusbar
        showStatusBar(true);
        setColorSkipButton(Color.parseColor("#1251a4"));
        setColorDoneText(Color.parseColor("#1251a4"));
        setNextArrowColor(Color.parseColor("#1251a4"));
        // Edit the color of the nav bar on Lollipop+ devices
        //setNavBarColor(Color.parseColor("#3F51B5"));

        // Hide Skip/Done button
        //showSkipButton(false);
        //showDoneButton(false);

    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        // Do something when users tap on Done button.
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }

    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
}
