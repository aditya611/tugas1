package polinema.ac.id.dtschapter03_starter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class activity_welcome extends AppCompatActivity {
    ViewPager viewPager;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        setupViewPager();
    }

    private void setupViewPager() {
        adapter = new Adapter(this);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
    }


    public void clickGetStarted(View view) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
    }

    public void Login(View view) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
    }

    private class Adapter extends PagerAdapter {
        Context context;
        LayoutInflater inflater;

        public Adapter(Context context) {
            this.context = context;
        }

        //list img
        int[] list_img = {
                R.drawable.ic_eventlist,
                R.drawable.ic_assign,
                R.drawable.ic_superhero
        };


        //list judul
        int[] list_judul = {
                R.string.judul_1,
                R.string.judul_2,
                R.string.judul_3
        };

        //list deskripsi
        int[] list_deskripsi = {
                R.string.deskripsi_1,
                R.string.deskripsi_2,
                R.string.deskripsi_3
        };

        //cover
        int[] listcover = {
                R.drawable.bg_red,
                R.drawable.bg_blue,
                R.drawable.bg_purple
        };

        @Override
        public int getCount() {
            return list_img.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.item_layout, container, false);
            ConstraintLayout constraintLayout = view.findViewById(R.id.item_layout);
            ImageView imageView = view.findViewById(R.id.img);
            TextView judul = view.findViewById(R.id.judul);
            TextView deskripsi = view.findViewById(R.id.deskripsi);
            ImageView imageView1 = view.findViewById(R.id.cover);

            return view;
        }
    }
}