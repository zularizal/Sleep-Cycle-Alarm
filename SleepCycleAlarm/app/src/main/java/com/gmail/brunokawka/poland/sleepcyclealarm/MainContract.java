package com.gmail.brunokawka.poland.sleepcyclealarm;

import android.support.v4.app.Fragment;
import android.content.SharedPreferences;
import android.view.MenuItem;

public interface MainContract {

    interface MainView {
        void setAppTheme(int themeId);
        void navigateToSpecificFragmentWithAnimation(Fragment fragment, int[] enterExitAnimationPair);
        void openMenuActivityWithItemVariables(int itemId, String itemTitle);
    }

    interface MainPresenter {
        void handleSetTheme(String changeThemeKey, SharedPreferences preferences);
        void handleBottomNavigationTabClick(int position, int previousPosition);
        void handleMenuItemClick(MenuItem item);
    }
}
