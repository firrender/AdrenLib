package club.adren.lib.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

/**
 * Creator: adren
 * CreTime: 2020/11/3
 * Descrip: 没有viewModel的情况
 */
public class NoViewModel extends AndroidViewModel {

    public NoViewModel(@NonNull Application application) {
        super(application);
    }
}
