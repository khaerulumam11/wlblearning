package com.wlb.framework.learning.ui.testing;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.wlb.framework.learning.R;

import androidx.annotation.Nullable;

public class TestingPageActivity extends Activity {
    private Spinner spinCurpos;
    private String[] language = {"English (US)", "Bahasa Indonesia"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_profile_experience);
//        initView();
//        setupLanguage();
    }

    private void setupLanguage() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, language);
        spinCurpos.setAdapter(adapter);
    }

    private void initView() {
//        spinCurpos = (Spinner) findViewById(R.id.spin_curpos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_default_save, menu);
        return true;
    }
}
