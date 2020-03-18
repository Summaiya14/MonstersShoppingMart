package com.example.mart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mart.ui.slideshow.SlideshowViewModel;

import java.util.List;

public class SliderAdapter extends PagerAdapter {

    private List<SlideshowViewModel>slideshowViewModelList;

    public SliderAdapter(List<SlideshowViewModel> slideshowViewModelList) {
        this.slideshowViewModelList = slideshowViewModelList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_slideshow,container,false);
        ImageView banner = view.findViewById(R.id.banner_slide);
        banner.setImageResource(slideshowViewModelList.get(position).getBanner());
        container.addView(view,0);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return slideshowViewModelList.size();
    }
}
