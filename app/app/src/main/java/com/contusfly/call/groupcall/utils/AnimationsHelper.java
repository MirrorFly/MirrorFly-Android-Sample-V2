/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contusfly.call.groupcall.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

import java.util.ArrayList;

/**
 * This is the animations helper class
 *
 * @author ContusTeam <developers@contus.in>
 * @version 2.0
 */
public class AnimationsHelper {

    private AnimationsHelper() {
    }

    /**
     * This method is used to animates arrows in audio and video call
     *
     * @param upArrow1   first up arrow
     * @param upArrow2   second up arrow
     * @param downArrow1 first down arrow
     * @param downArrow2 second down arrow
     */

    public static void animateArrows(View upArrow1, View upArrow2, View downArrow1, View downArrow2) {
        String propertyToBeAnimated = "Alpha";
        ArrayList<Animator> animatorList = new ArrayList<>();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());

        final ObjectAnimator upAlphaAnimator1 = ObjectAnimator.ofFloat(upArrow1, propertyToBeAnimated, 1.0f, 0f);
        upAlphaAnimator1.setRepeatCount(ObjectAnimator.INFINITE);
        upAlphaAnimator1.setRepeatMode(ObjectAnimator.RESTART);
        upAlphaAnimator1.setStartDelay(0);
        upAlphaAnimator1.setDuration(1000);
        animatorList.add(upAlphaAnimator1);

        final ObjectAnimator upAlphaAnimator2 = ObjectAnimator.ofFloat(upArrow2, propertyToBeAnimated, 1.0f, 0f);
        upAlphaAnimator2.setRepeatCount(ObjectAnimator.INFINITE);
        upAlphaAnimator2.setRepeatMode(ObjectAnimator.RESTART);
        upAlphaAnimator2.setStartDelay(100);
        upAlphaAnimator2.setDuration(1000);
        animatorList.add(upAlphaAnimator2);

        final ObjectAnimator downAlphaAnimator1 = ObjectAnimator.ofFloat(downArrow1, propertyToBeAnimated, 1.0f, 0f);
        downAlphaAnimator1.setRepeatCount(ObjectAnimator.INFINITE);
        downAlphaAnimator1.setRepeatMode(ObjectAnimator.RESTART);
        downAlphaAnimator1.setStartDelay(0);
        downAlphaAnimator1.setDuration(1000);
        animatorList.add(downAlphaAnimator1);

        final ObjectAnimator downAlphaAnimator2 = ObjectAnimator.ofFloat(downArrow2, propertyToBeAnimated, 1.0f, 0f);
        downAlphaAnimator2.setRepeatCount(ObjectAnimator.INFINITE);
        downAlphaAnimator2.setRepeatMode(ObjectAnimator.RESTART);
        downAlphaAnimator2.setStartDelay(100);
        downAlphaAnimator2.setDuration(1000);
        animatorList.add(downAlphaAnimator2);

        animatorSet.playTogether(animatorList);
        animatorSet.start();
    }

    /**
     * This method animates given view with provided animation
     *
     * @param context     context
     * @param view        view to be animated
     * @param animationId animation resource id
     */
    public static void animateView(Context context, View view, int animationId) {
        Animation animation = AnimationUtils.loadAnimation(context, animationId);
        view.startAnimation(animation);
    }

    /**
     * This method can be used to animate the view properties with start and end values.
     *
     * @param view              view
     * @param startValue        start value
     * @param endValue          endValue
     * @param animationDuration duration for animation in milliseconds
     * @param updateListener    listener to get the updated values to animate the view
     */
    public static void animateViewWithValues(View view, int startValue, int endValue, int animationDuration, AnimationValueUpdateListener updateListener) {

        Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                int updatedValue = startValue + (int) ((endValue - startValue) * interpolatedTime);
                updateListener.onAnimationValueUpdate(updatedValue);
            }
        };
        animation.setDuration(animationDuration); // in ms
        view.startAnimation(animation);
    }

    /**
     * Animation update listener
     */
    public interface AnimationValueUpdateListener {

        /**
         * Animation update listener continuously updating values for animation
         *
         * @param updatedValue values for animation
         */
        void onAnimationValueUpdate(int updatedValue);
    }
}
