package com.gmail.brunokawka.poland.sleepcyclealarm.ui.menu;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gmail.brunokawka.poland.sleepcyclealarm.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity
    implements MenuContract.MenuView {
    private static final String TAG = "MenuActivityLog";

    private MenuPresenter menuPresenter;

    private PreferenceFragmentCompat preferenceFragment;
    private Fragment fragment;

    @BindView(R.id.activityTitleTextView)
    TextView activityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        menuPresenter = new MenuPresenter(this);
        menuPresenter.handleSetTheme(getString(R.string.key_change_theme),
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        menuPresenter.initializeValueByKeysAndPassedIntent(getString(R.string.key_menu_item_id),
                getString(R.string.key_menu_item_title),
                getIntent());

        menuPresenter.handleSetActivityTitle();

        menuPresenter.performActionDependingOnMenuItemIdKey(savedInstanceState);
    }

    public void onCloseActivityButtonClick(View view) {
        menuPresenter.handleCloseActivityButton();
    }

    @Override
    public void setAppTheme(int themeId) {
        getDelegate().setLocalNightMode(themeId);
    }

    @Override
    public void setActivityTitle(String title) {
        activityTitle.setText(title);
    }

    @Override
    public void findPreferenceFragment() {
        preferenceFragment = (SettingsFragment) getSupportFragmentManager()
                .findFragmentByTag(getString(R.string.key_settings_tag));
    }

    @Override
    public void openNewPreferenceFragment() {
        preferenceFragment = new SettingsFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.menu_activity_container, preferenceFragment, getString(R.string.key_settings_tag))
                .commit();
    }

    @Override
    public void findStandardFragment() {

    }

    @Override
    public void openNewStandardFragment() {

    }

    @Override
    public void showErrorAndFinish(int resourceMsgReference) {
        String errorMsg = getResources().getString(resourceMsgReference);
        Toast.makeText(getApplicationContext(), errorMsg, Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void closeActivity() {
        finish();
    }
}