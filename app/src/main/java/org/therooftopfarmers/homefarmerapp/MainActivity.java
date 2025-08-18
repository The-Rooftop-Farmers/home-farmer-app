package org.therooftopfarmers.homefarmerapp;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;

// Import all the fragments from their new package
import org.therooftopfarmers.homefarmerapp.fragments.AboutUsFragment;
import org.therooftopfarmers.homefarmerapp.fragments.CameraFragment;
import org.therooftopfarmers.homefarmerapp.fragments.ContactSupportFragment;
import org.therooftopfarmers.homefarmerapp.fragments.FunctionsFragment;
import org.therooftopfarmers.homefarmerapp.fragments.HomeFragment;
import org.therooftopfarmers.homefarmerapp.fragments.ParametersFragment;
import org.therooftopfarmers.homefarmerapp.fragments.PlantSelectionFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Load the default screen (HomeFragment) when the app starts
        if (savedInstanceState == null) {
            replaceFragment(new HomeFragment());
            navigationView.setCheckedItem(R.id.nav_home);
            toolbar.setTitle("Home");
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        String title = getString(R.string.app_name);
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            selectedFragment = new HomeFragment();
            title = "Home";
        } else if (id == R.id.nav_parameters) {
            selectedFragment = new ParametersFragment();
            title = "Parameters";
        } else if (id == R.id.nav_camera) {
            selectedFragment = new CameraFragment();
            title = "Camera";
        } else if (id == R.id.nav_plant_selection) {
            selectedFragment = new PlantSelectionFragment();
            title = "Plant Selection";
        } else if (id == R.id.nav_functions) {
            selectedFragment = new FunctionsFragment();
            title = "Functions";
        } else if (id == R.id.nav_about_us) {
            selectedFragment = new AboutUsFragment();
            title = "About Us";
        } else if (id == R.id.nav_contact_support) {
            selectedFragment = new ContactSupportFragment();
            title = "Contact Support";
        }

        if (selectedFragment != null) {
            replaceFragment(selectedFragment);
            toolbar.setTitle(title);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}