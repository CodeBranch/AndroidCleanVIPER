package com.twere.android.clean.viper.presentation.main.modules.common;

import android.os.Bundle;
import android.support.annotation.StringRes;
import com.twere.android.clean.viper.presentation.main.MainActivity;
import com.twere.android.clean.viper.presentation.common.BaseFragment;
import com.twere.android.clean.viper.presentation.injection.component.ActivityComponent;

public abstract class BaseMainFragment extends BaseFragment implements BaseMainView {

  public abstract String getTitle();

  @Override public void showError(@StringRes int message) {

  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    setRetainInstance(true);
    MainActivity mainActivity = (MainActivity) getActivity();
    getPresenter().setRouter(mainActivity);
    mainActivity.resolveToolbar(this);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    getPresenter().setRouter(null);
  }

  protected ActivityComponent getActivityComponent() {
    return ((MainActivity) getActivity()).getActivityComponent();
  }
}
