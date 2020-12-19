package club.adren.lib.base;

import android.content.res.Resources;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;

import club.adren.lib.R;
import club.adren.lib.utils.ClassUtil;
import club.adren.lib.utils.ScreenHelper;
import club.adren.lib.utils.StatusBarUtil;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Creator: adren
 * CreTime: 2020/12/14
 * Descrip:
 *          1、viewModel/bingDing封装
 *          2、布局绑定
 *          3、状态栏设置
 *          4、PT适配
 *          5、
 *          6、页面状态图
 *              1、base中统一管理（根布局方式）
 *                  优点：统一配置，不需要每个页面都去布局，只需给定方法就行
 *                  缺点：特殊页面无法特殊处理
 *              2、
 */
public abstract class BaseActivity<VM extends AndroidViewModel, SV extends ViewDataBinding> extends AppCompatActivity {

    // ViewModel
    protected VM vm;
    // 布局view
    protected SV bv;

    private CompositeDisposable mCompositeDisposable;

    protected void setView(int layoutResID) {
        //bv = DataBindingUtil.inflate(LayoutInflater.from(this), layoutResID, null, false);
        bv = DataBindingUtil.setContentView(this, layoutResID);

        initStatusBar();
        initViewModel();
    }

    protected void initStatusBar() {
        // 设置透明状态栏，兼容4.4
        StatusBarUtil.setColor(this, getResources().getColor(R.color.design_default_color_error), 0);
    }

    //初始化ViewModel
    private void initViewModel() {
        Class<VM> viewModelClass = ClassUtil.getViewModel(this);
        if (viewModelClass != null) {
            this.vm = new ViewModelProvider(this).get(viewModelClass);
        }
    }

    public void addSubscription(Disposable s) {
        if (this.mCompositeDisposable == null) {
            this.mCompositeDisposable = new CompositeDisposable();
        }
        this.mCompositeDisposable.add(s);
    }

    //PT屏幕适配方案
    @Override
    public Resources getResources() {
        int o = super.getResources().getConfiguration().orientation;
        if (o == android.content.res.Configuration.ORIENTATION_LANDSCAPE)
            return ScreenHelper.adaptHeight(super.getResources(), 750);
        else return ScreenHelper.adaptWidth(super.getResources(), 750);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            // clear 和 dispose的区别是：  disposed = true;
            this.mCompositeDisposable.clear();
        }
    }
}
