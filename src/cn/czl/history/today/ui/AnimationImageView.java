/*
 * Copyright (C) 2015 RECRUIT LIFESTYLE CO., LTD.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.czl.history.today.ui;

import android.content.Context;
import android.view.animation.Animation;
import android.widget.ImageView;

/**
 * @author amyu
 */
class AnimationImageView extends ImageView {

  /**
   * Animation銇甋tart銇‥nd鏅傘伀Listener銇偄銉仚銈�   */
  private Animation.AnimationListener mListener;

  /**
   * 銈炽兂銈广儓銉┿偗銈�   * {@inheritDoc}
   */
  public AnimationImageView(Context context) {
    super(context);
  }

  /**
   * {@link AnimationImageView#mListener} 銇偦銉冦儓
   *
   * @param listener {@link android.view.animation.Animation.AnimationListener}
   */
  public void setAnimationListener(Animation.AnimationListener listener) {
    mListener = listener;
  }

  /**
   * View銇瓵nimation銇甋tart鏅傘伀銈汇儍銉堛仌銈屻仧Listener銇�{@link android.view.animation.Animation.AnimationListener#onAnimationStart(Animation)}
   * 銈掑懠銇�   */
  @Override public void onAnimationStart() {
    super.onAnimationStart();
    if (mListener != null) {
      mListener.onAnimationStart(getAnimation());
    }
  }

  /**
   * View銇瓵nimation銇瓻nd鏅傘伀銈汇儍銉堛仌銈屻仧Listener銇�{@link android.view.animation.Animation.AnimationListener#onAnimationEnd(Animation)}
   * (Animation)} 銈掑懠銇�   */
  @Override public void onAnimationEnd() {
    super.onAnimationEnd();
    if (mListener != null) {
      mListener.onAnimationEnd(getAnimation());
    }
  }
}