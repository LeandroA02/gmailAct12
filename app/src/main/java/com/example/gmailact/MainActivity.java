package com.example.gmailact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout= (DrawerLayout)findViewById(R.id.drawer_layout);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navView = (NavigationView)findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;
        int itemId = item.getItemId();
        if (itemId == R.id.menu_seccion_1) {
            fragment = new fragActivo();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_seccion_2) {
            fragment = new fragEstado();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_seccion_3) {
            fragment = new fragRecibidos();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_seccion_4) {
            fragment = new fragPrincipal();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_seccion_5) {
            fragment = new fragPromociones();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_seccion_6) {
            fragment = new fragSocial();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_seccion_7) {
            fragment = new fragNotificaciones();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_seccion_8) {
            fragment = new fragForos();
            fragmentTransaction = true;
        }
        else if (itemId == R.id.menu_opcion_1) {
            fragment = new FragDestacados();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_opcion_2) {
            fragment = new FragPospuestos();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_opcion_3) {
            fragment = new FragImportantes();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_opcion_4) {
            fragment = new FragEnviados();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_opcion_5) {
            fragment = new FragProgramados();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_opcion_6) {
            fragment = new FragBandejadeSalida();
            fragmentTransaction = true;
        }
        if(fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }
        drawerLayout.closeDrawers();
        return true;
    }
}