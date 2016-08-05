package lucky.main.viewpagerindicator;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ViewPager viewPager, viewPager1;
    MyPagerAdapter myPagerAdapter;
    ViewPagerIndicator2 indicator;
    ViewPagerIndicator indicator1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        myPagerAdapter = new MyPagerAdapter();
        viewPager.setAdapter(myPagerAdapter);
        indicator = (ViewPagerIndicator2) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager, myPagerAdapter.list.size());

        viewPager1 = (ViewPager) findViewById(R.id.viewPager1);
        viewPager1.setAdapter(myPagerAdapter);
        indicator1 = (ViewPagerIndicator) findViewById(R.id.indicator1);
        indicator1.setLength(myPagerAdapter.list.size());
        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                indicator1.setSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public class MyPagerAdapter extends android.support.v4.view.PagerAdapter{

        List<String> list = new ArrayList<>();

        public MyPagerAdapter(){
            list.add("one");
            list.add("two");
            list.add("three");
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            position = position%list.size();
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_item, null);
            TextView textView = (TextView) view.findViewById(R.id.item);
            textView.setText(list.get(position));
            container.addView(view);
            return view;
        }
    }
}
