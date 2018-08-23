package com.gll.gllandroidstudy.IPresenter;

import android.support.annotation.NonNull;

import com.gll.gllandroidstudy.base.Api;
import com.gll.gllandroidstudy.contact.SignInStepViewContact;
import com.gll.gllandroidstudy.model.TestBean;
import com.gll.mylibrary.mvpbase.BasePresenter;
import com.gll.mylibrary.mvpbase.baseImpl.BasePresenterImpl;
import com.gll.mylibrary.retroft.ExceptionHelper;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by: Z_B on 2018/8/23.
 * Function:
 */
public abstract class SignInStepViewPresenter extends BasePresenterImpl<SignInStepViewContact.view> implements SignInStepViewContact.presenter {

    public SignInStepViewPresenter(SignInStepViewContact.view view) {
        super(view);
    }

    @Override
    public void getData() {
        Api.getInstance().test()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        addDisposable(disposable);
                        view.showLoadingDialog("");
                    }
                })
                .map(new Function<TestBean, List<TestBean.StoriesBean>>() {
                    @Override
                    public List<TestBean.StoriesBean> apply(@NonNull TestBean testBean) throws Exception {
                        return testBean.getStories();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<TestBean.StoriesBean>>() {
                    @Override
                    public void accept(@NonNull List<TestBean.StoriesBean> storiesBeen) throws Exception {
                        view.dismissLoadingDialog();
                        view.setData(storiesBeen);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        view.dismissLoadingDialog();
                        ExceptionHelper.handleException(throwable);
                    }
                });
    }
}
