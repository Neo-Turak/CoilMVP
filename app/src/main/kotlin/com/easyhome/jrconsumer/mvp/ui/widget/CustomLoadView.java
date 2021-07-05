package com.easyhome.jrconsumer.mvp.ui.widget;

//import com.chad.library.adapter.base.loadmore.LoadMoreView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.loadmore.BaseLoadMoreView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.easyhome.jrconsumer.R;

import org.jetbrains.annotations.NotNull;

public class CustomLoadView extends BaseLoadMoreView {

    @Override
    public @NotNull View getLoadComplete(@NotNull BaseViewHolder baseViewHolder) {
        return baseViewHolder.findView(R.id.load_more_load_complete_view);
    }

    @Override
    public @NotNull View getLoadEndView(@NotNull BaseViewHolder baseViewHolder) {
        return baseViewHolder.findView(R.id.load_more_load_end_view);
    }

    @Override
    public @NotNull View getLoadFailView(@NotNull BaseViewHolder baseViewHolder) {
        return baseViewHolder.findView(R.id.load_more_load_fail_view);
    }

    @Override
    public @NotNull View getLoadingView(@NotNull BaseViewHolder baseViewHolder) {
        return baseViewHolder.findView(R.id.load_more_loading_view);
    }

    @Override
    public @NotNull View getRootView(@NotNull ViewGroup viewGroup) {
       return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.load_more_end_view,viewGroup,false);
    }
}
