package com.example.mart.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.mart.R;
import com.example.mart.SliderAdapter;
import com.example.mart.ui.slideshow.SlideshowViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    public HomeFragment(){

    }

    private HomeViewModel homeViewModel;
    ///private RecyclerView categoryRecyclerView;
    ///private CategoryAdapter categoryAdapter;

    private ViewPager bannerSliderViewPager;
    private List<SlideshowViewModel>slideshowViewModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME = 3000;
    final private long PERIOD_TIME = 3000;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_home, container, false);
        ///categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        ///LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ////layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        ///categoryRecyclerView.setLayoutManager(layoutManager);

        ///List<HomeViewModel> homeViewModelList = new ArrayList<HomeViewModel>();
        ////homeViewModelList.add(new HomeViewModel("Perfumes"));
        ////homeViewModelList.add(new HomeViewModel("Fashion"));
        ////homeViewModelList.add(new HomeViewModel("Shoes"));
        ////homeViewModelList.add(new HomeViewModel("Watches"));
        ////homeViewModelList.add(new HomeViewModel("Cosmetics"));
        ////homeViewModelList.add(new HomeViewModel("Purse"));

        ////categoryAdapter = new CategoryAdapter(homeViewModelList);
        ////categoryRecyclerView.setAdapter(categoryAdapter);
        ////categoryAdapter.notifyDataSetChanged();

        bannerSliderViewPager = view.findViewById(R.id.banner_slider_viewpager);
        slideshowViewModelList = new ArrayList<SlideshowViewModel>();
        slideshowViewModelList.add(new SlideshowViewModel(R.drawable.make));
        slideshowViewModelList.add(new SlideshowViewModel(R.drawable.shoee));

        slideshowViewModelList.add(new SlideshowViewModel(R.drawable.perfumej));
        slideshowViewModelList.add(new SlideshowViewModel(R.drawable.cosmetics));
        slideshowViewModelList.add(new SlideshowViewModel(R.drawable.watches));
        slideshowViewModelList.add(new SlideshowViewModel(R.drawable.handb));
        slideshowViewModelList.add(new SlideshowViewModel(R.drawable.shoe));
        slideshowViewModelList.add(new SlideshowViewModel(R.drawable.handbag));
        slideshowViewModelList.add(new SlideshowViewModel(R.drawable.make));
        slideshowViewModelList.add(new SlideshowViewModel(R.drawable.shoee));

        slideshowViewModelList.add(new SlideshowViewModel(R.drawable.perfumej));
        slideshowViewModelList.add(new SlideshowViewModel(R.drawable.cosmetics));


        SliderAdapter sliderAdapter = new SliderAdapter(slideshowViewModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }

            }
        };
        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideShow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLooper();
                stopBannerSlideShow();
                if (event.getAction() == MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }
                return false;
            }
        });


        return view;

    }

    private void pageLooper(){
        if (currentPage == slideshowViewModelList.size()-2){
            currentPage = 2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }

        if (currentPage == 1){
            currentPage = slideshowViewModelList.size()-3;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }

    }

    private void startBannerSlideShow(){
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage >= slideshowViewModelList.size()){
                    currentPage = 1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY_TIME, PERIOD_TIME );
    }

    private void stopBannerSlideShow(){
        timer.cancel();
    }


}
