package android.example.navigationdrawerforactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.example.navigationdrawerforactivity.databinding.ActivityMainBinding;
import android.example.navigationdrawerforactivity.fragment.GalleryFragment;
import android.example.navigationdrawerforactivity.fragment.HomeFragment;
import android.example.navigationdrawerforactivity.fragment.SlideshowFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_GALLERY = 1;
    private static final int FRAGMENT_SLIDESHOW = 2;

    private int currentFragment = FRAGMENT_HOME;

    NavigationView navigationView = null;
    ActivityMainBinding binding = null;
    DrawerLayout drawerLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = binding.drawerLayout;
        navigationView = binding.navView;

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        replaceFragment(new HomeFragment());
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_home) {
            if(currentFragment != FRAGMENT_HOME) {
                replaceFragment(new HomeFragment());
                currentFragment = FRAGMENT_HOME;
            }
        } else if(id == R.id.nav_gallery) {
            if(currentFragment != FRAGMENT_GALLERY) {
                replaceFragment(new GalleryFragment());
                currentFragment = FRAGMENT_GALLERY;
            }
        } else if(id == R.id.nav_slideshow) {
            if(currentFragment != FRAGMENT_SLIDESHOW) {
                replaceFragment(new SlideshowFragment());
                currentFragment = FRAGMENT_SLIDESHOW;
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.commit();
    }
}