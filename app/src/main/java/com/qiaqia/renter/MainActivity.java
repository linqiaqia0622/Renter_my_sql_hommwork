package com.qiaqia.renter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.qiaqia.renter.entity.Contract;
import com.qiaqia.renter.entity.Progress;
import com.qiaqia.renter.entity.Renter;
import com.qiaqia.renter.entity.Room;
import com.qiaqia.renter.ui.adapter.MainActivityFragmentAdapter;
import com.qiaqia.renter.ui.fragment.BaseFragment;
import com.qiaqia.renter.ui.fragment.ItemFragment;
import com.qiaqia.renter.ui.fragment.dummy.DummyContent;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener
        , NavigationView.OnNavigationItemSelectedListener {
    private String mTextviewArray[] = {"首页", "消息", "合同", "我"};
    BottomNavigationBar bottomNavigationBar;
    ViewPager mViewPager;
    String res=null;

    public String miao;
    public int[] colors={
            R.color.colorPrimary,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light,

    };
    //定义数组来存放按钮图片
    private int mImageViewArray[] = {
            R.drawable.tabbar_home_auto,
            R.drawable.tabbar_message_auto,
            R.drawable.tabbar_discover_auto,
            R.drawable.tabbar_profile_auto};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationBar=(BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mViewPager=(ViewPager)findViewById(R.id.container);
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(ItemFragment.newInstance(1));

        fragments.add(new BaseFragment());
        fragments.add(new BaseFragment());
        fragments.add(new BaseFragment());
            MainActivityFragmentAdapter mainActivityFragmentAdapter=
                new MainActivityFragmentAdapter(getSupportFragmentManager(),fragments);


        mViewPager.setAdapter(mainActivityFragmentAdapter);
        initBottomNavigationBar();

       // insert();
      //  Toast.makeText(this,""+room.toString(),Toast.LENGTH_SHORT).show();
      
        
                
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    } public void initBottomNavigationBar() {
        //   bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        for (int i = 0; i < 4; i++) {
            bottomNavigationBar.addItem(new BottomNavigationItem(mImageViewArray[i], mTextviewArray[i]).setActiveColor(colors[i]));
        }
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {
                mViewPager.setCurrentItem(position);
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationBar.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomNavigationBar
                .setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottomNavigationBar
                .setActiveColor(R.color.colorPrimary)
                .setInActiveColor("#FFFFFF")
                .setBarBackgroundColor("#ECECEC");

        bottomNavigationBar.initialise();
    }
    public  void insert(){

        Room room=new Room(10001);
        room.setArea(60);
        room.setDistrict("天河");
        room.setRoom_count(3);
        room.setFloor_p(2000);
        room.setPrice(2300);
        room.setState(0);
        room.setPicture_id(1);
        room.save();
        
        //2
        room=new Room(10002);
        room.setArea(23);
        room.setDistrict("黄埔");
        room.setRoom_count(0);
        room.setFloor_p(800);
        room.setPrice(900);
        room.setState(0);
        room.setPicture_id(2);
        room.save();
        //3
        room=new Room(10003);
        room.setArea(35);
        room.setDistrict("番禺");
        room.setRoom_count(1);
        room.setFloor_p(900);
        room.setPrice(900);
        room.setState(0);
        room.setPicture_id(3);
        room.save();
        
        //4
        room=new Room(10004);
        room.setArea(90);
        room.setDistrict("越秀");
        room.setRoom_count(4);
        room.setFloor_p(5000);
        room.setPrice(5300);
        room.setState(0);
        room.setPicture_id(4);
        room.save();
        
        //5
        room=new Room(10005);
        room.setArea(50);
        room.setDistrict("增城");
        room.setRoom_count(0);
        room.setFloor_p(100);
        room.setPrice(300);
        room.setState(0);
        room.setPicture_id(5);
        room.save();
        
        //6
        room=new Room(10006);
        room.setArea(40);
        room.setDistrict("从化");
        room.setRoom_count(0);
        room.setFloor_p(500);
        room.setPrice(500);
        room.setState(0);
        room.setPicture_id(6);
        room.save();
        
        //7
        room=new Room(10007);
        room.setArea(40);
        room.setDistrict("天河");
        room.setRoom_count(0);
        room.setFloor_p(1300);
        room.setPrice(1300);
        room.setState(0);
        room.setPicture_id(7);
        room.save();
        
        //8
        room=new Room(10008);
        room.setArea(32);
        room.setDistrict("花都");
        room.setRoom_count(3);
        room.setFloor_p(500);
        room.setPrice(700);
        room.setState(0);
        room.setPicture_id(1);
        room.save();
        
        //9
        room=new Room(10009);
        room.setArea(55);
        room.setDistrict("荔湾");
        room.setRoom_count(2);
        room.setFloor_p(1700);
        room.setPrice(1700);
        room.setState(0);
        room.setPicture_id(9);
        room.save();
        
        //10
        room=new Room(10010);
        room.setArea(40);
        room.setDistrict("萝岗");
        room.setRoom_count(0);
        room.setFloor_p(500);
        room.setPrice(700);
        room.setState(0);
        room.setPicture_id(10);
        room.save();
        room=null;
        
        //租客表
        Renter renter=new Renter("张三");
        renter.setRenter_id(201);
        renter.setPicture_id(11);
        renter.setDistrict("天河");
        renter.setPrice(800);
        renter.setRoom_count(0);
        renter.save();
        //2
        renter=new Renter("李四");
        renter.setRenter_id(202);
        renter.setPicture_id(12);
        renter.setDistrict("天河");
        renter.setPrice(1500);
        renter.setRoom_count(2);
        renter.save();
        //3
        renter=new Renter("王五");
        renter.setRenter_id(203);
        renter.setPicture_id(13);
        renter.setDistrict("天河");
        renter.setPrice(500);
        renter.setRoom_count(0);
        renter.save();
        //4
        renter=new Renter("朱八");
        renter.setRenter_id(204);
        renter.setPicture_id(14);
        renter.setDistrict("天河");
        renter.setPrice(3000);
        renter.setRoom_count(3);
        renter.save();
        //5
        renter=new Renter("易九");
        renter.setRenter_id(205);
        renter.setPicture_id(15);
        renter.setDistrict("天河");
        renter.setPrice(1300);
        renter.setRoom_count(2);
        renter.save();
        
        //进度
        //租户一
        Progress progress=new Progress();
        progress.setDate(1481977675);
        progress.setPid(302);
        progress.setProgress(1);
        progress.setRenter(DataSupport.find(Renter.class,1));
        progress.setRoom(DataSupport.find(Room.class,1));
        progress.save();
        //2
        progress=new Progress();
        progress.setDate(1451977675);
        progress.setPid(303);
        progress.setProgress(2);
        progress.setRenter(DataSupport.find(Renter.class,1));
        progress.setRoom(DataSupport.find(Room.class,1));
        progress.save();
        //租户二
        progress=new Progress();
        progress.setDate(1481977675);
        progress.setPid(304);
        progress.setProgress(2);
        progress.setRenter(DataSupport.find(Renter.class,2));
        progress.setRoom(DataSupport.find(Room.class,2));
        progress.save();
        //合同
        Contract contract=new Contract(DataSupport.find(Room.class,1),DataSupport.find(Renter.class,3));
        contract.setPrice(800);
        contract.setDate(1477977675);
        contract.setCid(401);
        contract.save();
        //2
        contract=new Contract(DataSupport.find(Room.class,2),DataSupport.find(Renter.class,4));
        contract.setPrice(800);
        contract.setDate(1479977675);

        contract.setCid(402);
        contract.save();
        
        

      


    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        
    }
}
