package am.example.headerfootergridview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import am.example.headerfootergridview.adapters.HeaderFooterGridAdapter;
import am.widget.headerfootergridview.HeaderFooterGridView;

public class HeaderFooterGridViewActivity extends AppCompatActivity implements
        CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener,
        View.OnClickListener, AdapterView.OnItemClickListener {

    private HeaderFooterGridView hfgContent;
    private HeaderFooterGridAdapter adapter = new HeaderFooterGridAdapter();
    private TextView tvHeaderView1, tvHeaderView2, tvHeaderView3;
    private TextView tvHeaderItem1, tvHeaderItem2, tvHeaderItem3;
    private TextView tvFooterView1, tvFooterView2, tvFooterView3;
    private TextView tvFooterItem1, tvFooterItem2, tvFooterItem3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headerfootergridview);
        Toolbar mToolbar = findViewById(R.id.gird_toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }
        }
        initView();
        hfgContent = findViewById(R.id.gird_hfg_content);
        ((CheckBox) findViewById(R.id.grid_cb_hv)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.grid_cb_hi)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.grid_cb_fv)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.grid_cb_fi)).setOnCheckedChangeListener(this);
        ((SeekBar) findViewById(R.id.grid_sb_number)).setOnSeekBarChangeListener(this);
        hfgContent.setAdapter(adapter);
        hfgContent.setOnItemClickListener(this);
    }

    private void initView() {
        tvHeaderView1 = (TextView) LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.item_headerfootergridview_header, hfgContent, false);
        tvHeaderView1.setText(
                String.format(Locale.getDefault(), getString(R.string.headerfootergridview_hv), 1));
        tvHeaderView1.setOnClickListener(this);
        tvHeaderView2 = (TextView) LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.item_headerfootergridview_header, hfgContent, false);
        tvHeaderView2.setText(
                String.format(Locale.getDefault(), getString(R.string.headerfootergridview_hv), 2));
        tvHeaderView2.setOnClickListener(this);
        tvHeaderView3 = (TextView) LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.item_headerfootergridview_header, hfgContent, false);
        tvHeaderView3.setText(
                String.format(Locale.getDefault(), getString(R.string.headerfootergridview_hv), 3));
        tvHeaderView3.setOnClickListener(this);

        tvHeaderItem1 = (TextView) LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.item_headerfootergridview_item, hfgContent, false);
        tvHeaderItem1.setText(String.format(Locale.getDefault(),
                getString(R.string.headerfootergridview_header), 1));
        tvHeaderItem2 = (TextView) LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.item_headerfootergridview_item, hfgContent, false);
        tvHeaderItem2.setText(String.format(Locale.getDefault(),
                getString(R.string.headerfootergridview_header), 2));
        tvHeaderItem3 = (TextView) LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.item_headerfootergridview_item, hfgContent, false);
        tvHeaderItem3.setText(String.format(Locale.getDefault(),
                getString(R.string.headerfootergridview_header), 3));

        tvFooterView1 = (TextView) LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.item_headerfootergridview_header, hfgContent, false);
        tvFooterView1.setText(
                String.format(Locale.getDefault(), getString(R.string.headerfootergridview_fv), 1));
        tvFooterView1.setOnClickListener(this);
        tvFooterView2 = (TextView) LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.item_headerfootergridview_header, hfgContent, false);
        tvFooterView2.setText(
                String.format(Locale.getDefault(), getString(R.string.headerfootergridview_fv), 2));
        tvFooterView2.setOnClickListener(this);
        tvFooterView3 = (TextView) LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.item_headerfootergridview_header, hfgContent, false);
        tvFooterView3.setText(
                String.format(Locale.getDefault(), getString(R.string.headerfootergridview_fv), 3));
        tvFooterView3.setOnClickListener(this);

        tvFooterItem1 = (TextView) LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.item_headerfootergridview_item, hfgContent, false);
        tvFooterItem1.setText(String.format(Locale.getDefault(),
                getString(R.string.headerfootergridview_footer), 1));
        tvFooterItem2 = (TextView) LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.item_headerfootergridview_item, hfgContent, false);
        tvFooterItem2.setText(String.format(Locale.getDefault(),
                getString(R.string.headerfootergridview_footer), 2));
        tvFooterItem3 = (TextView) LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.item_headerfootergridview_item, hfgContent, false);
        tvFooterItem3.setText(String.format(Locale.getDefault(),
                getString(R.string.headerfootergridview_footer), 3));
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        switch (compoundButton.getId()) {
            case R.id.grid_cb_hv:
                setHeaderView(checked);
                break;
            case R.id.grid_cb_hi:
                setHeaderItem(checked);
                break;
            case R.id.grid_cb_fv:
                setFooterView(checked);
                break;
            case R.id.grid_cb_fi:
                setFooterItem(checked);
                break;
        }
    }

    private void setHeaderView(boolean add) {
        if (add) {
            hfgContent.addHeaderView(tvHeaderView1);
            hfgContent.addHeaderView(tvHeaderView2);
            hfgContent.addHeaderView(tvHeaderView3);
        } else {
            hfgContent.removeHeaderView(tvHeaderView1);
            hfgContent.removeHeaderView(tvHeaderView2);
            hfgContent.removeHeaderView(tvHeaderView3);
        }
    }

    private void setHeaderItem(boolean add) {
        if (add) {
            hfgContent.addHeaderItem(tvHeaderItem1, null, true);
            hfgContent.addHeaderItem(tvHeaderItem2, null, true);
            hfgContent.addHeaderItem(tvHeaderItem3, null, true);
        } else {
            hfgContent.removeHeaderItem(tvHeaderItem1);
            hfgContent.removeHeaderItem(tvHeaderItem2);
            hfgContent.removeHeaderItem(tvHeaderItem3);
        }
    }

    private void setFooterView(boolean add) {
        if (add) {
            hfgContent.addFooterView(tvFooterView1);
            hfgContent.addFooterView(tvFooterView2);
            hfgContent.addFooterView(tvFooterView3);
        } else {
            hfgContent.removeFooterView(tvFooterView1);
            hfgContent.removeFooterView(tvFooterView2);
            hfgContent.removeFooterView(tvFooterView3);
        }
    }

    private void setFooterItem(boolean add) {
        if (add) {
            hfgContent.addFooterItem(tvFooterItem1, null, true);
            hfgContent.addFooterItem(tvFooterItem2, null, true);
            hfgContent.addFooterItem(tvFooterItem3, null, true);
        } else {
            hfgContent.removeFooterItem(tvFooterItem1);
            hfgContent.removeFooterItem(tvFooterItem2);
            hfgContent.removeFooterItem(tvFooterItem3);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        adapter.setCount(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View view) {
        if (view instanceof TextView) {
            TextView tv = (TextView) view;
            Toast.makeText(getApplicationContext(), tv.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), String.format(Locale.getDefault(),
                getString(R.string.headerfootergridview_toast), position + 1),
                Toast.LENGTH_SHORT).show();
    }
}
