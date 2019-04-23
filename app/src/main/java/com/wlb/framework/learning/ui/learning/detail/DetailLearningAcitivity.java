package com.wlb.framework.learning.ui.learning.detail;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.error.ANError;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.longtailvideo.jwplayer.JWPlayerSupportFragment;
import com.longtailvideo.jwplayer.JWPlayerView;
import com.longtailvideo.jwplayer.configuration.PlayerConfig;
import com.longtailvideo.jwplayer.events.FullscreenEvent;
import com.longtailvideo.jwplayer.events.listeners.VideoPlayerEvents;
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem;
import com.mindorks.placeholderview.ExpandablePlaceHolderView;
import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.data.model.api.ApiError;
import com.wlb.framework.learning.data.model.api.wlb.course.AboutRespMdl;
import com.wlb.framework.learning.data.model.api.wlb.course.CommentRespMdl;
import com.wlb.framework.learning.data.model.api.wlb.course.CourseRespMdl;
import com.wlb.framework.learning.data.model.api.wlb.course.ReviewRespMdl;
import com.wlb.framework.learning.data.model.api.wlb.course.ReviewRespMdl;
import com.wlb.framework.learning.data.model.api.wlb.jw.VideoDetail;
import com.wlb.framework.learning.databinding.ActivityDetailLearningAcitivityBinding;
import com.wlb.framework.learning.ui.base.BaseActivity;
import com.wlb.framework.learning.ui.learning.detail.custom_view.HeadingLessons;
import com.wlb.framework.learning.ui.learning.detail.custom_view.ItemLessons;
import com.wlb.framework.learning.ui.learning.detail.detail_viewmodel.DetailLearningViewModel;
import com.wlb.framework.learning.ui.learning.detail.timeline.TimelinePagerAdapter;
import com.wlb.framework.learning.ui.learning.detail.timeline.fragment.InstructorFragment;
import com.wlb.framework.learning.ui.learning.detail.timeline.fragment.InstructorFragment;
import com.wlb.framework.learning.ui.learning.detail.timeline.fragment.MAboutFragment;
import com.wlb.framework.learning.ui.learning.detail.timeline.fragment.MCommentsFragment;
import com.wlb.framework.learning.ui.learning.detail.timeline.fragment.MReviewFragment;
import com.wlb.framework.learning.ui.learning.detail.timeline.fragment.MCommentsFragment;
import com.wlb.framework.learning.ui.learning.detail.timeline.fragment.MReviewFragment;
import com.wlb.framework.learning.utils.jwplayer.JWEventHandler;
import com.wlb.framework.learning.utils.jwplayer.KeepScreenOnHandler;

import javax.inject.Inject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

import static com.wlb.framework.learning.utils.ManipulateUtils.addRp;

public class DetailLearningAcitivity extends BaseActivity<ActivityDetailLearningAcitivityBinding, DetailLearningViewModel> implements DetailLearningNavigator, HasSupportFragmentInjector, VideoPlayerEvents.OnFullscreenListener, AppBarLayout.OnOffsetChangedListener, ItemLessons.onItemPlay {

    private static final String TAG = "LearningActivity";

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    ViewModelProviderFactory factory;
    ActivityDetailLearningAcitivityBinding mActivityDetailLearningBinding;
    private Toolbar mToolbar;
    private AppBarLayout mAppBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private DetailLearningViewModel detailsViewModel;
    private ExpandablePlaceHolderView mExpandablePlaceHolderView;
    //jwt
    /**
     * Reference to the {@link JWPlayerView}
     */
    private JWPlayerView mPlayerView;
    private JWPlayerSupportFragment mPlayerFragment;
    /**
     * An instance of our event handling class
     */
    private JWEventHandler mEventHandler;
    private String urls = "";
    //course
    private String in_title_course = "";
    private int in_id_course = 0;
    boolean visible_lessons = false;

    //action lessons
    private ItemLessons.onItemPlay lessonAction;

    /**
     * Reference to the {@link //CastContext}
     */
//    private CastContext mCastContext;
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, DetailLearningAcitivity.class);
        return intent;
    }

    @Override
    public int getBindingVariable() {
        return BR.model;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail_learning_acitivity;
    }

    @Override
    public DetailLearningViewModel getViewModel() {
        detailsViewModel = ViewModelProviders.of(this, factory).get(DetailLearningViewModel.class);
        return detailsViewModel;
    }

    String courseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityDetailLearningBinding = getViewDataBinding();
        detailsViewModel.setNavigator(this);

        courseId = getIntent().getStringExtra("id");
        mActivityDetailLearningBinding.title.setText(getIntent().getStringExtra("title"));
        detailsViewModel.getAbout(courseId);
        detailsViewModel.getReview(courseId);
        detailsViewModel.getComments(courseId);
        setup();
        setupViewPager();
        setUpJw("");
    }


    private void setup() {

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            in_id_course = extras.getInt("id");
            in_title_course = extras.getString("title");
            Log.d(TAG, "id: " + in_id_course);

        }
        mToolbar = mActivityDetailLearningBinding.toolbar;
        mAppBarLayout = mActivityDetailLearningBinding.appbar;
        collapsingToolbarLayout = mActivityDetailLearningBinding.collapsingToolbar;
        mExpandablePlaceHolderView = mActivityDetailLearningBinding.expandableViewLessons;
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout.setTitle(in_title_course);
        collapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#44ffffff"));

        mAppBarLayout.addOnOffsetChangedListener(this);
        getViewModel().getAbout(Integer.toString(in_id_course));
        lessonAction = this::PlayVideo;
        Animation slidedown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation slideup = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        mActivityDetailLearningBinding.lnShowLessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!visible_lessons) {
                    mActivityDetailLearningBinding.lnContetLessons.setVisibility(View.VISIBLE);
                    mActivityDetailLearningBinding.lnContetLessons.startAnimation(slidedown);
                    visible_lessons = true;
                } else {
                    mActivityDetailLearningBinding.lnContetLessons.startAnimation(slideup);
                    mActivityDetailLearningBinding.lnContetLessons.setVisibility(View.GONE);
                    visible_lessons = false;
                }
            }
        });
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void openLoginActivity() {

    }

    @Override
    public void openProfileFragment() {

    }

    @Override
    public void handleErrorNetwork(ANError error) {
        ApiError apiError = error.getErrorAsObject(ApiError.class);
        ShowSnackBar(mActivityDetailLearningBinding.crdLearning, apiError.getMessage());
    }

    @Override
    public void updateAbout(AboutRespMdl aboutRespMdl) {
        mActivityDetailLearningBinding.tutor.setText(getTutor(aboutRespMdl));
        mActivityDetailLearningBinding.ratingMsg.setText("" + aboutRespMdl.getAverageRating());
        mActivityDetailLearningBinding.rating.setRating(aboutRespMdl.getAverageRating());
        mActivityDetailLearningBinding.language.setText(aboutRespMdl.getLanguage());

        MAboutFragment aboutFragment = (MAboutFragment) mPagerAdapter.getItem(0);
        InstructorFragment instructorFragment = (InstructorFragment) mPagerAdapter.getItem(3);

        aboutFragment.updateUi(aboutRespMdl);
        instructorFragment.updateInstruc(aboutRespMdl);
        //update lessons
        for (AboutRespMdl.Sections sections : aboutRespMdl.getSections()) {
            mExpandablePlaceHolderView.addView(new HeadingLessons(DetailLearningAcitivity.this, sections.getTitle()));
            for (AboutRespMdl.Lessons info : sections.getLessons()) {
                mExpandablePlaceHolderView.addView(new ItemLessons(this, info, lessonAction));
            }
        }

        if (aboutRespMdl.getVideo() != null) {
            detailsViewModel.getFileVideoJw(aboutRespMdl.getVideo());
        }
    }


    @Override
    public void updateReview(ReviewRespMdl reviewRespMdl) {
        MReviewFragment reviewFragment = (MReviewFragment) mPagerAdapter.getItem(1);
        reviewFragment.updateUi(reviewRespMdl);
    }

    @Override
    public void updateComment(CommentRespMdl commentRespMdl) {
        MCommentsFragment commentsFragment = (MCommentsFragment) mPagerAdapter.getItem(2);
        commentsFragment.updateUi(commentRespMdl);
    }

    @Override
    public void onUpdateVideo(VideoDetail videoDetail) {
        //update video Jw
        Log.i(TAG, "onUpdateVideo");
        setUpJw(videoDetail.getPlaylist().get(0).getLink());
    }


    private String getTutor(AboutRespMdl aboutRespMdl) {
        if (aboutRespMdl.getCreatorUser() != null) {
            if (aboutRespMdl.getCreatorUser().getName() != null) {
                return aboutRespMdl.getCreatorUser().getName();
            }
        }

        return "";
    }

    private String getPrice(CourseRespMdl.Data course) {
        if (course.getPrice() != null) {
            if (course.getPrice().getPricing() != null) {
                return addRp(course.getPrice().getPricing().getIDR());
            }
        }
        return "";
    }

    private void setUpJw(String fileUriVideo) {
        TextView outputTextView = (TextView) findViewById(R.id.output);
        outputTextView.setVisibility(View.GONE);
        // Construct a new JWPlayerSupportFragment (since we're using AppCompatActivity)
        if (fileUriVideo.isEmpty()) {
            mPlayerFragment = JWPlayerSupportFragment.newInstance(new PlayerConfig.Builder()
                    .file("https://cdn.jwplayer.com/videos/4CJD7sNP-uB6mRs4w.mp4?exp=1555274880&sig=6e2c76c12b63226efac9b877bae460ac")
                    .build());
        } else {
            mPlayerFragment = JWPlayerSupportFragment.newInstance(new PlayerConfig.Builder()
                    .file(fileUriVideo)
                    .build());
        }
        // Attach the Fragment to our layout
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container, mPlayerFragment);
        ft.commit();
        // Make sure all the pending fragment transactions have been completed, otherwise
        // mPlayerFragment.getPlayer() may return null
        fm.executePendingTransactions();
        // Get a reference to the JWPlayerView from the fragment
        mPlayerView = mPlayerFragment.getPlayer();
        // Keep the screen on during playback
        new KeepScreenOnHandler(mPlayerView, getWindow());
        // Instantiate the JW Player event handler class
        mEventHandler = new JWEventHandler(mPlayerView, outputTextView);
    }

    @Inject
    TimelinePagerAdapter mPagerAdapter;

    private void setupViewPager() {
        mPagerAdapter.setCount(4);
        mActivityDetailLearningBinding.TimelineViewPager.setAdapter(mPagerAdapter);
//        mActivityDetailLearningBinding.tabLayoutTimeline.setupWithViewPager(mActivityDetailLearningBinding.TimelineViewPager);
        mActivityDetailLearningBinding.tabLayoutTimeline.addTab(mActivityDetailLearningBinding.tabLayoutTimeline.newTab().setText(getString(R.string.abouttimeline)));
        mActivityDetailLearningBinding.tabLayoutTimeline.addTab(mActivityDetailLearningBinding.tabLayoutTimeline.newTab().setText(getString(R.string.reviewtimeline)));
        mActivityDetailLearningBinding.tabLayoutTimeline.addTab(mActivityDetailLearningBinding.tabLayoutTimeline.newTab().setText(getString(R.string.commenttimeline)));
        mActivityDetailLearningBinding.tabLayoutTimeline.addTab(mActivityDetailLearningBinding.tabLayoutTimeline.newTab().setText(getString(R.string.instructortimeline)));
////        mActivityDetailLearningBinding.tabLayoutTimeline.setTabGravity(TabLayout.GRAVITY_FILL);

        mActivityDetailLearningBinding.TimelineViewPager.setOffscreenPageLimit(mActivityDetailLearningBinding.tabLayoutTimeline.getTabCount());
        mActivityDetailLearningBinding.TimelineViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mActivityDetailLearningBinding.tabLayoutTimeline));
        mActivityDetailLearningBinding.tabLayoutTimeline.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mActivityDetailLearningBinding.TimelineViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_detaillearning, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        switch (item.getItemId()) {
            case R.id.action_wishlist:
                return true;
            case R.id.action_share:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        mPlayerView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlayerView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayerView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPlayerView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayerView.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // Set fullscreen when the device is rotated to landscape
        mPlayerView.setFullscreen(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE,
                true);
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Exit fullscreen when the user pressed the Back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mPlayerView.getFullscreen()) {
                mPlayerView.setFullscreen(false, true);
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onFullscreen(FullscreenEvent fullscreenEvent) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            if (fullscreenEvent.getFullscreen()) {
                actionBar.hide();
            } else {
                actionBar.show();
            }
        }

        // When going to Fullscreen we want to set fitsSystemWindows="false"
        mActivityDetailLearningBinding.crdLearning.setFitsSystemWindows(!fullscreenEvent.getFullscreen());
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (i == 0) {
            // Fully expanded
        } else {
            mPlayerView.onPause();
            // Not fully expanded or collapsed
        }
    }

    @Override
    public void PlayVideo(String Fileurl) {
        ShowSnackBar(mActivityDetailLearningBinding.crdLearning, Fileurl);
    }
}
