package com.gmit.gps;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class HeightAnimation extends Animation {
	int targetHeight;
	View view;
	boolean down;

	public HeightAnimation(View view, int targetHeight, boolean down) {
		this.view = view;
		this.targetHeight = targetHeight;
		this.down = down;
	}

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		int newHeight;
		if (down) {
			newHeight = (int) (targetHeight * interpolatedTime);
		} else {
			newHeight = (int) (targetHeight * (1 - interpolatedTime));
		}
		if (newHeight > 1) {
			view.getLayoutParams().height = newHeight;
			view.requestLayout();
		}
	}

	@Override
	public void initialize(int width, int height, int parentWidth, int parentHeight) {
		super.initialize(width, height, parentWidth, parentHeight);
	}

	@Override
	public boolean willChangeBounds() {
		return true;
	}
}