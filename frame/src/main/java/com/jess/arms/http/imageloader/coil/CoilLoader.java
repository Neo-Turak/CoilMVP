package com.jess.arms.http.imageloader.coil;

import android.content.Context;
import androidx.annotation.Nullable;
import com.jess.arms.http.imageloader.BaseImageLoaderStrategy;
import com.jess.arms.utils.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class CoilLoader {
    @Inject
    @Nullable
    CoilImageLoaderStrategy mStrategy;

    @Inject
    public CoilLoader() {

    }


    /**
     * 加载图片
     *
     * @param context
     * @param config
     * @param <T>
     */
    public <T extends CoilConfig> void loadImage(Context context, T config) {
        Preconditions.checkNotNull(mStrategy, "Please implement BaseImageLoaderStrategy and call GlobalConfigModule.Builder#imageLoaderStrategy(BaseImageLoaderStrategy) in the applyOptions method of ConfigModule");
        this.mStrategy.loadImage(context, config);
    }

    /**
     * 停止加载或清理缓存
     *
     * @param context
     * @param config
     * @param <T>
     */
    public <T extends CoilConfig> void clear(Context context, T config) {
        Preconditions.checkNotNull(mStrategy, "Please implement BaseImageLoaderStrategy and call GlobalConfigModule.Builder#imageLoaderStrategy(BaseImageLoaderStrategy) in the applyOptions method of ConfigModule");
        this.mStrategy.clear(context, config);
    }

    /**
     * 可在运行时随意切换 {@link BaseImageLoaderStrategy}
     *
     * @param strategy
     */
    public void setLoadImgStrategy(CoilImageLoaderStrategy strategy) {
        Preconditions.checkNotNull(strategy, "strategy == null");
        this.mStrategy = strategy;
    }

    @Nullable
    public CoilImageLoaderStrategy getLoadImgStrategy() {
        return mStrategy;
    }
}
