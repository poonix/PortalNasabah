package teknologi.azha.portaldebitur.ui.factory;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.lang.reflect.Field;

import teknologi.azha.portaldebitur.R;

/**
 * Created by user on 9/23/2017.
 */

public class SearchViewFactory {

    private final String TAG = SearchViewFactory.class.getSimpleName();
    private MenuItem mMenuSearch;

    public SearchViewFactory() {
    }

    public void setupSearchMenu(final Menu menu) {
        mMenuSearch = menu.findItem( R.id.action_search);
        if (mMenuSearch != null) {
            final SearchView searchView = (SearchView) mMenuSearch.getActionView();
            searchView.setIconified(true);
            searchView.setIconifiedByDefault(true);
            AutoCompleteTextView searchTextView = (AutoCompleteTextView) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
            try {
                Field mCursorDrawableRes = TextView.class.getDeclaredField("mCursorDrawableRes");
                mCursorDrawableRes.setAccessible(true);
                mCursorDrawableRes.set(searchTextView, 0); //This sets the cursor resource ID to 0 or @null which will make it visible on white background
            } catch (Exception e) {
            }

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Log.d(TAG, "onQueryTextSubmit : " + query);
                    if (!searchView.isIconified()) {
                        searchView.setIconified(true);
                    }
                    if(mListener != null) {
                        mListener.onSearchStarted(query);
                    }
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String query) {
                    Log.d(TAG, "SearchOnQueryTextChanged : " + query);
                    if(mListener != null) {
                        mListener.onSearchStarted(query);
                    }
                    return true;
                }
            });
            MenuItemCompat.setOnActionExpandListener(mMenuSearch, new MenuItemCompat.OnActionExpandListener() {
                @Override
                public boolean onMenuItemActionExpand(MenuItem item) {
                    Log.d(TAG, "onMenuItemActionExpand");
                    setMenuItemsVisibility(menu, mMenuSearch, false);
                    return true;
                }

                @Override
                public boolean onMenuItemActionCollapse(MenuItem item) {
                    Log.d(TAG, "onMenuItemActionCollapse");
                    setMenuItemsVisibility(menu, mMenuSearch, true);

                    if(mListener != null) {
                        mListener.onSearchStopped();
                    }
                    return true;
                }
            });
        }
    }

    private void setMenuItemsVisibility(Menu menu, MenuItem exception, boolean visible) {
        for (int i=0; i<menu.size(); ++i) {
            MenuItem item = menu.getItem(i);
            if (item != exception) item.setVisible(visible);
        }
    }

    private OnSearchListener mListener;

    public void setOnSearchListener(OnSearchListener listener) {
        this.mListener = listener;
    }

    public interface OnSearchListener {
        void onSearchStarted(String query);
        void onSearchStopped();
    }
}
